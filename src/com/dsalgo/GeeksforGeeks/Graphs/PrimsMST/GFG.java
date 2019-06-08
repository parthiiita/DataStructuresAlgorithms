package com.dsalgo.GeeksforGeeks.Graphs.PrimsMST;

/**
 * Created by parth.sharma on 08/06/19.
 */
import java.util.*;
public class GFG {

    public static void main(String args[]) {
        GFG gfg = new GFG();
        int t, e, n, i;
        Scanner scanner = new Scanner(System.in);
        t = scanner.nextInt();
        while(t-- > 0) {
            n = scanner.nextInt();
            e = scanner.nextInt();
            int[][] graph = new int[e][3];
            int max = 0, sum = 0;
            for ( i = 0; i < e; i++ ) {
                graph[i][0] = scanner.nextInt();
                graph[i][1] = scanner.nextInt();
                graph[i][2] = scanner.nextInt();
//                graph[ctr+ 1][0] =  graph[ctr][1];
//                graph[ctr + 1][1] = graph[ctr][0];
//                graph[ctr + 1][2] =  graph[ctr][2];

                if (graph[i][0] > max) max = graph[i][0];
                if (graph[i][1] > max) max = graph[i][1];

            }

            int included[] = new int[max];
            List<List<Integer>> minHeap = new ArrayList<List<Integer>>();
            List<Integer> edge = new ArrayList<Integer>();
            edge.add(1);
            edge.add(0);
            minHeap.add(edge);
            while(minHeap.size() > 0) {
                List<Integer> poppedEdge = new ArrayList<Integer>();
                poppedEdge = minHeap.get(0);
                if (included[poppedEdge.get(0) - 1] == 1) {
                    List<Integer> temp = minHeap.get(0);
                    minHeap.set(0, minHeap.get(minHeap.size() - 1));
                    minHeap.set(minHeap.size() - 1, temp);
                    minHeap.remove(0);
                    gfg.heapifyMin(minHeap, minHeap.size(), 0);

                    continue;
                }
                included[poppedEdge.get(0) - 1] = 1;
                sum += poppedEdge.get(1);
                for ( i = 0; i < e; i++ ) {
                    if (graph[i][0]  == poppedEdge.get(0) && included[graph[i][1] - 1] != 1) {
                        List<Integer> tobeadded = new ArrayList<Integer>();
                        tobeadded.add(graph[i][1]);
                        tobeadded.add(graph[i][2]);
                        minHeap.add(tobeadded);
                        List<Integer> temp = minHeap.get(0);
                        minHeap.set(0, minHeap.get(minHeap.size() - 1));
                        minHeap.set(minHeap.size() - 1, temp);
                        gfg.heapifyMin(minHeap, minHeap.size(), 0);
                        //System.out.println("heapify " );


                    } else
                    if (graph[i][1]  == poppedEdge.get(0) && included[graph[i][0] - 1] != 1) {
                        List<Integer> tobeadded = new ArrayList<Integer>();
                        tobeadded.add(graph[i][0]);
                        tobeadded.add(graph[i][2]);
                        minHeap.add(tobeadded);
                        List<Integer> temp = minHeap.get(0);
                        minHeap.set(0, minHeap.get(minHeap.size() - 1));
                        minHeap.set(minHeap.size() - 1, temp);
                        gfg.heapifyMin(minHeap, minHeap.size(), 0);
                        //System.out.println("heapify " );

                    }

                }
                //System.out.println("setting " + poppedEdge.get(0) + " --> " + poppedEdge.get(1) );
                minHeap.set(0, minHeap.get(minHeap.size() - 1));
                minHeap.remove(minHeap.size() - 1);
                gfg.heapifyMin(minHeap, minHeap.size(), 0);

            }
            System.out.println(sum);


        }

    }

    void heapifyMin(List<List<Integer>> arr, int limit, int ind) {
        int l = 2*ind +1, r = 2*ind +2, swapIndex = ind;
        if (l < limit && arr.get(l).get(1) < arr.get(swapIndex).get(1)) swapIndex = l;
        if (r < limit && arr.get(r).get(1) < arr.get(swapIndex).get(1)) swapIndex = r;
        if (swapIndex != ind) {
            List<Integer> temp= arr.get(ind);
            arr.set(ind, arr.get(swapIndex));
            arr.set(swapIndex, temp);
            heapifyMin(arr, limit, swapIndex);
        }

    }

}


