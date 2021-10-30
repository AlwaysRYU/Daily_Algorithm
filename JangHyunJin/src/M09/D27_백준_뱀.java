import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_뱀{
	private static final int[] dx = {0, 1, 0, -1};
	private static final int[] dy = {1, 0, -1, 0};
	
	private static final int EMPTY = 0;
	private static final int SNAKE = 1;
	private static final int APPLE = 2;	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		
		int k = Integer.parseInt(br.readLine());
		for (int i = 0; i < k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			
			map[r][c] = APPLE;
		}
		
		int l = Integer.parseInt(br.readLine());
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < l; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			q.offer(new int[] {x, c});
		}
		
		int time = 0;
		Deque<int[]> snake = new LinkedList<>();
		map[0][0] = SNAKE;
		snake.offer(new int[] {0, 0});
		int dir = 0;
		while(true) {
			if (!q.isEmpty()) {
				int changeTime = q.peek()[0];
				if (time == changeTime) {
					char c = (char)q.peek()[1];
					if (c == 'D') {
						dir = (dir + 1) % 4;
					} else {// c == 'L'
						dir = (dir - 1 + 4) % 4;
					}
					q.poll();
				}
			}
			
			int[] head = snake.peekFirst();
			int nx = head[0] + dx[dir];
			int ny = head[1] + dy[dir];
			
			if (nx < 0 || nx >= n || ny < 0 || ny >= n) break;
			if (map[nx][ny] == SNAKE) break;
			
			// 사과가 없으면 꼬리 줄이기
			if (map[nx][ny] != APPLE) {
				int[] tail = snake.pollLast();
				map[tail[0]][tail[1]] = EMPTY;
			}
			
			// 머리를 늘인다.
			map[nx][ny] = SNAKE;
			snake.offerFirst(new int[] {nx, ny});
			
			time++;
		}
		
		System.out.println(time + 1);
	}
}
