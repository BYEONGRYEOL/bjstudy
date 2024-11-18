package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2991_사나운개 {
	static int ATTACK = 0;
	static int CYCLE = 1;
	static void solve() throws Exception {
		int[] dog1 = scan.nextIntArray(2);
		int[] dog2 = scan.nextIntArray(2);
		dog1[CYCLE] +=dog1[ATTACK];
		dog2[CYCLE] +=dog2[ATTACK];
		for (int i = 0; i < 3; i++) {
			int bitten = 0;
			int minute = scan.nextInt();
			if(dog1[ATTACK] > (minute-1) % dog1[CYCLE])
				// if(dog1[ATTACK] >= minute % dog1[CYCLE]  && minute % dog1[CYCLE] != 0)
				// 주석처리된 라인의 결과와 완전히 동일하다.
				bitten ++;
			if(dog2[ATTACK] > (minute-1) % dog2[CYCLE])
				bitten ++;
			sb.append(bitten).append('\n');
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
		int[] nextIntArray(int n) {
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = nextInt();
			}
			return arr;
		}
		int[][] nextIntMatrix(int n) {
			return nextIntMatrix(n,n);
		}
		int[][] nextIntMatrix(int n, int m){
			int[][] arr = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					arr[i][j] = nextInt();
				}
			}
			return arr;
		}
		char[] nextCharArrayFromString() {
			return scan.nextLine().toCharArray();
		}
	}

	public static void main(String[] args) throws Exception {
		solve();
		print();
	}

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

}