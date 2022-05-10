/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Mathematical;

/**
 *
 * @author yasir
 */
public final class GCD {
    
    private GCD() { }
    
    /*
    a >= b iken -> a = b*q + r ifadesi yazılabilir. b < r olacaktır.
    a ve b'yi tam bölen en küçük sayı x olsun. x'in a'yı tam bölebilmesi için r'yi tam bölmesi yeterlidir.
    Çünkü böyle bir sayının a = b*q + r ifadesinde b*q ifadesini tam böleceğine b'yi tam böldüğünü farzettiğimiz için eminiz.
    Bu durumda a ve b'yi tam bölen sayıyı aramak yerine b ve r'yi tam bölen sayıyı arayabiliriz.
    Bir sonraki adımda a ifadesi b, b ifadesi de a%b (yani r) olacaktır. 
    r'nin b'den küçük oldugunu bildiğimiz için de a >= b şartı her zaman sağlanacaktır. 
    */
    
    static int euclid(int a, int b) {
        if(a >= b) {
            return _euclid(a,b);
        }
        
        return _euclid(b,a);
    }
    
    private static int _euclid(int a, int b) {
        if(b == 0) {
            return a;
        }
        
        return _euclid(b, a%b);
    }
}
