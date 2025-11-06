import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int V, E, K;
    static List<List<Edge>> list = new ArrayList<>();
    static int[] w;
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());   // 정점 수 <= 20_000 (번호:1~V)
        E = Integer.parseInt(st.nextToken());   // 간선 수 <= 300_000
        K = Integer.parseInt(br.readLine());    // 시작 정점 번호

        w = new int[V+1];   // 다익스트라 결과 저장 배열
        Arrays.fill(w, Integer.MAX_VALUE);

        for (int i = 0; i <= V; i++){   // 인접 리스트
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++){    // 입력
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.get(u).add(new Edge(v, w));
        }

        dijkstra();

        for (int i = 1; i <= V; i++){
            sb.append(w[i] == Integer.MAX_VALUE ? "INF" : w[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void dijkstra(){
        PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.w - e2.w);
        boolean[] visit = new boolean[V+1];
        pq.offer(new Edge(K, 0));
        w[K] = 0;

        while (!pq.isEmpty()){
            Edge cur = pq.poll();
            if (visit[cur.v]) continue; // 이미 그래프에 포함 된 간선이라면 패스 (가중치가 양수이기 때문에 다른 곳을 더 거치면 가중치가 늘어난다)

            visit[cur.v] = true;

            for (Edge ne : list.get(cur.v)){
                if (ne.w + w[cur.v] < w[ne.v]){
                    w[ne.v] = ne.w + w[cur.v];  //'출발지-현재 정점'까지 가중치 + '현재 정점-다음 정점'까지 가중치

                    pq.offer(new Edge(ne.v, w[ne.v]));
                }
                w[cur.v] = cur.w;
            }
        }
    }

    static class Edge{
        int v, w;
        public Edge(int v, int w){
            this.v = v;
            this.w = w;
        }
    }
}