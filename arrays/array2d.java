import java.util.*;
public class array2d{
    static Scanner scn=new Scanner(System.in);
    public static void input(int[][] arr){
       
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                arr[i][j]=scn.nextInt();
            }
        }
    }
 
    public static void display(int[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void multiply(int[][] arr1 , int[][] arr2){
        int[][] arr3=new int[arr1.length][arr2[0].length];
        if(arr1[0].length == arr2.length ){
        for(int i=0;i<arr3.length;i++){
            for(int j=0;j<arr3[0].length;j++){
                for(int k=0;k<arr1[0].length;k++){
                    arr3[i][j]+=arr1[i][k] * arr2[k][j];
                }
            }
        }
        display(arr3);
        }
        else{
            System.out.print("-1");
        }
    }

    public static void waveTraversal(int[][] arr){
        
        for(int i=0;i<arr[0].length;i++){
            if(i%2 == 0){
                for(int j=0;j<arr.length;j++){
                     System.out.print(arr[j][i]+ " ");
                }
            }
            else{
                for(int j=arr.length-1;j>=0;j--){
                    System.out.print(arr[j][i]+" ");
                }
            }
        }
    }
     
     public static void spiralTraversal(int[][] arr){
         int minr=0;
         int minc=0;
         int maxr=arr.length-1;
         int maxc=arr[0].length-1;
         int tot=(arr.length)*(arr[0].length);
         int count=0;
         while(count < tot){
             //left wall
              for(int i=minr,j=minc;i<=maxr && count < tot ;i++){
                  System.out.print(arr[i][j]+" ");
                  count++;

              }
               minc++;
             //bottom wall
               for(int i=maxr,j=minc;j<=maxc && count < tot ;j++){
                  System.out.print(arr[i][j] + " ");
                   count++;
              }
               maxr--;

             //right wall 
             //count vala check isme isliye chalaya kyunki 5*8 ke liye ni chlega agar left valle pe khtm ho raa h toh right call lahegi hi nhi. 
             for(int i=maxr,j=maxc;i>=minr && count < tot ;i--){
                  System.out.print(arr[i][j]+ " ");
                 count++;
              }
              maxc--;

             //top wall
             for(int i=minr,j=maxc;j>=minc && count < tot ;j--){
                  System.out.print(arr[i][j]+ " ");
                 count++;
              }
              minr++;
         }
     }

     public static void exitPoint(int[][] arr){
         int dir=0; //east
         // 0 - east
         // 1 - south
         // 2 - west
         // 3- north
         int i=0;
         int j=0;
         while(true){
         dir= (dir + arr[i][j] ) % 4; 

         if(dir==0){
             j++;
         }else if(dir==1){
             i++;

         }else if(dir==2){
             j--;
         }else if(dir==3){
             i--;
         }

         if(i<0){
             i++;
             break;
         }else if(j<0){
             j++;
             break;
         }else if(i==arr.length){
             i--;
             break;
         }else if(j==arr[0].length){
             j--;
             break;
         }
         }

         System.out.println(i);
         System.out.println(j);
     }

     public static void rotateby90Clockwise(int[][] arr){
         //transpose
         for(int i=0;i<arr.length;i++){
             for(int j=i;j<arr[0].length;j++){  // so that 2 baar swaping na ho
                 int temp=arr[i][j];
                 arr[i][j]=arr[j][i];
                 arr[j][i]=temp;
             }
         }
         //reverse rows
         for(int i=0;i<arr.length;i++){
             int si=0;
             int li=arr[0].length-1;
             while(li > si ){
                 int temp=arr[i][si];
                 arr[i][si]=arr[i][li];
                 arr[i][li]=temp;
                 si++;
                 li--;
             }
         }
         display(arr);
     }

     public static void diagnolTraversal(int[][] arr){
         for(int gap=0;gap<arr.length;gap++){
             for(int i=0,j=gap;j<arr[0].length;i++,j++){
                 System.out.print(arr[i][j]+" ");
             }
         }
     }

     public static void saddlePoint(int[][] arr){
         for(int i=0;i<arr.length;i++){
             int svj=0;
             for(int j=1;j<arr[0].length;j++){
                 if(arr[i][j] < arr[i][svj]){
                     svj=j;
                 }
             }
              boolean flag=true;
             for(int k=0;k<arr.length;k++){
                 if(arr[k][svj] > arr[i][svj]){
                     flag=false;
                     break;
                 }
             }

             if(flag==true){
                 System.out.println(arr[i][svj]);
                 return;
             }
         }
         System.out.print("No saddle point");
     }

     public static void search(int[][] arr , int d){  // sorted array2d. binary search
            
            int i=0;
            int j=arr[0].length-1;
            while(i<arr.length && j>=0){
                if(arr[i][j]==d){
                    System.out.println(i);
                    System.out.println(j);
                    return;
                }else if(arr[i][j] < d){
                    i++;
                }else{
                    j--;
                }
            }

     }

public static void reverse(int[] arr , int i ,int j){
   while(j>i){
       int temp=arr[i];
       arr[i]=arr[j];
       arr[j]=temp;
       i++;
       j--;
   }

    
}

public static void rotate(int[] arr , int k){
    k=k%arr.length; 
    if(k<0){
        k=k+arr.length;
    }
    
    reverse(arr , 0,arr.length-1-k);
    reverse(arr,arr.length-k,arr.length-1);
    reverse(arr,0,arr.length-1);
}

public static int[] fillonedFromShell(int[][] arr , int s){
    int minr=s-1;
    int minc=s-1;
    int maxr=arr.length - s;
    int maxc = arr.length - s;
    int size=2*(maxr - minr + maxc - minc);
    int[] oned=new int[size];
    int count=0;

                 //left wall
              for(int i=minr,j=minc;i<=maxr;i++){
                  oned[count]=arr[i][j];
                  count++;

              }
               minc++;
             //bottom wall
               for(int i=maxr,j=minc;j<=maxc ;j++){
                  oned[count]=arr[i][j];
                   count++;
              }
               maxr--;

             //right wall
             for(int i=maxr,j=maxc;i>=minr ;i--){
                  oned[count]=arr[i][j];
                 count++;
              }
              maxc--;

             //top wall
             for(int i=minr,j=maxc;j>=minc ;j--){
                 oned[count]=arr[i][j];
                 count++;
              }

              return oned;
}

public static void fillShellFromoned(int[][] arr, int s , int[] oned){
    int minr=s-1;
    int minc=s-1;
    int maxr=arr.length - s;
    int maxc = arr.length - s;
    int count=0;

                 //left wall
              for(int i=minr,j=minc;i<=maxr;i++){
                  arr[i][j]=oned[count];
                  count++;

              }
               minc++;
             //bottom wall
               for(int i=maxr,j=minc;j<=maxc ;j++){
                  arr[i][j]=oned[count];
                   count++;
              }
               maxr--;

             //right wall
             for(int i=maxr,j=maxc;i>=minr ;i--){
                  arr[i][j]=oned[count];
                 count++;
              }
              maxc--;

             //top wall
             for(int i=minr,j=maxc;j>=minc ;j--){
                 arr[i][j]=oned[count];
                 count++;
              }

              display(arr);
}

     public static void shellrotate(int[][] arr , int s, int r){
         int[] oned=fillonedFromShell(arr , s);
         rotate(oned , r);
         fillShellFromoned(arr, s , oned);
     }

     

    public static void main(String[] args){
        int n1=scn.nextInt();
        int m1=scn.nextInt();
        int[][] arr1=new int[n1][m1];
        input(arr1);
        int d=scn.nextInt();
        int r=scn.nextInt();
        //int n2=scn.nextInt();
        //int m2=scn.nextInt();
        //int[][] arr2=new int[n2][m2];
        //input(arr2);
        //display(arr);
        // multiply(arr1,arr2);
        //waveTraversal(arr1);
        //spiralTraversal(arr1);
        //exitPoint(arr1);
        //rotateby90Clockwise(arr1);
        //diagnolTraversal(arr1);
        //saddlePoint(arr1);
        //search(arr1 , d);
        shellrotate(arr1 , d , r);
     }
}