package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj_1197_최소스패닝트리 {

	static int findParent(int c, int[] parent){
		if(c ==parent[c]) return c;
		return findParent(parent[c], parent);
	}
	static boolean merge(int a, int b, int[] parent){
		int p = findParent(a, parent);
		int c = findParent(b, parent);
		if(c == p){
			return false;
		}
		if(c < p){
			int temp = c;
			c = p;
			p = temp;
		}
		parent[c] = p;
		return true;
	}
	static void input() throws Exception {
		int v = scan.nextInt();
		int e = scan.nextInt();
		int[][] edges = new int[e][3];
		int[] parent = new int[v+1];
		for (int i = 0; i < v + 1; i++) {
			parent[i] = i;
		}
		for (int i = 0; i < e; i++) {
			edges[i][0] = scan.nextInt();
			edges[i][1] = scan.nextInt();
			edges[i][2] = scan.nextInt();
		}
		Arrays.sort(edges, Comparator.comparingInt(a -> a[2]));
		int answer = 0;
		for (int i = 0; i < e; i++) {
			if(v == 1){
				break;
			}
			int[] edge = edges[i];
			int p = edge[0];
			int c = edge[1];
			boolean merged = merge(c, p, parent);
			if(merged){
				v--;
				answer += edge[2];
			}
		}
		System.out.println(answer);
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
	}

	public static void main(String[] args) throws Exception {
		input();
	}

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

}