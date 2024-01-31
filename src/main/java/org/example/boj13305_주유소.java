package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj13305_주유소 {

	static void input() throws Exception {
		int n = scan.nextInt();
		int[] dist = new int[n + 1];
		int[] price = new int[n + 1];
		for (int i = 0; i < n - 1; i++) {
			dist[i] = scan.nextInt();
		}
		for (int i = 0; i < n; i++) {
			price[i] = scan.nextInt();
		}
		long answer = 0;

		// 준비완료
		// 초기화 : 첫 도시에서 이동시 무조건 첫 도시에서 주유해야한다.
		answer += (long)dist[0] * price[0];
		int recentPrice = price[0];
		for (int i = 1; i < n - 1; i++) {
			recentPrice = Math.min(recentPrice, price[i]);
			answer += (long)dist[i] * recentPrice;
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