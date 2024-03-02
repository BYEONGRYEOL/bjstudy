package probs.pgm;

import java.util.*;
import java.util.stream.*;
class pgm_k진수에서소수개수구하기 {
	public String toBase_KNumber(int n, int k){
		StringBuilder sb = new StringBuilder();

		while(n >0){
			sb.append(n%k);
			n/=k;
		}
		return sb.reverse().toString();
	}

	public boolean isPrime(long number){
		if(number == 1)
			return false;
		for(int i = 2; i <= Math.pow(number, 0.5); i++){
			if(number % i == 0)
				return false;
		}
		return true;
	}

	public int solution(int n, int k) {
		// 0을 포함한 소수는 제외
		// 먼저 k진수로 변환하는 코드 작성
		int answer = -1;
		String kBase = toBase_KNumber(n,k);
		return (int) Arrays.stream(kBase.split("0")).filter(str -> "".equals(str) == false).map(Long::parseLong).filter(l -> isPrime(l)).count();
	}
}