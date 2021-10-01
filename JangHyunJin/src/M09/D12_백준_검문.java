package mathAlgo;
 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
 
public class 백준_검문 {
    static int N;
    static int arr[];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        
        int val = arr[1]-arr[0];
        for(int i=2; i<N; i++) {
            val = getGCD(val, arr[i] - arr[i-1]);
        }
        StringBuffer sb = new StringBuffer();
        for(int i=2; i<=val; i++) {
            if(val%i == 0) {
                sb.append(i+" ");
            }
        }
        System.out.println(sb.toString());
        
    }
    public static int getGCD(int a, int b) {
        if(a%b == 0) {
            return b;
        }
        
        return getGCD(b, a%b);
    }
}