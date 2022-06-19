/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures.LinkedLists.Nodes;

/**
 *
 * @author yasir
 */
public class NodeDoubCircLL<T> {
    public T data;
    public NodeDoubCircLL<T> prev;
    public NodeDoubCircLL<T> next;
    
    public NodeDoubCircLL(T data) {
        this.data = data;
    }
}
