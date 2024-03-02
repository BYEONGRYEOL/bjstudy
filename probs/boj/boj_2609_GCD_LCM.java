package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2609_GCD_LCM {
	static int GCD(int a, int b) {
		// 입력이 72, 54라면?
		// 나눠지지 않으므로 54, 18에 대해서 재검사
		return (a % b == 0) ? b : GCD(b, a % b);
	}

	static int LCM(int a, int b) {
		//최소공배수 = a * b / GCD(a,b)
		// 왜냐면 a/GCD * b/GCD * GCD가 겹치는 인수들을 걸러내는 방법이므로
		return a * b / GCD(a, b);
	}

	static void input() throws Exception {
		int a = scan.nextInt();
		int b = scan.nextInt();
		sb.append(GCD(a, b)).append('\n');
		sb.append(LCM(a, b));
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