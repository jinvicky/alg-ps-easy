package com.jinvicky.sort.topological;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class TopologicalSort {
    static int n; // 노드의 갯수
    static int m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        List<List<Integer>> list = new ArrayList<List<Integer>>();
        int[] indegree = new int[n+1];

        for(int i = 0; i < n+1; i++) {
            list.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            list.get(v1).add(v2);
            indegree[v2]++;
        }

        topologicalSort(indegree, list);
    }

    static void topologicalSort(int[] indegree, List<List<Integer>> list) {
        Queue<Integer> q = new LinkedList<Integer>();
        Queue<Integer> result = new LinkedList<Integer>();

        for(int i = 1; i <= n; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }

        while(!q.isEmpty()) {
            int node = q.poll();
            result.offer(node);

            for(Integer linked : list.get(node)) {
                indegree[linked]--;

                if(indegree[linked] == 0) {
                    q.offer(linked);
                }
            }
        }

        while(!result.isEmpty()) {
            System.out.println(result.poll() + " ");
        }
    }

}
