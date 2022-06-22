/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures.HashMap.Abstract;

/**
 *
 * @author ahmetyasir
 */
public interface IOpenHashing {
    public double getSettedLoadFactor();
    public boolean resizeHashTable(int newCap);
    public double calculateCurrLoadFactor();
}
