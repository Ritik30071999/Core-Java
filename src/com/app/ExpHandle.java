package com.app;

public class ExpHandle {
	public static void main(String[] args) {

		try {
			String nm = "hello";
			int x = Integer.parseInt(nm);
			System.out.println(x);
			int a = 8 / 0;
			System.out.println(a);

		} catch (ArithmeticException ae) { // catch(AritmeticException|NumberFormatException e)

			System.out.println(ae);
			System.out.println("------------------");
			ae.printStackTrace();
		} catch (NumberFormatException nf) {
			System.out.println(nf);
			System.out.println("------------------");
			nf.printStackTrace();
			System.out.println("------------------");
			System.out.println(nf.getMessage());
		}

		finally {
			System.out.println("Always Execute");
		}
	}

}
