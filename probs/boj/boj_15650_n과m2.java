package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_15650_n과m2 {

	static int[] result;

	static void dfs(int N, int R, int now, int depth) {
		if (depth == R) {
			for (int i = 0; i < R; i++) {
				sb.append(result[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		if (now > N) {
			return;
		}
		result[depth] = now;
		dfs(N, R, now + 1, depth + 1);
		result[depth] = 0;
		dfs(N, R, now + 1, depth);
	}

	static void input() throws Exception {
		int n = scan.nextInt();
		int r = scan.nextInt();
		result = new int[n];
		//calculate nPr
		dfs(n, r, 1, 0);

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