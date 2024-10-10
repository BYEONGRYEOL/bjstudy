package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_5575_타임카드 {

	static void input() throws Exception {

		for (int i = 0; i < 3; i++) {

			int bhour = scan.nextInt();
			int bminute = scan.nextInt();
			int bsecond = scan.nextInt();
			int ahour = scan.nextInt();
			int aminute = scan.nextInt();
			int asecond = scan.nextInt();

			int diff = (ahour - bhour) * 60 * 60 + (aminute - bminute) * 60 + asecond - bsecond;

			sb.append(diff / 60 / 60).append(' ').append(diff / 60 % 60).append(' ').append(diff % 60).append('\n');

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