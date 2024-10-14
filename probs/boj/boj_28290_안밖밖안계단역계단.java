package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Map;
import java.util.StringTokenizer;

public class boj_28290_안밖밖안계단역계단 {

	static void input() throws Exception {
		//안밖	검지 손가락에서 새끼손가락 순서대로 키보드를 치는 방법.	"fdsajkl;" 또는 "jkl;fdsa"
		// 밖안	새끼손가락에서 검지 손가락 순서대로 키보드를 치는 방법.	"asdf;lkj" 또는 ";lkjasdf"
		// 계단	왼쪽 새끼손가락에서 오른쪽 새끼손가락 순서대로 키보드를 치는 방법.	"asdfjkl;"
		// 역계단	오른쪽 새끼손가락에서 왼쪽 새끼손가락 순서대로 키보드를 치는 방법.	";lkjfdsa"

		Map<String,String> mapper = Map.of(
			"fdsajkl;", "in-out",
			"jkl;fdsa", "in-out",
			"asdf;lkj", "out-in",
			";lkjasdf", "out-in",
			"asdfjkl;", "stairs",
			";lkjfdsa", "reverse"
		);
		System.out.println(mapper.getOrDefault(scan.nextLine(), "molu"));
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
