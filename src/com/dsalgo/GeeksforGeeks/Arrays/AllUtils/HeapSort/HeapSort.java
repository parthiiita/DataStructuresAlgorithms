package com.dsalgo.GeeksforGeeks.Arrays.AllUtils.HeapSort;

import java.util.*;
public class HeapSort {
    public int arr[];
    public static void main(String args[]) {
        HeapSort instance = new HeapSort();
        int n,i;

        Scanner scanner = new Scanner(System.in);
            n = scanner.nextInt();
            int[] arr = new int[n];
            for (i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
        instance.buildHeap(arr, n);
        for (i = 0; i < n; i++) {
            int temp = arr[0];
            arr[0] = arr[n-i-1];
            arr[n-i-1] = temp;
            instance.heapify(arr, n-i-1,0);
        }
         instance.printArr(arr);


    }
    void buildHeap(int arr[], int n) {
        HeapSort instance = new HeapSort();

        for (int i = n/2 -1; i >=0; i--) {
            instance.heapify(arr, n, i);
            //instance.printArr(arr);
        }

    }
    void heapify(int arr[], int limit, int ind) {
        int l = 2*ind +1, r = 2*ind +2, swapIndex = ind;
        if (l < limit && arr[l] > arr[swapIndex]) swapIndex = l;
        if (r < limit && arr[r] > arr[swapIndex]) swapIndex = r;
        if (swapIndex != ind) {
            int temp = arr[ind];
            arr[ind] = arr[swapIndex];
            arr[swapIndex] = temp;
            heapify(arr, limit, swapIndex);
        }

    }

    void printArr(int[] arr) {
        System.out.println("printing array");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");

    }
}
