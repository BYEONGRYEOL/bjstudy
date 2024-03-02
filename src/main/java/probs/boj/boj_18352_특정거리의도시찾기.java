package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class boj_18352_특정거리의도시찾기 {

	static void input() throws Exception {
		int nodeCount = scan.nextInt();
		int edgeCount = scan.nextInt();
		int targetDist = scan.nextInt();
		int start = scan.nextInt();

		List<Integer>[] edges = new List[nodeCount + 1];
		for (int i = 0; i < nodeCount + 1; i++) {
			edges[i] = new ArrayList<>();
		}

		for (int i = 0; i < edgeCount; i++) {
			int s = scan.nextInt();
			int e = scan.nextInt();
			edges[s].add(e);
		}

		PriorityQueue<int[]> q = new PriorityQueue<>((a1, a2) -> a1[1] - a2[1]);
		int[] minDist = new int[nodeCount + 1];
		Arrays.fill(minDist, Integer.MAX_VALUE);
		q.add(new int[] {start, 0});
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int node = now[0];
			int dist = now[1];
			if (dist > targetDist) {
				break;
			}
			if (minDist[node] <= dist)
				continue;
			minDist[node] = dist;
			for (Integer next : edges[node]) {
				q.add(new int[] {next, dist + 1});
			}
		}

		IntStream.rangeClosed(1, nodeCount)
			.filter(i -> minDist[i] == targetDist)
			.forEach(i -> sb.append(i).append('\n'));
		if (sb.length() == 0) {
			System.out.println(-1);
			return;
		}
		print();
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