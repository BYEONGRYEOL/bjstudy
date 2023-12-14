package org.example;

import java.util.*;
class pgm_택배상자 {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> s= new Stack<>();
        int initialBox = 1;
        boolean stop = false;
        for(int i = 0 ; i < order.length; i++){
            int nowBox = order[i];
            while( nowBox > initialBox){
                s.push(initialBox++);
            }
            if(nowBox == initialBox){
                initialBox ++;
            }
            else if(nowBox<initialBox){
                if(s.peek() == nowBox){
                    s.pop();
                }
                else{
                    break;
                }
            }
            answer ++;
        }

        return answer;
    }
}