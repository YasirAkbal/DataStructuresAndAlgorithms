/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures.HashTable.Abstract;

/**
 *
 * @author yasir
 */
public interface IHashTable<K,V> {
    int hashFunc(K key);
    boolean containsKey(K key);
    boolean insert(K key, V value);
    V getItem(K key);
    V delete(K key);
    int getCapacity();
    int getSize();
}
