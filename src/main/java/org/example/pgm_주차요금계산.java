package org.example;

import java.util.*;

class pgm_주차요금계산 {
	public int timeToInt(String time){
		String[] timearray = time.split(":");
		return Integer.parseInt(timearray[0]) * 60 + Integer.parseInt(timearray[1]);
	}

	public int parkingFeeCalculator(int time, int[] fees){
		int defaultTime = fees[0];
		int defaultFee = fees[1];
		int unitTime = fees[2];
		int unitFee = fees[3];
		if(time <= defaultTime){
			return defaultFee;
		} else{
			return defaultFee + (int)Math.ceil((time - defaultTime) / (double) unitTime) * unitFee;
		}
	}

	public void calculateParkingFee(Map<String, Integer> parkingTimesMap, Map<String, Integer> parkingFeesMap, int[] fees){
		for(Map.Entry<String, Integer> times : parkingTimesMap.entrySet()){
			String carNumber = times.getKey();
			int totalParkingTime = times.getValue();
			int parkingFee = parkingFeeCalculator(totalParkingTime, fees);
			parkingFeesMap.put(carNumber, parkingFee);
		}
	}

	public int[] solution(int[] fees, String[] records) {
		int[] answer = {};
		Map<String, Integer> parkingFeesMap = new HashMap<>();
		Map<String, Integer> parkingTimesMap = new HashMap<>();
		Map<String, Integer> inTimesMap = new HashMap<>();
		for(String record : records){
			String time = record.substring(0,5);
			String carNumber = record.substring(6,10);
			String inOrOut = record.substring(11);
			
			// 입차시간과 출차시간을 비교하여 누적시간 계산
			if("IN".equals(inOrOut)){
				inTimesMap.put(carNumber, timeToInt(time));
			} else {
				parkingTimesMap.put(carNumber, timeToInt(time) - inTimesMap.get(carNumber));
				inTimesMap.remove(carNumber);
			}
		}
		// 출차기록이 없는 차에 대해서 누적시간 계산
		for(Map.Entry<String, Integer> noOutCars : inTimesMap.entrySet()){
			parkingTimesMap.put(noOutCars.getKey(), timeToInt("23:59") - noOutCars.getValue());
		}
		calculateParkingFee(parkingTimesMap, parkingFeesMap, fees);
		
		return parkingFeesMap.entrySet().stream().sorted((e1,e2)-> e1.getKey().compareTo(e2.getKey())).mapToInt((e)->e.getValue()).toArray();
	}
}