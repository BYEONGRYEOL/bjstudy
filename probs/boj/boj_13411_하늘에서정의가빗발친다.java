package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_13411_하늘에서정의가빗발친다 {
	static void solve() throws Exception {
		int iter = scan.nextInt();
		Missile[] missiles = new Missile[iter];
		for(int i =0; i < iter; i++){
		    double x = scan.nextDouble();
			double y = scan.nextDouble();
			double d = Math.sqrt(x*x + y*y);
			double time = d / scan.nextDouble();
			missiles[i] = new Missile(i+1,time);
		}
		Arrays.stream(missiles).sorted((m1,m2)->{
			if (m1.sec == m2.sec){
				return Integer.compare(m1.idx, m2.idx);
			}
			return Double.compare(m1.sec, m2.sec);
		}).forEachOrdered(d->sb.append(d.idx).append('\n'));
	}
	static class Missile{
		int idx;
		double sec;
		public Missile(int idx, double sec){
			this.idx=idx;
			this.sec=sec;
		}
	}

	private static int getIntersectionArea(int[] box1, int[] box2) {
		int intersectionW = Math.max(0, Math.min(box1[2], box2[2]) - Math.max(box1[0], box2[0]));
		int intersectionH = Math.max(0, Math.min(box1[3], box2[3]) - Math.max(box1[1], box2[1]));
		return (intersectionW * intersectionH);
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