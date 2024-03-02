package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_3015_오아시스재결합 {

	static void input() throws Exception {
		// 1 2 3
		Stack<long[]> s = new Stack<>();
		int n = scan.nextInt();

		long answer = 0;
		for (int i = 0; i < n; i++) {
			int now = scan.nextInt();
			long sameHeight = 1;
			while (!s.isEmpty() && s.peek()[0] <= now) {
				if (s.peek()[0] == now) {
					answer += s.peek()[1];
					sameHeight = s.peek()[1] + 1;
					s.pop();
				} else {
					answer += s.peek()[1];
					s.pop();
					sameHeight = 1;
				}

			}

			if (!s.isEmpty()) // 인접한
				answer++;
			s.push(new long[] {now, sameHeight});
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