package org.example;

class pgm_쿼드압축후개수세기 {
	int ZERO_ONE_COUNT[];

	void quad(int sx, int sy, int len, int[][] arr) {
		int num = arr[sx][sy];
		for (int dx = 0; dx < len; dx++) {
			for (int dy = 0; dy < len; dy++) {
				if (arr[sx + dx][sy + dy] != num) {
					len /= 2;
					quad(sx, sy, len, arr);
					quad(sx + len, sy, len, arr);
					quad(sx, sy + len, len, arr);
					quad(sx + len, sy + len, len, arr);
					return;
				}
			}
		}
		ZERO_ONE_COUNT[num]++;
	}

	public int[] solution(int[][] arr) {
		int n = arr.length;
		ZERO_ONE_COUNT = new int[2];
		quad(0, 0, n, arr);

		return ZERO_ONE_COUNT;
	}
}