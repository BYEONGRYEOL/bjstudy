package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class boj_12840_창용이의시계 {
	static int day = 60 * 60 * 24;

	static void input() throws Exception {
		int sec = 0;
		sec += scan.nextInt() * 60 * 60;
		sec += scan.nextInt() * 60;
		sec += scan.nextInt();
		int iter = scan.nextInt();
		for (int i = 0; i < iter; i++) {
			int T = scan.nextInt();
			if (T == 3) {
				sb.append(String.format("%d %d %d\n", sec / 3600, sec % 3600 / 60, sec % 60));
			} else {
				sec = Math.floorMod(sec + scan.nextInt() * (T == 1 ? 1 : -1), day);
			}
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
