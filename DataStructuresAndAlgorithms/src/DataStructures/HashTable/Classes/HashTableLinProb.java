/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures.HashTable.Classes;

import DataStructures.HashTable.Abstract.IOpenHashing;
import DataStructures.HashTable.Abstract.IHashTable;
import java.lang.reflect.Array;
import java.util.Iterator;

/**
 *
 * @author ahmetyasir
 */
public class HashTableLinProb<K,V> implements IHashTable<K,V>, IOpenHashing, Iterable<HashNode<K,V>> {
    private int capacity;
    private int size;
    private double loadFactor;
    private HashNode<K,V>[] hashTable;
    private boolean[] dummyTable; //ilgili indisteki eleman silinmişse -> true, silinmemişse -> false
    
    public HashTableLinProb(int capacity, double loadFactor) {
        this.capacity = capacity;
        this.size = 0;
        this.loadFactor = loadFactor;
        this.hashTable = (HashNode<K,V>[])Array.newInstance(HashNode.class, capacity);
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
        int index = this.getIndexFromKey(key);
        
        return index != -1;
    }

    @Override
    public boolean insert(K key, V value) {
        if(this.calculateCurrLoadFactor() >= this.loadFactor) {
            this.resizeHashTable(this.capacity*2);
        }
        
        int hash = this.hashFunc(key);
        
        int i = 0;
        while(this.hashTable[hash] != null && !this.dummyTable[hash] && i < this.capacity) { //null(hiç eleman eklenmemiş) veya silinmiş bir göz arıyoruz.
            if(this.hashTable[hash].key == key && !this.dummyTable[hash]) { //tekrar eden elemanlara yer yok!
                return false;
            }
            
            hash = (hash + (++i))%this.capacity;
        }
        
        if(this.hashTable[hash] == null || this.dummyTable[hash]) {
            this.hashTable[hash] = new HashNode<K,V>(key,value,hash);
            this.dummyTable[hash] = false;
            this.size++;
            return true;
        }
        
        return false;
    }

    @Override
    public V getItem(K key) {
        int index = getIndexFromKey(key);
        
        if(index == -1) { return null; }
        
        return this.hashTable[index].value;
    }

    @Override
    public V delete(K key) {
        int index = this.getIndexFromKey(key);
        
        if(index == -1) { return null; }
        
        this.dummyTable[index] = true;
        this.size--;
        return this.hashTable[index].value;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public double getSettedLoadFactor() {
        return this.loadFactor;
    }

    public int getIndexFromKey(K key) {
        int hash = this.hashFunc(key);
        
        int i = 0;
        while(this.hashTable[hash] != null && i < this.capacity) { 
            if(this.hashTable[hash].key == key && !this.dummyTable[hash]) { 
                return hash;
            }
            hash = (hash + (++i))%this.capacity;
        }
        
        return -1;
    }

    //Rehashing
    @Override
    public boolean resizeHashTable(int newCap) {
        if(newCap < size) { return false; }
        
        HashNode<K,V>[] tempHashTable = this.hashTable;
        boolean[] tempDummyTable = this.dummyTable;
        this.hashTable = (HashNode<K,V>[])Array.newInstance(HashNode.class, newCap);
        this.dummyTable = new boolean[newCap];
        this.capacity = newCap;
        this.size = 0;       
        
        for(HashNode<K,V> node : tempHashTable) {
            if(node != null) {
                if(!tempDummyTable[node.hash]) {
                    this.insert(node.key, node.value);
                }
            }
        }
        
        return true;
    }

    @Override
    public Iterator<HashNode<K,V>> iterator() 
    {      
        // OverRiding Default List Iterator 
        Iterator<HashNode<K,V>> it = new Iterator<HashNode<K,V>>() 
        {
            private int count = 0;
            private int index = 0;
            
            @Override
            public boolean hasNext() 
            {        
                return count < size;
            }
            @Override
            public HashNode<K,V> next() 
            {             
                int i = index;
                while(i < capacity && (hashTable[i] == null || dummyTable[i]))
                    i++;
                count++;
                index = i+1;
                return hashTable[i];
            }
            @Override
            public void remove() 
            {                     
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }

    @Override
    public double calculateCurrLoadFactor() {
        return (double)this.size/this.capacity;
    }
}
