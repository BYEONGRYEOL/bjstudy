package probs.pgm;

import java.util.Arrays;

class pgm_2개이하로다른비트 {
	public static long[] solution(long[] numbers) {
		long[] answer = new long[numbers.length];
		// 1111처럼 1이 꽉차있는 경우 10111로 변경해줘야한다.
		// 1011의 경우는? 1101
		// 대부분의 경우에서 처음으로 발견한 0을 오른쪽에 있는 1과 자리를 바꾸면 된다.
		// 그러면 1000의 경우는? 비트가 한개만 1001로 달라져도 된다.

		// 비트의오른쪽부터 1을 만나기 전 0을 먼저 만난 경우 해당 0을 1로 변경 -> 그냥 수에서 +1
		// 1을 만난 후 0을 만난 경우 해당 0과 1을 변경해줄것 그렇다면 원래 1이 있던 자리수를 빼고 0이 있던 자리수를 더해야한다.
		// 수가 충분히 크다
		for(int i = 0 ; i < numbers.length; i++){
			long flag = 1;
			while((numbers[i] & flag) > 0){
				System.out.println(flag);
				flag <<= 1;
			}
			answer[i] = numbers[i] + flag;
		}
		return answer;
	}

	public static void main(String[] args) {
		Arrays.stream(solution(new long[] {3, 7})).forEach(System.out::println);
	}
}