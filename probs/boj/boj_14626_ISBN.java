package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import static java.util.Arrays.binarySearch;

public class boj_14626_ISBN {

	static void solve() throws Exception {
		String isbn = scan.nextLine();
		int sum = 0;
		int asteriskDigit = 0;
		for(int i = 0; i < isbn.length()-1; i++) {
			if(isbn.charAt(i) == '*') {
				asteriskDigit = i % 2;
				continue; // *인 경우는 건너뛴다.
			}
			if(i % 2 == 0) {
				sum += isbn.charAt(i) - '0';
			} else {
				sum += (isbn.charAt(i) - '0') * 3;
			}
		}
		sum += (isbn.charAt(isbn.length() - 1) - '0');
		int mod = sum % 10;
		int asterRiskValue = (10 - mod)%10;
		if(asteriskDigit == 1) {
			for(int i = 0; i <= 9; i++){
				if((i * 3) % 10 == asterRiskValue){
					asterRiskValue = i;
					break;
				}
			}
		}
		sb.append(asterRiskValue);
		
		
	}


	private static void printBoard(int[][] board) {
		for (int[] row : board) {
			for (int cell : row) {
				sb.append(cell).append(" ");
			}
			sb.append("\n");
		}
		sb.append("\n");
		
	}

	static List<int[]> unlockDoor(char[][] map, boolean[] keysAvailable) {
		List<int[]> unlockedDoors = new ArrayList<>();
		for(int i = 0 ; i < map.length; i++) {
			for(int j = 0 ; j < map[i].length; j++) {
				if(map[i][j] >= 'A' && map[i][j] <= 'Z') { // 문인 경우
					if(keysAvailable[map[i][j] - 'A']) { // 키가 없는 경우
						map[i][j] = '.'; // 문을 열 수 있으므로 문을 제거
						unlockedDoors.add(new int[] {i, j}); // 문이 열렸음을 기록
					}
				}
			}
		}
		return unlockedDoors; // 문을 열 수 있는 키가 있는지 여부를 반환
	}
	//
	// public static void dfs(int x, int y, char[][] board, boolean visited[][], )

	public static double crossProduct(Point2D p1, Point2D p2, Point2D p3) {
		// x1 x2 x3
		// y1 y2 y3
		double result = p1.x * p2.y + p2.x * p3.y + p3.x * p1.y;
		result -= p2.x * p1.y + p3.x * p2.y + p1.x * p3.y;
		return result;
	}

	static class UnionFind {
		static int[] parent;

		static void init(int n) {
			parent = new int[n + 1];
			for (int i = 0; i < n + 1; i++) {
				parent[i] = i;
			}
		}

		static int getParent(int c) {
			if (parent[c] == c)
				return c;
			return getParent(parent[c]);
		}

		static boolean union(int a, int b) {
			a = getParent(a);
			b = getParent(b);
			if (a == b)
				return false;
			parent[a] = b;
			return true;
		}
	}

	static class LineSegment3D {
		Point3D p1;
		Point3D p2;
		Vector3D v;

		public LineSegment3D(Point3D p1, Point3D p2) {
			this.p1 = p1;
			this.p2 = p2;
			this.v = new Vector3D(p2, p1);
		}

		public boolean isOnLineSegment(Point3D p) {
			Vector3D v = new Vector3D(this.p1, this.p2);
			double dx = v.x * (p.x - this.p1.x);
			double dy = v.y * (p.y - this.p1.y);
			double dz = v.z * (p.z - this.p1.z);
			boolean isOnLine = dx == dy && dy == dz;
			boolean xBetween = (p.x - p1.x) * (p2.x - p.x) > 0;
			boolean yBetween = (p.y - p1.y) * (p2.y - p.y) > 0;
			boolean zBetween = (p.z - p1.z) * (p2.z - p.z) > 0;
			return isOnLine && xBetween && yBetween && zBetween;
		}

		@Override
		public String toString() {
			return String.format("LineSegment : (%f,%f,%f) -> (%f,%f,%f) ", p1.x, p1.y, p1.z, p2.x, p2.y, p2.z);
		}
	}

	static class LineSegment2D {
		Point2D p1;
		Point2D p2;
		Vector2D v;

		public LineSegment2D(Point2D p1, Point2D p2) {
			this.p1 = p1;
			this.p2 = p2;
			this.v = new Vector2D(p2, p1);
		}

		public boolean isOnLineSegment(Point2D p) {
			boolean xBetween = (p.x - p1.x) * (p2.x - p.x) >= 0;
			boolean yBetween = (p.y - p1.y) * (p2.y - p.y) >= 0;
			return crossProduct(p1, p2, p) == 0 && xBetween && yBetween;
		}

