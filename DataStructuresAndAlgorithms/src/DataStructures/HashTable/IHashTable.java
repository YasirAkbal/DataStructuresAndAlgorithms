/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures.HashTable;

/**
 *
 * @author yasir
 */
public interface IHashTable<T> {
    int hashFunc(T item);
    boolean search(T item);
    void insert(T item);
    void delete(T item);
    int getCapacity();
    double getLoadFactor();
}
