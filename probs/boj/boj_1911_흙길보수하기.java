package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1911_흙길보수하기 {

	static void input() throws Exception {
		
		int N = scan.nextInt();
		int L = scan.nextInt();
		int[][] pools = new int[N][2];
		for (int i = 0; i < N; i++) {
			pools[i][0] = scan.nextInt();
			pools[i][1] = scan.nextInt();
		}
		Arrays.sort(pools, (a1, a2) -> a1[0] - a2[0]);
		int lastPlank = 0;
		int count = 0;
		for (int i = 0; i < N; i++) {
			if (lastPlank < pools[i][1]) {
				if (lastPlank >= pools[i][0]) {
					pools[i][0] = lastPlank + 1;
				}

				int toCover = pools[i][1] - pools[i][0];
				int usePlank = toCover / L + (toCover % L > 0 ? 1 : 0);

				count += usePlank;
				lastPlank = (pools[i][0] + L * usePlank) - 1;

				// System.out.printf("toCover : %d usePlank : %d count : %d lastPlank : %d \n", toCover, usePlank, count,
				// lastPlank);
			}
		}
		System.out.println(count);
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