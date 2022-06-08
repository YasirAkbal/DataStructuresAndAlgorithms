/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures.HashTable;

import java.lang.reflect.Array;
import java.util.LinkedList;

/**
 *
 * @author yasir
 */
public class HashTableChaining<T> implements IHashTable<T> {
    private int capacity;
    private double loadFactor;
    private LinkedList<T>[] hashTable;
    
    public HashTableChaining(int capacity, double loadFactor) {
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        this.hashTable = (LinkedList<T>[])Array.newInstance(LinkedList.class, capacity);
    }
    
    @Override
    public int hashFunc(T item) {
        if(item.getClass() == int.class || item.getClass() == Integer.class) {
            int intVal = (int)item;
            return intVal%capacity;
        } else { //diğer tipler için de oluşturulabilir.
            return item.hashCode();
        }
    }
    
    @Override
    public boolean search(T item) {
        int hash = this.hashFunc(item);
        
        if(hashTable[hash] == null) { return false; }
        
        LinkedList<T> list = hashTable[hash];
        //return list.contains(item);
        for(T elem : list) { 
            if(elem == item) { return true; }
        }

        return false;
    }

    @Override
    public void insert(T item) {
        int hash = this.hashFunc(item);
        
        if(hashTable[hash] == null) {
            hashTable[hash] = new LinkedList<T>();
        }
        
        hashTable[hash].add(item);
    }

    @Override
    public void delete(T item) {
        int hash = this.hashFunc(item);
        
        if(hashTable[hash] != null) {
            /*if(!this.search(item)) {
                throw item not found falan
            }*/
            hashTable[hash].remove(item);
        }
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public double getLoadFactor() {
        return this.loadFactor;
    }
}
