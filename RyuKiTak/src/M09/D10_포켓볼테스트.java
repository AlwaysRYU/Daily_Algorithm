package M09;

public class D10_포켓볼테스트 {
	//좌표
	static class JP {
		double x;
		double y;
		
		public JP() {}
		public JP(double x, double y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "JP [x=" + x + ", y=" + y + "]";
		}
		
		// 두 좌표 각도 구하기 
		// 이거 반드시 외워두기
		public double gakdo(JP Node) {
			// 구하는 좌표  - 지금 좌표
			// YY XX 로 넣어야함!!!
			// - 면 360에서 빼줘야함~~
			double XX = Node.x - this.x;
			double YY = Node.y - this.y;
			double gak = Math.toDegrees(Math.atan2(YY, XX));
			return (double) ((gak < 0) ? (360d + gak) : gak);
		}
		
//		public toRadians(degrees) {	
//			return degrees * (Math.PI / 180);
//		}
		
		// 거리 구하기
		// 이것도 외워둬라~~이말이야
		public double length(JP Node) {
			double XX = Math.pow(Node.x - this.x, 2);
			double YY = Math.pow(Node.y - this.y, 2);
//			return Math.pow(XX+YY, 0.5);
			return Math.sqrt(XX+YY);
		}
		
		
		
		public JP whereToGo(JP Target, JP Hole) {
			JP WTG = new JP();
			
			//타겟이랑 거리
			double length = Target.length(Hole);
			System.out.println(length);
			//
			// 타겟과 홀의 각도
			double gak = Target.gakdo(Hole);
			System.out.println(Math.toRadians(gak));
			
			// 구하고자하는 5.73 + 
			double yy = (5.73 + length) * Math.sin(Math.toRadians(gak));  // 이게  세로  y 좌표임
			double xx = (5.73 + length) * Math.cos(Math.toRadians(gak));  // 이게  세로  y 좌표임
			// 왼쪽에 있거나 오른쪽에 있거나임
			WTG.x = Hole.x - xx;
			WTG.y = Hole.y - yy;
			
			return WTG;
			
		}
		
	}
	public static void main(String[] args) {
		
		JP origin = new JP(0,0);
		JP hall = new JP(254,127);
//		System.out.println(origin.gakdo(hall));
//		System.out.println(origin.gakdo(new JP(127,0)));
//		System.out.println(origin.gakdo(new JP(0,127)));
//		
		JP center = new JP(127,63.5);
		System.out.println(center.gakdo(new JP(254,63.5)));
		System.out.println(center.gakdo(new JP(254,127)));
		System.out.println(center.gakdo(new JP(127,127)));

		System.out.println(center.gakdo(new JP(0,63.5)));
		System.out.println(center.gakdo(new JP(0,50)));
		System.out.println(center.gakdo(new JP(0,0)));
		System.out.println(center.gakdo(new JP(127,0)));
		System.out.println(center.gakdo(new JP(254,0)));
		
		System.out.println();
		System.out.println("거리구하기");
		System.out.println();
		System.out.println(center.length(new JP(0,127)));
		
		System.out.println();
		System.out.println("어디로 보낼지 ");
		System.out.println();
		// center 127 / 63.5
		System.out.println(center.whereToGo( new JP(200,100), new JP(254,127)));
		JP exp = new JP (194.875, 97.437);
		System.out.println(exp.length(new JP(200,100)));
		
		
//		Math.toRadians(angdeg) 라디안 아니면 
		
		
		
	}

}
