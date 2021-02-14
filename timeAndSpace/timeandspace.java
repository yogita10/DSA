import java.util.*;
public class timeandspace { 

    static Scanner scn=new Scanner(System.in);
 
    public static void display(int[] arr){

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
    }
    }
    public static void bubblesort(int[] arr){
        for(int i=1;i<=arr.length-1;i++){   //0 se isliye start ni kra kyunki voh error dega index out of bound as we are comparing j+1 and j. So aar.length-1 should be last not arr.length
             for(int j=0 ; j<arr.length-i;j++){
                if(arr[j] > arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        display(arr);
    }

    public static void selectionsort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            int min=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j] < arr[min]){
                    min=j;
                }
            }
                int temp=arr[i];
                arr[i]=arr[min];
                arr[min]=temp;
            }
        
        display(arr);
    }

    public static void insertionsort(int[] arr){  //better than bubble and selection sort. 
        for(int i=1;i<arr.length;i++){  // phla element sorted h , dusre element ko sorted list me ana h . 
            for(int j=i-1 ; j>=0 ; j--){
                   if(arr[j] > arr[j+1]){
                       int temp=arr[j];
                       arr[j]=arr[j+1];
                       arr[j+1]=temp;
                   }
                   else{
                       break;
                   }
            }
        }

        display(arr);
    }

    public static int[] mergetwosortedarray(int[] arr1 , int[] arr2){
        int i=0;
        int j=0;
        int k=0;
        int[] ans=new int[arr1.length + arr2.length];

        while(i<arr1.length && j<arr2.length){
            if(arr1[i] > arr2[j]){
                ans[k]=arr2[j];
                j++;
                k++;
            }
            else{
                ans[k]=arr1[i];
                i++;
                k++;
            }
        }

        while(i<arr1.length){
            ans[k]=arr1[i];
            i++;
            k++;
        }
        while(j<arr2.length){
            ans[k]=arr2[j];
            j++;
            k++;
        }

        return ans;
    }

    public static int[] mergesort(int[] arr , int lo , int hi){
        
        if(lo==hi){
            int[] ba=new int[1];
            ba[0]=arr[lo];
            return ba;
        }

        int mid=(lo+hi)/2 ; 
        
        int[] fh = mergesort(arr , lo , mid);
        int[] lh=mergesort(arr, mid+1 , hi);
        int[] ans=mergetwosortedarray(fh , lh);
        return ans;
    }

    public static void partitionInArray(int[] arr , int pivot , int lo , int hi ){
        //0 to j-1 -- <=pivot
        //j to i-1 -- >pivot
        //i to end -- unknown
        int i=lo;
        int j=lo;
        while(i<=hi){
            if(arr[i] > pivot){
                i++;
            }
            else{
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j++;
            }
        }
        display(arr);

    }

    public static int partition(int[] arr , int pivot , int lo , int hi ){
        //0 to j-1 -- <=pivot
        //j to i-1 -- >pivot
        //i to end -- unknown
        int i=lo;
        int j=lo;
        while(i<=hi){
            if(arr[i] > pivot){
                i++;
            }
            else{
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j++;
            }
        }
       return j-1;

    }

    public static void quicksort(int[] arr , int lo , int hi){
        if(lo > hi){
            return;
        }
        int pivot=arr[hi];
       int pi= partition(arr , pivot , lo ,hi );
       quicksort(arr,lo,pi-1);
       quicksort(arr,pi+1,hi);
    }

    public static int quickselect(int[] arr , int lo ,int hi , int k){
        int pivot=arr[hi];
        int pi=partition(arr,pivot , lo ,hi);
        if(k>pi){
            return quickselect(arr, pi+1,hi,k);
        }else if(k<pi){
            return quickselect(arr , lo , pi-1 ,k);
        }
        else{
            return arr[pi];
        }
    }

    public static void countsort(int[] arr , int min , int max){
        int range=max-min+1;
        int[] farr=new int[range];
        for(int i=0;i<arr.length;i++){
            int idx=arr[i] - min;
            farr[idx]++;
        }
        for(int i=1;i<farr.length;i++){
            farr[i]=farr[i] + farr[i-1];
        }
        int[] ans=new int[arr.length];
        for(int i=arr.length-1 ; i>=0 ; i--){
            int val=arr[i];
            int pos=farr[val-min];
            int idx=pos-1;
            ans[idx]=val;
            farr[val-min]--;
        }
        for(int i=0;i<ans.length;i++){
            arr[i]=ans[i];
        }
        display(arr);
    }

    public static void sort01(int[] arr){
        //0 to j-1 -- <=pivot
        //j to i-1 -- >pivot
        //i to end -- unknown
        int i=0;
        int j=0;
        int pivot=0;
        while(i<arr.length){
            if(arr[i] > pivot){
                i++;
            }
            else{
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j++;
            }
        }
        display(arr);
    }

    public static void sort012(int[] arr){
        int i=0;
        int j=0;
        int k=arr.length-1;
        while(i<=k){
            if(arr[i]==1){
                i++;
            }
            else if(arr[i]==0){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j++;
            }
            else{
                int temp=arr[i];
                arr[i]=arr[k];
                arr[k]=temp;
                k--;
            }
        }

        display(arr);

    }

    public static void radixsort(int[] arr){
        int max=arr[0];
        for(int val=0;val<arr.length;val++){
            if(arr[val] > max);
            max=arr[val];
        }
        int exp=1;
        while(exp<=max){
            count(arr , exp);
            exp=exp*10;
        }
        display(arr);
    }

    public static void count(int[] arr , int exp){
        int[] farr=new int[10];  //no.s are from 0 to 9 
        for(int i=0;i<arr.length;i++){
            farr[arr[i] / exp %10]++;
        }
        for(int i=1;i<farr.length;i++){
            farr[i]=farr[i] + farr[i-1];
        }
        int[] ans=new int[arr.length];
        for(int i=arr.length-1 ; i>=0 ; i--){
            int pos=farr[arr[i] /exp %10] -1;
            ans[pos]=arr[i];
            farr[arr[i] / exp %10]--;
        }
        for(int i=0;i<ans.length;i++){
            arr[i]=ans[i];
        }
    }

    public static void targetsum(int[] arr , int sum){
        int[] ans= mergesort(arr , 0 , arr.length -1);
        int i=0;
        int j=ans.length-1;
        while(i<j){
            if(ans[i]+ans[j] > sum){
                j--;
            }else if(ans[i]+ans[j] < sum){
                i++;
            }else{
                System.out.println(ans[i] + " " + ans[j]);
                i++;
                j--;
            }
        }
    }

    public static int pivotOfSortedRotatedArray(int[] arr){
        int i=0;
        int j=arr.length -1;
        while(i<j){
            int m=(i+j)/2;
            if(arr[m] < arr[j]){
                j=m;
            }else{
                i=m+1;
            }
        }
        return arr[j];
    }

    public static void main(String[] args){
       int n=scn.nextInt();
       int[] arr1=new int[n];
       for(int i=0;i<arr1.length;i++){
           arr1[i]=scn.nextInt();
       }       
       //int pivot=scn.nextInt();
        int m=scn.nextInt();
    //    int[] arr2=new int[m];
    //    for(int i=0;i<arr2.length;i++){
    //       arr2[i]=scn.nextInt();
    //    }
      //bubblesort(arr1);
      //selectionsort(arr);
      //insertionsort(arr);  
     //int[] a=mergetwosortedarray(arr1,arr2);
      // int[] a= mergesort(arr1 , 0 ,arr1.length-1);
      // display(a);
     // partitionInArray(arr1 , pivot , 0 , arr1.length-1);
     //System.out.print(partition(arr1, pivot , 0 ,arr1.length-1));
     //quicksort(arr1,0,arr1.length-1);
     //display(arr1);
     //countsort(arr1 , 3,9);
     //sort01(arr1);
     //sort012(arr1);
     //radixsort(arr1);
     System.out.print(quickselect(arr1,0,arr1.length-1,m-1));
     //targetsum(arr1 , m);
     //System.out.print(pivotOfSortedRotatedArray(arr1));
    }
}