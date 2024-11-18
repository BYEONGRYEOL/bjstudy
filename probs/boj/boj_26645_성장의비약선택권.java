package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_26645_성장의비약선택권 {

	static void input() throws Exception {
		int[] levelLimit = {210, 220, 230, 240};
		int[] drug = {8,4,2,1};
		int maxLevel = 0;
		int maxDrugIdx = 0;
		int nowLevel = scan.nextInt();
		for (int i = 0; i < 4; i++) {
			if(maxLevel <= Math.min(nowLevel + drug[i], levelLimit[i])){
				maxDrugIdx = i+1;
				maxLevel = Math.min(nowLevel + drug[i], levelLimit[i]);
			}
		}
		System.out.println(maxDrugIdx);

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