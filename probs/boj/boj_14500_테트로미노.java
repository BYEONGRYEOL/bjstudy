package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_14500_테트로미노 {

	static int N, M;
    static int[][] A;

    // 5개 기본 도형(상대 좌표; (0,0)을 포함하도록 아무렇게나 배치)
    // 좌표는 {y,x}
    static int[][][] BASE = {
        // I (—)
        {{0,0},{0,1},{0,2},{0,3}},
        // O (□)
        {{0,0},{0,1},{1,0},{1,1}},
        // T
        {{0,0},{0,1},{0,2},{1,1}},
        // L
        {{0,0},{1,0},{2,0},{2,1}},
        // S (ㄴ자 뒤틀린거; S/Z 한쪽만 두고 대칭으로 생성)
        {{0,1},{0,2},{1,0},{1,1}}
    };

    static class Shape {
        int[][] cells; // 4개 (y,x)
        Shape(int[][] c) {
            cells = new int[4][2];
            for (int i=0;i<4;i++){ cells[i][0]=c[i][0]; cells[i][1]=c[i][1]; }
            normalize();
        }
        void normalize() {
            int minY = Integer.MAX_VALUE, minX = Integer.MAX_VALUE;
            for (int[] p: cells) { minY = Math.min(minY, p[0]); minX = Math.min(minX, p[1]); }
            for (int[] p: cells) { p[0]-=minY; p[1]-=minX; }
            Arrays.sort(cells, (a,b)-> a[0]==b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        }
        Shape rot90() { // (y,x) -> (x, -y)
            int[][] c = new int[4][2];
            for (int i=0;i<4;i++) { c[i][0]=cells[i][1]; c[i][1]=-cells[i][0]; }
            return new Shape(c);
        }
        Shape flipX() { // 좌우반전: (y,x) -> (y,-x)
            int[][] c = new int[4][2];
            for (int i=0;i<4;i++) { c[i][0]=cells[i][0]; c[i][1]=-cells[i][1]; }
            return new Shape(c);
        }
        @Override public boolean equals(Object o) {
            if (!(o instanceof Shape)) return false;
            return Arrays.deepEquals(cells, ((Shape)o).cells);
        }
        @Override public int hashCode() {
            return Arrays.deepHashCode(cells);
        }
    }

    static List<int[][]> genAllShapes() {
        HashSet<Shape> set = new HashSet<>();
        for (int[][] base : BASE) {
            Shape s0 = new Shape(base);
            for (int r=0;r<4;r++) {           // 회전 4번
                Shape sr = (r==0)? s0 : s0.rot90();
                s0 = sr;
                set.add(sr);
                Shape fr = sr.flipX();        // 각 회전에 대해 좌우대칭
                set.add(fr);
            }
        }
        // 최종 오프셋 리스트로 변환
        ArrayList<int[][]> shapes = new ArrayList<>();
        for (Shape s : set) shapes.add(s.cells);
        return shapes;
    }

    public static void solve(){
        N = scan.nextInt();
        M = scan.nextInt();
        A = scan.nextIntMatrix(N,M);

        List<int[][]> shapes = genAllShapes(); // 중복 제거된 19개 주변 좌표 얻음
        int ans = 0;

        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                for (int[][] s : shapes) {
                    int sum = 0;
                    boolean ok = true;
                    for (int[] p : s) {
                        int y = i + p[0];
                        int x = j + p[1];
                        if (y<0 || y>=N || x<0 || x>=M) { ok = false; break; }
                        sum += A[y][x];
                    }
                    if (ok) ans = Math.max(ans, sum);
                }
            }
        }
        sb.append(ans);
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