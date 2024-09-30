package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11689_GCD_n_k_1 {

	static void input() throws Exception {
		long n = scan.nextLong();
		// 서로소의 개수를 구하는 함수 : 오일러 피 함수
		// phi(n) = n의 서로소의 개수
		int p = 2;
		long result = n;

		// 36 의 경우 2로 나누어떨어짐, 2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36 모두 제거되어야함
		// result = n -  n / 2;
		// result = 36 - 18;
		// 오일러 phi 함수는 a,b 가 서로소인 경우 phi(a*b) = phi(a) * phi(b) 가 성립함
		// 위의 n의 값을 소인수분해하여 p1^a1 * p2^a2 * p3^a3 의 꼴로 변형한다면,
		// p1^a1, p2^a2, p3^a3는 각각 n의 소인수이므로, 서로소이다.
		// phi(n) = phi(p1^a1) * phi(p2^a2) * phi(p3^a3)
		// 어떤 소수 p에 대하여 phi(p^n) = p^n - p^n-1 이 된다.
		// p1,p2,p3는 각각 n의 소인수이므로 소수이다.
		// phi(n) = (p1^a1 - p1^(a1-1)) * (p2^a2 - p2^(a2-1)) *....
		// = p1^a1 * p2^a2 * p3^a3 *(1-1/p1)*(1-1/p2)*....
		// = n *(1-1/p1)*(1-1/p2)*....
		// 여기서 n * (1-1/p1)의 값은 n - n/p1으로 계산될 수 있으며 
		// 컴퓨터의 나눗셈연산으로 해결될 수 있다. (p1은 n의 인수이므로 나머지 = 0)
		// n - n/p1 == n -= n/p 임이 자명함
		// n - n/p1의 값을 n1이라고하면 다음 괄호부터는 n1(1-1/p2)를 계산하게된다.
		// 수학적으로는 n1은 n을 n의 소인수인 p1으로 한번 나눈 값이 되므로, n의 p1이 아닌 다른 소인수인 p2로 나누어떨어짐이 자명하다.
		// 계속해서 result -= result / p_i 로 계산
		// 3으로 나누어떨어짐, 3,9,15,21,27,33 제거

		while((long)p * p <=n){
			// 굳이 p가 소수인지 체크하지 않아도 되는 이유는 소수가 아닌 p는 해당 p의 인수인 p_prev에 의해 n이 나누어진 상황으로, n%p ==0이 성립하지 않음
			if(n%p == 0){
				result -= result / p;
				while (n % p == 0)
					n /=p;
			}
			p +=1;
		}

		if(n > 1){
			result -= result / n;
		}
		sb.append(result);
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