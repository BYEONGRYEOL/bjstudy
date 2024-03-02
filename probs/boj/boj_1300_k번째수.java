package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1300_k번째수 {

	static void input() throws Exception {
		// 1

		// 1 2
		// 2 4

		// 1 2 3
		// 2 4 6
		// 3 6 9

		// 1 2 3 4
		// 2 4 6 8
		// 3 6 9 12
		// 4 8 12 16

		// 순서를 적용하려니 중복되는 숫자가 많아서 순서가 꼬인다
		// 수 : 순서(몇번째)
		// 1 : 1
		// 2 : 2
		// 3 : 4
		// 4 : 6
		// 6 : 9
		// 실제로 데이터로 존재하지 않는 순서를 가지고 찾으려고 하니 어려움

		// 내가 어떤 수를 입력하면 몇번째인지는 알아낼 수 있는가? -> 이게 맞다면 이분탐색
		// P1 : 8을 입력한 경우 8보다 작은 수들은 각 행에서 쉽게 찾아낼 수 있다. 총 10개, 따라서 8은 11번째수이다.
		// P2 : 7을 입력한 경우에도 위의 결과와 같이 7이 11번째수라는 출력이 나올 수가 있다.
		// case i : 만약 7이 보드에 존재했다면 P1과 P2의 결과가 달랐을 것.
		// case ii : 만약 7이 보드에 존재하지 않는다면 P1, P2의 결과가 같으므로, 입력한 수가 큰 쪽이 옳은 답이다.

		int n = scan.nextInt();
		int k = scan.nextInt();

		int l = 1;
		int r = 1000000000;
		int m = 0;

		while (l + 1 < r) {
			m = (l + r) / 2;
			if (k > calculateK(n, m)) {
				l = m;
			} else {
				r = m;
			}
		}
		if (calculateK(n, l) >= k) {
			System.out.println(l);
		} else
			System.out.println(r);
	}

	static int calculateK(int n, int m) {
		int calculateK = 0;
		for (int i = 1; i <= n; i++) {
			calculateK += Math.min(m / i, n);
		}
		return calculateK;
	}

	static long lessThanCount(long n, long x) {
		long count = 0;
		for (int i = 1; i <= n; i++) {
			count += Math.min(n, x / i);
		}
		return count;
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