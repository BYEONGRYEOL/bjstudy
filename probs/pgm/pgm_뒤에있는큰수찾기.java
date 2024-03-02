package probs.pgm;
import java.util.*;

class pgm_뒤에있는큰수찾기 {
	public int[] solution(int[] numbers) {
		int[] answer = new int[numbers.length];
		// 완전탐색은 안된다.
		// 가장 가까운 ~~~한 조건 -> 스택
		Stack<int[]> s = new Stack<>();
		for(int i = 0 ; i < numbers.length; i++){
			while(!s.isEmpty() && s.peek()[0] < numbers[i]){
				// 가장 가까운 큰수를 만났다.
				int[] find = s.pop();
				answer[find[1]] = numbers[i];
			}
			// 저장되어있던 수들에 대해서 모두 numbers[i] 보다 크거나 같다
			s.push(new int[]{numbers[i], i});
		}
		while(!s.isEmpty()){
			int[] remain = s.pop();
			answer[remain[1]] = -1;
		}
		return answer;
	}
}