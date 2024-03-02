package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_4889_안정적인문자열 {

	static void input() throws Exception {
		int caseNum = 0;
		while (true) {
			caseNum++;
			String line = scan.nextLine();
			if (line.startsWith("-"))
				break;
			int openParenthesis = 0;
			int operationCount = 0;
			for (int i = 0; i < line.length(); i++) {
				if (line.charAt(i) == '{') {
					openParenthesis++;
				} else {
					openParenthesis--;
				}
				if (openParenthesis == -1) {
					openParenthesis = 1;
					operationCount++;
				}
			}
			operationCount += openParenthesis / 2;
			sb.append(caseNum).append('.').append(' ').append(operationCount).append('\n');
		}
		print();
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