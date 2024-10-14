package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_29725_체스초보비실이 {

	static void input() throws Exception {
		//K, k, P, p, N, n, B, b, R, r, Q, q
		int[] score = new int[200];
		//킹, 폰, 나이트, 비숍, 룩, 퀸의 기물 점수는 각각
		// $0$,
		// $1$,
		// $3$,
		// $3$,
		// $5$,
		// $9$점이다.
		score['P'] = 1;
		score['p'] = -1;
		score['N'] = 3;
		score['n'] = -3;
		score['B'] = 3;
		score['b'] = -3;
		score['R'] = 5;
		score['r'] = -5;
		score['Q'] = 9;
		score['q'] = -9;
		int result = 0;
		for (int i = 0; i < 8; i++) {
			String line = scan.nextLine();
			for (int j = 0; j < 8; j++) {
				result += score[line.charAt(j)];
			}
		}
		System.out.println(result);
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
