package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1086_박성원 {

	static void input() throws Exception {
		int N = scan.nextInt();
		String[] set = new String[N];
		for (int i = 0; i < N; i++) {
			set[i] = scan.nextLine();
		}
		int divisor = scan.nextInt();
		int[] remainders = new int[N];
		for (int i = 0; i < N; i++) {
			remainders[i] = getRemainder(set[i], divisor);
		}
		// 자릿수 별 나머지들 digitRemainders[50]은 10^50 을 divisor로 나눈 나머지를 저장하는 것
		int[] digitRemainders = new int[51];
		digitRemainders[0] = 1 % divisor;
		for (int i = 1; i < 51; i++) {
			digitRemainders[i] = (digitRemainders[i - 1] * 10) % divisor;
		}

		// 현재 어떤 수를 골랐는지 표현하는 방법
		// n = 5 일때
		// 10010 라면 첫번째 수와 4번째 수를 고른 경우로 생각함, 비트마스킹
		int max = (int)Math.pow(2, 15);
		long[][] dp = new long[max + 1][100];
		dp[0][0] = 1;
		for (int cur = 0; cur < (1 << N); cur++) {
			for (int i = 0; i < N; i++) {
				if ((cur & (1 << i)) == 0) {
					int next = (cur | (1 << i));
					for (int remainder = 0; remainder < divisor; remainder++) {
						int newRemainder =
							((remainder * digitRemainders[set[i].length()]) % divisor + remainders[i]) % divisor;
						dp[next][newRemainder] += dp[cur][remainder];
					}
				}
			}
		}
		long numerator = dp[(1 << N) - 1][0];
		long denominator = 1;
		for (int i = 1; i <= N; i++) {
			denominator *= i;
		}
		long gcd = gcd(numerator, denominator);
		sb.append(numerator / gcd).append('/').append(denominator / gcd);
		print();
	}

	static long gcd(long a, long b) {
		return a % b == 0 ? b : gcd(b, a % b);
	}

	static int getRemainder(String num, int divisor) {
		int remainder = 0;
		for (int i = 0; i < num.length(); i++) {
			int digit = Character.getNumericValue(num.charAt(i));
			remainder = (remainder * 10 + digit) % divisor;
		}
		return remainder;
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