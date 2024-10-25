package probs.boj;

import static java.lang.Double.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_6322_직각삼각형의두변 {

	static void input() throws Exception {
		int[] len = new int[3];
		int idx = 1;
		while(true){
			for (int i = 0; i < 3; i++) {
				len[i] = scan.nextInt();
			}
			if(len[0] == 0) break;

			if(len[0] == -1){
				double computedLen = Math.sqrt(len[2] * len[2] - len[1] * len[1]);
				if(Double.isNaN(computedLen) || computedLen == 0){
					System.out.printf("Triangle #%d\nImpossible.\n\n",idx++);
				} else System.out.printf("Triangle #%d\na = %.3f\n\n",idx++,computedLen);
			}
			else if(len[1] == -1){
				double computedLen = Math.sqrt(len[2] * len[2] - len[0] * len[0]);
				if(Double.isNaN(computedLen) || computedLen == 0){
					System.out.printf("Triangle #%d\nImpossible.\n\n",idx++);
				} else System.out.printf("Triangle #%d\nb = %.3f\n\n",idx++,computedLen);
			}
			else if(len[2] == -1){
				double computedLen = Math.sqrt(len[0] * len[0] + len[1] * len[1]);
				if(Double.isNaN(computedLen) || computedLen == 0){
					System.out.printf("Triangle #%d\nImpossible.\n\n",idx++);
				} else System.out.printf("Triangle #%d\nc = %.3f\n\n",idx++,computedLen);
			}
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
