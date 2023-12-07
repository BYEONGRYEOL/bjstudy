package org.example;

class pgm_타겟넘버 {

	static int COUNT = 0;
	public void dfs(int[] numbers, int result, int target, int depth){
		if(depth == numbers.length){
			if(result == target)
				COUNT++;
			return;
		}

		dfs(numbers, result + numbers[depth], target, depth+1);
		dfs(numbers, result - numbers[depth], target, depth+1);
	}
	public int solution(int[] numbers, int target) {
		// 주어진 n이 크지 않으니 완전탐색
		dfs(numbers, 0, target, 0);
		return COUNT;
	}




}