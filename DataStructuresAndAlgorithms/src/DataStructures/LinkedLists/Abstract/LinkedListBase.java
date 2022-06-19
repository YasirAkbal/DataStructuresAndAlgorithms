/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures.LinkedLists.Abstract;


/**
 *
 * @author yasir
 */
public abstract class LinkedListBase<T,N> {
    protected N head;
    protected int size;
    
    protected abstract N getNodeFromValue(T value);
    protected abstract N getNodeFromPosition(int position);
}
