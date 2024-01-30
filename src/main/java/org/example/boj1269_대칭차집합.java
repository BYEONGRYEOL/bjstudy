package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class boj1269_대칭차집합 {

	static void input() throws Exception {
		Map<Integer, Integer> numberCount = new HashMap<>();
		int n = scan.nextInt();
		int m = scan.nextInt();
		int duplicateCount = 0;
		for (int i = 0; i < n + m; i++) {
			int number = scan.nextInt();
			if (numberCount.containsKey(number)) {
				duplicateCount++;
			} else {
				numberCount.put(number, 0);
			}
		}
		// 8 - (A,B한테 할당되어야했을 숫자) 2 * 2(실제로 중복이 발생한 수)
		List<String> d = new ArrayList<>();
		d.sort((str1, str2) -> {
			if (str1.length() == str2.length())
				return str1.compareTo(str2);
			return str1.length() - str2.length();
		});

		System.out.println(numberCount.size() - duplicateCount);
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