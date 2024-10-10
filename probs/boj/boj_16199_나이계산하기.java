package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_16199_나이계산하기 {

	static void input() throws Exception {
		int[] birthDate = new int[3];
		for (int i = 0; i < 3; i++) {
			birthDate[i] = scan.nextInt();
		}
		int[] criteriaDate = new int[3];
		for (int i = 0; i < 3; i++) {
			criteriaDate[i] = scan.nextInt();
		}
		boolean afterBirthDay = false;
		if(criteriaDate[1] > birthDate[1] || (criteriaDate[1] == birthDate[1] && criteriaDate[2] >= birthDate[2])) {
			afterBirthDay = true;
		}
		sb.append(criteriaDate[0] - birthDate[0] - 1 + (afterBirthDay ? 1 : 0)).append('\n');
		sb.append(criteriaDate[0] - birthDate[0] +1).append('\n');
		sb.append(criteriaDate[0] - birthDate[0]);
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