package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_16727_ICPC {

	static void input() throws Exception {
		int homeA = scan.nextInt();
		int awayB = scan.nextInt();
		int homeB = scan.nextInt();
		int awayA = scan.nextInt();
		int result = 0; // 1 awin 2 bwin 0 draw
		if(homeA + awayA != homeB + awayB){
			result = (homeA + awayA) > (homeB + awayB) ? 1 : 2;
		} else{
			if(awayA == awayB){
				result = 0;
			} else{
				result = awayA > awayB ? 1 : 2;
			}
		}
		if(result == 1){
			System.out.println("Persepolis");
		} else if(result == 2){
			System.out.println("Esteghlal");
		} else
			System.out.println("Penalty");
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