		@Override
		public String toString() {
			return String.format("LineSegment : (%f,%f) -> (%f,%f) ", p1.x, p1.y, p2.x, p2.y);
		}
	}

	static class Line3D {
		Point3D p;
		Vector3D v;

		public Line3D(Point3D p, Vector3D v) {
			this.p = p;
			this.v = v;
		}

		public Line3D(Point3D p1, Point3D p2) {
			v = new Vector3D(p2, p1);
			p = p1;
		}

		public Line3D(LineSegment3D lineSegment3D) {
			this.v = lineSegment3D.v;
			this.p = lineSegment3D.p1;
		}

		public boolean isOnLine(Point3D p) {
			double dx = v.x * (p.x - this.p.x);
			double dy = v.y * (p.y - this.p.y);
			double dz = v.z * (p.z - this.p.z);
			return dx == dy && dy == dz;
		}

		@Override
		public String toString() {
			return String.format("Line : (%f, %f, %f) + t(%f, %f, %f", p.x, p.y, p.z, v.x, v.y, v.z);
		}
	}

	static class PlaneEquation3D {
		double a;
		double b;
		double c;
		double d;

		PlaneEquation3D(PlaneNormal3D planeNormal3D) {
			a = planeNormal3D.normalV.x;
			b = planeNormal3D.normalV.y;
			c = planeNormal3D.normalV.z;
			d = -(a * planeNormal3D.p.x + b * planeNormal3D.p.y + c * planeNormal3D.p.z);
		}

		public Point3D interSect(Line3D l) {
			double denominator = (a * l.v.x) + (b * l.v.y) + (c * l.v.z);
			if (denominator == 0) {
				return new Point3D(0, 0, 0);
			}
			double t = -(d + (a * l.p.x + b * l.p.y + c * l.p.z)) / denominator;
			return new Point3D(t * l.v.x + l.p.x, t * l.v.y + l.p.y, t * l.v.z + l.p.z);
		}

		@Override
		public String toString() {
			return String.format("PlaneEquation : %fx + %fy + %fz + %f = 0", a, b, c, d);
		}
	}

	static class PlaneNormal3D {
		Point3D p;
		Vector3D normalV;

		public PlaneNormal3D(Point3D p, Vector3D normalV) {
			this.p = p;
			this.normalV = normalV;
		}

		@Override
		public String toString() {
			return String.format("Plane(Vector) : %f(x - %f) + %f(y - %f) + %f(z - %f) = 0", normalV.x, p.x, normalV.y,
				p.y, normalV.z, p.z);
		}
	}

	static class Vector3D {
		double x;
		double y;
		double z;

		public Vector3D(double x, double y, double z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}

		public Vector3D(Point3D p1, Point3D p2) {
			this.x = p1.x - p2.x;
			this.y = p1.y - p2.y;
			this.z = p1.z - p2.z;
		}

		public double dot(Vector3D other) {
			return x * other.x + y * other.y + z * other.z;
		}

		public double magnitudeSquared() {
			return x * x + y * y + z * z;
		}

		public Vector3D multiply(double t) {
			return new Vector3D(x * t, y * t, z * t);
		}
	}

	static class Vector2D {
		double x;
		double y;

		public Vector2D(double x, double y) {
			this.x = x;
			this.y = y;
		}

		public Vector2D(Point2D p1, Point2D p2) {
			this.x = p1.x - p2.x;
			this.y = p1.y - p2.y;
		}

		public double dot(Vector2D other) {
			return x * other.x + y * other.y;
		}

		public double magnitudeSquared() {
			return x * x + y * y;
		}

		public Vector2D multiply(double t) {
			return new Vector2D(x * t, y * t);
		}
	}

	static class Point3D {
		double x;
		double y;
		double z;

		public Point3D(double[] input) {
			x = input[0];
			y = input[1];
			z = input[2];
		}

		public Point3D(double x, double y, double z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}

		public Point3D add(Vector3D v) {
			return new Point3D(this.x + v.x, this.y + v.y, this.z + v.z);
		}

		public double distance(Point3D p) {
			double distance = 0;
			distance += (this.x - p.x) * (this.x - p.x);
			distance += (this.y - p.y) * (this.y - p.y);
			distance += (this.z - p.z) * (this.z - p.z);
			return Math.sqrt(distance);
		}

		@Override
		public String toString() {
			return String.format("(%f, %f, %f)", x, y, z);
		}
	}

	static class Triangle2D {
		Point2D[] vertices;

		public Triangle2D(Point2D[] vertices) {
			this.vertices = vertices;
		}

