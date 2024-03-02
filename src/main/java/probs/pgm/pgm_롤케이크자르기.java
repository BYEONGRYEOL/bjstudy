package probs.pgm;

import java.util.*;
class pgm_롤케이크자르기 {
    public int solution(int[] topping) {
        int answer = 0;
        //모두 잘라서 탐색하긴 어렵다
        // 왼쪽 토핑종류당 수 오른쪽 토핑 종류당 수 를 계산하며 가야함
        Map<Integer, Integer> leftMap = new HashMap<>();
        Map<Integer, Integer> rightMap = new HashMap<>();
        
        for(int i =0 ; i < topping.length; i ++){
            rightMap.put(topping[i], rightMap.getOrDefault(topping[i], 0) + 1);
        }
        for(int i = 0;  i< topping.length; i++){
            leftMap.put(topping[i], leftMap.getOrDefault(topping[i], 0) + 1);
            if(rightMap.get(topping[i]) == 1){
                rightMap.remove(topping[i]);
            } else{
                rightMap.put(topping[i], rightMap.getOrDefault(topping[i], 0) - 1);
            }
            if(rightMap.size() == leftMap.size())
                answer++;
        }
        return answer;
    }
}