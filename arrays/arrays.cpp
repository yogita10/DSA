#include<iostream>
using namespace std;

void display(int arr[] , int size){
    for(int k=0;k<size;k++){
        cout<<arr[k];
    }
}
int max(int arr[],int size){
    int max=0;
    for(int i=0;i<size;i++){
        if(arr[i]>max){
            max=arr[i];
        }
    }
    return max;
}
int min(int arr[],int size){
    int min=arr[0];
    for(int i=0;i<size;i++){
        if(arr[i]<min){
            min=arr[i];
        }
    }
    return min;
}

int span(int arr[] , int size){
    int ma=max(arr,size);
    int mi=min(arr,size);
    int sp=ma-mi;
    return sp;
}

int findElement(int arr[] , int size ,int d){
     for(int i=0;i<size;i++){
         if(arr[i]==d){
             return i;
         }
     }
     return -1;
}

void barchart(int arr[] , int size){
    int ma=max(arr,size);
    for(int floor=ma;floor>=1;floor--){
        for(int i=0;i<size;i++){
            if(arr[i]>=floor){
                cout<<"*";
            }
            else{
                cout<<" ";
            }

        }
        cout<<endl;
    }
}

void sumOfTwoArray(int size1 , int arr1[] , int size2 , int arr2[]){
    int size3;
    int carry=0;
    int arr3[10];
    if(size2>size1){
        size3=size2;
    }
    else{
        size3=size1;
    }
    int i=size1-1;
    int j=size2-1;
    int k=size3-1;

    while(k>=0){
        int d=carry;
        if(i>=0){
            d+=arr1[i];
        }
        if(j>=0){
            d+=arr2[j];
        }
        carry=d/10;
        d=d%10;
        arr3[k]=d;
        i--;
        j--;
        k--;
    }

    if(carry!=0){
        cout<<carry;
    }
    for(int val:arr3){
        cout<<val;
    }

}

void reverse(int arr[] , int size, int i ,int j){
   while(j>i){
       int temp=arr[i];
       arr[i]=arr[j];
       arr[j]=temp;
       i++;
       j--;
   }

    
}

void rotate(int arr[] , int size,int k){
    reverse(arr,size,0,size-1-k);
    reverse(arr,size,size-k,size-1);
    reverse(arr,size,0,size-1);

    for(int i=0;i<size;i++){
        cout<<arr[i];
    }
}

void inverse(int arr[], int size){
    int inv[size];
    for(int i=0;i<size;i++){
        int v=arr[i];  //to invert position and value that is i and value
        inv[v]=i;
    }
    display(inv,size);

}

void subArray(int arr[] , int size ){
    for(int i=0;i<size;i++){  //starting point
        for(int j=i;j<size;j++){  //end point
            for(int k=i;k<=j;k++){
                cout<<arr[k]<<" ";
            }
            cout<<endl;
        }
    }
}

int abc(int arr[], int size){
    int sm=1;
    for(int i=0;i<size;i++){
        if(arr[i]<=sm){
            sm+=arr[i];
        }
        else{
            break;
        }
    }
    return sm;
}

void CeilAndFloor(int arr[] , int size ,int d){
    int l=0;
    int h=size-1;
    int ceil=-1;
    int floor=-1;
    while(h>=l){
        int m=(h+l)/2;
        if(d<arr[m]){
            h=m-1;
            ceil=arr[m];

        }else if(d>arr[m]){
            l=m+1;
            floor=arr[m];

        }else{
            ceil=arr[m];
            floor=arr[m];
        }
    }
    cout<<ceil<<endl<<floor;
}

int firstIndex(int arr[],int size,int d){
    int l=0;
    int h=size-1;
    int fi=-1;
    while(h>=l){
        int m=(l+h)/2;
        if(d<arr[m]){
            h=m-1;
        }
        else if(d>arr[m]){
            l=m+1;
        }else{
             fi=m;
             h=m-1;
        }
    }
    return fi;
}

int lastIndex(int arr[],int size,int d){
    int l=0;
    int h=size-1;
    int hi=-1;
    while(h>=l){
        int m=(l+h)/2;
        if(d<arr[m]){
            h=m-1;
        }
        else if(d>arr[m]){
            l=m+1;
        }else{
             hi=m;
             l=m+1;
        }
    }
    return hi;
}

int main(){
    int arr1[20];
    int size1;
    cin>>size1;
    for(int i=0;i<size1;i++){
        cin>>arr1[i];
    }
    //int k;
    //cin>>k;
    //int arr2[20];
    //int size2;
    //cin>>size2;
    //for(int i=0;i<size2;i++){
      //  cin>>arr2[i];
    //}
    int d;
    cin>>d;
    //cout<<span(arr,size);
    //cout<<findElement(arr,size,d);
    //barchart(arr,size);
    //sumOfTwoArray(size1,arr1,size2,arr2);
    //reverse(arr1,size1,0,size1-1);
    //rotate(arr1,size1,k);
    //inverse(arr1,size1);
    //subArray(arr1,size1);
    //cout<<abc(arr1,size1);
    //cout<<firstIndex(arr1,size1,d)<<endl<<lastIndex(arr1,size1,d);
    CeilAndFloor(arr1,size1,d);
    return 0 ;
}
