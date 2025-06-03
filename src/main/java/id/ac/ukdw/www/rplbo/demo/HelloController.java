package id.ac.ukdw.www.rplbo.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.*;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class HelloController{

    static final int INF = Integer.MAX_VALUE;
    static final int N = 12; // jumlah gedung
    static final int M = 16; // jumlah building

    static String getGedung(int gedung) {
        switch (gedung) {
            case 1: return "Agape";
            case 2: return "Biblos";
            case 3: return "Chara";
            case 4: return "Didaktos";
            case 5: return "Euodia";
            case 6: return "Filia";
            case 7: return "Gnosis";
            case 8: return "Hagios";
            case 9: return "Iama";
            case 10: return "Koinonia";
            case 11: return "Logos";
            case 12: return "Makarios";
            default: return "Unknown";
        }
    }

    public static String solve(int start, int goal, List<int[]> edges) {
        List<List<int[]>> neighbours = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            neighbours.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int a = edge[0], b = edge[1], w = edge[2];
            neighbours.get(a).add(new int[]{w, b});
            neighbours.get(b).add(new int[]{w, a});
        }

        long[] minDistance = new long[N + 1];
        Arrays.fill(minDistance, INF);
        minDistance[start] = 0;

        int[] path = new int[N + 1];
        Arrays.fill(path, -1);
        path[start] = 0;

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.add(new long[]{0, start});

        while (!pq.isEmpty()) {
            long[] current = pq.poll();

            long distance = current[0];
            int now = (int) current[1];

            if (distance != minDistance[now]) continue;

            if (now == goal) {
                List<Integer> ans = new ArrayList<>();
                while (now != 0) {
                    ans.add(now);
                    now = path[now];
                }

                Collections.reverse(ans);
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < ans.size() - 1; i++) {
                    result.append(getGedung(ans.get(i))).append(" -> ");
                }
                result.append(getGedung(ans.get(ans.size() - 1)));
                return result.toString();
            }

            for (int[] edge : neighbours.get(now)) {
                int edgeWeight = edge[0];
                int target = edge[1];
                long totalDistance = distance + edgeWeight;

                if (minDistance[target] > totalDistance) {
                    pq.add(new long[]{totalDistance, target});
                    minDistance[target] = totalDistance;
                    path[target] = now;
                }
            }
        }

        return "Tidak ada jalur ditemukan";
    }


//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        solve(sc);
//    }
}
