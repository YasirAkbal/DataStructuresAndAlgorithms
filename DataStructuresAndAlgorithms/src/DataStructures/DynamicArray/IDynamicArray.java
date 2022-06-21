/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures.DynamicArray;

/**
 *
 * @author yasir
 */
public interface IDynamicArray<T> {
    boolean contains(T value);
    int size();
    boolean isEmpty();
    void append(T value);
    void insert(int index, T value);
    T get(int index);
    T remove(int index);
}
