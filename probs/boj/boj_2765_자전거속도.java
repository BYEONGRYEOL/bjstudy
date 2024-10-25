package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2765_자전거속도 {
	static double pi = 3.1415927;
	static void input() throws Exception {
		//π의 값은 3.1415927을 사용하면 된다.
		// 1마일은 5280피트이다.
		// 1피트는 12인치이다.
		// 1시간은 60분이다.
		// 1분은 60초이다.
		// 1펄롱은 201.168미터이다.
		int iter = 1;
		while(true){
			double diameterInch = scan.nextDouble();
			int rotate = scan.nextInt();
			double second = scan.nextDouble();
			if(rotate == 0)
				break;
			double diameterFeet = diameterInch / 12;
			double diameterMiles = diameterFeet / 5280;
			double roundMiles = diameterMiles * pi;
			double distance = roundMiles * rotate;
			double hour = second / 3600;
			double MPH = distance / hour;
			sb.append(String.format("Trip #%d: %.2f %.2f\n",iter++, distance, MPH));
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