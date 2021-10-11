package M10;

public class D13_배달_2트 {
	public static int solution(int N, int[][] road, int K) {
		 //각 정점별 최단거리 배열.
        int[][] map = new int[N][N];                                       
        
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (i == j) {
                    map[i][j] = 0;
                    continue;
                }
              //K가 500000이하 자연수이므로 
                map[i][j] = 500001;                                            
            }
        }
 
        for (int i = 0; i < road.length; i++) { // road배열 적용
            if(map[road[i][0] - 1][road[i][1] - 1] < road[i][2])  continue;  
            map[road[i][0] - 1][road[i][1] - 1] = road[i][2];
            map[road[i][1] - 1][road[i][0] - 1] = road[i][2];
        }
        
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(i == j) continue;
                    if (map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }
 
        int count = 0;                                                        //1번 도시에 K이하만큼 연결돼있는 도시 개수
 
        for (int i = 0; i < map[0].length; i++) {
            if (map[0][i] <= K) 
                count++;
        }
        
        return count;
    }
	
	public static void main(String[] args) throws Exception {
		int N;
		int[][] road;
		int K;
		
		road = new int[][] {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
		N = 5;
		K = 3;
		System.out.println((solution(N,road,K)));
		
		road = new int[][] {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}};
		N = 6;
		K = 4;
		System.out.println((solution(N,road,K)));
		
	
	
	}
	
}


