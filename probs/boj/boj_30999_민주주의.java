	package probs.boj;

	import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.StringTokenizer;

	public class boj_30999_민주주의 {

		static void solve() throws Exception {
			int prob = scan.nextInt();
			int professor = scan.nextInt();
			int exam = 0;
			for (int i = 0; i < prob; i++) {
				String line = scan.nextLine();
				int oCount = 0;
				for (int j = 0; j < professor; j++) {
					oCount += line.charAt(j) == 'O' ? 1 : 0;
				}
				if(oCount >= (professor-1)/2 + 1){
					exam++;
				}
			}
			System.out.println(exam);
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
			solve();
		}

		static FastReader scan = new FastReader();
		static StringBuilder sb = new StringBuilder();
	}
