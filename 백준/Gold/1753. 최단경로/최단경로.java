import java.io.*;
import java.util.*;

// Dijkstra
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int V, E, K;
    static List<List<Edge>> adjList = new ArrayList<>();
    static int[] weight;    // 다익스트라 자료구조
    static boolean[] visit;

    static PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.w - e2.w);
    static final int INF = Integer.MAX_VALUE;



    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        weight = new int[V+1];
        visit = new boolean[V+1];
        for (int i = 0; i <= V; i++){
            adjList.add(new ArrayList<>());
        }
        Arrays.fill(weight, INF);

        for (int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adjList.get(u).add(new Edge(v, w));
        }

        dijkstra();

        for (int i = 1; i <= V; i++){
            System.out.println(weight[i] == INF ? "INF" : weight[i]);
        }
    }

    static void dijkstra(){
        weight[K] = 0;
        pq.offer(new Edge(K, 0));

        while (!pq.isEmpty()){
            Edge e = pq.poll();     // 최소비용 간선
            if (visit[e.v]) continue;   // 이미 그래프에 포함되어있는 간선이라면 패스! -> 간선의 가중치가 양수이기 때문에 어떻게 해도 경로 길어짐

            visit[e.v] = true;

            for (Edge ne : adjList.get(e.v)){   // e에서 갈수 있는 정점들 ne
                // ne.v가 갈수있는 정점이 아직 방문하지 않았으면서 동시에 가중치를 줄여주는 정점일 경우
                if (ne.w + weight[e.v] < weight[ne.v]){
                    weight[ne.v] = ne.w + weight[e.v];

                    pq.offer(new Edge(ne.v, weight[ne.v]));
                }
                    weight[e.v] = e.w;
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