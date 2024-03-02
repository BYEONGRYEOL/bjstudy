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

public class boj_9372_상근이의여행 {

	static void input() throws Exception {
		HashMap<Integer, Integer> inDegree = new HashMap<>();
		for (int caseNum = 1; ; caseNum++) {
			inDegree.clear();
			while (true) {
				int start = scan.nextInt();
				int end = scan.nextInt();
				if (start == -1 && end == -1) {
					print();
					return;
				} else if (start == 0 && end == 0) {
					break;
				}
				inDegree.put(start, inDegree.getOrDefault(start, 0));
				inDegree.put(end, inDegree.getOrDefault(end, 0) + 1);
			}
			int zeroIn = 0;
			boolean flag = true;
			if (inDegree.size() > 1) {
				for (Map.Entry<Integer, Integer> kv : inDegree.entrySet()) {
					if (kv.getValue() == 0) {
						zeroIn++;
					} else if (kv.getValue() > 1) {
						flag = false;
						break;
					}
				}
				if (zeroIn != 1) {
					flag = false;
				}
			}
			sb.append("Case ").append(caseNum).append(" is ").append(flag ? "" : "not ").append("a tree.").append('\n');
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
	}

	public static void main(String[] args) throws Exception {
		input();
	}

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

}