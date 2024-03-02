package probs.pgm;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.stream.Collectors;

class pgm_두큐합같게만들기 {
	public static int solution(int[] queue1, int[] queue2) {
		long sumOfQueue1 = Arrays.stream(queue1).sum();
		long sumOfQueue2 = Arrays.stream(queue2).sum();
		if(sumOfQueue1 + sumOfQueue2 % 2 == 1){
			return -1;
		}
		long targetNumber = (sumOfQueue1 + sumOfQueue2) / 2;
		long q1Diff = sumOfQueue1 - targetNumber;

		Queue<Integer> q1 = Arrays.stream(queue1).boxed().collect(Collectors.toCollection(ArrayDeque::new));
		Queue<Integer> q2 = Arrays.stream(queue2).boxed().collect(Collectors.toCollection(ArrayDeque::new));

		int q1PopCount = 0;
		int q2PopCount = 0;

		while(q1PopCount < 2 * queue1.length && q2PopCount < 2 * queue2.length){
			if(q1Diff == 0){
				return q1PopCount + q2PopCount;
			} else if(q1Diff < 0){
				q2PopCount ++;
				int add = q2.poll();
				q1Diff += add;
				q1.add(add);
			} else{
				q1PopCount ++;
				int minus = q1.poll();
				q1Diff -= minus;
				q2.add(minus);
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int result = solution(new int[]{3,2,7,2}, new int[]{4,6,5,1});
		System.out.println(result);
	}
}