package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2110_공유기설치 {

	static boolean putWifiWithDistance(int distance, int wifiCount, int[] houses) {
		int recentPos = -1000000000;
		for (int i = 0; i < houses.length; i++) {
			if (houses[i] - recentPos >= distance) {
				wifiCount--;
				recentPos = houses[i];
			}
			if (wifiCount == 0)
				return true;
		}
		return false;
	}

	static void input() throws Exception {
		// hint 1: 최적화 문제임
		// hint 2: 최소 3의 거리를 두고 공유기를 설치할 수 있는 지 해보세요 라고 질문했다면 답변이 쉽다.
		// -> 이분탐색 parametric search

		int n = scan.nextInt();
		int numOfWifi = scan.nextInt();

		int houses[] = new int[n];
		for (int i = 0; i < n; i++) {
			houses[i] = scan.nextInt();
		}
		Arrays.sort(houses);

		int l = 1;
		int r = 1000000000;
		int m = 0;
		while (l + 1 < r) {
			m = (l + r) / 2;
			if (putWifiWithDistance(m, numOfWifi, houses)) {
				l = m;
			} else {
				r = m;
			}
		}
		System.out.println(l);
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