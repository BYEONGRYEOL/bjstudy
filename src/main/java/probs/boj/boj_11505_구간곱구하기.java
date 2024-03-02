package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11505_구간곱구하기 {

	static class SegTree {
		long divisor = 1000000007;
		long[] array;
		long[] productArray;

		public SegTree(long[] array) {
			this.array = array;
			this.productArray = new long[this.array.length * 4];
			init(0, this.array.length - 1, 1);
		}

		public long init(int s, int e, int index) {
			if (s == e) {
				productArray[index] = array[s];
				return productArray[index];
			}
			int m = (s + e) / 2;
			productArray[index] = (init(s, m, index * 2) * init(m + 1, e, index * 2 + 1)) % divisor;
			return productArray[index];
		}

		public long getProduct(int s, int e, int l, int r, int index) {
			if (l > e || r < s)
				return 1;
			if (l <= s && r >= e)
				return productArray[index];

			int m = (s + e) / 2;
			return (getProduct(s, m, l, r, index * 2) * getProduct(m + 1, e, l, r, index * 2 + 1)) % divisor;
		}

		public long update(int s, int e, int index, int targetIndex, int newNum) {
			if (targetIndex < s || targetIndex > e)
				return productArray[index];
			if (s == e) {
				if (s == targetIndex)
					productArray[index] = newNum;
				return productArray[index];
			}
			int m = (s + e) / 2;
			productArray[index] =
				(update(s, m, index * 2, targetIndex, newNum) * update(m + 1, e, index * 2 + 1, targetIndex, newNum))
					% divisor;
			return productArray[index];
		}
	}

	static void input() throws Exception {
		int n = scan.nextInt();
		int m = scan.nextInt();
		int k = scan.nextInt();
		int operationCount = m + k;
		long[] array = new long[n];
		for (int i = 0; i < n; i++)
			array[i] = scan.nextLong();
		SegTree segTree = new SegTree(array);
		for (int i = 0; i < operationCount; i++) {
			int operation = scan.nextInt();
			switch (operation) {
				case 1:
					int targetIndex = scan.nextInt() - 1;
					int newNum = scan.nextInt();
					segTree.update(0, n - 1, 1, targetIndex, newNum);
					break;
				case 2:
					int l = scan.nextInt() - 1;
					int r = scan.nextInt() - 1;
					sb.append(segTree.getProduct(0, n - 1, l, r, 1)).append('\n');
					break;
			}
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