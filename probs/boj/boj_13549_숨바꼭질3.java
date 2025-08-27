package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_13549_숨바꼭질3 {

    public static void solve(){
		int n = scan.nextInt();
		int k = scan.nextInt();
		int[] minDist = new int[100001];
		Arrays.fill(minDist, Integer.MAX_VALUE);
		
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[]{n, 0});
		minDist[n] = 0;
		while(!queue.isEmpty()){
			int[] cur = queue.poll();
			int pos = cur[0];
			int dist = cur[1];
			if(pos == k){
				break;
			}
			if(pos * 2 <= 100000 && minDist[pos * 2] > dist){
				minDist[pos * 2] = dist;
				queue.add(new int[]{pos * 2, dist});
			}
			if(pos + 1 <= 100000 && minDist[pos + 1] > dist + 1){
				minDist[pos + 1] = dist + 1;
				queue.add(new int[]{pos + 1, dist + 1});
			}
			if(pos - 1 >= 0 && minDist[pos - 1] > dist + 1){
				minDist[pos - 1] = dist + 1;
				queue.add(new int[]{pos - 1, dist + 1});
			}
		}
		sb.append(minDist[k]);
		
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