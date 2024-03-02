package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2798_블랙잭 {

	static void input() throws Exception {
		int cardNum = scan.nextInt();
		int targetNum = scan.nextInt();
		int[] cards = new int[cardNum];
		for (int i = 0; i < cardNum; i++)
			cards[i] = scan.nextInt();
		// 100개니까 시간복잡도 상관 x, 문제조건예외가 없음

		int maxSum = 0;
		for (int i = 0; i < cardNum; i++)
			for (int j = i + 1; j < cardNum; j++)
				for (int k = j + 1; k < cardNum; k++) {
					int nowSum = cards[i] + cards[j] + cards[k];
					if (nowSum <= targetNum)
						maxSum = Math.max(maxSum, nowSum);
				}

		System.out.println(maxSum);
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