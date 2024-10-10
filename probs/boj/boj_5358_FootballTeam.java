package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_5358_FootballTeam {

	//static void input() throws Exception {
	//     Map<Character, Character> replacements = Map.of(
	//         'i', 'e',
	//         'e', 'i',
	//         'I', 'E',
	//         'E', 'I'
	//     );
	//
	//     String line = "";
	//     while ((line = scan.nextLine()) != null) {
	//         StringBuilder sb = new StringBuilder();
	//         for (char ch : line.toCharArray()) {
	//             sb.append(replacements.getOrDefault(ch, ch)); // Replace or keep original
	//         }
	//         sb.append('\n');
	//         System.out.print(sb.toString()); // Or your custom print method
	//     }
	// }
	static void input() throws Exception {
		String line = "";
		while((line = scan.nextLine())!= null){
			char[] lineCharArray = line.toCharArray();
			for (int i = 0; i < lineCharArray.length; i++) {
				if(lineCharArray[i] == 'i')
					lineCharArray[i] = 'e';
				else if(lineCharArray[i] == 'e')
					lineCharArray[i] = 'i';
				else if(lineCharArray[i] == 'I')
					lineCharArray[i] = 'E';
				else if (lineCharArray[i] == 'E')
					lineCharArray[i] = 'I';
			}
			sb.append(lineCharArray).append('\n');
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