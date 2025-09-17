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

public class boj_1967_트리의지름 {

    public static void solve(){
		int n = scan.nextInt();
		ArrayList<int[]>[] nodes = new ArrayList[n+1];
		for(int i = 1 ; i <= n; i++){
			nodes[i] = new ArrayList<>();
		}
		for(int i = 0 ; i < n-1; i++){
			int parent = scan.nextInt();
			int child = scan.nextInt();
			int weight = scan.nextInt();
			nodes[parent].add(new int[]{child, weight});
			nodes[child].add(new int[]{parent, weight});
		}
		// 트리의 지름이란, 출발점을 한 개씩 정해서 가잔 가중치의 합이 큰 경로를 찾는 것이다.
		// 시작점을 1개씩 정해서 다 해보기에는... 너무 오래걸린다.
		// 트리의 지름의 성질은 임이의 한 점에서 가장 먼 점과 그점과 가장 먼 점의 거리를 구하면 된다.

		if(n==1){
			sb.append(0);
			return;
		}
		int[] farthestNodeFrom1 = getLongestNode(nodes, 1);
		int[] farthestNodeFromThat = getLongestNode(nodes, farthestNodeFrom1[0]);
		sb.append(farthestNodeFromThat[1]);
	}
	
	static int[] getLongestNode(List<int[]>[] nodes, int start){
		Queue<int[]> q = new ArrayDeque<>();
		boolean[] visited = new boolean[nodes.length];
		int maxLen = 0;
		int[] farthestNode = new int[2];
		q.add(new int[]{start, 0});
		while(!q.isEmpty()){
			int[] cur = q.poll();
			if(visited[cur[0]]) continue;
			visited[cur[0]] = true;
			if(cur[1] > maxLen){
				maxLen = cur[1];
				farthestNode = cur;
			}
			for(int i = 0 ; i < nodes[cur[0]].size(); i++){
				if(nodes[cur[0]].get(i) != null && !visited[nodes[cur[0]].get(i)[0]]){
					q.add(new int[]{nodes[cur[0]].get(i)[0], cur[1] + nodes[cur[0]].get(i)[1]});
				}
			}
		}
		return farthestNode;
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