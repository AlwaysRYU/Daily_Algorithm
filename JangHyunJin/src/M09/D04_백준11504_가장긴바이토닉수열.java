package dynnamic;

import java.io.*;
import java.util.*;

// BOJ 11054 가장 긴 바이토닉 부분 수열 <동적 계획법 1>
public class 백준11504_가장긴바이토닉수열 {
    public static int N;
    public static int[] arr;
    public static int[] ret;
    public static int[] dp1;
    public static int[] dp2;

    public static void func1(){
        ret = new int[N];
        int size = 0;
        ret[size++] = arr[0];
        dp1[0] = 1;
        for(int i=1; i<N; ++i){
            if(ret[size-1] < arr[i]){
                ret[size++] = arr[i];
            }
            else{
                int idx = Arrays.binarySearch(ret, 0, size, arr[i]);
                if(idx < 0)
                    idx = -idx -1;
                ret[idx] = arr[i];
            }
            dp1[i] = size;
        }
    }

    public static void func2(){
        ret = new int[N];
        int size = 0;
        ret[size++] = arr[N-1];
        dp2[N-1] = 1;
        for(int i=N-2; i>=0; --i){
            if(ret[size-1] < arr[i]){
                ret[size++] = arr[i];
            }
            else{
                int idx = Arrays.binarySearch(ret, 0, size, arr[i]);
                if(idx < 0)
                    idx = -idx -1;
                ret[idx] = arr[i];
            }
            dp2[i] = size;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp1 = new int[N];
        dp2 = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; ++i)
            arr[i] = Integer.parseInt(st.nextToken());

        func1();
        func2();
        int max = Integer.MIN_VALUE;
        for(int i=0; i<N; ++i){
            max = max > dp1[i] + dp2[i] ? max : dp1[i] + dp2[i] ;
        }
        System.out.println(max-1);
    }
}