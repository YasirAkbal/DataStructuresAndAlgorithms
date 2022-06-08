/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures.HashTable.Classes;

/**
 *
 * @author ahmetyasir
 */
public class HashNode<K,V> {
    public final K key;
    public final V value;
    public final int hash;
    
    public HashNode(K key, V value, int hash) {
        this.key = key;
        this.value = value;
        this.hash = hash;
    }
}
