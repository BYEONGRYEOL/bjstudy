package org.example;

class pgm_별찍기 {
	public long solution(int k, int d) {
		long answer = 0;
		long dSquare = (long)d * d;
		for (long i = 0; i <= d; i += k) {
			answer += (long)Math.sqrt(dSquare - i * i) / k + 1;
		}

		return answer;
	}
}