package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2096_내려가기 {

    static void solve() throws Exception {
		int n = scan.nextInt();
		long[][] arr = scan.nextLongMatrix(n, 3);
		long[][] dpMax = new long[n][3];
		long[][] dpMin = new long[n][3];
		// dpMax[i][j] : i번째 줄 j번째 칸까지 내려왔을 때의 최대 점수
		// dpMin[i][j] : i번째 줄 j번째 칸까지 내려왔을 때의 최소 점수
		// 각각 열로 내려가는 최대점수를 모두 구한다 : 2열은 0열은 제외하고 계산한다
		for (int j = 0; j < 3; j++) {
			dpMax[0][j] = arr[0][j];
			dpMin[0][j] = arr[0][j];
		}
		for(int i = 1; i < n ; i++){
			dpMax[i][0] = Math.max(dpMax[i-1][0], dpMax[i-1][1]) + arr[i][0];
			dpMax[i][1] = Math.max(Math.max(dpMax[i-1][0], dpMax[i-1][1]), dpMax[i-1][2]) + arr[i][1];
			dpMax[i][2] = Math.max(dpMax[i-1][1], dpMax[i-1][2]) + arr[i][2];
			dpMin[i][0] = Math.min(dpMin[i-1][0], dpMin[i-1][1]) + arr[i][0];
			dpMin[i][1] = Math.min(Math.min(dpMin[i-1][0], dpMin[i-1][1]), dpMin[i-1][2]) + arr[i][1];
			dpMin[i][2] = Math.min(dpMin[i-1][1], dpMin[i-1][2]) + arr[i][2];
		}
		long max = Math.max(Math.max(dpMax[n-1][0], dpMax[n-1][1]), dpMax[n-1][2]);
		long min = Math.min(Math.min(dpMin[n-1][0], dpMin[n-1][1]), dpMin[n-1][2]);
		sb.append(max).append(' ').append(min);
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

		long[] nextLongArray(int n) {
			long[] arr = new long[n];
			for (int i = 0; i < n; i++) {
				arr[i] = nextLong();
			}
			return arr;
		}
		long[][] nextLongMatrix(int n, int m) {
			long[][] arr = new long[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					arr[i][j] = nextLong();
				}
			}
			return arr;
		}

		String[][] nextStringMatrix_space(int n, int m) {
			String[][] arr = new String[n][m];
			for (int i = 0; i < n; i++) {
				arr[i] = scan.nextLine().split(" ");
			}
			return arr;
		}

		public double[] nextDoubleArray(int n) {
			double[] arr = new double[n];
			for (int i = 0; i < n; i++) {
				arr[i] = nextDouble();
			}
			return arr;
		}

		double[][] nextDoubleMatrix(int n, int m) {
			double[][] arr = new double[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					arr[i][j] = nextDouble();
				}
			}
			return arr;
		}

		int[][] nextIntMatrix(int n) {
			return nextIntMatrix(n, n);
		}

		int[][] nextIntMatrix(int n, int m) {
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