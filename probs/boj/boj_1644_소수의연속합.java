package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1644_소수의연속합 {

	static ArrayList<Integer> getPrimeList(int n) {
		ArrayList<Integer> primeArray = new ArrayList<>();
		boolean[] isPrime = new boolean[n + 1];
		Arrays.fill(isPrime, true);
		isPrime[1] = false;
		for (int i = 2; i <= n; i++) {
			if (isPrime[i] == false)
				continue;
			for (int j = i * 2; j <= n; j += i)
				isPrime[j] = false;
			// 여기까지왔다는 것은 이미 소수임을 의미함
			primeArray.add(i);
		}
		return primeArray;
	}

	static void input() {

		// 연속된 -> 슬라이딩 윈도우 바로 생각난다.
		int n = scan.nextInt();
		ArrayList<Integer> primeList = getPrimeList(4000000);
		int len = primeList.size();

		int l = 0;
		int r = 0;
		int sum = 2;
		int consequencePrimeSumCount = 0;
		while (true) {
			if (sum > n) {
				sum -= primeList.get(l++);
			} else if (sum < n) {
				if (r == len - 1)
					break;
				sum += primeList.get(++r);
			} else if (sum == n) {
				consequencePrimeSumCount++;
				if (r == len - 1)
					break;
				sum += primeList.get(++r);
			}
			if (l == len)
				break;
		}
		System.out.println(consequencePrimeSumCount);

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