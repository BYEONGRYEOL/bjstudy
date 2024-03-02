package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_11053_가장긴증가하는부분수열 {

	static void input() throws Exception {
		int n = scan.nextInt();

		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = scan.nextInt();
		}

		int[] dp = new int[n];
		Arrays.fill(dp, 1);

		for (int i = 1; i < n; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (array[i] > array[j]) { // 현재 i는 j보다 크므로 증가하는 부분 수열에 추가 가능
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		System.out.println(Arrays.stream(dp).max().getAsInt());
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