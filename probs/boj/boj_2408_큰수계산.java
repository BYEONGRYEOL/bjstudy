package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_2408_큰수계산 {
    static void solve() throws Exception {
		int iter = scan.nextInt();
		List<Character> operations = new ArrayList<>();
		List<BigInteger> nums = new ArrayList<>();
		for (int i = 0; i < iter * 2 - 1; i++) {
			if(i % 2 == 0){
				BigInteger newNum = new BigInteger(scan.nextLine());
				nums.add(newNum);
			} else{
				char operation = scan.nextLine().charAt(0);
				operations.add(operation);
			}
		}
		for (int i = operations.size()-1 ; i >=0; i--) {
			if(operations.get(i) == '*' || operations.get(i) == '/'){
				nums.set(i, calculate(nums.get(i), operations.get(i), nums.get(i+1)));
				nums.remove(i+1);
				operations.remove(i);
			}
		}
		for (int i = operations.size()-1 ; i >=0; i--) {
			nums.set(i, calculate(nums.get(i), operations.get(i), nums.get(i+1)));
			nums.remove(i+1);
			operations.remove(i);
		}
		sb.append(nums.get(0));
	}
	static BigInteger calculate(BigInteger a, char oper, BigInteger b){
		switch (oper) {
			case '+': return a.add(b);
			case '-': return a.subtract(b);
			case '*': return a.multiply(b);
			case '/': {
				BigInteger[] resultAndRemainder = a.divideAndRemainder(b);
				BigInteger q = resultAndRemainder[0];
				BigInteger r = resultAndRemainder[1];

				// 나머지가 0이 아니고, a와 b의 부호가 다를 경우 내림 처리를 위해 -1을 더함
				if (!r.equals(BigInteger.ZERO) && a.signum() != b.signum()) {
					q = q.subtract(BigInteger.ONE);
				}
			}
			default:
				return BigInteger.ONE;
		}
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

		int[] nextIntArray(int n) {
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = nextInt();
			}
			return arr;
		}

		long[] nextLongArray(int n) {
			long[] arr = new long[n];
			for (int i = 0; i < n; i++) {
				arr[i] = nextLong();
			}
			return arr;
		}
		long[][] nextLongMatrix(int n, int m) {
			long[][] arr = new long[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					arr[i][j] = nextLong();
				}
			}
			return arr;
		}

		String[][] nextStringMatrix_space(int n, int m) {
			String[][] arr = new String[n][m];
			for (int i = 0; i < n; i++) {
				arr[i] = scan.nextLine().split(" ");
			}
			return arr;
		}

		public double[] nextDoubleArray(int n) {
			double[] arr = new double[n];
			for (int i = 0; i < n; i++) {
				arr[i] = nextDouble();
			}
			return arr;
		}

		double[][] nextDoubleMatrix(int n, int m) {
			double[][] arr = new double[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					arr[i][j] = nextDouble();
				}
			}
			return arr;
		}

		int[][] nextIntMatrix(int n) {
			return nextIntMatrix(n, n);
		}

		int[][] nextIntMatrix(int n, int m) {
			int[][] arr = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					arr[i][j] = nextInt();
				}
			}
			return arr;
		}


		char[] nextCharArrayFromString() {
			return scan.nextLine().toCharArray();
		}

	}

	public static void main(String[] args) throws Exception {
		solve();
		print();
	}

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

}