import edu.princeton.cs.algs4.In;

import java.util.Arrays;
import java.util.Date;

public class Sum3 {
    public static int binarySearch(int[] a, int left, int right, int x){
        while(left <= right){
            int mid = (left + right)/2;
            if(a[mid] == x){
                return mid;
            }else if(a[mid] > x){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        In in = new In("D:/algs4-data/4Kints.txt");
        int[] a = in.readAllInts();
        Date d = new Date();
        long s_time = d.getTime();
        int count_c1 = 0;
        System.out.println("Running method 1");
        for(int i = 0; i < a.length; i++){
            for(int j = i+1; j < a.length; j++){
                for(int k = j+1; k < a.length; k++)
                    if(a[i] + a[j] + a[k] == 0){
//                    System.out.println(a[i]+ " "+a[j]+" "+a[k]);
                        count_c1++;
                    }
            }
        }

        System.out.println((new Date()).getTime() - s_time);
        Arrays.sort(a);
        s_time = (new Date()).getTime();
        int count_c2 = 0;
        System.out.println("Running method 2");

        for(int i = 0; i < a.length; i++){
            int j = i + 1;
            int k = a.length-1;
            while(j < k){
                int s = a[i] + a[j] + a[k];
                if(s == 0) {
                    j++;
                    count_c2++;
                }
                else if (s < 0) j++;
                else k--;
            }
        }
        System.out.println((new Date()).getTime() - s_time);
        System.out.println("Running method 3");
        s_time = (new Date()).getTime();
        int count_c3 = 0;
        for(int i = 0; i < a.length; i++){
            for(int j = i+1; j < a.length; j++){
                if(binarySearch(a, j+1, a.length-1, -a[i]-a[j]) >=0){
                    count_c3++;
                }
            }
        }
        System.out.println((new Date()).getTime() - s_time);
        System.out.println(a.length+" "+count_c1+" "+count_c2+" "+count_c3);
    }
}