package com.dsalgo.GeeksforGeeks.Arrays.RGB;

import java.util.Scanner;


public class RGB {
    public  static  void main(String args[]) {


        int t, n, i, j, ctr, temp, ans;
        int[] rgb = new int [3];
        rgb[0] = 'r';
        rgb[1] = 'g';
        rgb[2] = 'b';
        Scanner scanner = new Scanner(System.in);

        t = scanner.nextInt();

        while (t-- > 0) {
            n = scanner.nextInt();
            String s;
            s = scanner.next();
            ans = 0;
            for ( i = 0; i < n; i++) {
                j = i;
                ctr = 0;
                while ( j < n) {
                    if ( i == j) {
                        if ( s.charAt(i) == 'r') {
                             temp = (j+1);
                            if (temp < n &&  s.charAt(temp) == 'g') {
                                temp = (j+2);
                                if ( temp < n && s.charAt(temp) == 'b') {
                                    ctr++;
                                    j = j +3;
                                } else break;
                            } else break;
                        }
                        else if ( s.charAt(i) == 'g') {
                            temp = (j+1) ;
                            if (temp < n && s.charAt(temp) == 'b') {
                                temp = (j+2);
                                if ( temp < n && s.charAt(temp) == 'r') {
                                    ctr++;
                                    j = j +3;
                                }  else break;
                            }  else break;
                        }
                        else if ( s.charAt(i) == 'b') {
                            temp = (j+1) ;
                            if ( temp < n && s.charAt(temp) == 'r') {
                                temp = (j+2);
                                if ( temp < n &&  s.charAt(temp) == 'g') {
                                    ctr++;
                                    j = j +3;
                                }  else break;
                            }  else break;
                        } else break;
                    }
                    else {
                        if ( j < n && s.charAt(j -1) == 'r' && s.charAt(j) == 'g' ) {
                            ctr++;
                            j++;
                        }
                        else  if ( j < n && s.charAt(j -1) == 'g' && s.charAt(j) == 'b' ) {
                            ctr++;
                            j++;
                        }
                        else  if ( j < n && s.charAt(j -1) == 'b' && s.charAt(j) == 'r' ) {
                            ctr++;
                            j++;
                        }
                        else break;
                    }
                }
                ans += ctr;
            }
            System.out.println(ans);
        }
    }
}
