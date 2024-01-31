package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj9613_GCD합 {

	static int gcd(int a, int b) {
		return a % b == 0 ? b : gcd(b, a % b);
	}

	static void input() throws Exception {
		int numCase = scan.nextInt();

		for (int i = 0; i < numCase; i++) {
			int n = scan.nextInt();
			if (n == 1) {
				sb.append(scan.nextInt()).append('\n');
				continue;
			}
			long answer = 0;
			int[] arr = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = scan.nextInt();
			}

			for (int j = 0; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					answer += gcd(arr[j], arr[k]);
				}
			}
			sb.append(answer).append('\n');
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