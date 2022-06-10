/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.HashTable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 *
 * @author yasir
 */
public class SortArraybyIncreasingFrequency {
    public int[] frequencySort(int[] arr) {
        int n = arr.length;
        HashMap<Integer,Node> map = new HashMap<>();
        Node node;
        
        for(int x: arr) {
            if(map.containsKey(x)) {
                node = map.get(x);
                node.count++;
                map.put(x,node);
            } else {
                node = new Node(x);
                map.put(x,node);
            }
        }
        
        ArrayList<Node> sortedNodes = new ArrayList<>(map.values());
        Collections.sort(sortedNodes);
        
        int i=0;
        for(Node hashNode: sortedNodes) {
            while(hashNode.count > 0) {
                arr[i++] = hashNode.num;
                hashNode.count--;
            }
        }
        
        return arr; 
    }
}

class Node implements Comparable<Node> {
    public int num;
    public int count;
        
    public Node(int num) {
        this.num = num;
        this.count = 1;
    }
        
    public int compareTo(Node n) {
        if(this.count > n.count)
            return 1;
        else if(this.count < n.count)
               return -1;
        else {
            return n.num-this.num;
        }
    }
}