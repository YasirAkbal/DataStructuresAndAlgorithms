/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.LinkedList;

import java.util.HashSet;

/**
 *
 * @author yasir
 */
public class DetectLoopInLL {
    /*
    Time Complexity -> O(n^2)
    Auxiliary Space -> O(1)
    Her node için sonraki elemanına(node.next) eşit olan bir node var mı diye kontrol et.(head'den o node'a kadar tara)
    */
    public static boolean naiveSolution(SinglyNode head) {
        SinglyNode node = head;
        while(node != null) {
            SinglyNode itr = head;
            SinglyNode next = node.next;
            while(itr != node) {
                if(itr == next)
                    return true;
                itr = itr.next;
            }
            node = node.next;
        }
        
        return false;
    }
    
    
    class ModifiedNode {
        int data;
        boolean visited;
        ModifiedNode next;
        
        public ModifiedNode(int data) {
            this.data = data;
        }
    }
    /*
    Time Complexity -> O(n)
    Auxiliary Space -> BigTheta(n) (Node'a n tane boolean değişkeni eklendiği için)
    Node'un değiştirilmesi gerekiyor. Çok da genel bir çözüm değil.
    */
    public static boolean solution1(ModifiedNode head) {
        ModifiedNode itr = head;
        
        while(itr != null) {
            if(itr.visited)
                return true;
            itr.visited = true;
            itr = itr.next;
        }
        
        return false;
    }
    
    
    /*
    Time Complexity -> O(n)
    Auxiliary Space -> O(1) 
    Listeyi değiştiriyor. Bu da çok genel bir çözüm değil.
    */
    public static boolean solution2(SinglyNode head) {
        SinglyNode itr = head;
        SinglyNode lookupNode = new SinglyNode(0); //Datanın bir anlamı yok. Adresleri karşılaştıracağız.
        
        while(itr != null) {
            if(itr.next == lookupNode)
                return true;
            
            SinglyNode temp = itr.next;
            itr.next = lookupNode;
            itr = temp;
        }
        
        return false;
    }
    
    /*
    Time Complexity -> O(n)
    Auxiliary Space -> O(n) 
    Liste bağlantılarını veya Node yapısını değiştirmiyor. Genel bir çözüm.
    */
    public static boolean solution3(SinglyNode head){
        HashSet<SinglyNode> set = new HashSet<>();
        
        SinglyNode itr = head;
        while(itr != null) {
            if(set.contains(itr))
                return true;
            set.add(itr);
            itr = itr.next;
        }
        
        return false;
    }
    
    
    /*
    Time Complexity -> O(n)
    Auxiliary Space -> O(1)
    Floyd Cycle Detection Algoritması.
    Liste bağlantılarını veya Node yapısını değiştirmiyor. Genel ve en iyi çözüm.
    */
    public static boolean bestSolution(SinglyNode head){
        SinglyNode slow = head;
        SinglyNode fast = head;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;
        }
        
        return false;
    }
}
