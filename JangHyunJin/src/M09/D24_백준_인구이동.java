import java.io.*;
import java.util.*;

public class 인구이동{
    static int N, L, R;
    static int[][] map = new int[50][50];
    static int[][] visited = new int[50][50];
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nlr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = nlr[0];
        L = nlr[1];
        R = nlr[2];

        for (int i = 0; i < N; i++) {
            int[] people = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < N; j++) {
                map[i][j] = people[j];
            }
        }

        System.out.println(solve());
    }

    static int solve() {
        int ret = 0;
        boolean flag;
        do {
            flag = false;
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++)
                    visited[i][j] = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j] == 0) {
                        cnt = 0;
                        int total = find(i, j, -1);
                        if (cnt > 1) {
                            flag = true;
                            move(i, j, total / cnt);
                        } else {
                            visited[i][j] = 2;
                        }
                    }
                }
            }
            if (flag) ret++;
        } while (flag);

        return ret;
    }

    static int find(int r, int c, int value) {
        if (r < 0 || r > N - 1 || c < 0 || c > N - 1) return 0;
        if (visited[r][c] != 0) return 0;

        if (value != -1) {
            int diff = Math.abs(value - map[r][c]);
            if (diff < L || diff > R) return 0;
        }

        visited[r][c] = 1;
        cnt++;
        int sum = map[r][c];
        sum += find(r - 1, c, map[r][c]);
        sum += find(r + 1, c, map[r][c]);
        sum += find(r, c - 1, map[r][c]);
        sum += find(r, c + 1, map[r][c]);

        return sum;
    }

    static void move(int r, int c, int value) {
        if (r < 0 || r > N - 1 || c < 0 || c > N - 1) return;
        if (visited[r][c] != 1) return;

        visited[r][c] = 2;
        map[r][c] = value;
        move(r - 1, c, value);
        move(r + 1, c, value);
        move(r, c - 1, value);
        move(r, c + 1, value);
    }
}