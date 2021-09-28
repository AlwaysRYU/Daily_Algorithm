package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준17472다리만들기3 {
    static class Edge implements Comparable<Edge> {
        int y, x, v;

        Edge(int y, int x, int v) {
            this.y = y;
            this.x = x;
            this.v = v;
        }

        Edge(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public int compareTo(Edge o) {
            return this.v - o.v;
        }
    }

    static Queue<Edge> q;
    static ArrayList<Edge> bridge;
    static int[] parent;
//    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[] dy = {0,0,1,-1};
    static int[] dx = {1,-1,0,0};
    static int[][] map;
    static boolean[][] visited;
    static int N, M, label;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        label = 0;
        map = new int[N][M];
        visited = new boolean[N][M];

        q = new LinkedList<>();
        bridge = new ArrayList<>();

        for (int r = 0; r < N; ++r) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; ++c) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        // 라벨링
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    label++;
                    visited[i][j] = true;
                    map[i][j] = label;
                    q.offer(new Edge(i, j, 0));
                    bfs();
                }
            }
        }
        // 2. 다리 놓을 수 있는 모든 경우를 bridge에 넣는다.
        for (int r = 0; r < N; ++r) {
            for (int c = 0; c < M; ++c) {
                if (map[r][c] > 0) {
                    q.offer(new Edge(r, c, 0));
                    calDistance(map[r][c]);
                }
            }
        }

        // 3. Kruskal 알고리즘을 이용하여 모든 섬을 연결하는 최소값을 찾는다.
        parent = new int[label + 1];
        for (int i = 1; i <= label; ++i) parent[i] = i;
        kruskal();
    }

    private static void kruskal() {
        Collections.sort(bridge);

        int cnt = 0;
        int dis = 0;
        for (Edge edge : bridge) {
            if (find(edge.y) != find(edge.x)) {
                union(edge.y, edge.x);
                dis += edge.v;
                cnt++;
            }
        }

        if (cnt != label - 1) System.out.println(-1);
        else System.out.println(dis);
    }

    private static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        parent[rootB] = rootA;
    }

    private static void calDistance(int start) {
        while (!q.isEmpty()) {
            Edge cur = q.poll();

            for (int i = 0; i < 4; ++i) {
                int ry = cur.y + dy[i];
                int rx = cur.x + dx[i];

                // 직진 시작
                int distance = 0;
                boolean flag = false;
                while (true) {
                    if (ry >= N || ry < 0 || rx >= M || rx < 0 || map[ry][rx] == start) break;
                    if (map[ry][rx] != 0) {
                        flag = true;
                        break;
                    }
                    distance++;
                    // 같은 방향으로 나아가기
                    ry += dy[i];
                    rx += dx[i];
                }
                // 다른 섬에 닿은 경우에만 거리갱신
                if (flag) {
                    // 다리 길이 2 미만일 경우
                    if (distance < 2) continue;
                    bridge.add(new Edge(start, map[ry][rx], distance));
                }
            }
        }
        q.clear();
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            Edge cur = q.poll();

            for (int i = 0; i < 4; ++i) {
                int ry = cur.y + dy[i];
                int rx = cur.x + dx[i];
                if (ry >= N || ry < 0 || rx >= M || rx < 0 || visited[ry][rx]) continue;
                if (map[ry][rx] == 1) {
                    visited[ry][rx] = true;
                    map[ry][rx] = label;
                    q.offer(new Edge(ry, rx, 0));
                }
            }
        }
        q.clear();
    }

    private static void print() {
        for (int r = 0; r < N; ++r) {
            for (int c = 0; c < M; ++c) {
                System.out.print(map[r][c] + " ");
            }
            System.out.println();
        }
    }

}