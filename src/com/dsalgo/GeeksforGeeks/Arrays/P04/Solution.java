package com.dsalgo.GeeksforGeeks.Arrays.P04;

import java.util.Scanner;

/**
 * Created by parth.sharma on 01/11/19.
 */
//public class GFG {
//
//
//
////    A[] = {1, 4, 45, 6, 0, 19}
////    x  =  51
////    Output: 3
////    Minimum length subarray is {4, 45, 6}
//    public static  void main(String args[]) {
//        Scanner scanner =  new Scanner(System.in);
//        int n,x, i, t;
//        t = scanner.nextInt();
//        while (t-- > 0) {
//            n = scanner.nextInt();
//            x = scanner.nextInt();
//            int[] arr = new int[n];
//            for (i = 0; i < n; i++) {
//                arr[i] = scanner.nextInt();
//            }
//            int j = 0, sum = 0, len = 9999999;
//            for (i = 0; i < n; i++) {
//                sum += arr[j];
//                if (sum <= x) {
//                    i--;
//                    j++;
//                    if (j == n) break;
//
//                } else {
//                    if (j - i + 1 < len) {
//                        len = j - i + 1;
//
//                    }
//                    sum -= arr[i];
//                    sum -= arr[j];
//                }
//
//            }
//            System.out.println(len);
//        }
//
//    }
//}
