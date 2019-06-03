package com.dsalgo.GeeksforGeeks.Arrays.P03;

/**
 * Created by parth.sharma on 03/06/19.
 */
import java.util.*;
public class GFG {
    public static void main(String args[]) {
        GFG gfg = new GFG();
        int t, n, i, l, r;
        Scanner scanner = new Scanner(System.in);
        t = scanner.nextInt();
        while(t-- > 0) {
            n = scanner.nextInt();
            int[] arr = new int[n];
            for (i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            l = r = gfg.maxIndex(arr, 0,n-1);
            int water = 0;
            while (l !=0 || r != n-1) {
                // System.out.println("l = " + l +  "r =" + r);
                if (l != 0 ) {
                        int nextL = gfg.maxIndex(arr, 0, l - 1);
                        if (nextL != -1 ) {
                            water += arr[nextL] * (l - nextL -1);
                            // System.out.println("l = " + l + "nextL =" + nextL);
                            // System.out.println("grid = " +  arr[nextL] * (l - nextL -1));
                            water -= gfg.delta(arr, nextL + 1, l - 1 );
                            // System.out.println("delta = " + gfg.delta(arr, nextL + 1, l - 1 ));
                            l = nextL;
                        } else l = 0;
                    }
                if (r != n-1) {
                    int nextR = gfg.maxIndex(arr,r + 1,n-1);
                    if (nextR != -1) {
                        water += arr[nextR] * (nextR - r -1);
                        water -= gfg.delta(arr, r + 1, nextR - 1);
                        r = nextR;
                    } else r = n-1;
                }
            }
            System.out.println(water);
        }

    }
    int delta (int[] arr, int l, int r) {
        int del = 0;
        for (int i = l; i <= r; i++) {
            del += arr[i];
        }
        return del;
    }
    int maxIndex(int[] arr, int l, int r) {
        int i, max = -1, ans = -1;
        if (l == r) return ans;
        for ( i = l; i <= r; i++) {
            if (arr[i] >= max) {
                max = arr[i];
                ans = i;
            }
        }
        return ans;
    }
}
