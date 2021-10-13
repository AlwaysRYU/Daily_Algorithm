package Recursive;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 백준_미로찾기 {
    static int N, M, result;
    static char[][] map;
    static boolean[][] visited;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        map = new char[N][M];
        for (int i = 0; i < N; ++i) {
            map[i] = br.readLine().toCharArray();
        }

        result = Integer.MAX_VALUE;
        visited = new boolean[N][M];
        bfs();
        System.out.println(result);
    }

    private static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 1));
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.r == N - 1 && node.c == M - 1) {
                result = Math.min(result, node.dis);
            }

            for (int d = 0; d < 4; ++d) {
                int nR = node.r + dir[d][0];
                int nC = node.c + dir[d][1];
                if (nR < 0 || nR >= N || nC < 0 || nC >= M) continue;

                if (!visited[nR][nC] && map[nR][nC] == '1') {
                    visited[nR][nC] = true;
                    q.offer(new Node(nR, nC, node.dis + 1));
                }
            }
        }
    }
    static class Node {
        int r, c, dis;

        public Node(int r, int c, int dis) {
            this.r = r;
            this.c = c;
            this.dis = dis;
        }
    }
}