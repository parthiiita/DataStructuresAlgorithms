package com.dsalgo.GeeksforGeeks.Arrays.P01;

/**
 * Created by parth.sharma on 01/06/19.
 */
import java.util.*;
public class GFG {
    public static void main(String args[]) {
        int t, n, max = 0, a =0, b = 1,maxFib = 1;
        Scanner scanner = new Scanner(System.in);
        t = scanner.nextInt();
        // System.out.println(t);
        Map< Integer,Boolean> fibMap = new HashMap< Integer,Boolean>();
        fibMap.put(0, true);
        while (t-- > 0) {
            n = scanner.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
                if ( arr[i] > max) max = arr[i];
            }

            while(maxFib < max) {
                maxFib = a + b;
                a = b;
                b = maxFib;
                fibMap.put(maxFib, true);
            }
            // ArrayList<Integer> ans = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                if (fibMap.containsKey(arr[i])) System.out.print(arr[i] + " ");

                    //ans.add(arr[i]);
            }
            System.out.println();

        }

    }
}
