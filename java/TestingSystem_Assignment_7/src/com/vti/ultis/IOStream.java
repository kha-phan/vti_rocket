package com.vti.ultis;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class IOStream {

	// read file
	public static String readFile(String pathFile) throws Exception {

		// Check file exists
		if (!FileManager.isFileExists(pathFile)) {
			throw new Exception(FileManager.FILE_NOT_EXISTS);
		}

		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(pathFile);

			// read 1KB
			byte[] b = new byte[1024];
			// convert 1KB to length of String
			int length = fileInputStream.read(b);

			String content = "";
			while (length > -1) {
				// read content from 0->length
				content = new String(b, 0, length);

				// continue read from position read b
				length = fileInputStream.read(b);
			}

			return content;

		} finally {
			// close
			fileInputStream.close();
		}
	}

	// write content to File
	public static void writeFile(String pathFile, String content, boolean isContinuing) throws Exception {

		// Check file exists
		if (!FileManager.isFileExists(pathFile)) {
			throw new Exception(FileManager.FILE_NOT_EXISTS);
		}

		FileOutputStream fileOutputStream = null;

		try {

			fileOutputStream = new FileOutputStream(pathFile, isContinuing);
			fileOutputStream.write(content.getBytes());

		} finally {
			// close file
			fileOutputStream.close();
		}
	}

	// read object
	public static Object readObject(String pathFile) throws Exception {

		// Check file exists
		if (!FileManager.isFileExists(pathFile)) {
			throw new Exception(FileManager.FILE_NOT_EXISTS);
		}

		// Read File
		FileInputStream fileInputStream = null;
		ObjectInputStream objectInputStream = null;

		try {
			fileInputStream = new FileInputStream(new File(pathFile));
			objectInputStream = new ObjectInputStream(fileInputStream);

			return objectInputStream.readObject();

		} finally {
			// close file
			fileInputStream.close();
			objectInputStream.close();
		}
	}

	// write object
	public static void writeObject(Object object, String pathFile) throws Exception {

		// Write file
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;

		try {
			fileOutputStream = new FileOutputStream(pathFile);
			objectOutputStream = new ObjectOutputStream(fileOutputStream);

			objectOutputStream.writeObject(object);

		} finally {
			// Close file
			fileOutputStream.close();
			objectOutputStream.close();
		}
	}
}