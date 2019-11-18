package com.dsalgo.GeeksforGeeks.Recursion.Nesting;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Nesting {

    public static  void main(String args[]) {

        Nesting nest = new Nesting();

        Scanner scanner = new Scanner(System.in);

        int t, n, i, level, nodes,  mn, ctr, ml;
        t = scanner.nextInt();

        while (t-- > 0) {
            n = scanner.nextInt();

            String s;
            s = scanner.next();
            level = 0;
            nodes = 0;
             mn = 0;
            ctr = 0;
            ml = 0;
            Map< Integer,Integer> myMap = new HashMap< Integer,Integer>();
            for (i = 0 ; i < n; i++) {
                if (s.charAt(i) == '[') {
                    level++;
                    nodes++;
                    if (ml < level) ml = level;
                    myMap.put(level,(myMap.get(level) == null ? 0 : myMap.get(level)) + 1);
                    if ( mn <= myMap.get(level))  {

                        if ( mn == myMap.get(level)) {
                            ctr++;
                        } else {
                            ctr = 1;
                            mn = myMap.get(level);
                        }

                    }

                } else {

                    level--;

                }
            }
            System.out.println(nodes + " " + ml + " " + mn + " " + ctr);


            // System.out.println();

        }


    }
}
