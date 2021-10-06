package M10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

//https://programmers.co.kr/learn/courses/30/lessons/72412?language=java
public class D07_순위검색 {
	
	public static void main(String[] args) {
		String[] info = {"java backend junior pizza 150",
					"python frontend senior chicken 210",
					"python frontend senior chicken 150",
					"cpp backend senior pizza 260",
					"java backend junior chicken 80",
					"python backend senior chicken 50"
						};
		
		String[] query = {
				"java and backend and junior and pizza 100",
				"python and frontend and senior and chicken 200",
				"cpp and - and senior and pizza 250",
				"- and backend and senior and - 150",
				"- and - and - and chicken 100",
				"- and - and - and - 150"
		};
		
		System.out.println(Arrays.toString(solution(info,query)));
		
	}
	
	// 이분탐색
	static HashMap<String, ArrayList<Integer>> map;
	public static int[] solution(String[] info, String[] query) {
        
		// 쿼리의 질문의 개수만큼 답이 정해져 있다.
		int[] answer = new int[query.length];
        
		// 입력받은 지원자의 정보들로 만들어 질 수 있는 모든 경우의 수를 저장
		// 조합 이용
		// 문자열이 key / 점수가 value임 
		// 점수를 기준으로 데이터 정렬
		map = new HashMap<>();
		for(String str : info) {
			// 빈칸을 기준으로 분리
			String[] infoArray = str.split(" ");
			System.out.println(Arrays.toString(infoArray));
			// 이걸 왜하냐?
			// 이 인물이 해당되는 것을 모두 저장하기 위함이다.
			combination("",0,infoArray);
		}
        // 위 과정을 끝내면, map안에는 한사람당 가질 수있는, 즉 포함되는 모든 경우의수를 키로 갖는 (문자열), 그 값은 점수인  해시맵이 완성된다.
		// 이제 그 쿼리에 따라 맞춰볼 것이다.
		
		// 쿼리 주소
		int queryIdx = 0;
        for(String Q : query) {
        	// 쿼리 하나 하나 해보기
        	String str = Q.replace(" and ",""); // 쿼리에 and 없애기
        	String[] temp = str.split(" "); // str을 " "을 분리해서 저장
        	System.out.println();
        	System.out.println("해당쿼리");
        	System.out.println(Arrays.toString(temp));
        	// 사실 다붙여놔서 점수따로, str만 저장된다.
        	// [ pythonfrontendseniorchicken, 200 ] 이런식임
        	
        	Collections.sort(map.get(temp[0])); // 정렬
        	// 글자로 정렬해버린다.
        	
        	// 이진탐색해서 찾아봅니다.
        	answer[queryIdx] = binarySearch(temp[0], Integer.parseInt(temp[1]));
        	queryIdx += 1;
        }
        
        return answer;
    }
	
	static void combination(String str, int depth, String[] arr) {
		// 기저 조건
		if (depth == 4 ) {
			System.out.println(str);
			int score = Integer.parseInt(arr[4]);
			
			if ( map.containsKey(str)) map.get(str).add(score);
			else {
				ArrayList<Integer> tmp = new ArrayList<>();
				tmp.add(score);
				map.put(str, tmp);
			}
			// 종료
			return;
		}
		// 
		combination(str + "-", depth + 1, arr);
		combination(str + arr[depth], depth+1, arr);
	}
	
	
	static int binarySearch(String query, int score) {
		// 없으면 0리턴
		// 1. str 조건에 맞는 사람 찾기
		if(map.containsKey(query) == false ) return 0;
		ArrayList<Integer> tmpList = map.get(query);
//		있다.
		System.out.println("이진탐색");
		System.out.println(tmpList.toString());
		
		// 2. 점수 맞는 사람 찾기
		int start = 0;
		int end = tmpList.size() -1;
		while( start <= end ) {
			int mid = (start + end) / 2;
			if( score > tmpList.get(mid) ) start = mid+1;
			else end = mid - 1;
		}
		return tmpList.size() - start;
	}

}
