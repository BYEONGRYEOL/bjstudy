package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_9012_괄호 {
	static void input() throws Exception {
		// 규칙 1. 여는 괄호가 먼저 나와야함
		// 규칙 2. 닫는 괄호가 여는 괄호보다 많은 순간이 있으면 안된다.
		Stack<Character> s = new Stack<>();
		int caseNum = scan.nextInt();
		for (int z = 0; z < caseNum; z++) {
			s.clear();
			String parenthesis = scan.nextLine();
			boolean flag = true;
			for (int i = 0; i < parenthesis.length(); i++) {
				if (parenthesis.charAt(i) == '(') {
					s.push('(');
				} else {
					if (s.isEmpty()) {
						flag = false;
						break;
					}
					s.pop();
				}
			}

			// flag == false이면, 여는괄호보다 닫는 괄호가 많은 순간이 있었음
			// stack이 비어있지 않으면, 여는괄호가 더 많음
			sb.append(flag && s.isEmpty() ? "YES" : "NO").append('\n');
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