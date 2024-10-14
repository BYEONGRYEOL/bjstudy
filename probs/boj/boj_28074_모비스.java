	package probs.boj;

	import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.StringTokenizer;

	public class boj_28074_모비스 {

		static void input() throws Exception {
			char[] arr = scan.nextLine().toCharArray();
			int[] mobis = new int['Z'+1];
			for (int i = 0; i < arr.length; i++) {
				mobis[arr[i]] ++;
			}
			if((mobis['M'] > 0 && mobis['O'] > 0 && mobis['B'] > 0 && mobis['I'] > 0 && mobis['S'] > 0)){
				System.out.println("YES");
			}else
				System.out.println("NO");
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
