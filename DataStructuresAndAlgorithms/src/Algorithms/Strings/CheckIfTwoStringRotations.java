/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Strings;

/**
 *
 * @author yasir
 */
public class CheckIfTwoStringRotations {
    /*
    Time Complexity -> O(n^2)
    Auxiliary Space -> O(1)
    */
    public static boolean solution(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if(n != m) return false;
        
        int j;
        for(int i=0;i<n;i++) {
            j=0;
            while(j < n && s1.charAt((i+j)%n) == s2.charAt(j)) {
                j++;
            }
            if(j == n)
                return true;
        }
        
        return false;
    }
    
    
    /*
    Time Complexity -> BigTheta(n)
    Auxiliary Space -> O(1)
    Orjinal string'e kendisi eklenerek birleştirilirse yeni oluşacak stringte orjinal string'in rotate edilmiş tüm halleri bulunmak zorundadır.
    Dolayısıyla s2 bu oluşturulan stringte varsa s2, s1'in rotate edilmiş hali denilebilir.
    */
    public static boolean efficientSolution(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if(n != m) return false;
        
        return (s1+s1).contains(s2);
    }
}
