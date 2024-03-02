package probs.pgm;

import java.util.stream.*;
class pgm_가장큰수 {
	public static String solution(int[] numbers) {
		if(IntStream.of(numbers).sum() == 0) return "0";
		return IntStream.of(numbers)
			.mapToObj(String::valueOf)
			.sorted((s1,s2)->(s2 + s1).compareTo(s1 + s2))
			.collect(Collectors.joining());
	}

	public static void main(String[] args) {
		solution(new int[] {1, 4, 25, 342, 102, 2});
	}
}