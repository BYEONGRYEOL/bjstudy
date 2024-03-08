package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_18111_마인크래프트 {

	static void input() throws Exception {
		int n = scan.nextInt() * scan.nextInt();
		int[] heights = new int[n];
		int blocks = scan.nextInt();
		int l = 0;
		for (int i = 0; i < n; i++) {
			heights[i] = scan.nextInt();
			l = Math.min(heights[i], l);
		}
		int totalBlocks = Arrays.stream(heights).sum() + blocks;
		int r = totalBlocks / n;

		int minTime = Integer.MAX_VALUE;
		int answerHeight = 0;
		for (int i = l; i <= r; i++) {
			int time = 0;
			for (int j = 0; j < n; j++) {
				if (heights[j] > i) {
					time += 2 * (heights[j] - i);
				} else {
					time -= heights[j] - i;
				}
			}
			if (minTime >= time) {
				minTime = time;
				answerHeight = i;
			} else {
				break;
			}
		}
		System.out.println(minTime + " " + answerHeight);

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