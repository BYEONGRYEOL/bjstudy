package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1932_정수삼각형 {

	static void input() throws Exception {
		int n = scan.nextInt();
		int triangle[][] = new int[n][n];

		for (int i = 0; i < n; i++)
			for (int j = 0; j <= i; j++)
				triangle[i][j] = scan.nextInt();

		int dp[][] = new int[n][n];

		dp[0][0] = triangle[0][0];

		for (int i = 1; i < n; i++) { // 끝점은 경로가 끝으로만 이동한 경우 단 하나이다.
			dp[i][0] = dp[i - 1][0] + triangle[i][0];
			dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];
		}

		for (int i = 2; i < n; i++) {
			for (int j = 1; j < n - 1; j++) {
				dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
			}
		}
		System.out.println(Arrays.stream(dp[n - 1]).max().getAsInt());

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