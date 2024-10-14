package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class boj_30031_지폐세기 {

	static void input() throws Exception {
		//천 원권의 가로 길이는
		// $136\text{mm}$, 오천 원권의 가로 길이는
		// $142\text{mm}$, 만 원권의 가로 길이는
		// $148\text{mm}$, 오만 원권의 가로 길이는
		// $154\text{mm}$이다
		int iter = scan.nextInt();
		Map<Integer, Integer> price = Map.of(
			136,1000,
			142,5000,
			148,10000,
			154,50000
		);
		int result = 0;
		for (int i = 0; i < iter; i++) {
			result +=price.get(scan.nextInt());
			scan.nextInt();
		}
		System.out.println(result);
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
