import java.util.*;
public class array1d{
    public static void display(int[] arr){
        for(int i=0;i<arr.length;i++){
          System.out.print(arr[i]+" ");
        }
    }
    public static void arraysum(int[] arr1 , int[] arr2){
        int i=arr1.length-1;
        int j=arr2.length-1;
        int size=arr1.length  ;
        if(size<arr2.length){
            size=arr2.length;
        }
        int[] ans=new int[size+1];
        int k=ans.length-1;
        int carry=0;
        while(i>=0 && j>=0 && k>=0){
           int sum =arr1[i] + arr2[j] + carry;
            
             carry=sum/10;
            ans[k] = sum%10;
             i--;
             j--;
             k--;
        }
        while(i>=0){
            int sum=arr1[i] + carry;
            ans[k]=sum%10;
            carry=sum/10;
            i--;
            k--;
        }
        while(j>=0){
            int sum = arr2[j]+carry;
            ans[k]=sum %10;
            carry=sum/10;
            j--;
            k--;
        }
            ans[k]=carry;
            //To remove the starting zeroes in ans
         
    }

    public static void arraydiff(int[] arr1 , int[] arr2){
        int i=arr1.length-1;
        int j=arr2.length-1;
        int size=arr1.length;
        if(size<arr2.length){
            size=arr2.length;
        }
        int[] ans=new int[size];
        int k=ans.length-1;
        int borrow=0;
        //we have assumed that arr1 is always greater than or equal to arr2 
        while(i>=0 ){
            int d1=arr1[i];
            int d2=0; //if it will be out of range that is it will -1 and so on . 
            if(j>=0){
                d2=arr2[j];
            }
            d1=d1-borrow;
            borrow=0;
            if(d1 < d2){
                d1=d1+10;
                borrow=1;
            }
            ans[k]= d1-d2;
            k--;
            i--;
            j--;
        }
        
        displaydiff(ans);
    }
 
 public static void displaydiff(int[] arr){
      int idx=0;
        while(idx<arr.length && arr[idx] ==0 ){  
            idx++;
        }
        if(idx==arr.length){
            System.out.print("0") ;
        }else{
          //To print all numbers after removing starting zeroes.
        while(idx<arr.length){
            System.out.print(arr[idx] + " ");
            idx++;
        }
        }
 }

 public static void subarray(int[] arr){
     for(int i=0;i<arr.length;i++){
         for(int j=i;j<arr.length;j++){
             for(int k=i;k<=j;k++){
             System.out.print(arr[k]);
         }
         System.out.println();
         }
        // System.out.println();
     }
 }
public static void main(String[] args){
    Scanner scn=new Scanner(System.in);
    int n1=scn.nextInt();
    int[] arr1=new int[n1]; 
    for(int i=0;i<arr1.length;i++){
        arr1[i]=scn.nextInt();
    } 
    // int n2=scn.nextInt();
    // int[] arr2=new int[n2];
    // for(int i=0;i<arr2.length;i++){
    //     arr2[i]=scn.nextInt();
    // }
    //arraysum(arr1,arr2);
    //arraydiff(arr1,arr2);

     subarray(arr1);
}

}