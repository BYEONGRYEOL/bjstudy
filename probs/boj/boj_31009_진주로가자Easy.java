package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

public class boj_31009_진주로가자Easy {

	static void input() throws Exception {
		int n = scan.nextInt();
		int jinjuFee = 0;
		int[] fees = new int[n];
		for (int i = 0; i < n; i++) {
			String[] transit = scan.nextLine().split(" ");
			fees[i] = Integer.parseInt(transit[1]);
			if(transit[0].equals("jinju")){
				jinjuFee = fees[i];
			}
		}
		int expensiveCount = 0;
		for (int i = 0; i < n; i++) {
			if(fees[i] > jinjuFee){
				expensiveCount ++;
			}
		}
		System.out.println(jinjuFee);
		System.out.println(expensiveCount);
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