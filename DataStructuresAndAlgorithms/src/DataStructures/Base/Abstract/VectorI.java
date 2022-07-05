/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures.Base.Abstract;

import DataStructures.Base.Exceptions.NotValidIndexOrPosition;

/**
 *
 * @author yasir
 */
public interface VectorI<T> {
    boolean contains(T value);
    int size();
    boolean isEmpty();
    void insert(int index, T value) throws NotValidIndexOrPosition;
    T get(int index) throws NotValidIndexOrPosition;
    T remove(int index) throws NotValidIndexOrPosition;
}