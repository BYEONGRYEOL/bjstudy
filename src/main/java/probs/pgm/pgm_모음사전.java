package probs.pgm;
import java.util.*;

class pgm_모음사전 {
	// I가 1563이므로 
	// A ~ AUUUU가 761개
	// E ~ EUUUU가 761개이다.
	// 총 761 * 5 개가 있음
	final char[] ALPHABET = {'A','E','I','O','U'};
	List<String> list = new ArrayList<>();
	void dfs(String str, int len) {
		list.add(str);
		if(len < 5)
			for(int i = 0; i < 5; i++)
				dfs(str + ALPHABET[i], len + 1);
	}
	public int solution(String word) {
		dfs("", 0);
		return list.indexOf(word);
	}
}