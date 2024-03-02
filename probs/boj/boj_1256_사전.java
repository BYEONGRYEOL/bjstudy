package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1256_사전 {

	static void input() throws Exception {
		// 2 2

		int n = scan.nextInt();
		int m = scan.nextInt();
		int k = scan.nextInt();
		int[][] C = new int[101][101];
		for (int i = 1; i < 101; i++) {
			C[i][0] = 1;
			C[0][i] = 1;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				C[i][j] = Math.min(C[i - 1][j] + C[i][j - 1], 1000000000);
			}
		}

		// 3 4 일경우
		// a a2z4
		// z a3z3

		int l = 1;
		if (k > C[n][m]) {
			System.out.println(-1);
			return;
		}
		while (n > 0 && m > 0) {
			// System.out.println("k : " + k + " n : " + n + " m : " + m + " l : " + l);
			if (k >= l + C[n - 1][m]) {
				sb.append('z');
				l += C[n - 1][m];
				m--;
			} else {
				sb.append('a');
				n--;
			}
		}
		for (int i = 0; i < n; i++) {
			sb.append('a');
		}
		for (int i = 0; i < m; i++) {
			sb.append('z');
		}
		print();
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