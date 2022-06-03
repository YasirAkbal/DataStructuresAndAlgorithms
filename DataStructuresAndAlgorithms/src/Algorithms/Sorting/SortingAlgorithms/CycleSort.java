/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithms.Sorting.SortingAlgorithms;

import Utils.IntArrayUtils;

/**
 *
 * @author yasir
 */
public final class CycleSort {
    private CycleSort() {}
    
    private static IntArrayUtils util = new IntArrayUtils();
    
    /*
    Time Complexity -> BigTheta(n) -> (Tüm Durumlarda)
    Auxiliary Space -> O(1)
    Non Stable
    Minimum diziye yazma operasyonu olan sıralama algoritması
    */
    public static void cycleSort(int[] arr) {
        int n = arr.length;
        
        for(int start=0;start<n-1;start++) { //start cycle indeks görevi görüyor
            int element = arr[start]; //cycle başındaki elemanı bir değişkende tut
            int pos = start; //cycle indeksini bir değişkende tut
            
            for(int i=start+1;i<n;i++) { //starttan önceki dizi sıralı olduğu için arr[start]'ın dizideki kaç elemandan büyük olduğu start+1'den başlanarak sayılıyor. Dizinin 0..<start alt dizisi zaten sıralı. Dolayısıyla arr[start]'ın start kadar sayıdan büyük olduğu zaten biliniyor.
                if(arr[i] < element){ //dizinin sırasız tarafındaki sayıdan da büyükse pos'u arttır.
                    pos++;
                }
            }
            
            if(pos == start) //Zaten olması gereken yerindeyse sonraki cycle'a geç
                continue;
            
            while(arr[pos] == element) //Duplicateleri es geç(stable olma özelliği burada bozuluyor)
                pos++;
            
            //Ekstra kontrol. Belleğe yazma işlemi maliyetli ise oldukca faydalı.
            if(pos != start) {
                int temp = arr[pos];
                arr[pos] = element;
                element = temp;
            }
            
            //Cycle tamamlanana kadar dönecek. Yukarıdakilerin tekrarı.
            while(pos != start) {
                pos = start;
                
                for(int i=start+1;i<n;i++) {
                    if(arr[i] < element)
                        pos++;
                }
                
                while(arr[pos] == element)
                    pos++;
                
                if(element != arr[pos]) {
                    int temp = arr[pos];
                    arr[pos] = element;
                    element = temp;
                }
            }
        }
    }
}
