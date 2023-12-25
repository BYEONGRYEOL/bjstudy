package org.example;

class pgm_마법의엘리베이터 {
	int elevator(int floor) {
		int num = floor % 10;
		floor /= 10;
		if (floor == 0) {
			return Math.min(11 - num, num);
		}
		if (num > 5) {
			return elevator(floor + 1) + 10 - num;
		} else if (num < 5) {
			return elevator(floor) + num;
		} else {
			return Math.min(elevator(floor), elevator(floor + 1)) + 5;
		}
	}

	public int solution(int storey) {
		return elevator(storey);
	}
}