package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_32369_양파실험 {

	static void input() throws Exception {
		int[] onions = {1,1};
		int N = scan.nextInt();
		int compliment = scan.nextInt();
		int blame = scan.nextInt();
		int temp = 0;
		for (int i = 0; i < N; i++) {
			onions[0] += blame;
			onions[1] += compliment;
			if(onions[0] > onions[1]){
				temp = onions[0];
				onions[0] = onions[1];
				onions[1] = temp;
			} else if(onions[1] == onions[0]){
				onions[0] --;
			}
		}
		System.out.printf("%d %d", onions[1], onions[0]);
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
