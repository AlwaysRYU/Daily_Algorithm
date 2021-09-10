package M09;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;


public class D05_집합3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        HashSet<Integer> set = new LinkedHashSet<>();

        int M = Integer.parseInt(br.readLine());
        for(int m = 0;m<M; m++){
            st = new StringTokenizer(br.readLine()," ");
            String command = st.nextToken();
            int x = 0;

            switch (command){
                case "add" :
                    x = Integer.parseInt(st.nextToken());
                    set.add(x);
                    break;

                case "remove":
                    x = Integer.parseInt(st.nextToken());
                    set.remove(x);
                    break;

                case "check" :
                    x = Integer.parseInt(st.nextToken());
                    if(set.contains(x)) bw.write("1\n");
                    else bw.write("0\n");
                    break;

                case "toggle" :
                    x = Integer.parseInt(st.nextToken());
                    if(set.contains(x)) set.remove(x);
                    else set.add(x);
                    break;

                case "all" :
                    for(int num = 1; num<=20; num++){
                        set.add(num);
                    }
                    break;
                case "empty" :
                    set.clear();
                    break;
            }

        }

        bw.flush();
    }
}