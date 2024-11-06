package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import javax.naming.InterruptedNamingException;

public class boj_21312_홀짝칵테일 {

	static void input() throws Exception {
		int[] num = new int[3];
		boolean[] oddOrEven = new boolean[3];
		int result = 1;
		for (int i = 0; i < 3; i++) {
			num[i] = scan.nextInt();
			oddOrEven[i] = num[i] % 2 == 1;
		}
		for(int i = 0 ; i < 3 ; i++){
			if(oddOrEven[i]){
				result *= num[i];
			}
		}
		if(result == 1){
			for(int i = 0 ; i < 3 ; i++){
				result *= num[i];
			}
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