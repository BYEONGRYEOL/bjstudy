	package probs.boj;

	import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.math.BigInteger;
	import java.util.StringTokenizer;

	public class boj_306767_이별은무슨색일까 {

		static void input() throws Exception {
			//빨간색: 620nm 이상 780nm 이하
			// 주황색: 590nm 이상 620nm 미만
			// 노란색: 570nm 이상 590nm 미만
			// 초록색: 495nm 이상 570nm 미만
			// 파란색: 450nm 이상 495nm 미만
			// 남색: 425nm 이상 450nm 미만
			// 보라색: 380nm 이상 425nm 미만

			int[] measure = {620, 590, 570, 495, 450, 425, 380};
			String[] color = {"Red", "Orange", "Yellow", "Green", "Blue", "Indigo", "Violet"};
			int wavelength = scan.nextInt();
			for (int i = 0; i < 7; i++) {
				if(wavelength >= measure[i]){
					System.out.println(color[i]);
					return;
				}
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
