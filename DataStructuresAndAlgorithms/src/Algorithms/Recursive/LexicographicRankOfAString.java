/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Recursive;

/**
 *
 * @author yasir
 */
public class LexicographicRankOfAString {
    private static final int mod = 1000000007;
    private static final int CHAR_SIZE = 256;
    
    static long solution(String S) {
        int n = S.length();
        long[] facts = new long[n+1];
        int[] counts = new int[CHAR_SIZE];
        long result = 1;
        
        facts[0] = 1;
        for(int i=1;i<=n;i++) { 
            facts[i] = (facts[i-1]*i)%mod;
        }
        
        for(int i=0;i<n;i++) { //herbir karakterin kaç defa tekrar ettiği hesaplanıyor.
            counts[S.charAt(i)]++;
            if(counts[S.charAt(i)] > 1) //elemanların tekrar etmemesi gerektiği farzedildi.
                return 0;
        }
        
        //Kümulatif toplam. Bu döngü sonucu her i. eleman kendisinin daha küçük ve eşit elemanların sayısını verecek.
        //Elemanların tekrar etmediğini varsayarsak i-1. indisteki değer i. eleman küçük eleman sayısını verecektir.
        for(int i=1;i<CHAR_SIZE;i++) 
            counts[i] = (counts[i] + counts[i-1])%mod;
        
        for(int i=0;i<n-1;i++) {
            //i. elemandan küçük elemanların sayısını bul. stringte i.elemandan sonra x tane eleman varsa bu elemanlar x! farklı biçimde sıranabilir. bu 2 değeri çarp.
            long mult = (counts[S.charAt(i)-1]*facts[n-i-1])%mod;
            result = (result + mult)%mod;
            
            /*i. eleman için gerekli işlemleri yaptık. Bir sonraki iterasyonda sağdaki bir sonraki eleman için işlem yapacağız...
            Sonraki iterasyonda i. eleman'dan küçük eleman sayısını bulmak istediğimizde önceki aşamada işlenen elemanın hesaba katılmamasını istiyoruz(taramaya soldan başladığımız...
            ve her defasında i.elemanın sağındaki i. elemandan küçük sayıyı bulmak istediğimiz için. Bu yüzden i. elemana ait tüm bilgileri count arrayden siliyoruz.*/
            for(int j=S.charAt(i);j<CHAR_SIZE;j++) 
                counts[j]--;
        }
        
        return result;
    }
}
