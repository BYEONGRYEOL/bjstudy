package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_1874_스택수열 {
	static void input() throws Exception {
		int n = scan.nextInt();
		// 4 3 6 8 7 5 2 1 을 스택으로 만들 수 있는가?
		// 생각해보면, 4 2 같은 수열은 죽어도 만들 수 없다.
		// 1 2 5 3 4
		// 1 2 는 해결하고 5 까지 push한 경우라면, 이제는 4 3의 순서로 pop 할 수밖에 없다.
		// 이미 지나간 수들은 stack에 저장하고있어야 순서를 지키며 뺄 수 있다.
		Stack<Integer> s = new Stack<>();
		int currentNum = 1;
		for (int i = 1; i <= n; i++) {
			// 수열에서 현재 필요한 숫자
			int number = scan.nextInt();
			// 이 while문에 걸리지 않는다면, 이미 검사를 했던 수
			// 따라서 이미 스택에 들어가있는 숫자를 뽑아서 써야한다.
			while (currentNum <= number) {
				s.add(currentNum);
				sb.append('+').append('\n');
				currentNum++;
			}
			if (s.peek() == number) {
				s.pop();
				sb.append('-').append('\n');
			} else {
				System.out.println("NO");
				return;
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