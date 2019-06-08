package com.dsalgo.GeeksforGeeks.Arrays.P04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by parth.sharma on 05/06/19.
 */
public class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()), n, i, x;
        while (t-- > 0) {
            String s = br.readLine();
            String[] xn = s.split(" ", 0);

            n = Integer.parseInt(xn[0]);
            x = Integer.parseInt(xn[1]);

            String sarr = br.readLine();
            String[] arr = sarr.split(" ", 0);
            int sum = Integer.parseInt(arr[0]), l = 0, r = 0, minLength = n;
            if (sum > x) System.out.println("1");
            else {
                for (i = 1; i < n; i++) {
                    sum += Integer.parseInt(arr[i]);
                    // System.out.println("adding i = " + i + " value = " + Integer.parseInt(arr[i]) + " l =" + l + " newSum = " + sum);

                    if (sum >= x) {
                        if ((i - l + 1) < minLength) {
                            //System.out.println("i = " + i + "l = " + l + "sum = " + sum);
                            minLength = i - l + 1;
                        }
                        sum = sum - Integer.parseInt(arr[l]);
                        sum = sum - Integer.parseInt(arr[i]);

                        l++;
                        i--;
                        //System.out.println(" setting i = " + i + "l = " + l + "sum = " + sum);


                    }
                }
                System.out.println(minLength);
            }

        }

    }
}
