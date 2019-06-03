package com.dsalgo.GeeksforGeeks.Arrays.P03;

/**
 * Created by parth.sharma on 03/06/19.
 */
import java.util.*;
public class GFG2 {
    public static void main(String args[]) {
        GFG2 gfg = new GFG2();
        int t, n, i, l, r;
        Scanner scanner = new Scanner(System.in);
        t = scanner.nextInt();
        while(t-- > 0) {
            n = scanner.nextInt();
            int[] arr = new int[n];
            int[] maxL = new int[n];
            int maxLi = -1, max = 0;

            for (i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();




            }
            maxL[0] = arr[0];
            for (i = 1; i < n; i++) {


                maxL[i] = Math.max(arr[i],maxL[i-1]);


            }
            // maxL[0] = -1;
            int[] maxR = new int[n];

            int maxRi = -1; max = 0;
            maxR[n-1] = arr[n-1];
            for (i = n-2; i >= 0; i--) {

                maxR[i] = Math.max(arr[i], maxR[i+1]);


            }
            // maxR[n-1] = -1;
            // l = r = maxR[0];
            int water = 0;
            for (i = 0; i < n; i++) {
                water += Math.min(maxL[i], maxR[i]) - arr[i];
            }
//
            System.out.println(water);
        }

    }

}
