package M10;

public class D32_큰수만들기 {
	
	public static void main(String[] args) throws Exception {
		
		String number = "1924";
		int k = 2;
		System.out.println(solution(number,k));
		
		number = "1231234";
		k = 3;
		System.out.println(solution(number,k));
//		
		number = "4177252841";
		k = 4;
		System.out.println(solution(number,k));
		
		
	} 
	
	static String N;
	static String Ranswer;
	static long answer;
	static StringBuilder str;
	static public String solution(String number, int k) {
        answer = 0;
        Ranswer = "";
        N = number;
        
        int len = number.length();
        int[] delarr = new int[k];
        
        delC(0, 0, k,delarr, len);
        
        
        return Ranswer;
    }

	private static void delC(int depth, int number, int k, int[] delarr,int len ) {
		if ( depth == k) {
			
//			System.out.println( Arrays.toString(delarr));
			str = new StringBuilder();
			str.append(N);
			for (int i = delarr.length-1; i >=0  ; i--) {
				int index = delarr[i];
				str.deleteCharAt(index);
			}
//			System.out.println(str.toString());
			if ( Integer.parseInt(str.toString()) > answer ) {
				answer = Integer.parseInt(str.toString());
				Ranswer = str.toString();
			}
			
			return;
		}
		if (number >= len) {
			return;
		}
		delarr[depth] = number;
		delC(depth+1, number+1, k, delarr, len);
		delC(depth, number+1,  k, delarr, len);
		
		
		
	}
	
	public String solution2(String number, int k) {
        StringBuilder sb = new StringBuilder();
	    
		int cnt = number.length() - k;
        int left = 0;
        int right = number.length() - cnt;
        int max = -1;
        int idx = 0;
        
        while(cnt > 0) {
        	 max = -1;
             for(int j = left ; j <= right ; ++j){
                 int num = number.charAt(j) - '0';
                 if(num > max){
                     idx = j;
                     max = num;
                 }
             }
             sb.append(number.charAt(idx));
             left = idx + 1;
             right = number.length() - --cnt;
        }

        return sb.toString();
    }
}
