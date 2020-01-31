package com.io;

import java.io.*;

public class ImageCopy {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream("d:\\wof.jpeg");
			fos = new FileOutputStream("d:\\copywof.jpeg");
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