package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_2304_창고다각형 {

	static void input() throws Exception {
		Stack<int[]> s = new Stack<>();
		int n = scan.nextInt();
		int answer = 0;
		int[][] columns = new int[n][2];
		int possibleEndHeight = 0;
		for (int i = 0; i < n; i++) {
			columns[i][0] = scan.nextInt();
			columns[i][1] = scan.nextInt();
		}

		Arrays.sort(columns, (a1, a2) -> a1[0] - a2[0]);

		for (int i = 0; i < n; i++) {
			int[] nowColumn = columns[i];
			int xPos = nowColumn[0];
			int height = nowColumn[1];

			if (s.isEmpty() || s.peek()[1] <= height) {
				s.push(nowColumn);
			}
		}

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