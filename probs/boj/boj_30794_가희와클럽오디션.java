package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class boj_30794_가희와클럽오디션 {

	static void input() throws Exception {
		String[] line = scan.nextLine().split(" ");
		int count = Integer.parseInt(line[0]);
		//miss일 때
		// $0$점을 받습니다.
		// bad일 때
		// $200$에
		// $lv$을 곱한 점수를 받습니다.
		// cool일 때
		// $400$에
		// $lv$을 곱한 점수를 받습니다.
		// great일 때
		// $600$에
		// $lv$을 곱한 점수를 받습니다.
		// perfect
		//  
		// $n$연팩일 때
		// $n \cdot lv$에
		// $1\,000$을 곱한 점수를 받습니다
		String criteria = line[1];
		Map<String, Integer> score = Map.of(
			"miss", 0,
			"bad", 200,
			"cool", 400,
			"great", 600,
			"perfect", 1000
		);
		System.out.println(score.get(criteria) * count);
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