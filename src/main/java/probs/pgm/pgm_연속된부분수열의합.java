package probs.pgm;

import java.util.HashMap;
import java.util.Map;

class pgm_연속된부분수열의합 {
	public int[] solution(int[] sequence, int k) {

		int l = 0;
		int r = 0;
		int sum = sequence[0];
		int minLen = Integer.MAX_VALUE;
		int[] answer = new int[2];
		while(r < sequence.length){
			if(sum < k){
				if(r == sequence.length-1)
					break;
				sum += sequence[++r];
			} else if(sum > k){
				sum -= sequence[l++];
			} else{
				if(minLen > r - l){
					minLen = r-l;
					answer[0] = l;
					answer[1] = r;
				}
				if(r == sequence.length-1)
					break;
				sum += sequence[++r];
			}
		}
		return answer;
	}
}