package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14928_큰수_BIG {

	static void input() throws Exception {
		String num = scan.nextLine();
		int divisor = 20000303;
		int divisorLen = 8;
		StringBuilder tempDividend = new StringBuilder();
		int i = 0;
		while (i < num.length()) {
			tempDividend.append(num.charAt(i++));
			if (tempDividend.length() >= divisorLen) {
				int tempD = Integer.parseInt(tempDividend.toString());
				while (tempD >= divisor)
					tempD -= divisor;
				tempDividend = new StringBuilder(String.valueOf(tempD));
			}
		}
		while(tempDividend.length() > 1 && tempDividend.charAt(0) == '0')
			tempDividend.deleteCharAt(0);
		System.out.println(tempDividend);
	}

	static void print() {
		System.out.print(sb.toString());
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public FastReader(String s) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(new File(s)));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

	public static void main(String[] args) throws Exception {
		input();
	}

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

}