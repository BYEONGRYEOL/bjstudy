package probs.pgm;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class pgm_숫자카드나누기 {
	static int gcd(int a, int b) {
		return a % b == 0 ? b : gcd(b, a % b);
	}

	public static int solution(int[] arrayA, int[] arrayB) {
		int answer = 0;
		int[] distinctA = IntStream.of(arrayA).distinct().toArray();
		int gcdA = distinctA[0];
		for (int i = 1; i < distinctA.length; i++) {
			gcdA = gcd(distinctA[i], gcdA);
		}

		int[] distinctB = IntStream.of(arrayB).distinct().toArray();

		int gcdB = distinctB[0];
		for (int i = 1; i < distinctB.length; i++) {
			gcdB = gcd(distinctB[i], gcdB);
		}

		List<Integer> divisorListA = new ArrayList<>();
		for (int i = gcdA; i > 1; i--)
			if (gcdA % i == 0)
				divisorListA.add(i);

		List<Integer> divisorListB = new ArrayList<>();
		for (int i = gcdB; i > 1; i--)
			if (gcdB % i == 0)
				divisorListB.add(i);

		boolean dividedFlag = false;
		for (Integer divisorA : divisorListA) {
			dividedFlag = false;
			for (int i = 0; i < distinctB.length; i++) {
				if (distinctB[i] % divisorA == 0) {
					dividedFlag = true;
					break;
				}
			}
			if (dividedFlag == false) {
				answer = Math.max(divisorA, answer);
			}
		}

		dividedFlag = false;
		for (Integer divisorB : divisorListB) {
			dividedFlag = false;
			for (int i = 0; i < distinctA.length; i++) {
				if (distinctA[i] % divisorB == 0) {
					dividedFlag = true;
					break;
				}
			}
			if (dividedFlag == false) {
				answer = Math.max(divisorB, answer);
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		solution(new int[] {10, 20}, new int[] {5, 17});
	}
}