package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj1005_ACMCraft {

	static void input() throws Exception {
		int testCase = scan.nextInt();
		for (int z = 0; z < testCase; z++) {
			int numOfBuilding = scan.nextInt();
			int numOfRule = scan.nextInt();

			int[] costs = new int[numOfBuilding + 1];
			for (int i = 1; i < numOfBuilding + 1; i++) {
				costs[i] = scan.nextInt();
			}
			ArrayList<Integer>[] nextBuildingOf = new ArrayList[numOfBuilding + 1];
			for (int i = 0; i < numOfBuilding + 1; i++) {
				nextBuildingOf[i] = new ArrayList<>();
			}
			int[] inDegree = new int[numOfBuilding + 1];
			for (int i = 0; i < numOfRule; i++) {
				int preBuilding = scan.nextInt();
				int postBuilding = scan.nextInt();
				nextBuildingOf[preBuilding].add(postBuilding);
				inDegree[postBuilding]++;
			}

			int goal = scan.nextInt();

			PriorityQueue<int[]> q = new PriorityQueue<>((i1, i2) -> i1[1] - i2[1]);
			for (int i = 1; i < numOfBuilding + 1; i++) {
				if (inDegree[i] == 0)
					q.add(new int[] {i, costs[i]});
			}

			int time = 0;
			while (!q.isEmpty()) {
				int[] now = q.poll();
				int buildingIndex = now[0];
				int completeTime = now[1];
				if (time < completeTime) {
					time = completeTime;
				}
				if (buildingIndex == goal) {
					sb.append(time).append('\n');
					break;
				}
				for (Integer next : nextBuildingOf[buildingIndex]) {
					inDegree[next]--;
					if (inDegree[next] == 0) {
						q.add(new int[] {next, time + costs[next]});
					}
				}
			}
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