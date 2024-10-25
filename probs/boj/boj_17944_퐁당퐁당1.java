package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_17944_퐁당퐁당1 {

	static void input() throws Exception {
		int n = scan.nextInt();
		int t = scan.nextInt();
		// 0 1 2 	3 4 5 	6 7 8 9 10 11 12
		// 1 2 3 	4 3 2 	1 2 3 4  3  2

		// 1 2 3 4 5 6 7 8 9 10 11 12
		// 1 2 3 4 5 6 5 4 3  2  1
		if(((t-1) /(2 * n-1)) % 2 == 0){
			System.out.println((t-1) %(2 *n-1) + 1);
		} else{
			System.out.println(2 * n -(t-1) %(2 * n-1) );
		}

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