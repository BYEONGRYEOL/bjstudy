package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14939_불끄기 {

	static int LEN = 10;
	static boolean[][] board = new boolean[LEN][LEN];
	static boolean[][] tempBoard = new boolean[LEN][LEN];
	static int minCount = Integer.MAX_VALUE;


	static boolean[] firstLine = new boolean[LEN];
	static int[] dirx = {-1,1,0,0};
	static int[] diry = {0,0,-1,1};
	static void input() throws Exception {

		for (int i = 0; i < LEN; i++) {
			String line  =scan.nextLine();
			for (int j = 0; j < LEN; j++) {
				board[i][j] = line.charAt(j) == 'O';
			}
		}

		make01Array(0);

		sb.append(minCount == Integer.MAX_VALUE ? -1 : minCount);
		print();
	}

	static void make01Array(int depth){
		if(depth == LEN){

			for (int i = 0; i < LEN; i++) {
				for (int j = 0; j < LEN; j++) {
					tempBoard[i][j] = board[i][j];
				}
			}
			int count = 0;
			for (int j = 0; j < LEN; j++) {
				if(firstLine[j]){
					count++;
					turnOff(0,j, tempBoard);
				}
			}

			for (int i = 0; i < LEN-1; i++) {
				for (int j = 0; j < LEN; j++) {
					if(tempBoard[i][j]){
						count++;
						turnOff(i+1, j, tempBoard);
					}
				}
			}

			// check
			boolean successFlag = true;
			for (int i = 0; i < LEN; i++) {
				if(tempBoard[LEN-1][i]){
					successFlag = false;
				}
			}
			if(successFlag){
				minCount = Math.min(minCount, count);
			}
			return;
		}
		firstLine[depth] = true;
		make01Array(depth+1);

		firstLine[depth] = false;
		make01Array(depth+1);
	}

	static void turnOff(int x, int y, boolean[][] board){
		board[x][y] = !board[x][y];
		for (int i = 0; i < 4; i++) {
			int newx = x + dirx[i];
			int newy = y + diry[i];
			if(newx >= 0 && newx < LEN && newy >= 0 && newy < LEN){
				board[newx][newy] = !board[newx][newy];
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