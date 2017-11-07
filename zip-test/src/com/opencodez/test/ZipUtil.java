/**
 * 
 */
package com.opencodez.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * @author pavan.solapure
 *
 */
public class ZipUtil {

	private final static String DEFAULT_EXTENSION_TO_ZIP = "txt";

	public void zip(String sourceDir, String destZipFile, String extensions) {
		List<File> fileList = getFileList(sourceDir, extensions);
		zipFiles(fileList, destZipFile);
	}

	public void zip(String sourceDir, String destZipFile) {
		List<File> fileList = getFileList(sourceDir, null);
		zipFiles(fileList, destZipFile);
	}

	public void unzip(String srcZipFile, String destDir) {
		byte[] buffer = new byte[1024];
		
		try {
			ZipInputStream zis = new ZipInputStream(new FileInputStream(srcZipFile));
			ZipEntry zipEntry = zis.getNextEntry();
			while (zipEntry != null) {
				String fileName = zipEntry.getName();
				File newFile = new File(destDir + File.separator + fileName);
				FileOutputStream fos = new FileOutputStream(newFile);
				int len;
				while ((len = zis.read(buffer)) > 0) {
					fos.write(buffer, 0, len);
				}
				fos.close();
				//This is required to make sure the unzipped files keep the last modified 
				//time same as of the time they were compressed.
				newFile.setLastModified(zipEntry.getTime());
				zipEntry = zis.getNextEntry();
			}
			zis.closeEntry();
			zis.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private void zipFiles(List<File> fileList, String destZipFile) {

		byte[] buffer = new byte[1024];

		try {

			FileOutputStream fos = new FileOutputStream(destZipFile);
			ZipOutputStream zos = new ZipOutputStream(fos);

			System.out.println("Creating Zip Archive : " + destZipFile);

			for (File file : fileList) {

				System.out.println("Added " + file);
				ZipEntry ze = new ZipEntry(file.getName());
				//This is required to make sure the archived files keep the last modified 
				//time same as disk.   
				ze.setTime(file.lastModified());
				zos.putNextEntry(ze);

				FileInputStream in = new FileInputStream(file);

				int len;
				while ((len = in.read(buffer)) > 0) {
					zos.write(buffer, 0, len);
				}
				in.close();
			}
			zos.closeEntry();
			zos.close();
			System.out.println("Done");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private List<File> getFileList(String sourceDir, String extensions) {

		List<File> fileList = new ArrayList<File>();

		File dir = new File(sourceDir);

		if (dir.isDirectory()) {

			String[] fList = dir.list();

			for (String filename : fList) {
				File iFile = new File(getAbsolutePath(dir, filename));
				if (iFile.isFile()) {
					if (null != extensions) {
						if (extensions.toLowerCase().contains(getFileExtension(filename))) {
							fileList.add(iFile);
						}
					} else {
						fileList.add(iFile);
					}
				}
			}
		} else if (dir.isFile()) {
			fileList.add(dir);
		}

		return fileList;
	}

	private String getAbsolutePath(File dir, String filename) {
		return dir.getAbsolutePath() + File.separator + filename;
	}

	private String getFileExtension(String filename) {
		return (filename == null) ? DEFAULT_EXTENSION_TO_ZIP
				: filename.substring(filename.lastIndexOf(".") + 1, filename.length());
	}
}
