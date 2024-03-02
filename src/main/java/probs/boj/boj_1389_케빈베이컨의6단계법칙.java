package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1389_케빈베이컨의6단계법칙 {
	static void input() throws Exception {
		int n = scan.nextInt();
		int m = scan.nextInt();

		int[][] dist = new int[n + 1][n + 1];
		for (int i = 0; i < n + 1; i++) {
			Arrays.fill(dist[i], 10000);
		}
		for (int i = 0; i < m; i++) {
			int s = scan.nextInt();
			int e = scan.nextInt();
			dist[s][e] = 1;
			dist[e][s] = 1;
		}

		for (int k = 1; k < n + 1; k++)
			for (int i = 0; i < n + 1; i++)
				for (int j = 0; j < n + 1; j++)
					dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]);

		int minKevin = Integer.MAX_VALUE;
		int answer = n;
		for (int i = n; i > 0; i--) {
			int kevin = 0;
			for (int j = 1; j < n + 1; j++) {
				kevin += dist[i][j];
			}
			if (kevin <= minKevin) {
				minKevin = kevin;
				answer = i;
			}
		}
		System.out.println(answer);
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