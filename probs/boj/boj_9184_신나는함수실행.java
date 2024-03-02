package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_9184_신나는함수실행 {

	static int[][][] memoW;

	static int w(int a, int b, int c) {
		if (a <= 0 || b <= 0 || c <= 0) {
			return 1;
		}
		if (a > 20 || b > 20 || c > 20) {
			return w(20, 20, 20);
		}
		if (a < b && b < c) {
			if (memoW[a][b][c] == 0)
				memoW[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
			return memoW[a][b][c];
		}
		if (memoW[a][b][c] == 0) {
			memoW[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c)
				+ w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
		}
		return memoW[a][b][c];
	}

	static void input() throws Exception {
		// 아무거나 0이하면 1리턴
		// 아무거나 20을 넘으면 w(20,20,20)
		// a<b<c 인경우
		// 재귀로도 풀 수 있을 것 같지만, 재귀로 풀지 말아달라함
		// 저번엔 w 함수의 1~20 각각의 리턴값을 모두 지정해서 풀었는데,
		// 메모이제이션을으로 진행해도 통과할까?

		memoW = new int[21][21][21];

		while (true) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			int c = scan.nextInt();
			if (a == -1 && b == -1 && c == -1)
				break;
			sb.append(String.format("w(%d, %d, %d) = %d", a, b, c, w(a, b, c))).append('\n');
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