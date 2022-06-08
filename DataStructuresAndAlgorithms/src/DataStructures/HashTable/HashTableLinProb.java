/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures.HashTable;

import java.lang.reflect.Array;
import java.util.LinkedList;

/**
 *
 * @author ahmetyasir
 */
public class HashTableLinProb<K,V> implements IHashTable<K,V>, IOpenHashing {
    private int capacity;
    private int size;
    double loadFactor;
    private HashNodeChain<K,V>[] hashTable;
    private boolean[] dummyTable;
    
    public HashTableLinProb(int capacity, int size, int loadFactor) {
        this.capacity = capacity;
        this.size = size;
        this.loadFactor = loadFactor;
        this.hashTable = (HashNodeChain<K,V>[])Array.newInstance(HashNodeChain.class, capacity);
        this.dummyTable = new boolean[capacity];
    }
    
    @Override
    public int hashFunc(K key) {
        if(key.getClass() == int.class || key.getClass() == Integer.class) {
            int intVal = (int)key;
            return intVal%capacity; //capacity'i asal sayı seçmekte fayda var
        } else { //diğer tipler için de oluşturulabilir.
            return key.hashCode();
        }
    }

    @Override
    public boolean containsKey(K key) {
        return true;
    }

    @Override
    public boolean insert(K key, V value) {
        int hash = this.hashFunc(key);
        
        int i = 0;
        while(this.hashTable[hash] != null && i < this.capacity) {
            if(this.hashTable[hash] == value) { //tekrar eden elemanlara yer yok!
                return false;
            }
            
            hash = (hash + (++i))%this.capacity;
        }
        
        if(this.hashTable[hash] == null) {
            this.hashTable[hash] = new HashNodeChain<K,V>(key,value);
            this.dummyTable[hash] = false;
            this.size++;
            return true;
        }
        
        return false;
    }

    @Override
    public V getItem(K key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public V delete(K key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getCapacity() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getSize() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public double getLoadFactor() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
