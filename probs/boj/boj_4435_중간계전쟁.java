package probs.boj;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_4435_중간계전쟁 {

    static void input() throws Exception {
        //호빗, 인간, 엘프, 드워프, 독수리, 마법사 순서이다. 둘째 줄에는 사우론 군대에 참여한 종족의 수가 주어진다.
        // 이 값 역시 공백으로 구분되어 있으며,
        // 오크, 인간, 워그, 고블린, 우럭하이, 트롤, 마법사
        //호빗 - 1
        // 인간 - 2
        // 엘프 - 3
        // 드워프 - 3
        // 독수리 - 4
        // 마법사 - 10
        // 사우론의 군대의 점수는 다음과 같다.
        //
        // 오크 - 1
        // 인간 - 2
        // 워그(늑대) - 2
        // 고블린 - 2
        // 우럭하이 - 3
        // 트롤 - 5
        // 마법사 - 10
        int[] gandalf = {1,2,3,3,4,10};
        int[] sauron = {1,2,2,2,3,5,10};

        int iter = scan.nextInt();
        for (int i = 0; i < iter; i++) {
            int gandalfPower = 0;
            int sauronPower = 0;
            for (int j = 0; j < 6; j++) {
                gandalfPower += gandalf[j] * scan.nextInt();
            }
            for (int j = 0; j < 7; j++) {
                sauronPower += sauron[j]* scan.nextInt();
            }
            sb.append(String.format("Battle %d: ", i+1));
            sb.append(gandalfPower > sauronPower ? "Good triumphs over Evil" : gandalfPower == sauronPower ? "No victor on this battle field" : "Evil eradicates all trace of Good").append('\n');
        }
        print();
    }

    static void print(){
        System.out.print(sb.toString());
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(s));
        }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt() {
            return Integer.parseInt(next());
        }
        long nextLong() {
            return Long.parseLong(next());
        }
        double nextDouble() {
            return Double.parseDouble(next());
        }
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) throws Exception {
        input();
    }
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();



}