package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_12850_본대산책2 {

	static long[][] base = {
		{0, 1, 1, 0, 0, 0, 0, 0}, // 정보
		{1, 0, 1, 1, 0, 0, 0, 0}, // 전산
		{1, 1, 0, 1, 1, 0, 0, 0}, // 미래
		{0, 1, 1, 0, 1, 1, 0, 0}, // 신양
		{0, 0, 1, 1, 0, 1, 0, 1}, // 한경직
		{0, 0, 0, 1, 1, 0, 1, 0}, // 진리
		{0, 0, 0, 0, 0, 1, 0, 1}, // 학생회관
		{0, 0, 0, 0, 1, 0, 1, 0}  // 형남공학
	};
	static int MOD = 1000000007;

	static void input() {

		int D = scan.nextInt();
		int n = base.length;

		long[][] result = new long[n][n];
		// Identity Matrix
		for (int i = 0; i < n; i++) {
			result[i][i] = 1;
		}

		while (D > 0) {
			if ((D & 1) == 1) {
				result = multiply(result, base);
				D--;
			}
			base = multiply(base, base);
			D /= 2;
		}
		System.out.println(result[0][0]);
		print();
	}

	static long[][] multiply(long[][] M1, long[][] M2) {
		long[][] result = new long[M1.length][M2[0].length];
		for (int i = 0; i < M1.length; i++) {
			for (int j = 0; j < M2[0].length; j++) {
				long e = 0;
				for (int k = 0; k < M1[0].length; k++) {
					e += (M1[i][k] * M2[k][j]) % MOD;
				}
				e %= MOD;
				result[i][j] = e;
			}
		}
		return result;
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

	public static void main(String[] args) {
		input();
	}

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

}