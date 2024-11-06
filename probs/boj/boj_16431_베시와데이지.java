package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_16431_베시와데이지 {
	static void solve() throws Exception {
		int[] bessie = scan.nextIntArray(2);
		int[] daisy = scan.nextIntArray(2);
		int[] target = scan.nextIntArray(2);
		int bessieDistance = Math.max(Math.abs(target[0] - bessie[0]), Math.abs(target[1] - bessie[1]));
		int daisyDistance = Math.abs(target[0] - daisy[0]) + Math.abs(target[1] - daisy[1]);
		if(bessieDistance>daisyDistance)
			sb.append("daisy");
		else if(daisyDistance>bessieDistance)
			sb.append("bessie");
		else sb.append("tie");
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