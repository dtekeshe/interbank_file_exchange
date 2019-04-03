package com.bsva.dmcs.fileloadv02.indexer;

import com.bsva.dmcs.fileloadv02.model.FileDetailDTO;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.bsva.dmcs.fileloadv02.util.StringUtils.replace;

/**
 * TODO Document
 */
public class ExportRecordWriter {

	private final Map<String, PrintWriter> writers;

	private final String exportFolder;

	private final static String FILE_PATH_SEPARATOR = System.getProperty("file.separator");

	public ExportRecordWriter(String exportFolder) {
		this.writers = new HashMap<>();
		this.exportFolder = exportFolder;
	}

	/*
	 * TODO Document
	 */
	public void write(List<FileDetailDTO> payLines) throws IOException {

		// validate records
		if (!"C".equals(payLines.get(0).getStatus())) {
			return;
		}

		// get filename
		String filename = payLines.get(0).getOutputFilename();
		String filepath = exportFolder + FILE_PATH_SEPARATOR + filename + ".idx";
		// get writer
		PrintWriter writer = writers.get(filename);
		// adde and used to print blank line for the writer arrays
		String firstLine = "";
		// create one if none
		if (writer == null) {
			writer = new PrintWriter(new BufferedWriter(new FileWriter(filepath, true)));
			// This starts from this positions and write the data
			// writer.println(padLeftString(firstLine,71));

			if (filename.startsWith("CD")) {
				writer.println(padLeftString(firstLine, 2228));
				writer.println(padLeftString(firstLine, 2228));
			}
			else {
				writer.println(padLeftString(firstLine, 71));
			}
			writers.put(filename, writer);
		}

		// write lines
		for (FileDetailDTO payLine : payLines) {
			fixSequence(payLine);
			writer.println(payLine.getInput());
		}
	}

	private void fixSequence(FileDetailDTO payLine) {
		// replace col 5 to 11 with new sequence number
		String input = payLine.getInput();
		long outputLineId = payLine.getOutputLineId();
		replace(input, "" + outputLineId, 5, 11);
	}

	public void flushAndClose() {

		for (String filename : writers.keySet()) {

			PrintWriter writer = writers.get(filename);
			writer.flush();
			writer.close();
		}

		// reset writers collection
		writers.clear();
	}

	public static String padLeftString(String s, int n) {
		return String.format("%0$" + n + "s", s).replace('0', ' ');
	}
}
