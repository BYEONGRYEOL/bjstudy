package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_14003_가장긴증가하는부분수열5 {
	static void input() throws Exception {
		int n = scan.nextInt();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = scan.nextInt();
		}

		int[] pos = new int[n];
		List<Integer> lis = new ArrayList<>();
		lis.add(Integer.MIN_VALUE);
		Arrays.fill(pos, -1);
		for (int i = 0; i < n; i++) {
			// 증가하는중인가?
			if(lis.get(lis.size()-1) < array[i]){
				lis.add(array[i]);
				pos[i] = lis.size()-1;
			} else if(lis.get(lis.size()-1) > array[i]){
				int index = Collections.binarySearch(lis, array[i]);
				// index가 0이상의 정수라면 제 위치를 찾았기 때문에 중복되어 필요없다.
				if(index <0){
					// 제 위치로 돌려주기
					index = (index+1) * -1;
					pos[i] = index;
					lis.set(index,array[i]);
				}
			}
		}
		sb.append(lis.size()-1).append('\n');
		int len = lis.size()-1;
		Stack<Integer> s = new Stack<>();
		for (int i = n-1; i >=0; i--) {
			if(pos[i] == len){
				len--;
				s.push(array[i]);
			}
		}
		while(!s.isEmpty()){
			sb.append(s.pop()).append(' ');
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