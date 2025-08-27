package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_7662_이중우선순위큐 {

	static Runnable flush(Queue<Long> queue, Map<Long,Long> countMap) {
		return ()->{
			while(!queue.isEmpty() && countMap.get(queue.peek()) == 0){
				queue.poll();
			}
		};
	}
    static void solve() throws Exception {
		// max min 두개의 우선순위 큐를 사용
		// max, min 중복으로 insert하지만 delete는 1개에서만 진행한다.
		// 따라서 현재 queue에 존재하는 원소의 종류와 개수를 기록하고있다가,
		// max or min 에서 현재 삭제하고있는 원소가 실제로는 존재하지 않는 원소인지 파악한다.

		PriorityQueue<Long> minHeap = new PriorityQueue<>();
		PriorityQueue<Long> maxHeap = new PriorityQueue<>((a, b) -> b.compareTo(a));
		HashMap<Long, Long> countMap = new HashMap<>();

		
		int t = scan.nextInt();
		while(t>0){
			minHeap.clear();
			maxHeap.clear();
			countMap.clear();
			t--;
			int n =scan.nextInt();
			int size = 0;
			for(int i = 0 ; i < n; i++){
				String[] command = scan.nextLine().split(" ");
				long num = Long.parseLong(command[1]);
				if (command[0].equals("I")) {
					minHeap.offer(num);
					maxHeap.offer(num);
					countMap.merge(num, 1L, Long::sum);
					size++;
				}
				else if(command[0].equals("D")){
					if(num == 1){
						flush(maxHeap, countMap).run();
						if(!maxHeap.isEmpty()){
							long max = maxHeap.poll();
							countMap.merge(max, -1L, Long::sum);
							size--;
						}
					} else{
						flush(minHeap, countMap).run();
						if(!minHeap.isEmpty()){
							long min = minHeap.poll();
							countMap.merge(min, -1L, Long::sum);
							size--;
						}
					}
				}
				
			}
			if(size == 0){
				sb.append("EMPTY\n");
			} else{
				flush(maxHeap, countMap).run();
				flush(minHeap, countMap).run();
				sb.append(maxHeap.peek()).append(" ").append(minHeap.peek()).append("\n");
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