package com.dsalgo.GeeksforGeeks.Arrays.AllUtils.BinarySearchTree;

import java.util.*;
public class BST {
    //public String path = "";
    public static void main(String args[]) {
        Node head = null;
        BST bst = new BST();
        //System.out.println(head.x);
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        // head.x = scanner.nextInt();
        //System.out.println(head.x);
        for ( int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            head = bst.insert(head, x);
            // System.out.println("printing bst");
            // bst.printBst(head);
            // System.out.println();
        }
        bst.printBst(head);


    }
    Node balanceAVL(Node head) {
        String sub = head.tr;
        System.out.println("Balance required at " + head.x);

        if (sub.equals("RR")) {
            System.out.println("RR");
            Node ch = head;
            ch.maxHeight = ch.maxHeight - 2;
            ch.df = ch.df - 2;
            Node cr = head.r;
            cr.df = cr.df - 1;
            Node crr = head.r.r;

            Node newHead = cr;
            newHead.l = ch;
            ch.r = null;
//            head.r = null;
//            newHead.l = head;
            head = newHead;
//            head.df = head.df - 2;
//            head.r.df = 0;
//            head.l.df = 0;
//            head.maxHeight =  1;
//            head.r.maxHeight = 0;
//
//            head.l.maxHeight = 0;

        }
        if (sub.equals("LL")) {
            System.out.println("LL");
            Node ch = head;
            ch.maxHeight = ch.maxHeight -2;
            ch.df = ch.df - 2;
            Node cl = head.l;
            cl.df = cl.df - 1;
            //cl.maxHeight--;
            Node cll = head.l.l;

            //cll.maxHeight--;

            Node newHead = cl;
            newHead.r = ch;
            ch.l = null;
//            head.l = null;
//            newHead.r = head;
            head = newHead;
//            head.df = 0;
//            head.r.df = 0;
//            head.l.df = 0;
//            head.maxHeight =  1;
//            head.r.maxHeight = 0;
//
//            head.l.maxHeight = 0;
        }
        if (sub.equals("RL")) {
            System.out.println("RL");
            Node ch = head;
            ch.maxHeight = ch.maxHeight - 2;
            ch.df = ch.df - 2;
            Node cr = head.r;
            cr.df = cr.df - 1;
            Node crl = head.r.l;
            crl.maxHeight = crl.maxHeight+1;
            Node newHead = crl;
            Node oldRight = newHead.r;
            Node oldLeft = newHead.l;

            newHead.r = cr;
            cr.l = oldRight;
            newHead.l = ch;
            ch.r = oldLeft;
            head = newHead;
//            head.df = 0;
//            head.r.df = 0;
//            head.l.df = 0;
//            head.maxHeight =  1;
//            head.r.maxHeight = 0;
//
//            head.l.maxHeight = 0;
        }
        if (sub.equals("LR")) {
            System.out.println("LR");
            Node ch = head;
            ch.maxHeight = ch.maxHeight - 2;
            ch.df = ch.df - 2;
            Node cl = head.l;
            cl.df = cl.df - 1;
            Node clr = head.l.r;
            clr.maxHeight = clr.maxHeight + 1;
            Node newHead = clr;
            Node oldRight = newHead.r;
            Node oldLeft = newHead.l;
            newHead.l = cl;


            cl.r = oldLeft;
            newHead.r = ch;
            ch.l = oldRight;
            head = newHead;
//            head.df = 0;
//            head.r.df = 0;
//            head.l.df = 0;
//            head.maxHeight =  1;
//            head.r.maxHeight = 0;
//
//            head.l.maxHeight = 0;
        }
        return head;
    }
    Node insert(Node head,int x) {
        BST bst = new BST();

        if (head == null) {
            head = new Node();
            head.x = x;
            head.df = 0;
            head.maxHeight = 0;
            head.tr = "";
            return head;

        }
        else if (x > head.x)  {
            Boolean tr = head.r == null;
            head.tr = "R";
            head.r = insert( head.r, x);
            if (head.l == null)  {
                head.maxHeight = head.r.maxHeight  +1;
                head.df = Math.abs(head.r.df) + 1;
            } else {
                head.maxHeight = Math.max(head.r.maxHeight, head.l.maxHeight)  +1;
                head.df = Math.abs(head.r.maxHeight - head.l.maxHeight);
            }
//            if(tr) head.tr = head.tr + 'R';
//            else if(head.r != null && head.r.tr.length() > 0) head.tr = head.tr + head.r.tr.substring(head.r.tr.length()-1);
            if(head.r != null && head.r.tr.length() > 0) head.tr = head.tr + head.r.tr.charAt(0);

        }
        else {
//            Boolean tr = head.l == null;
            head.tr = "L";
            head.l = insert(head.l, x);
            if (head.r == null)  {
                head.maxHeight = head.l.maxHeight  +1;

                head.df = Math.abs(head.l.df) + 1;
            } else {
                head.maxHeight = Math.max(head.r.maxHeight, head.l.maxHeight)  +1;
                head.df = Math.abs(head.r.maxHeight - head.l.maxHeight);
            }
//            if(tr) head.tr = head.tr + 'L';
//            else if(head.l != null && head.l.tr.length() > 0) head.tr = head.tr + head.l.tr.substring(head.l.tr.length()-1);
            if(head.l != null && head.l.tr.length() > 0) head.tr = head.tr +  head.l.tr.charAt(0);


        }
        if (head.df == 2) head = bst.balanceAVL(head);
        return head;
    }
    void printBst (Node head) {
        if (head == null) return;
        if (head.l != null) printBst(head.l);
        System.out.print(head.x + " ");

        if (head.r != null) printBst(head.r);
    }


}

