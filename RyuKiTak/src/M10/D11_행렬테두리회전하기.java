package M10;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/77485?language=java
public class D11_행렬테두리회전하기 {
	
	
	public static int[] solution(int rows, int columns, int[][] queries) {
		int QN = queries.length;
		int[] answer = new int[QN];
		
		
		// 1. 필드 초기화
		int[][] field = new int[rows][columns];
		int temp = 1;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				field[i][j] = temp++; 
			}
		}
		
		System.out.println();
		for (int xx = 0; xx< rows; xx++) {
			for (int j = 0; j < columns; j++) {
				System.out.print(field[xx][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		

		// 2. 쿼리 실행
		for (int i = 0; i < QN; i++) {
			int Maxx = Integer.MAX_VALUE;
			
			
			int x1 = queries[i][0] -1;
			int y1 = queries[i][1] -1;
			int x3 = queries[i][2] -1;
			int y3 = queries[i][3] -1;
			int x2 = x1;
			int y2 = y3;
			int x4 = x3;
			int y4 = y1;
			
		
			// 1. 위측 옮기기
			int remember = field[x2][y2-1]; // 처음수 저장해놓기
			int len = y2-y1 -1;
			for (int j = 0; j < len; j++) {
				field[x1][y2-1-j] = field[x1][y2-2-j];
				Maxx = Integer.min(Maxx, field[x1][y2-1-j]);
			}
			// 위에 맨 마지막수 하기
			field[x1][y1] = field[x1+1][y1];
			Maxx = Integer.min(Maxx, field[x1][y1]);
			System.out.println("위측 " + remember);
			for (int xx = 0; xx< rows; xx++) {
				for (int j = 0; j < columns; j++) {
					System.out.print(field[xx][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
			
			
			// 2. 우측돌리기
			int before = field[x3][y3];
			len = x3-x2;
			for (int j = 0; j < len; j++) {
				field[ x3 - j ][y2] = field[x3 -j -1][y2];
				Maxx = Integer.min(Maxx, field[ x3 - j ][y2]);
			}
			Maxx = Integer.min(Maxx, field[x2][y2]);
			field[x2][y2] = remember;
			System.out.println("우측돌리기" + before);
			for (int xx = 0; xx< rows; xx++) {
				for (int j = 0; j < columns; j++) {
					System.out.print(field[xx][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
			
			
			// 3. 밑에 돌리기
			remember = field[x4][y4];
			len = y3-y4;
			for (int j = 0; j < len; j++) {
				field[x3][y4+j] = field[x3][y4+1+j];
				Maxx = Integer.min(Maxx, field[x3][y4+j]);
			}
			field[x3][y3-1] = before;
			Maxx = Integer.min(Maxx, field[x3][y3-1]);
			
			System.out.println("밑에돌리기" + remember);
			for (int xx = 0; xx< rows; xx++) {
				for (int j = 0; j < columns; j++) {
					System.out.print(field[xx][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
			
			
			
			// 4. 왼쪽돌리기
			System.out.println(remember + "ddd");
			len = x4 - x1 -1;
			for (int j = 0; j < len; j++) {
				field[x1+1+j][y4] = field[x1+1+j +1][y4];
				Maxx = Integer.min(Maxx, field[x1+1+j][y4]);
			}
			field[x4-1][y4] = remember;
			Maxx = Integer.min(Maxx, field[x4-1][y4]);
			
			System.out.println("왼쪽돌리기");
			for (int xx = 0; xx< rows; xx++) {
				for (int j = 0; j < columns; j++) {
					System.out.print(field[xx][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
			
			
			answer[i] = Maxx;
		}
		
		
	    return answer;
	    
	
	}
	 
	public static void main(String[] args) throws Exception {
		int rows, columns;
		int[][] query;
		int answer;
		
//		query = new int[][] {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
//		rows = 6; columns = 6; 
//		System.out.println(Arrays.toString(solution(rows,columns,query)));
		
		query = new int[][ ]{{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}};
		rows = 3; columns = 3;
		System.out.println(Arrays.toString(solution(rows,columns,query)));
		
		
//		query = new int[][] {{1,1,8,8}};
//		rows = 8; columns = 8; 
//		System.out.println(Arrays.toString(solution(rows,columns,query)));
	}

}
