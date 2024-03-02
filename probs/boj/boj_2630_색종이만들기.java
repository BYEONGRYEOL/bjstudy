package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2630_색종이만들기 {

	static int ZERO_COUNT = 0;
	static int ONE_COUNT = 0;

	static void checkColor(int sx, int sy, int offset, int[][] array) {
		int color = array[sx][sy];
		for (int dx = 0; dx < offset; dx++) {
			for (int dy = 0; dy < offset; dy++) {
				if (array[sx + dx][sy + dy] != color) {
					checkColor(sx, sy, offset / 2, array);
					checkColor(sx + offset / 2, sy, offset / 2, array);
					checkColor(sx, sy + offset / 2, offset / 2, array);
					checkColor(sx + offset / 2, sy + offset / 2, offset / 2, array);
					return;
				}
			}
		}
		if (color == 0) {
			ZERO_COUNT++;
		} else
			ONE_COUNT++;

	}

	static void input() throws Exception {
		int n = scan.nextInt();
		int[][] array = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				array[i][j] = scan.nextInt();
			}
		}
		checkColor(0, 0, n, array);
		sb.append(ZERO_COUNT).append('\n').append(ONE_COUNT);
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