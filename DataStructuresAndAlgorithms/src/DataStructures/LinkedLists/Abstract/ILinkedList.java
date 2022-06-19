/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures.LinkedLists.Abstract;

/**
 *
 * @author yasir
 */
public interface ILinkedList<T> {
    int search(T value);
    boolean contains(T value);
    int size();
    boolean isEmpty();
    void addFirst(T value);
    void addLast(T value);
    boolean insert(int position, T value);
    T getFirst();
    T getLast();
    T get(int position);
    T removeLast();
    T removeFirst();
    T remove(int position);
    void printAll();
}
