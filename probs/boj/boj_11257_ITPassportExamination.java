package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_11257_ITPassportExamination {

	static void input() throws Exception {
		int iter = scan.nextInt();
		for (int i = 0; i < iter; i++) {
			int id = scan.nextInt();
			int[] points = new int[3];
			int[] criteria = {35, 25, 40};
			boolean passed = true;
			int sum = 0;
			for (int j = 0; j < 3; j++) {
				points[j] = scan.nextInt();
				sum += points[j];
				if(points[j] < criteria[j] * 0.3)
					passed = false;
			}
			if(sum < 55)
				passed = false;
			sb.append(String.format("%d %d %s", id, sum, passed ? "PASS":"FAIL")).append('\n');
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