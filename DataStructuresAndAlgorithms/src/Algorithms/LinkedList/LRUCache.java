/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.LinkedList;

import java.util.HashMap;

/**
 *
 * @author yasir
 * https://practice.geeksforgeeks.org/problems/lru-cache/1
 */

class Node {
    int key;
    int value;
    Node prev;
    Node next;
    
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class DoublyLL {
    private Node head;
    private Node tail;
    private int size = 0;
    
    int size() {
        return size;
    }
    
    Node addFirst(int key, int value) {
        Node newNode = new Node(key, value);
        
        if(head == null) {
            head = tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        
        size++;
        return newNode;
    }
    
    int deleteLast() {
        int key;
        if(tail.prev == null) {
            key = tail.key;
            tail = head = null;
        } else {
            key = tail.key;
            tail.prev.next = null;
            tail = tail.prev;
        }
        
        size--;
        return key;
    }
    
    void moveToHead(Node node) {
        if(node == head) {
            return;
        } else if(node == tail) {
            node.prev.next = null;
            tail = tail.prev;
            node.next = head;
            head.prev = node;
            head = node;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = head;
            head.prev = node;
            head = node;
        }
        
        head.prev = null;
    }
}

class LRUCache
{
    private int capacity;
    private HashMap<Integer,Node> map;
    private DoublyLL list;
    
    //Constructor for initializing the cache capacity with the given value.
    LRUCache(int cap)
    {
        this.capacity = cap;
        this.map = new HashMap<>();
        this.list = new DoublyLL();
    }

    //Function to return value corresponding to the key.
    public int get(int key)
    {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            list.moveToHead(node);
            return map.get(key).value;
        }
        else
            return -1;
    }

    //Function for storing key-value pair.
    public void set(int key, int value)
    {
        if(map.containsKey(key)) { //hit
            Node node = map.get(key);
            node.value = value;
            list.moveToHead(node);
        } else { //mis
            if(list.size() == capacity) {
                int deleted = list.deleteLast();
                map.remove(deleted);
            }
            Node added = list.addFirst(key,value);
            map.put(key,added);
        }
    }
}