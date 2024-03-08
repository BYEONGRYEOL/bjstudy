package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_1167_트리의지름 {

	static void input() throws Exception {
		int V = scan.nextInt();
		List<int[]>[] edges = new List[V+1];
		for (int i = 1; i < V+1; i++) {
			edges[i] = new ArrayList<>();
		}
		for (int i = 0; i < V; i++) {
			int s = scan.nextInt();
			while(true){
				int e = scan.nextInt();
				if(e == -1){
					break;
				}
				int v = scan.nextInt();
				edges[s].add(new int[]{e,v});
			}
		}
		int[] endPoint1 = dijkstra(V, 1, edges);
		int start = endPoint1[0];
		int[] endPoint2 = dijkstra(V, start, edges);
		System.out.println(endPoint2[1]);
	}

	private static int[] dijkstra(int V, int start, List<int[]>[] edges) {
		int[] minDist = new int[V +1];
		Arrays.fill(minDist, 10000 * 100000 + 1);
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
		pq.add(new int[]{start, 0});
		minDist[start] = 0;

		while(!pq.isEmpty()){
			int[] now = pq.poll();
			int node = now[0];
			int dist = now[1];
			for (int[] next : edges[node]) {
			    int nextNode = next[0];
				int nextDist = next[1] + dist;
				if(minDist[nextNode] > nextDist){
					minDist[nextNode] = nextDist;
					pq.add(new int[]{nextNode, nextDist});
				}
			}
		}

		int maxDistIndex = 0;
		int maxDist = 0;
		for (int i = 1; i < V + 1; i++) {
			if(maxDist < minDist[i]){
				maxDistIndex = i;
				maxDist = minDist[i];
			}
		}
		return new int[]{maxDistIndex, maxDist};
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