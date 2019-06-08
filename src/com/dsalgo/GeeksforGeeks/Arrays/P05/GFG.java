package com.dsalgo.GeeksforGeeks.Arrays.P05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by parth.sharma on 05/06/19.
 */
public class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()), n, i, k;
        while (t-- > 0) {
            String s ;
            s= br.readLine();


            n = Integer.parseInt(s);

            String sarr = br.readLine();
            String[] arr = sarr.split(" ", 0);
            int sum = 0, maxSum = -99999999, l = 0;
            s= br.readLine();

            k = Integer.parseInt(s);
            for ( i = 0; i < n; i++) {
                // System.out.println("i = " + i + "l = " + l);
                sum += Integer.parseInt(arr[i]);


                if ((i -l + 1) >= k) {
                    if ( sum > maxSum) {
                        maxSum = sum;
                    } else {
                        sum -= Integer.parseInt(arr[i]);
                        sum -= Integer.parseInt(arr[l]);

                        l++;
                        i--;
                        if ((i -l + 1) >= k && sum > maxSum) maxSum = sum;

                    }

                }





            }
            System.out.println(maxSum);



        }

    }
}
