package org.example;
import java.util.*;


public class test {
    static class Timer{
        long start;
        public void start(){
            start = System.currentTimeMillis();
        }
        public void end(String task){
            System.out.println(task + " : " + (System.currentTimeMillis() - start)/(double) 1000);
        }
    }
    public static int switchString(String str){
        switch(str){
            case "string1":
                return 1;
            case "string2":
                return 2;
            case "string3":
                return 3;
            case "string4":
                return 4;
            case "string5":
                return 5;
            case "string6":
                return 6;
            case "string7":
                return 7;
            case "string8":
                return 8;
            case "string9":
                return 9;
            case "string10":
                return 10;
            case "string11":
                return 11;
            case "string12":
                return 12;

            default:
                return 1;
        }
    }
    public static int switchInt(int value){
        switch(value){
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 6;
            case 7:
                return 7;
            case 8:
                return 8;
            case 9:
                return 9;
            case 10:
                return 10;
            case 11:
                return 11;
            case 12:
                return 12;
            default:
                return 0;
        }
    }

    public static int ifInt(int value){
        if(value == 1)
            return 1;
        else if(value == 2)
            return 2;
        else if(value == 3)
            return 2;
        else if(value == 4)
            return 2;
        else if(value == 5)
            return 2;
        else if(value == 6)
            return 2;
        else if(value == 7)
            return 2;
        else if(value == 8)
            return 2;
        else if(value == 9)
            return 2;
        else if(value == 10)
            return 2;
        else if(value == 11)
            return 2;
        else if(value == 12)
            return 2;
        return 0;
    }
    public static void main(String[] args) {
        Timer timer = new Timer();

        Map<String, Integer> map = new HashMap<>();
        for(int i  =1 ; i < 13; i++){
            map.put("string" + i, i);
        }




        timer.start();
        for(int i = 0 ; i < 100000000; i++){
            switchInt(1); // switch 첫번째 hit
        }
        timer.end("int switch 첫번 째 hit");

        timer.start();
        for(int i = 0 ; i < 100000000; i++){
            switchInt(1); // switch 첫번째 hit
        }
        timer.end("int switch 첫번 째 hit");


        timer.start();
        for(int i = 0 ; i < 100000000; i++){
            switchInt(12); // switch 6번째 hit
        }
        timer.end("int switch 12번 째 hit");

        timer.start();
        for(int i = 0 ; i < 100000000; i++){
            switchString("string1"); // switch 첫번째 hit
        }
        timer.end("String switch 첫번 째 hit");

        timer.start();
        for(int i = 0 ; i < 100000000; i++){
            switchString("string12"); // switch 6번째 hit
        }
        timer.end("String switch 12번 째 hit");



        timer.start();
        for(int i = 0 ; i < 100000000; i++){
            switchInt(map.get("string1")); // mapper 활용한 switch 첫번째 hit
        }
        timer.end("mapper 활용한 int switch 첫번 째 hit");

        timer.start();
        for(int i = 0 ; i < 100000000; i++){
            switchInt(map.get("string12")); // mapper 활용한 switch 12번째 hit
        }
        timer.end("mapper 활용한 int switch 12번 째 hit");

        timer.start();
        for(int i = 0 ; i < 100000000; i++){
            ifInt(1); // mapper 활용한 switch 12번째 hit
        }
        timer.end("보너스 int if문 1번째 hit");
        timer.start();
        for(int i = 0 ; i < 100000000; i++){
            ifInt(12); // mapper 활용한 switch 12번째 hit
        }
        timer.end("보너스 int if문 12번째 hit");
    }
}