		public double getArea() {
			int len = vertices.length;
			double result = 0;
			for (int i = 0; i < len; i++) {
				result += vertices[i].x * vertices[(i + 1) % len].y;
			}
			for (int i = 0; i < len; i++) {
				result -= vertices[(i + 1) % len].x * vertices[i].y;
			}
			return result * 0.5;
		}
	}

	static class Polygon2D {
		Point2D[] vertices;

		public Polygon2D(Point2D[] vertices) {
			this.vertices = vertices;
			Arrays.sort(this.vertices, Comparator.comparingDouble(p -> Math.atan2(p.y, p.x)));
		}

		public double getArea() {
			int len = vertices.length;
			double result = 0;
			for (int i = 0; i < len; i++) {
				result += vertices[i].x * vertices[(i + 1) % len].y;
			}
			for (int i = 0; i < len; i++) {
				result -= vertices[(i + 1) % len].x * vertices[i].y;
			}
			return result * 0.5;
		}
	}

	static class Point2D {
		double x;
		double y;

		public Point2D(double[] input) {
			x = input[0];
			y = input[1];
		}

		public Point2D(double x, double y) {
			this.x = x;
			this.y = y;
		}

		public Point2D add(Vector2D v) {
			return new Point2D(this.x + v.x, this.y + v.y);
		}

		public double distance(Point2D p) {
			double distance = 0;
			distance += (this.x - p.x) * (this.x - p.x);
			distance += (this.y - p.y) * (this.y - p.y);
			return Math.sqrt(distance);
		}

		@Override
		public String toString() {
			return String.format("(%f, %f)", x, y);
		}
	}

	private static int getIntersectionArea(int[] box1, int[] box2) {
		int intersectionW = Math.max(0, Math.min(box1[2], box2[2]) - Math.max(box1[0], box2[0]));
		int intersectionH = Math.max(0, Math.min(box1[3], box2[3]) - Math.max(box1[1], box2[1]));
		return (intersectionW * intersectionH);
	}

	// 기울기를 계산할 때 기울기가 무한이 되는 경우를 생각해야한다.
	static long innerProduct(int[][] points) {
		return (long)(points[1][0] - points[0][0]) * (points[1][1] - points[0][1])
			+ (long)(points[2][0] - points[0][0]) * (points[2][1] - points[0][1]);
	}

	static long innerProduct(int[] point1, int[] point2, int[] point3) {
		return (long)(point2[0] - point1[0]) * (point2[1] - point1[1]) + (long)(point3[0] - point1[0]) * (point3[1]
			- point1[1]);
	}

	static long crossProduct(int[] point1, int[] point2, int[] point3) {
		int dx1 = point2[0] - point1[0];
		int dy1 = point2[1] - point1[1];
		int dx2 = point3[0] - point1[0];
		int dy2 = point3[1] - point1[1];

		return (long)dx1 * dy2 - (long)dy1 * dx2;
	}

	static long crossProduct(int[][] points) {
		int[] dx = new int[2];
		int[] dy = new int[2];

		for (int i = 0; i < 2; i++) {
			dx[i] = points[i + 1][0] - points[0][0];
			dy[i] = points[i + 1][1] - points[0][1];
		}

		return (long)dx[0] * dy[1] - (long)dy[0] * dx[1];
	}

	static double distance(int[] a, int[] b) {
		return Math.sqrt(Math.pow(b[0] - a[0], 2) + Math.pow(b[1] - a[1], 2));
	}

	static double distance(double[] a, double[] b) {
		return Math.sqrt(Math.pow(b[0] - a[0], 2) + Math.pow(b[1] - a[1], 2));
	}

	static long distanceSquare(int[] a, int[] b) {
		return (long)(b[0] - a[0]) * (long)(b[0] - a[0]) + (long)(b[1] - a[1]) * (long)(b[1] - a[1]);
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

		Point2D nextIntPoint2D() {
			return new Point2D(scan.nextInt(), scan.nextInt());
		}

		char[][] nextCharMatrixFromString(int n) {
			char[][] arr = new char[n][];
			for (int i = 0; i < n; i++) {
				arr[i] = nextCharArrayFromString();
			}
			return arr;
		}
		char[][] nextCharMatrixFromString(int n, int m) {
			char[][] arr = new char[n][m];
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

		public List<int[]>[] newAdjacencyMatrix(int V, int E) {
			List<int[]>[] adj = new ArrayList[V + 1];
			for (int i = 0; i < adj.length; i++) {
				adj[i] = new ArrayList<>();
			}
			for (int i = 0; i < E; i++) {
				int s = nextInt();
				int e = nextInt();
				int v = nextInt();
				adj[s].add(new int[] {e, v});
				adj[e].add(new int[] {s, v});
			}
			return adj;
		}
	}

	public static void main(String[] args) throws Exception {
		solve();
		print();
	}

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

}