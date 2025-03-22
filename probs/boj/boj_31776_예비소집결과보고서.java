package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_31776_예비소집결과보고서 {

	static void solve() throws Exception {
		// int iter = scan.nextInt();
		// int sincerityTeamCount = 0;
		// for (int i = 0; i < iter; i++) {
		// 	int curSolveTime = -1;
		// 	boolean sincerity = true;
		// 	boolean cantSolve = false;
		// 	boolean oneSolve = false;
		// 	for (int j = 0; j < 3; j++) {
		// 		int solveTime = scan.nextInt();
		// 		if((curSolveTime > solveTime && solveTime > -1) || (cantSolve && solveTime >-1)){
		// 			sincerity = false;
		// 		}
		// 		curSolveTime = solveTime;
		// 		if(curSolveTime == -1){
		// 			cantSolve = true;
		// 		} else{
		// 			oneSolve = true;
		// 		}
		// 	}
		// 	if(!oneSolve)
		// 		sincerity = false;
		// 	sincerityTeamCount += sincerity ? 1 : 0;
		// 	System.out.println(sincerity);
		// }
		// System.out.println(sincerityTeamCount);

		int iter = scan.nextInt();
		int[] solveTime = new int[3];
		int sincerityTeamCount = 0;
		for (int i = 0; i < iter; i++) {
			for (int j = 0; j < 3; j++) {
				solveTime[j] = scan.nextInt();
			}
			boolean solveAtLeastOne = false;
			for (int j = 0; j < 3; j++) {
				if(solveTime[j] == -1)
					solveTime[j] = 121;
				else
					solveAtLeastOne = true;
			}
			boolean sincerity = true;
			for (int j = 0; j < 2; j++) {
				if(solveTime[j+1] < solveTime[j])
					sincerity = false;
			}
			sincerityTeamCount += sincerity && solveAtLeastOne ? 1:0;
		}
		System.out.println(sincerityTeamCount);
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