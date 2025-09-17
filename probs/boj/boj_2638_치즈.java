package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2638_치즈 {

	static int[] dirx = {-1,0,1,0};
	static int[] diry = {0,1,0,-1};
	
	static int[][] check;

	static Queue<int[]> q;
	static boolean[][] visited;

	static int cheese = 0;

    static void solve() throws Exception {
		int n = scan.nextInt();
		int m = scan.nextInt();
		int[][] board = scan.nextIntMatrix(n, m);
		for(int i = 0 ; i < n ; i ++){
			for(int j = 0 ; j < m; j++){
				cheese += board[i][j];
			}
		}
		check = new int[n][m];
		q = new ArrayDeque<>();
		int time = 0;
		while (cheese>0) { 
			time++;
			search(board, 0,0,0) ;
			search(board, 0,m-1,1) ;
			search(board, n-1,m-1,2) ;
			search(board, n-1,0,3) ;
			cleanUp(board);
		}
		sb.append(time);
	}

	static void cleanUp(int[][] board){
		int n = board.length;
		int m = board[0].length;
		for(int i = 0; i < n ; i++){
			for(int j = 0 ; j < m ; j++){
				if(board[i][j] == 1 && check[i][j] >=2){
					board[i][j] = 0;
					cheese --;
				}
			}
		}
	}

	static void search(int[][] board, int sx, int sy, int flag){
		int n = board.length;
		int m = board[0].length;
		visited = new boolean[n][m];
		visited[sx][sy] = true;
		q.clear();
		q.add(new int[]{sx,sy});

		while(!q.isEmpty()){
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			
			for(int k = 0 ; k < 4 ; k ++){
				if(
					(flag == 0 && (k == 1 || k==2)) ||
					(flag == 1 && (k == 2 || k==3)) ||
					(flag == 2 && (k == 3 || k==0)) ||
					(flag == 3 && (k == 0 || k==1)) 
					){
					int newx = x + dirx[k];
					int newy = y + diry[k];
					if(newx <0 || newx >=n || newy < 0 || newy >=m ) continue;
					if(visited[newx][newy]) continue;
					visited[newx][newy] = true;
					if(board[newx][newy] == 1) 
						check[newx][newy] ++;
					else
						q.add(new int[]{newx, newy});
					
				}
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

		int[] nextIntArray(int n) {
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = nextInt();
			}
			return arr;
		}

		long[] nextLongArray(int n) {
			long[] arr = new long[n];
			for (int i = 0; i < n; i++) {
				arr[i] = nextLong();
			}
			return arr;
		}
		long[][] nextLongMatrix(int n, int m) {
			long[][] arr = new long[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					arr[i][j] = nextLong();
				}
			}
			return arr;
		}

		String[][] nextStringMatrix_space(int n, int m) {
			String[][] arr = new String[n][m];
			for (int i = 0; i < n; i++) {
				arr[i] = scan.nextLine().split(" ");
			}
			return arr;
		}

		public double[] nextDoubleArray(int n) {
			double[] arr = new double[n];
			for (int i = 0; i < n; i++) {
				arr[i] = nextDouble();
			}
			return arr;
		}

		double[][] nextDoubleMatrix(int n, int m) {
			double[][] arr = new double[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					arr[i][j] = nextDouble();
				}
			}
			return arr;
		}

		int[][] nextIntMatrix(int n) {
			return nextIntMatrix(n, n);
		}

		int[][] nextIntMatrix(int n, int m) {
			int[][] arr = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					arr[i][j] = nextInt();
				}
			}
			return arr;
		}


		char[] nextCharArrayFromString() {
			return scan.nextLine().toCharArray();
		}

	}

	public static void main(String[] args) throws Exception {
		solve();
		print();
	}

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

}