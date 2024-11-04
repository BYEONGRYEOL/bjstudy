package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class boj_30032_알파벳뒤집기 {

	static void input() throws Exception {
		Map<Character, Character> upDownMapper = Map.of(
			'd', 'q',
			'b','p',
			'q','d',
			'p','b'
		);
		Map<Character, Character> leftRightMapper = Map.of(
			'd', 'b',
			'b','d',
			'q','p',
			'p','q'
		);
		
		int iter = scan.nextInt();
		int dir = scan.nextInt();
		for (int i = 0; i < iter; i++) {
			String line = scan.nextLine();
			for (int j = 0; j < line.length(); j++) {
				sb.append(dir == 1 ? upDownMapper.get(line.charAt(j)) : leftRightMapper.get(line.charAt(j)));
			}
			sb.append('\n');
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