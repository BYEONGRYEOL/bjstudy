package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_4563_리벤지오브피타고라스 {
	static void solve() throws Exception {
		while(true){
		    String input = scan.nextLine();
		    if("0".equals(input)) break;
		    long a = Long.parseLong(input);
			int rightTriangleCount = 0;
			long aSquare = a*a;
			for (int i = 1; i < a; i++) {
				if(aSquare % i == 0 && (aSquare/i + i) % 2 == 0 && (aSquare/i - i) % 2 == 0){
					// c-b = i
					// c+b = aSqaure / i
					long c =(aSquare/i + i) / 2;
					long b =(aSquare/i - i) /2;
					if(b > a && c > b){
						rightTriangleCount++;
					}
				}
			}
			sb.append(rightTriangleCount).append('\n');
		}
	}

	private static int getIntersectionArea(int[] box1, int[] box2) {
		int intersectionW = Math.max(0, Math.min(box1[2], box2[2]) - Math.max(box1[0], box2[0]));
		int intersectionH = Math.max(0, Math.min(box1[3], box2[3]) - Math.max(box1[1], box2[1]));
		return (intersectionW * intersectionH);
	}

	// 기울기를 계산할 때 기울기가 무한이 되는 경우를 생각해야한다.
	static long innerProduct(int[][] points){
		return (long)(points[1][0] - points[0][0]) * (points[1][1] - points[0][1]) + (long)(points[2][0] - points[0][0])
			* (points[2][1] - points[0][1]);
	}
	static long innerProduct(int[] point1, int[] point2, int[] point3) {
		return (long) (point2[0] - point1[0]) * (point2[1] - point1[1]) +
			(long) (point3[0] - point1[0]) * (point3[1] - point1[1]);
	}

	static long crossProduct(int[] point1, int[] point2, int[] point3) {
		int dx1 = point2[0] - point1[0];
		int dy1 = point2[1] - point1[1];
		int dx2 = point3[0] - point1[0];
		int dy2 = point3[1] - point1[1];

		return (long) dx1 * dy2 - (long) dy1 * dx2;
	}


	static long crossProduct(int[][] points) {
		int[] dx = new int[2];
		int[] dy = new int[2];

		for (int i = 0; i < 2; i++) {
			dx[i] = points[i + 1][0] - points[0][0];
			dy[i] = points[i + 1][1] - points[0][1];
		}

		return (long) dx[0] * dy[1] - (long) dy[0] * dx[1];
	}


	static double distance(int[] a, int[] b){
		return Math.sqrt(Math.pow(b[0] - a[0], 2) + Math.pow(b[1]-a[1], 2));
	}
	static long distanceSquare(int[] a, int[] b){
		return (long)(b[0] - a[0]) *(long)(b[0] - a[0]) + (long)(b[1]-a[1]) * (long)(b[1]-a[1]);
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