package com.io;

import java.io.*;

public class FileCopyCharacter {
	public static void main(String[] args) {
		FileReader fis = null;
		FileWriter fos = null;
		try {
			fis = new FileReader("d:\\stream.txt");
			fos = new FileWriter("d:\\copystream.txt");
			long t1 = System.currentTimeMillis();// value in milliseconds

			int data = 0;
			while ((data = fis.read()) != -1) {
				fos.write(data);
			}

			long t2 = System.currentTimeMillis();
			System.out.println("File Copied in " + (t2 - t1) + " milliseconds");

		} catch (FileNotFoundException fe) {
			System.out.println(fe);
		} catch (IOException ie) {
			System.out.println(ie);
		} finally {
			try {
				if (fis != null)
					fis.close();
				if (fos != null)
					fos.close();
			} catch (IOException ie) {
				System.out.println(ie);
			}
		}

	}

}