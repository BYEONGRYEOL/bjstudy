package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_30454_얼룩말을찾아라 {

	static void input() {
		int iter = scan.nextInt();
		int len = scan.nextInt();
		int maxBlackLineCount = 0;
		int maxBlackLineIndividualCount = 0;
		for (int i = 0; i < iter; i++) {
			String zebra = scan.nextLine();
			char now = '0';
			int blackLineCount = 0;
			for (int j = 0; j < len; j++) {
				if(now == '0' && zebra.charAt(j) == '1'){
					blackLineCount++;
				}
				now = zebra.charAt(j);
			}
			if(blackLineCount > maxBlackLineCount){
				maxBlackLineCount = blackLineCount;
				maxBlackLineIndividualCount = 1;
			} else if(blackLineCount == maxBlackLineCount){
				maxBlackLineIndividualCount++;
			}
		}
		sb.append(maxBlackLineCount).append(' ').append(maxBlackLineIndividualCount);
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

	public static void main(String[] args) {
		input();
	}

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

}