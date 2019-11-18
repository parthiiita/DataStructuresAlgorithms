package com.dsalgo.GeeksforGeeks.Arrays.P06;

import java.util.ArrayList;

/**
 * Created by parth.sharma on 28/06/19.
 */
public class INC {
    public static  void main (String args[]) {
       // Scanner s = new Sc
        int[] input = {0,0,0,3,7,6,4,0,5,5,5};
        INC i = new INC();
        ArrayList<Integer> answer = i.incrementV(input);
        int ctr = 0;
        for (int j = 0; j < answer.size(); j++) {

            System.out.print(answer.get(j) + " ");
        }

    }

    ArrayList<Integer> incrementV(int[] arr) {
        int i = 0, dig = 0, rem = 0;
        int[] ans = new int[arr.length];
        for ( i = arr.length - 1; i >=0; i--) {
            if (i == arr.length - 1){
                dig = arr[i] + 1 ;
                if (dig == 10)  {
                    dig = 0;
                    rem = 1;
                    ans[i] = dig;
                }
                else{
                    ans[i] = dig;
                }
            }
            else {
                ans[i] = arr[i]+ rem;
                if (ans[i] == 10)  {
                    dig = 0;
                    rem = 1;
                    ans[i] = dig;
                }

            }
        }
        int ctr = 0;
        if (rem != 0) {
            int[] newArr = new int[arr.length + 1];
            newArr[0] = rem;
            for (i = 0; i < ans.length; i++) {
                newArr[i+1] = ans[i];
            }
            return removed(newArr);
        }
        else return removed(ans);

    }
    ArrayList<Integer> removed(int[] arr) {
        int ctr = 0;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            if ( ctr ==0 && arr[i] == 0) continue;
            else {
                ans.add(arr[i]);
                ctr++;

            }

        }
        return ans;
    }
}
