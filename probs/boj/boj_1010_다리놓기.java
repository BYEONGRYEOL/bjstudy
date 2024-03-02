package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1010_다리놓기 {

	static void input() throws Exception {
		int t = scan.nextInt();

		// 조합을 구해야 하는데,
		// 30C15 같은 큰 수의 경우 팩토리얼을 활용하면 계산과정에 overflow가 날 수도 있다.
		// nCr = n-1Cr + n-1Cr-1 을 활용하자.

		// 1
		// 1 1
		// 1 2 1

		int[][] C = new int[31][31];

		for (int i = 1; i <= 30; i++) {
			// nCn && nC0 = 1
			C[i][0] = 1;
			C[i][i] = 1;
		}

		for (int i = 2; i <= 30; i++) {
			for (int j = 1; j < i; j++) {
				C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
			}
		}

		for (int z = 0; z < t; z++) {
			int r = scan.nextInt();
			int n = scan.nextInt();
			sb.append(C[n][r]).append('\n');
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