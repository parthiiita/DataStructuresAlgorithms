package com.dsalgo.GeeksforGeeks.Arrays.P02;

/**
 * Created by parth.sharma on 01/06/19.
 */
import java.util.*;
public class GFG {
    public static void main(String args[]) {
        int i, n, t, k;
        Scanner scanner = new Scanner(System.in);
        t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            int[] arr = new int[n];
            Map<Integer, Integer> myMap= new HashMap<Integer, Integer>();

            for (i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
                if (myMap.containsKey(arr[i]))
                myMap.put(arr[i], myMap.get(arr[i]) + 1 );
                else myMap.put(arr[i],  1 );

            }
            k = scanner.nextInt();

            int ctr = 0;
            for (Map.Entry<Integer, Integer> entry: myMap.entrySet())
                if (entry.getValue() !=0 && myMap.containsKey(entry.getKey() + k) && myMap.get(entry.getKey() + k) != 0) {
                    int freq = Math.min(entry.getValue(), myMap.get(entry.getKey() + k));
                    if (entry.getValue() ==  myMap.get(entry.getKey() + k)) {
                        if (k == 0 && freq == 1) freq = 0;
                        else if (k != 0 && freq == 1) {
                            freq = 1;

                        } else if ( freq > 0)
                            freq = 1;
                    }
                    ctr += freq;
                    myMap.put(entry.getKey(), entry.getValue() - 1);

                }
            System.out.println(ctr);


        }



    }
}
