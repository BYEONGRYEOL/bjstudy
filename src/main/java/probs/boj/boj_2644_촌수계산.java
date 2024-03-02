package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2644_촌수계산 {

	static void input() throws Exception {
		int n = scan.nextInt();
		int from = scan.nextInt();
		int to = scan.nextInt();
		int numOfPair = scan.nextInt();
		ArrayList<Integer>[] edges = new ArrayList[n + 1];
		for (int i = 0; i < n + 1; i++) {
			edges[i] = new ArrayList<>();
		}
		for (int i = 0; i < numOfPair; i++) {
			int s = scan.nextInt();
			int e = scan.nextInt();
			edges[s].add(e);
			edges[e].add(s);
		}
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {from, 0});
		int[] minDist = new int[n + 1];
		Arrays.fill(minDist, Integer.MAX_VALUE);

		while (!q.isEmpty()) {
			int[] now = q.poll();
			int node = now[0];
			int dist = now[1];

			if (minDist[node] <= dist)
				continue;
			minDist[node] = dist;
			if (node == to) {
				break;
			}
			for (Integer next : edges[node]) {
				q.add(new int[] {next, dist + 1});
			}
		}
		System.out.println(minDist[to] == Integer.MAX_VALUE ? -1 : minDist[to]);
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