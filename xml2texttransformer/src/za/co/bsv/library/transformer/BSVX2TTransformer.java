/*
 * ##########################################################################
 * # $Rev::                                    $: Revision of last commit   #
 * # $Author::                                 $: Author of last commit     #
 * # $Date::                                   $: Date of last commit       #
 * ##########################################################################
 */
package za.co.bsv.library.transformer;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import javax.xml.namespace.QName;

import javax.xml.parsers.DocumentBuilderFactory;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/**
 * Default XML to text parser supported by this transformer
 *
 * @author Bongani Hlope <bonganih@bankservafrica.com>
 */
public class BSVX2TTransformer extends X2TTransformer{
    public final static int LEFT_JUSTIFY    = 0;
    public final static int RIGHT_JUSTIFY   = 1;
    public final static int CENTER_JUSTIFY  = 2;
    
    public final static int TYPE_NUMBER     = 1;
    public final static int TYPE_STRING     = 2;

    private XPath xPath;
    private PrintStream out;
    private int pageNumber = 1;
    private Document xmlDocument;
    private Document xslDocument;
    private InputStream xmlSource;
    private Map<String, Node> namedRecords;
    private List<String> pageBreakRecordList;
    private Stack<Boolean> lastRecordStack;
    private Map<String, Node> templates;
    private Map<String, String> templatesRoots;
    private int maxLinesPerPage = 0;
    private int documentLineCount = 0;
    private boolean pageBreakLastAction = false;

    protected BSVX2TTransformer(InputStream xmlSource) {
        this.xmlSource = xmlSource;
        namedRecords = new HashMap<String, Node>();
        lastRecordStack = new Stack<Boolean>();
        templates = new HashMap<String, Node>();
        templatesRoots = new HashMap<String, String>();
    }
    @Override
    public void transform(InputStream xslSource, OutputStream result) throws X2TTransformerException {
        try {
            xmlDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xmlSource);
            xPath = XPathFactory.newInstance().newXPath();
            
            xslDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xslSource);
            
