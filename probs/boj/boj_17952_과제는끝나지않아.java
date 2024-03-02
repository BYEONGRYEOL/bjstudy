package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_17952_과제는끝나지않아 {

	static void input() throws Exception {
		int time = scan.nextInt();
		int totalPoint = 0;
		Stack<int[]> s = new Stack<>();
		for (int t = 1; t <= time; t++) {
			int taskFlag = scan.nextInt();

			if (taskFlag == 1) {

				int point = scan.nextInt();
				int duration = scan.nextInt();
				s.push(new int[] {point, duration});
			}
			if (!s.isEmpty()) {
				int[] task = s.peek();
				task[1] -= 1;
				if (task[1] == 0) {
					totalPoint += task[0];
					s.pop();
				}
			}
		}
		System.out.println(totalPoint);
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