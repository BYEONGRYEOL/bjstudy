package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_16566_카드게임 {

	static int[] parent;

	static int findParent(int c) {
		if (c == parent[c]) {
			return c;
		}
		parent[c] = findParent(parent[c]);
		return parent[c];
	}

	static void union(int a, int b) {
		int c = findParent(a);
		int p = findParent(b);
		if (c == p)
			return;
		parent[c] = p;
	}

	static void input() throws Exception {
		// 빨간색 카드 N 개중 M개 선택
		// 파란색 카드 N 개도 선택됨

		int N = scan.nextInt();
		int M = scan.nextInt();
		int K = scan.nextInt();

		parent = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			parent[i] = i;
		}

		int[] cards = new int[M];
		for (int i = 0; i < M; i++) {
			cards[i] = scan.nextInt();
		}
		Arrays.sort(cards);
		for (int i = 0; i < K; i++) {
			int enemyCard = scan.nextInt();
			int index = Arrays.binarySearch(cards, enemyCard);
			index = index >= 0 ? index + 1 : (index + 1) * -1;
			index = findParent(index);
			sb.append(cards[index]).append('\n');
			union(index, index + 1);
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