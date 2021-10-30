import java.io.*;
import java.util.*;

public class 백준_이분그래프{

    static List<List<Integer>> graph;
    static int[] group; // 0: 그룹x, 1: 그룹1, -1: 그룹2

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            group = new int[v + 1];

            for (int j = 0; j <= v; j++) {
                graph.add(new ArrayList<>());
            }

            for (int j = 0; j < e; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            String answer = "YES";
            // 연결 그래프가 아닐 수도 있음
            for (int j = 1; j <= v; j++) {
                // 모두 방문할 때까지 탐색
                if (group[j] == 0) {
                    if (!isBinaryGraph(j)) answer = "NO";
                }
            }
            System.out.println(answer);
        }
    }

    // BFS
    public static boolean isBinaryGraph(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        group[start] = 1;

        while (!queue.isEmpty()) {
            int id = queue.poll();
            // 현재 정점에서 갈 수 있는 정점들 중 현재 정점이 속한 그룹과 같은 그룹에 속해있는 정점이 있으면 이분 그래프가 아님
            for (int next : graph.get(id)) {
                if (group[next] == group[id]) {
                    return false;
                } else if (group[next] == 0) {
                    // 아직 방문하지 않았으면 현재 정점의 그룹과 반대의 그룹에 할당
                    group[next] = group[id] * -1;
                    queue.offer(next);
                }
            }
        }
        return true;
    }
}