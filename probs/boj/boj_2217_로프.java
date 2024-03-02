package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2217_로프 {

	static void input() throws Exception {
		int n = scan.nextInt();
		Integer[] ropes = new Integer[n];
		for (int i = 0; i < n; i++) {
			ropes[i] = scan.nextInt();
		}
		Arrays.sort(ropes, (i1, i2) -> i2 - i1);
		int maxWeight = 0;
		for (int i = 0; i < n; i++) {
			maxWeight = Math.max(ropes[i] * (i + 1), maxWeight);
		}
		System.out.println(maxWeight);
	}

	static int calculateK(int n, int m) {
		int calculateK = 0;
		for (int i = 1; i <= n; i++) {
			calculateK += Math.min(m / i, n);
		}
		return calculateK;
	}

	static long lessThanCount(long n, long x) {
		long count = 0;
		for (int i = 1; i <= n; i++) {
			count += Math.min(n, x / i);
		}
		return count;
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