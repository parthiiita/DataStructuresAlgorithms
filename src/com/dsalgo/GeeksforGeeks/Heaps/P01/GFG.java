package com.dsalgo.GeeksforGeeks.Heaps.P01;

/**
 * Created by parth.sharma on 04/06/19.
 */
import java.util.*;
import java.io.*;

public class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        GFG gfg = new GFG();
        List<Integer> leftMaxHeap = new ArrayList<Integer>();
        List<Integer> rightMinHeap = new ArrayList<Integer>();
        List<Integer> ans = new ArrayList<Integer>();


        int median = 0;

        int i, n;
        Scanner scanner = new Scanner(System.in);
        n = Integer.parseInt(br.readLine());
        for (i = 0 ; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == median) {
                if (leftMaxHeap.size() < rightMinHeap.size())  gfg.insertNHeapify(leftMaxHeap, num, "Max");
                else gfg.insertNHeapify(rightMinHeap, num, "Min");
            } else
            if (num > median) {
                gfg.insertNHeapify(rightMinHeap, num, "Min");

            } else {
                gfg.insertNHeapify(leftMaxHeap, num, "Max");
            }
            int disbalance = Math.abs(rightMinHeap.size() - leftMaxHeap.size());
            if ( disbalance > 1) gfg.balance(leftMaxHeap, rightMinHeap);

            if (rightMinHeap.size() ==  leftMaxHeap.size()) {
                median = (int)Math.floor((rightMinHeap.get(0) + leftMaxHeap.get(0))/2);
            } else if (rightMinHeap.size() > leftMaxHeap.size() ) {
                median = rightMinHeap.get(0);
            } else median = leftMaxHeap.get(0);
             System.out.println(median);
            // ans.add(median);

        }
//
//        for ( i = 0 ; i < n; i++) {
//            System.out.println(ans.get(i));
//        }
    }

    void insertNHeapify(List<Integer> arr, int num, String type) {

        arr.add(num);
//        int temp = arr.get(0);
//        arr.set(0, num);
//        arr.set(arr.size() - 1,  temp);
        if ( type == "Max")  {
            int i = (arr.size() -2)/2;
            while (i >= 0) {
                //System.out.println(i);
                heapifyMax(arr, arr.size(), i);
                if (i == (i-1)/2) break;

                i = (i-1)/2;
            }
        }
        else {
            int i = (arr.size() -2)/2;
            while (i >= 0) {
                //System.out.println(i);

                heapifyMin(arr, arr.size(), i);
                if (i == (i-1)/2) break;

                i = (i-1)/2;

            }

        }



    }
    void balance(List<Integer> leftMaxHeap, List<Integer> rightMinHeap  ) {
        GFG gfg = new GFG();
        int extra = 0;
        if (leftMaxHeap.size() > rightMinHeap.size()) {
            extra = leftMaxHeap.get(0);
//            leftMaxHeap = gfg.beHeadHeap(leftMaxHeap, "Max");
//            rightMinHeap = gfg.insertNHeapify(rightMinHeap, extra, "Min");
            gfg.beHeadHeap(leftMaxHeap, "Max");
            gfg.insertNHeapify(rightMinHeap, extra, "Min");


        }
        else  {
            extra = rightMinHeap.get(0);
            beHeadHeap(rightMinHeap, "Min");
            gfg.insertNHeapify(leftMaxHeap, extra, "Max");

        }

    }

    void beHeadHeap(List<Integer> arr, String type) {
        GFG gfg = new GFG();
        arr.set(0, arr.get(arr.size() - 1));
        arr.remove(arr.size() - 1);
        if (type == "Min")
        gfg.heapifyMin(arr,arr.size(), 0 );
        else gfg.heapifyMax(arr, arr.size(), 0 );


    }
    void heapifyMax(List<Integer> arr, int limit, int ind) {
        int l = 2*ind +1, r = 2*ind +2, swapIndex = ind;
        if (l < limit && arr.get(l) > arr.get(swapIndex)) swapIndex = l;
        if (r < limit && arr.get(r) > arr.get(swapIndex)) swapIndex = r;
        if (swapIndex != ind) {
            int temp = arr.get(ind);
            arr.set(ind, arr.get(swapIndex));
            arr.set(swapIndex, temp);
            heapifyMax(arr, limit, swapIndex);
        }

    }

    void heapifyMin(List<Integer> arr, int limit, int ind) {
        int l = 2*ind +1, r = 2*ind +2, swapIndex = ind;
        if (l < limit && arr.get(l) < arr.get(swapIndex)) swapIndex = l;
        if (r < limit && arr.get(r) < arr.get(swapIndex)) swapIndex = r;
        if (swapIndex != ind) {
            int temp = arr.get(ind);
            arr.set(ind, arr.get(swapIndex));
            arr.set(swapIndex, temp);
            heapifyMin(arr, limit, swapIndex);
        }

    }



}

