package M10;

import java.util.ArrayList;
import java.util.Arrays;

//https://programmers.co.kr/learn/courses/30/lessons/42891?language=java
public class D03_무지의먹방라이브 {
	
	static class Food{
		int food;
		int index;
		public Food(int food, int index) {
			this.food = food;
			this.index = index;
		}
		@Override
		public String toString() {
			return "Food [food=" + food + ", index=" + index + "]";
		}
	}
	
	public static int solution(int[] food_times, long k) {
		int answer = 1;
		ArrayList<Food> foodlist = new ArrayList<>();
		int min = 100_000_001;
		for (int i = 0; i < food_times.length; i++) {
			if ( food_times[i] == 0 ) continue;
			foodlist.add(new Food(food_times[i], i));
			min = Math.min(min, food_times[i]);
		}
		for (Food x : foodlist ) {
			System.out.println(x);
		}
		System.out.println();
		
		// 배열로바꿔주기 
		// 최소를 저장해놓는다.

		ArrayList<Integer> deletelist = new ArrayList<>();
		
		// 연산 시작 
		long time = 0;
		while(true) {
			System.out.println("경과시간  : " + time);
			
			if ( (k-time) > foodlist.size() ) {
				
			}
			
			
			// 시간 푸드리스트 배열 길이 만큼 추가 
			time += foodlist.size() * min;
			deletelist.clear();
			for (int i = 0; i < foodlist.size(); i++) {
				foodlist.get(i).food -= min;
				if (foodlist.get(i).food == 0 ) {
					deletelist.add(i);
				}
			}
			for (Food x : foodlist ) {
				System.out.println(x);
			}
			System.out.println("삭제해야할 놈들");
			for (int x : deletelist ) {
				System.out.print(x + " --- >");
				System.out.println(foodlist.get(x));
			}
			
			// arraylist 0 있는거 조정하기
			for ( int i = deletelist.size()-1 ; i >= 0 ; i-- ) {
				int idx = deletelist.get(i);
				foodlist.remove(idx);
			}
			
			for (Food x : foodlist ) {
				System.out.println(x);
			}
			System.out.println();
			
			if ( deletelist.size() == 1) break;
			
		}
		
		
		
	    return foodlist.get(0).index + 1;    
	}
	 
	public static void main(String[] args) throws Exception {
//		int answer = solution();
		int[] arr = {3,1,2};
		int K = 5;
		System.out.println(solution(arr,K));
	}

}
