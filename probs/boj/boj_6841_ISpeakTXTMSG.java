package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class boj_6841_ISpeakTXTMSG {

	static void input() throws Exception {

		Map<String,String> map = new HashMap<String,String>();
		map.put("CU","see you");
		map.put(":-)",	"I’m happy");
		map.put(":-(",	"I’m unhappy");
		map.put(";-)",	"wink");
		map.put(":-P",	"stick out my tongue");
		map.put("(~.~)",	"sleepy");
		map.put("TA",	"totally awesome");
		map.put("CCC",	"Canadian Computing Competition");
		map.put("CUZ",	"because");
		map.put("TY",	"thank-you");
		map.put("YW",	"you’re welcome");
		map.put("TTYL",	"talk to you later");
		String line = "";
		while((line = scan.nextLine()) != null) {
			sb.append(map.getOrDefault(line,line)).append("\n");
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