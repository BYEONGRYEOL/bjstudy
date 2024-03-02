package probs.pgm;

class pgm_멀쩡한사각형 {
	int gcd(int a, int b) {
		return a % b == 0 ? b : gcd(b, a % b);
	}

	public long solution(int w, int h) {

		return (long)w * h - (w + h - gcd(w, h));
	}
}