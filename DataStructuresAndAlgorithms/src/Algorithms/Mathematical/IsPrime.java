/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Mathematical;

/**
 *
 * @author yasir
 */
public final class IsPrime {
    private IsPrime() { }
    
    /*
    Bir sayının tam bölenleri a<= b olmak üzere (a,b) ikilileri halinde bulunur. Örn;
    30 -> (1,30) - (2,15) - (3,10) - (5,6)
    25 -> (1,25) - (5,5)
    Herbir ikilideki ilk sayıyı işlem yaptığımız sayıya böldüğümüzde o ikilideki diğer sayıyı elde ederiz.
    Buna göre bir sayının asallığı test edilirken kullanılan döngüde (i=bas;i<n;i++ gibi) üst limit olarak n'nin karekökünü seçebiliriz.
    Yani bu ikililer içinde sadece a değerleri üzerinden kontrol yapabiliriz. 
    a <= b ve a*b = n olduğunuz biliyorduk. Bu durumda a*a < n olur ve ikililerdeki b değerlerini kontrol etmeye gerek olmadığı için sadece...
    a'ları kontrol etmemiz yeterli olacaktır. Bu durumda i <= sqtr(n) döngü şartını kullanabiliriz.
    n her zaman tam kare olamayabilir. Bu yüzden sqrt(n) aşağı yuvarlanmalıdır veya i*i <= n yazılır.
    */
    
    public static boolean efficientSolution1(int n) {
        if(n < 2) { return false; }
        if(n == 2 || n == 3) { return true; }
        if(n % 2 == 0 || n % 3 == 0) { return false; }
        
        /*
        Base caselerde 2 ve 3'ü tam bölmeyen sayılar bu satıra kadar gelecek. Döngüde tekrar 2 ve 3'ün katları olan i değerleri için...
        asallık kontrolü yapmaya gerek yok. Örn n = 3535 için:
        (5) 6 [7] 8 9 10 (11) 12 [13] 14 15 ....
        Döngü her döndüğünde i ve i+2 değerleri n'i tam bölüyor mu diye bakmak yeterli olacaktır.
        Bu numara big O'yu değiştirmese de normalden 3 kat daha az karşılaştırma yapmamızı sağlıyor.
        */
        for(int i=5;i*i<=n;i+=6) {
            if(n % i == 0 || n % (i+2) == 0) {
                return false;
            }
        }
        
        return true;
    }
}
