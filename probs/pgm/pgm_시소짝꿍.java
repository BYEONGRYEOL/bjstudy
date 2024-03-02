package probs.pgm;

public class pgm_시소짝꿍 {
	public long solution(int[] weights) {
		long answer = 0;
		long[] arr = new long[1001];

		for (int i = 0; i < weights.length; i++) {
			arr[weights[i]]++;
		}

		for (int i = 100; i <= 1000; i++) {
			if (arr[i] == 0)
				continue;
			// 같은 무게끼리 짝꿍
			answer += (arr[i] * (arr[i] - 1)) / 2;
			int case1 = (4 * i) / 3;
			int case2 = (3 * i) / 2;
			int case3 = (i * 2);
			if (case1 > 1000)
				continue;
			if (i % 3 == 0) {
				answer += arr[i] * arr[case1];
			}
			if (case2 > 1000)
				continue;
			if (i % 2 == 0) {
				answer += arr[i] * arr[case2];
			}

			if (case3 > 1000)
				continue;
			answer += arr[i] * arr[case3];
		}

		return answer;
	}

}
