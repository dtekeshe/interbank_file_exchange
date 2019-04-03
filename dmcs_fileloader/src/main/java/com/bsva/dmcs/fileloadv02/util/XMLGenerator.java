package com.bsva.dmcs.fileloadv02.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

/**
 * Generated when the entire file has been rejected
 * e.g fatal error with the header/trailer of the file
 *
 */
public class XMLGenerator <T> {

    public final static String FILE_PATH = System.getProperty("file.separator");

    public void generate(String path, String filename, T data) throws JAXBException {

        File file = new File(path + FILE_PATH + filename);
        file.delete();
        JAXBContext context = JAXBContext.newInstance(data.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(data, file);
    }
}
