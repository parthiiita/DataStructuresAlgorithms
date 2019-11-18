package com.dsalgo.GeeksforGeeks.LinkedList;

/**
 * Created by parth.sharma on 26/10/19.
 */

import java.io.*;
import java.util.Scanner;

public class LinkedList {
    public static void main (String args[]){

        Node prev = null, start = null;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-- > 0) {
            Node node = new Node();
            node.x = scanner.nextInt();
            node.next = null;
            if (prev == null) start = node;
            if(prev != null) prev.next = node;
             prev = node;

        }
        Node it = start, prevs = null;
        while (it.next != null) {
            Node temp = it.next;
            Node next = it.next.next;
            it.next = prevs;
            temp.next = it;
            prevs = temp;
            it = next;

            //System.out.println(it.x);
//            int temp = it.x;
//            it.x = it.next.x;
//            it.next.x = temp;
//            it = it.next.next;

        }
        it.next = prevs;
        start = it;
        while (start != null) {
            System.out.println(start.x);
            start = start.next;


        }
        System.out.println("welocome to ll" );
    }
}
