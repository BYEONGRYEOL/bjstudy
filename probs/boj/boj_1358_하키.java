package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1358_하키 {
	static void solve() throws Exception {
		int w = scan.nextInt();
		int h = scan.nextInt();
		int ox = scan.nextInt();
		int oy = scan.nextInt();
		int p = scan.nextInt();

		int[] c1 = new int[2];
		c1[0] = ox;
		c1[1] = oy + h/2;
		int[] c2 = new int[2];
		c2[0] = ox + w;
		c2[1] = oy + h/2;

		int boxMinX = ox;
		int boxMinY = oy;
		int boxMaxX = ox + w;
		int boxMaxY = oy + h;
		int count = 0;
		for (int i = 0; i < p; i++) {
			int t[] = scan.nextIntArray(2);
			// 두 원 안에
			if(distance(c1, t) <= h/2 || distance(c2, t) <= h/2 || boxMinX <= t[0] && boxMaxX >= t[0] && boxMinY <= t[1] && boxMaxY >= t[1]) {
				count++;
			}
		}
		sb.append(count);
	}

	// 기울기를 계산할 때 기울기가 무한이 되는 경우를 생각해야한다.
	static long crossProduct(int[][] points) {
		int[] dx = new int[2];
		int[] dy = new int[2];

		for (int i = 0; i < 2; i++) {
			dx[i] = points[i + 1][0] - points[0][0];
			dy[i] = points[i + 1][1] - points[0][1];
		}

		return (long) dx[0] * dy[1] - (long) dy[0] * dx[1];
	}

	static boolean hasDuplicatePoints(int[][] points){
		for (int i = 0; i < points.length-1; i++) {
			if(points[i][0] == points[i+1][0] && points[i][1] == points[i+1][1]){
				return true;
			}
		}
		return false;
	}

	static double distance(int[] a, int[] b){
		return Math.sqrt(Math.pow(b[0] - a[0], 2) + Math.pow(b[1]-a[1], 2));
	}

	static void print() {
		System.out.print(sb.toString());
	}

	private static int compareDoublePoint(double[] a1, double[] a2) {
		if (a1[0] == a2[0])
			return Double.compare(a1[1], a2[1]);
		return Double.compare(a1[0], a2[0]);
	}

	private static int compareIntPoint(int[] a1, int[] a2) {
		if (a1[0] == a2[0])
			return Integer.compare(a1[1], a2[1]);
		return Integer.compare(a1[0], a2[0]);
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

		char[][] nextCharMatrixFromString(int n) {
			char[][] arr = new char[n][];
			for (int i = 0; i < n; i++) {
				arr[i] = nextCharArrayFromString();
			}
			return arr;
		}

		public String[] nextStringArray(int n) {
			String[] arr = new String[n];
			for (int i = 0; i < n; i++) {
				arr[i] = scan.nextLine();
			}
			return arr;
		}
	}

	public static void main(String[] args) throws Exception {
		solve();
		print();
	}

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

}