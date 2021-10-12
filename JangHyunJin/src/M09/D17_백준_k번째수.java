package searching;

import java.util.*;
import java.io.*;

public class 백준_k번째수{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        
        bw.write(String.valueOf(solution(n,k)));
        bw.flush();
    }
    
    
    public static int solution(int n, int k){
        int result = 0;
        int left = 1;
        int right = k;
        
        while(left <= right){
            int mid = (left + right) / 2;
            int cnt = 0;
            for(int i=1; i<=n; i++){
                cnt += Math.min(mid/i, n);
            }
            if(k <= cnt){
                result = mid;
                right = mid - 1;
            } else{
                left = mid + 1;
            }
        }
        return result;
    }
}