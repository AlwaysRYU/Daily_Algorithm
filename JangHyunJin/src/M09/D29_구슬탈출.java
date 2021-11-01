import java.awt.Point;
import java.io.*;
import java.util.*;

class Ball{
	
	Point red;
	Point blue;
	
	public Ball(Point red, Point blue) {
		super();
		this.red = red;
		this.blue = blue;
	}
	
	@Override
	public String toString() {
		return "Balls [red=" + red + ", blue=" + blue + "]";
	}
	
	
}
public class 백준_구슬탈출{


	
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N,M;
	static char[][] arr;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	public static void main(String[] args) throws Exception{
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr =new char[N][M];
		
		Point r = new Point();
		Point b = new Point();
		
		for(int i=0;i<N;++i) {
			String input = br.readLine();
			for(int j=0;j<M;++j) {
				arr[i][j] =  input.charAt(j);
				if(arr[i][j]=='R') {
					arr[i][j] = '.';
					r.x = i;
					r.y = j;
				}else if(arr[i][j]=='B') {
					arr[i][j] = '.';
					b.x = i;
					b.y = j;
				}
			}
		}
		
		
		System.out.println(bfs(r,b)==true?"1\n":"0\n");

	}
	private static boolean bfs(Point r, Point b) {
		Queue<Ball> q = new LinkedList<>();
		q.add(new Ball(r,b));
		
		int cnt = 0;
		
		while(!q.isEmpty()) {
			if(cnt==10) break;
			
			int s= q.size();			
			for(int i=0;i<s;++i) {
				Ball item = q.poll();
				//printing(item);
				for(int d=0;d<4;++d) {					
					if (detectWhole(item.blue.x, item.blue.y, d)) {
						continue;
					}
					if (detectWhole(item.red.x, item.red.y, d)) {
						return true;		
					}
					
					Point nextRedPoint = getLocation(item.red,d);
					Point nextBluePoint = getLocation(item.blue,d);
					
					if(nextRedPoint.x==nextBluePoint.x && nextRedPoint.y==nextBluePoint.y) {
						int redDistance = getDistance(item.red,nextRedPoint);
						int blueDistance = getDistance(item.blue,nextBluePoint);
						
						if(redDistance<blueDistance) {
							nextBluePoint.x = nextRedPoint.x-dx[d];
							nextBluePoint.y = nextRedPoint.y-dy[d];
						}else {
							nextRedPoint.x = nextBluePoint.x-dx[d];
							nextRedPoint.y = nextBluePoint.y-dy[d];
						}	
					}
					q.add(new Ball(nextRedPoint,nextBluePoint));
					
				}
				
			}
			cnt++;
		}
		
		
		return false;
	}
	
	private static void printing(Ball b) {
		System.out.println(b);
		for(int i=0;i<N;++i) {
			for(int j=0;j<M;++j) {
				if(b.red.x==i && b.red.y==j) {
					System.out.print('R');
				}
				else if(b.blue.x==i && b.blue.y==j) {
					System.out.print('B');
				}else {					
					System.out.print(arr[i][j]);
				}
			}System.out.println();
		}
	}
	private static int getDistance(Point p1, Point p2) {
		return Math.abs(p1.x-p2.x)+Math.abs(p1.y-p2.y);
	}
	private static Point getLocation(Point p,int d) {
		Point res= new Point(p.x,p.y);
		
		while(isRange(res.x, res.y) && arr[res.x][res.y]=='.') {
			res.x+=dx[d];
			res.y+=dy[d];
		}
		
		res.x-=dx[d];
		res.y-=dy[d];
		
		return res;
	}
	private static boolean detectWhole(int x, int y, int d) {		
		while(true) {
			x+=dx[d];
			y+=dy[d];
			
			if(!isRange(x,y)) return false;
			
			if(arr[x][y]=='#') return false;
			else if(arr[x][y]=='O') return true;
		}
	}
	
	private static boolean isRange(int x,int y) {
		return x>=0 && y>=0 &&x<N&&y<M;
	}

}