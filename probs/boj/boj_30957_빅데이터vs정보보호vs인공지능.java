package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class boj_30957_빅데이터vs정보보호vs인공지능 {
	static void solve() throws Exception {
		int n = scan.nextInt();
		char[] charArray = scan.nextCharArrayFromString();
		int[] BSA = new int[3];
		for (int i = 0; i < n; i++) {
			if(charArray[i] == 'B') BSA[0]++;
			else if(charArray[i] == 'S') BSA[1]++;
			else if(charArray[i] == 'A') BSA[2]++;
		}
		int max = 0;
		for (int i = 0; i < 3; i++) {
			max = Math.max(max, BSA[i]);
		}
		if(BSA[0] == max)
			sb.append('B');
		if(BSA[1] == max)
			sb.append('S');
		if(BSA[2] == max)
			sb.append('A');
		if("BSA".contentEquals(sb)){
			sb.setLength(0);
			sb.append("SCU");
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