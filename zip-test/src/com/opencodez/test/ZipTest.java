/**
 * 
 */
package com.opencodez.test;

/**
 * @author pavan.solapure
 *
 */
public class ZipTest {

	private static final String OUTPUT_ZIP_FILE = "C:\\java-exec\\MyFile1.zip";
	private static final String SOURCE_FOLDER = "C:\\java-exec";
	private static final String DESTINATION_FOLDER = "C:\\java-exec\\unzipped";

	public static void main(String[] args) {
		
		ZipUtil zipper = new ZipUtil();
		
		//Zip all the text files from source folder to specified zip file.
		zipper.zip(SOURCE_FOLDER, OUTPUT_ZIP_FILE, "txt");
		
		//Unzip the given archive to specified folder.
		zipper.unzip(OUTPUT_ZIP_FILE, DESTINATION_FOLDER);
	}
}
