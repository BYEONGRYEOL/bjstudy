package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_20233_Bicycle {

	static void input() throws Exception {
		int aMonthlyFee = scan.nextInt();
		int aExceed30Fee = scan.nextInt();
		int bMonthlyFee = scan.nextInt();
		int bExceed45Fee = scan.nextInt();
		int time = scan.nextInt();
		int aTotalFee = aMonthlyFee + 21 * Math.max(0, (time - 30)) * aExceed30Fee;
		int bTotalFee = bMonthlyFee + 21 * Math.max(0,(time - 45)) * bExceed45Fee;
		System.out.printf("%d %d", aTotalFee, bTotalFee);

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