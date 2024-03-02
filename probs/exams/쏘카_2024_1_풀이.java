package probs.exams;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 쏘카_2024_1_풀이 {

	static void input() throws Exception {

		int money = scan.nextInt();
		int roll = scan.nextInt();
		int ticketCount = scan.nextInt();
		int shopCount = scan.nextInt();
		int 상점에있는티켓수 = scan.nextInt();
		String[] tickets = new String[ticketCount];
		String[][] shop = new String[shopCount][상점에있는티켓수];
		for (int i = 0; i < ticketCount; i++) {
			tickets[i] = scan.nextLine();
		}
		for (int i = 0; i < shopCount; i++) {
			for (int j = 0; j < 상점에있는티켓수; j++) {
				shop[i][j] = scan.next();
			}
		}

		// 문제를 설명하면서 자연스럽게 턴제 게임을 하듯이 생각하게 만듬
		// 턴제 게임?
		// 현재 state 에서 내가 할 수 있는 action = {reroll, a,b,c등 주어진 카드들 중 1개를 구입, 2개? 어 종류는?}

		// action 1 a 1개 사기
		// action 2 b 1개 사기
		// action 3 c 1개 사기

		// ------

		// action 113 a2개 b1개 c1개 사기
		// dfs, bfs를 배웟으니까

		// state에 어떤 action을 취해야하는지 오해하게 만드는 유형
		// 사실은 greedy한 규칙이 숨어있다.

		Arrays.sort(tickets, Comparator.comparingInt(s -> Integer.parseInt(s.substring(2))));
		Map<String, Integer> ticketIndexMapper = new HashMap<>();

		// 티켓의 가격
		// Map = [A:2, B:3, C:5, D:4]

		// 현재 리롤 횟수에 대한 티켓의 종류와 그 수
		// Map = [A:2 B:2]

		// Map.Entry key : A value : 2
		// A가 3개 이상이고, A의 가격이 얼마고
		// 없는 정보가 A를 사야하는가?

		// 티켓과 티켓의 가격에 의한 구매 우선순위
		// Map [A:1, B:2, C:4, D:3]

		// array [A,B,D,C]

		int[] values = new int[ticketCount];
		int[] ticketCounts = new int[ticketCount];
		int m = shop[0].length;

		for (int i = 0; i < ticketCount; i++) {
			String[] ticket_value_pair = tickets[i].split(" ");
			ticketIndexMapper.put(ticket_value_pair[0], i);
			values[i] = Integer.parseInt(ticket_value_pair[1]);
		}
		// A B D C 싼 순서대로 정렬되어있는 상태

		// 0 1 2 3
		// 가격
		// 1 2 3 5

		// roll 0 B2 C2   에서 30원으로 최대한 많이 사기
		// roll 1 A3 B3 C2 에서 20원으로 ``
		// roll 2 A3 B3 C3 D3 에서 10원으로 ``
		// roll 3 ``

		int maxGoldTicket = 0;
		int nowGoldTicket = 0;
		for (int reroll = 0; reroll < shopCount; reroll++) {
			nowGoldTicket = 0;
			int nowMoney = money;
			nowMoney -= reroll * roll;
			// 살 수 있는 후보들 정리
			for (int j = 0; j < m; j++) {
				String ticket = shop[reroll][j];
				ticketCounts[ticketIndexMapper.get(ticket)]++;
			}

			for (int j = 0; j < ticketCount; j++) {
				int gold = ticketCounts[j] / 3;

				while (gold > 0) {
					if (nowMoney >= values[j] * 3) {
						nowMoney -= values[j] * 3;
						nowGoldTicket++;
						gold--;
					} else {
						break;
					}
				}
			}
			maxGoldTicket = Math.max(nowGoldTicket, maxGoldTicket);
			System.out.printf("reroll : %d nowGoldTicket : %d nowMoney : %d \n", reroll, nowGoldTicket, nowMoney);
		}
		System.out.println(maxGoldTicket);
	}

	static void print() {
		System.out.print(sb.toString());
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public FastReader(String s) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(new File(s)));
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