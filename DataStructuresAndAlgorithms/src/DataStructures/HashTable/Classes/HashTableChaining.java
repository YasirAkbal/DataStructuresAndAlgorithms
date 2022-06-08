/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures.HashTable.Classes;

import DataStructures.HashTable.Interfaces.IHashTable;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author yasir
 */
public class HashTableChaining<K,V> implements IHashTable<K,V> {
    private int capacity;
    private int size;
    private LinkedList<HashNode<K,V>>[] hashTable;
    
    public HashTableChaining(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.hashTable = (LinkedList<HashNode<K,V>>[])Array.newInstance(LinkedList.class, capacity);
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
        int hash = this.hashFunc(key);
        
        if(this.hashTable[hash] == null) { return false; }
        
        final LinkedList<HashNode<K,V>> list = hashTable[hash];
        
        for(HashNode<K,V> elem : list) { 
            if(elem.key == key) { return true; }
        }

        return false;
    }

    @Override
    public boolean insert(K key, V val) {      
        int hash = this.hashFunc(key);
        
        if(this.hashTable[hash] == null) { //hash'e karsilik gelen gozde daha once linkledlist olusturulmamis
            this.hashTable[hash] = new LinkedList<HashNode<K,V>>();
        }
        
        if(!this.containsValueInLL(val, hash)) { //eklenecek item daha once eklenmemis
            this.hashTable[hash].add(new HashNode<K,V>(key,val,hash));
            this.size++;
            return true;
        } else { //eklenecek item daha once eklenmis
            return false;
        }
    }

    @Override
    public V delete(K key) {
        int hash = this.hashFunc(key);
        
        if(this.hashTable[hash] != null) {
            LinkedList<HashNode<K,V>> list = hashTable[hash];

            Iterator<HashNode<K,V>> itr = hashTable[hash].iterator();
            int i=0;
            while(itr.hasNext()) {
                if(itr.next().key == key) {
                    HashNode<K,V> deleted = list.remove(i);
                    size--;
                    return deleted.value;
                }
                i++;
            }
        }
        
        return null;
    }
    
    
    private boolean containsValueInLL(V val, int hash) {
        final LinkedList<HashNode<K,V>> list = this.hashTable[hash];
        
        for(HashNode<K,V> node : list) {
            if(node.value == val)
                return true;
        }
        
        return false;
    }

    @Override
    public V getItem(K key) {
        int hash = this.hashFunc(key);
        
        if(this.hashTable[hash] == null) { return null; }
        
        final LinkedList<HashNode<K,V>> list = this.hashTable[hash];
        for(HashNode<K,V> node : list) {
            if(node.key == key) {
                return node.value;
            }
        }
        
        return null;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public int getSize() {
        return this.size;
    }
}