            out = new PrintStream(result);
        }
        catch(Exception ex) {
            throw new X2TTransformerException("Error parsing XML documents, cause: " + ex.getMessage(), ex);
        }        
        NodeList rootList = xslDocument.getDocumentElement().getChildNodes();
            
        for(int i = 0; i < rootList.getLength(); i ++) {            
            parseStylesheet(rootList.item(i), "/");
        }
    }
    
    /**
     * Parse the style-sheet and process the transformation
     *
     * @param child the current tag we are processing
     * @param currentRoot the root for <code>XPath</code> lookup
     * @throws X2TTransformerException if an error occurs with XPath parsing
     */
    private void parseStylesheet(Node child, String currentRoot) throws X2TTransformerException {
        if(child.getNodeType() == Node.TEXT_NODE) {
            return;
        }

        NamedNodeMap attributes = child.getAttributes();

        Node pbbattribute = attributes.getNamedItem("page-break-before");
        if (pbbattribute != null) {
            pageNumber++;
            out.print((char)12);
            documentLineCount = 0;
        } else {
            pbbattribute = attributes.getNamedItem("print-page-break-before");
            if (pbbattribute != null) {
                printPageBreak(null);
            }
        }

        String tagName = child.getNodeName();

        String oldTagName = tagName;
        
        String[] split = oldTagName.split(":"); //Remove namespace
        if(split.length >= 2) {
            tagName = split[1];
        }

        if("record".equals(tagName)) {                    
            Node attribute = attributes.getNamedItem("start");
            String start = attribute.getNodeValue();
            
            attribute = attributes.getNamedItem("name");
            
            if(attribute != null) {
                String name = attribute.getNodeValue();
                if (namedRecords.containsKey(name)) {
                    namedRecords.remove(name);
                }
                namedRecords.put(name, child);
            }
            
            attribute = attributes.getNamedItem("print-on-last-record");
            
            if(attribute != null) {
                String print = attribute.getNodeValue();

                if(("no".equals(print.toLowerCase()) || "false".equals(print.toLowerCase())))  {
                    if(!lastRecordStack.empty() && lastRecordStack.peek()) {
                        return;
                    }
                }
            }

            int recordStart = 0;
            try {
                recordStart = Integer.parseInt(start);
            }
            catch(Exception ex) {

            }
            out.print(ensureLength(" ", ' ', recordStart, LEFT_JUSTIFY));

            NodeList myLis = child.getChildNodes();

            for(int i = 0; i < myLis.getLength(); i ++) {
                if(child.getNodeType() == Node.TEXT_NODE) {
                    continue;
                }
                parseStylesheet(myLis.item(i), currentRoot);
            }
            out.println();
            documentLineCount++;
            pageBreakLastAction = false;
            if (documentLineCount >= maxLinesPerPage &&
                    maxLinesPerPage > 0) {
                printPageBreak(currentRoot);
            }
        }
        else if("for-each".equals(tagName)) {
            lastRecordStack.push(false);
            processForEach(child, attributes, currentRoot);
            lastRecordStack.pop();
        }
        else if("value-of".equals(tagName)) {            
            processValueOf(currentRoot, attributes);
        }
        else if("built-in".equals(tagName)) {
            processBuiltIn(child, attributes);
        }
        else if("text".equals(tagName)) {
            processText(child, attributes);                    
        }
        else if("when".equals(tagName)) {
            //TODO: add support for when
            Node attribute = attributes.getNamedItem("select");
            String select = attribute.getNodeValue();

            attribute = attributes.getNamedItem("value");
            String value = attribute.getNodeValue();
        }
        else if("page-break".equals(tagName)) {
            pageBreakRecordList = new ArrayList<String>();
            Node attribute = attributes.getNamedItem("records");
            
            if(attribute != null) {
                String records = attribute.getNodeValue();
                String recordList[] = records.split(",");
                
                pageBreakRecordList.addAll(Arrays.asList(recordList));
            }            
        }
        else if("template".equals(tagName)) {
            processTemplate(child, attributes,currentRoot);
        }
        else if("variable".equals(tagName)) {
            processVariable(child, attributes);
        }
        else if("apply-templates".equals(tagName)) {
            processApplyTemplate(attributes,currentRoot);
        }
        else if("max-lines-per-page".equals(tagName)) {
            Node attribute = attributes.getNamedItem("select");
            String select = attribute.getNodeValue();

            try {
                if (select != null) {
                    maxLinesPerPage = Integer.parseInt(select);
                }
            } catch (Exception ex) {
                
            }
        }
    }
    
    /**
     * Process the <code>for-each</code> tag
     *
     * @param node the <code>Node</code> that represent the <code>for-each</code> tag
     * @param attributes the attributes of this node
     * @throws X2TTransformerException if an error occurs with XPath parsing
     */
    private void processForEach(Node node, NamedNodeMap attributes, String root) throws X2TTransformerException{
        Node attribute = attributes.getNamedItem("select");

        String select = attribute.getNodeValue();

        String pageBreakAfter = null;

        attribute = attributes.getNamedItem("page-break-after");
        
        if(attribute != null) {
            pageBreakAfter = attribute.getNodeValue();
        }
        int breakAfter = 999999999;
        
        try {
            breakAfter =Integer.parseInt(pageBreakAfter);
        }
        catch(Exception ex){
            
        }
        
        String resetPBonMLStr = null;
        boolean resetPageBreakOnMaxLines = false;
        attribute = attributes.getNamedItem("reset-page-break-on-max-lines");
        if(attribute != null) {
            resetPBonMLStr = attribute.getNodeValue();
            if (resetPBonMLStr.equals("true") || resetPBonMLStr.equals("yes")) {
                resetPageBreakOnMaxLines = true;
            }
        }
        
        
        String currentRoot = root + (!root.endsWith("/") ? "/" : "") + select;
        NodeList myLis = node.getChildNodes();

        NodeList loop = (NodeList)read(currentRoot, XPathConstants.NODESET);
        
        int count = 1;
        int loopCount = 0;
        for(int j = 0; j < loop.getLength(); j++) {
            Node child = loop.item(j);
        
            if(child.getNodeType() == Node.TEXT_NODE) {
                continue;
            }
            String myRoot = currentRoot + "["+(count)+"]";

            if(count ==  loop.getLength()) {
                lastRecordStack.pop();
                lastRecordStack.push(true);
                //lastRecord = true;
            }
            for(int i = 0; i < myLis.getLength(); i ++) {
                Node childNode = myLis.item(i);
                parseStylesheet(childNode, myRoot);
            }
            loopCount++;
            /*
             * if this Node's page-break must be reset when the page break for max
             * number of lines on a page was reached AND the max number of lines
             * for the document was set AND the page break was the last action, 
             * the page break must be reset to 0.
             */
            if (resetPageBreakOnMaxLines && 
                    maxLinesPerPage > 0 &&
                    pageBreakLastAction) {
                loopCount = 0;
            }
            if (loopCount == breakAfter) {
                printPageBreak(null);
                loopCount = 0;
            }

            if(count == loop.getLength()) {
                break;
            }

            /*
            if(pageBreakAfter != null && (count == (breakAfter * pageNumber))) {
                pageNumber++;

                for(String str: pageBreakRecordList) {
                    Node recordNode = namedRecords.get(str);

                    if(recordNode != null) {
                        parseStylesheet(recordNode, "/");
                    }
                }
            }*/
            ++count;
            //loopCount++;
        }
    }
    
    private void printPageBreak(String currentRoot)  throws X2TTransformerException{
        out.print((char)12);
        pageNumber++;
        documentLineCount = 0;

        for(String str: pageBreakRecordList) {
            Node recordNode = namedRecords.get(str);
            String nodeName = recordNode.getNodeName();

            String oldTagName = nodeName;
        
            String[] split = oldTagName.split(":"); //Remove namespace
            if(split.length >= 2) {
                nodeName = split[1];
            }

            if ("template".equals(nodeName)) {
                NodeList templateContent = recordNode.getChildNodes();
                NamedNodeMap attributes = recordNode.getAttributes();
                Node tmpltName = attributes.getNamedItem("name");
                String strNodeName = tmpltName.getNodeValue();
                        
                if (currentRoot == null) {
                    currentRoot = templatesRoots.get(strNodeName);
                }

                int xx = 0;
                recordNode = templateContent.item(xx);
                while (recordNode != null) {
                    xx++;
                    parseStylesheet(recordNode, currentRoot);
                    recordNode = templateContent.item(xx);
                }
                recordNode = null;
            }

            if(recordNode != null) {
                parseStylesheet(recordNode, "/");
            }
        }        
        pageBreakLastAction = true;
    }
    
    /**
     * Processes the <code>value-of</code> tag.
     *
     * @param root the root for the <code>XPath</code> lookup
     * @param attributes the tag's attributes
     * @throws X2TTransformerException if an error occurs with XPath parsing
     */
    private void processValueOf(String root, NamedNodeMap attributes) throws X2TTransformerException {
        Node attribute = attributes.getNamedItem("select");
        String select = attribute.getNodeValue();

        attribute = attributes.getNamedItem("width");
        String widthStr = "10";
        
        if(attribute != null) {
            widthStr = attribute.getNodeValue();
        }
        attribute = attributes.getNamedItem("align");
        String alignment = attribute.getNodeValue();

        if(alignment == null) {
            alignment = "left";
        }
        attribute = attributes.getNamedItem("type");
        int dataType = TYPE_STRING;
        
        if(attribute != null) {
            String type = attribute.getNodeValue();
            
            if("number".equals(type)) {
                dataType = TYPE_NUMBER;
            }
        }

        int width = 1;
        try {
            width = Integer.parseInt(widthStr);
        }
        catch(Exception ex) {

        }
        
        if(!root.endsWith("/")) {
                root = root + "/";
        }
        String value = (String)read(root + select, XPathConstants.STRING);
        
        if(dataType == TYPE_NUMBER) {
            attribute = attributes.getNamedItem("format");
            String format ="############";

            if(attribute != null) {
                format = attribute.getNodeValue();
            }
            X2TDecimalFormat df = new X2TDecimalFormat(format);
            try {
                double doubleValue = Double.valueOf(value);
                value = df.format(doubleValue);
            }
            catch(Exception ex) {
            }
        }
        int justify = LEFT_JUSTIFY;            
           
        if("right".equals(alignment)) {
            justify = RIGHT_JUSTIFY;
        }
        else if("center".equals(alignment)) {
            justify = CENTER_JUSTIFY;
        }
        out.print(ensureLength(value, ' ', width, justify));
    }
    
    /**
     * Processing the <code>built-in</code> tag
     *
     * @param node the <code>Node</code> representing this tag
     * @param attributes the attributes of this tag
     */
    private void processBuiltIn(Node node, NamedNodeMap attributes) {
        
        Node attribute = attributes.getNamedItem("name");
        String name = attribute.getNodeValue();

        attribute = attributes.getNamedItem("width");
        String widthStr = attribute.getNodeValue();

        attribute = attributes.getNamedItem("align");
        String alignment = attribute.getNodeValue();
        
        if(alignment == null) {
            alignment = "left";
        }
        int width = 1;                    

        try {
            width = Integer.parseInt(widthStr);
        }
        catch(Exception ex) {

        }
        String value = node.getFirstChild().getNodeValue();
            
        if("currDate".equals(name)) {
            if(value == null) {
                value ="yy/MM/dd";
            }
            SimpleDateFormat sdf = new SimpleDateFormat(value);
            value = sdf.format(new Date());
        }
        else if("fillChar".equals(name)) {
            StringBuilder buff = new StringBuilder();

            for(int i = 0; i < width; i++) {
                buff.append(value);
            }
            value = buff.toString();
        }
        else if("pageNumber".equals(name)) {
            if(value == null) {
                value ="############";
            }
            X2TDecimalFormat df = new X2TDecimalFormat(value);
            value = df.format(pageNumber);
        }
        else if("nextPage".equals(name)) {
            if(value == null) {
                value ="############";
            }
            pageNumber++;
            DecimalFormat df = new DecimalFormat(value);
            value = df.format(pageNumber);
        }
        int justify = LEFT_JUSTIFY;

        if("right".equals(alignment)) {
            justify = RIGHT_JUSTIFY;
        }
        else if("center".equals(alignment)) {
            justify = CENTER_JUSTIFY;
        }
        out.print(ensureLength(value, ' ', width, justify));
    }

    /**
     * Processes the <code>text</code> tag
     *
     * @param node the <code>Node</code> representing this tag
     * @param attributes the attributes of this tag
     */
    private void processText(Node node, NamedNodeMap attributes) {
        
        String value = node.getFirstChild().getNodeValue();

        Node attribute = attributes.getNamedItem("width");
        String widthStr = attribute.getNodeValue();

        attribute = attributes.getNamedItem("align");
        String alignment = attribute.getNodeValue();

        if(alignment == null) {
            alignment = "left";
        }
        int width = 1;

        try {
            width = Integer.parseInt(widthStr);
        }
        catch(Exception ex) {

        }

        int justify = LEFT_JUSTIFY;

        if("right".equals(alignment)) {
            justify = RIGHT_JUSTIFY;
        }
        else if("center".equals(alignment)) {
            justify = CENTER_JUSTIFY;
        }
        out.print(ensureLength(value, ' ', width, justify));
    }
    
    /**
     * Uses the <code>XPathExpression</code> to read a given expression
     *
     * @param expression the expression to read using <code>XPath</code>
     * @param returnType the type of object that will be returned by the <code>XPath</code> look-up
     * @return the object resolved by the given expression
     * @throws X2TTransformerException if an error occurs with XPath parsing
     */
    private Object read(String expression, QName returnType) throws X2TTransformerException{
        try {
            XPathExpression xPathExpression = xPath.compile(expression);
            return xPathExpression.evaluate(xmlDocument, returnType);
        }
        catch(Exception ex) {
            throw new X2TTransformerException("Error creating XPath expression, cause: " + ex.getMessage(), ex);
        }
    }

    /**
     * Allows definition of a node without actually adding it 
     * to the document. It can later be referenced by "apply-templates"
     * 
     * @param node
     * @param attributes 
     * @param currentRoot
     */
    private void processTemplate(Node node, NamedNodeMap attributes,String currentRoot) {
        Node attribute = attributes.getNamedItem("name");
        if (attribute == null) {
            return;
        }
        String name = attribute.getNodeValue();
        if (templates.containsKey(name)) {
            templates.remove(name);
            templatesRoots.remove(name);
            namedRecords.remove(name);
        }
        templates.put(name, node);
        templatesRoots.put(name, currentRoot);
        namedRecords.put(name, node);
    }
    
    /**
     * Inserts a defined template
     * 
     * @param node
     * @param attributes 
     */
    private void processApplyTemplate(NamedNodeMap attributes,String currentRoot)
             throws X2TTransformerException {
        Node attribute = attributes.getNamedItem("select");
        String select = attribute.getNodeValue();

        Node template = templates.get(select);
        String templateRoot = templatesRoots.get(select);
        if (template == null) {
            throw new X2TTransformerException("Template " + select + " does not exist");
        }
        
        NodeList myLis = template.getChildNodes();
        NodeList loop = (NodeList)read(templateRoot, XPathConstants.NODESET);
        
        for(int j = 0; j < loop.getLength(); j++) {
            Node child = loop.item(j);
        
            if(child.getNodeType() == Node.TEXT_NODE) {
                continue;
            }

            for(int i = 0; i < myLis.getLength(); i ++) {
                Node childNode = myLis.item(i);
                parseStylesheet(childNode, currentRoot);
            }
        }
    }   
     /**
     * Add a variable to the root which can be accessed using "value-of"
     * To change the value, simply re-define the variable.
     * To delete a variable simply re-define it empty
     * 
     * @param node
     * @param attributes 
     */
    private void processVariable(Node node, NamedNodeMap attributes) {
        Node attribute = attributes.getNamedItem("name");
        String name = attribute.getNodeValue();
        
        attribute = attributes.getNamedItem("select");
        String select = null;
        if (attribute == null) {
            select = node.getTextContent(); // .getNodeValue();
        } else {
            select = attribute.getNodeValue();
        }

        Node rootNode = xmlDocument.getDocumentElement();
        NodeList varNodeList = xmlDocument.getElementsByTagName(name);
        Node varNode = varNodeList.item(0);
        
        if (select == null || select.isEmpty()) {
            varNode.removeChild(varNode.getFirstChild());
            return;
        }
        
        if (varNode != null) {
            varNode.removeChild(varNode.getFirstChild());
        } else {
            varNode = xmlDocument.createElement(name);
        }
        varNode.appendChild(xmlDocument.createTextNode(select));
        rootNode.appendChild((Node)varNode);            
    }
    
    /**
     * Fills the sting with spaces at the end, returns a string with length
     * equal the given required length.
     *
     * @param value the string to fill with a character
     * @param ch the character to fill the string with
     * @param requiredLength the required length of the output string
     * @param justify where to fill the string
     * @return a string with length <code>requiredLength</code>
     */
    public static String ensureLength(String value, char ch, int requiredLength, int justify) {
        if(value == null) {
            value = "";
        }
        int length = value.length();
        StringBuilder buff = null;
        
        if (length < requiredLength) {
            buff = new StringBuilder();

            if(justify == CENTER_JUSTIFY) {
                int round = 0;
                int spaceToFill = requiredLength - length;               
                
                if(spaceToFill % 2 != 0) {
                    round = 1;
                }
                spaceToFill = spaceToFill / 2;
                
                for(int i = 0; i < spaceToFill + round; i++) {
                    buff.append(ch);
                }
                buff.append(value);

                for(int i = 0; i < spaceToFill; i++) {
                    buff.append(ch);
                }
            }
            else {
                if(justify == LEFT_JUSTIFY) {
                    buff.append(value);
                }
                int diff = requiredLength - length;

                for (int i = 0; i < diff; i++) {
                    buff.append(ch);
                }

                if(justify == RIGHT_JUSTIFY) {
                    buff.append(value);
                }
            }
        }
        else {
            buff = new StringBuilder(value.substring(0, requiredLength));
        }
        return buff.toString();
    }
}
