package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_10828_Stack {
	static void input() throws Exception {
		int operationCount = scan.nextInt();
		Stack<Integer> s = new Stack<>();
		Map<String, Integer> operationMapper = Map.of(
			"push", 1,
			"empty", 2,
			"size", 3,
			"top", 4,
			"pop", 5
		);

		for (int i = 0; i < operationCount; i++) {
			String[] operation = scan.nextLine().split(" ");

			// switch 문자열 됨..
			switch (operationMapper.get(operation[0])) {
				case 1:
					s.add(Integer.parseInt(operation[1]));
					break;
				case 2:
					sb.append(s.isEmpty() ? 1 : 0).append('\n');
					break;
				case 3:
					sb.append(s.size()).append('\n');
					break;
				case 4:
					if (s.isEmpty())
						sb.append(-1).append('\n');
					else
						sb.append(s.peek()).append('\n');
					break;

				case 5:
					if (s.isEmpty())
						sb.append(-1).append('\n');
					else
						sb.append(s.pop()).append('\n');
					break;
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