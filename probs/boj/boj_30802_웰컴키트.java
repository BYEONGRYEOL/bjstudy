package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_30802_웰컴키트 {

	static void input() throws Exception {
		//
		// $S, M, L, XL, XXL, XXXL$이
		int N = scan.nextInt();
		int[] tshirts = new int[6];
		for (int i = 0; i < 6; i++) {
			tshirts[i] = scan.nextInt();
		}
		int tshirtBuyUnit = scan.nextInt();
		int penBuyUnit = scan.nextInt();

		int tshirtBuyCount = 0;
		for (int i = 0; i < 6; i++) {
			tshirtBuyCount += (int)Math.ceil((double)tshirts[i] / tshirtBuyUnit);
		}
		sb.append(tshirtBuyCount).append('\n');
		sb.append(String.format("%d %d", N / penBuyUnit, N%penBuyUnit));

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