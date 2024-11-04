package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_2476_주사위게임 {

	static void input() throws Exception {
		int n = scan.nextInt();
		int maxPrize = 0;
		for (int i = 0; i < n; i++) {
			int[] dice = new int[3];
			int prize = 0;
			for (int j = 0; j < 3; j++) {
				dice[j] = scan.nextInt();
			}
			Arrays.sort(dice);
			if (dice[0] == dice[1] && dice[1] == dice[2]) {
				prize = 10000 + dice[0] * 1000;
			} else if (dice[0] == dice[1]) {
				prize = 1000 + dice[0] * 100;
			} else if (dice[1] == dice[2]) {
				prize = 1000 + dice[1] * 100;
			} else if (dice[2] == dice[0]) {
				prize = 1000 + dice[2] * 100;
			} else {
				prize = dice[2] * 100;
			}
			maxPrize = Math.max(maxPrize, prize);
		}
		System.out.println(maxPrize);
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