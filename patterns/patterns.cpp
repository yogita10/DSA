#include<iostream>
using namespace std;
void pattern1(int n){
    for(int i=1;i<=n;i++){
        for(int j=1;j<=i;j++){
            cout<<"*";
        }
        cout<<endl;
    }
}

void pattern2(int n){
    for(int i=n;i>=1;i--){
        for(int j=1;j<=i;j++){
            cout<<"*";
        }
       cout<<endl;
    }
}

void pattern3(int n){
    int sp=n-1;
    int st=1;
    for(int i=1;i<=n;i++){
      for(int j=1;j<=sp;j++){
          cout<<" ";
      }
      for(int j=1;j<=st;j++){
          cout<<"*";
      }
      cout<<endl;
        sp--;
        st++;

    }
}

void pattern4(int n){
    int sp=0;
    int st=n;
    for(int i=1;i<=n;i++){
        for(int j=1;j<=sp;j++){
            cout<<" ";
        }
        for(int j=1;j<=st;j++){
            cout<<"*";
        }
        cout<<endl;
        sp++;
        st--;

    }
}

void pattern5(int n){
    int st=1;
    int sp=n/2;
    for(int i=1;i<=n;i++){
        for(int j=1;j<=sp;j++){
            cout<<" ";
        }
        for(int j=1;j<=st;j++){
            cout<<"*";
        }
        cout<<endl;
        if(i<=n/2){
        sp--;
        st=st+2;
        }
        else{
            sp++;
            st=st-2;
        }
    }
}

void pattern6(int n){
    int st=n/2 + 1 ; 
    int sp= 1;
    for(int i=1;i<=n;i++){
        for(int j=1;j<=st;j++){
            cout<<"*";
        }
        for(int j=1;j<=sp;j++){
            cout<<" ";
        }
        for(int j=1;j<=st;j++){
            cout<<"*";
        }
        cout<<endl;
        if(i<=n/2){
            st--;
            sp=sp+2;
        }
        else{
            st++;
            sp-=2;
        }
    }
}
void pattern7(int n){
    for(int i=1;i<=n;i++){
        for(int j=1;j<=n;j++){
            if(i==j){
                cout<<"*";
            }
            else{
                cout<<" ";
            }
        }
        cout<<endl;
    }
}

void pattern8(int n){
    for(int i=1;i<=n;i++){
        for(int j=1;j<=n;j++){
            if(i+j == n+1 ){
                cout<<"*";
            }
            else{
                cout<<" ";
            }
        }
        cout<<endl;
    }

}

void pattern9(int n ){
    for(int i=1;i<=n;i++){
        for(int j=1;j<=n;j++){
            if(i==j || i+j == n+1){
                cout<<"*";
            }            else{
                cout<<" ";
            }
        }
        cout<<endl;
    }
}
void pattern10(int n){
    int os=n/2;
    int is=-1;
    for(int i=1;i<=n;i++){
        for(int j=1;j<=os;j++){
            cout<<" ";
        }
        cout<<"*";
        for(int j=1;j<=is;j++){
            cout<<" ";
        }
        if(i>1 && i<n){
            cout<<"*";
        }
        
        if(i<=n/2){
            os--;
            is+=2;
        }else{
            os++;
            is-=2;
        }
        cout<<endl;
    }
}

void pattern11(int n){
    int val=1;
    for(int i=1;i<=n;i++){
        for(int j=1;j<=i;j++){
            cout<<val<<" ";
            val++;
        }
        cout<<endl;
    }
}

void pattern12(int n){
    int a=0;
    int b=1;
    for(int i=1;i<=n;i++){
        for(int j=1;j<=i;j++){
            cout<<a<<" ";
            int c=a+b;
            a=b;
            b=c;
        }
        cout<<endl;
    }
}

void pattern13(int n){
    for(int i=0;i<n;i++){
         int ncr=1;
        for(int j=0;j<=i;j++){
            cout<<ncr<<" ";
          int ncrp1=(ncr * (i-j))/(j+1); 
          ncr=ncrp1;

        }
        cout<<endl;
    }
}

void pattern14(int n){
    for(int i=1;i<=10;i++){
        cout<<n<<"*"<<i<<"="<<n*i<<endl;
    }
}

void pattern15(int n){
    int st=1;
    int sp=n/2;
    int val=1;
    for(int i=1;i<=n;i++){
        for(int j=1;j<=sp;j++){
            cout<<" ";
        }
        int cval=val;
        for(int j=1;j<=st;j++){
            cout<<cval;
            //cval++;
            if(j<=st/2){
                cval++;
            }
            else{
                cval--;
            }
        }
        //val++;
        cout<<endl;
        if(i<=n/2){
        sp--;
        st=st+2;
        val++;
        }
        else{
            sp++;
            st=st-2;
            val--;
        }
    }

}

void pattern16(int n){
    int st=1;
    int sp=2*n - 3;
    for(int i=1;i<=n;i++){
        int val=1;
        for(int j=1;j<=st;j++){
            cout<<val;
            val++;
        }
        for(int j=1;j<=sp;j++){
            cout<<" ";
        }
        if(i==n){
            st--;
            val--;
        }
        for(int j=1;j<=st;j++){
            val--;
            cout<<val;
        }
        cout<<endl;
        st++;
        sp-=2;
    }
}

void pattern17(int n){
    int sp=n/2;
    int st=1;
    for(int i=1;i<=n;i++){
        for(int j=1;j<=sp;j++){
            cout<<" ";
        }
        for(int j=1;j<=st;j++){
            if(j<=n/2 && j!=(n/2)+1){
                cout<<" ";
            }else{
                cout<<"*";
            }
        }
        if(i<=n/2){
            st+=2;
            sp--;
        }
        else{
            st-=2;
            sp++;
        }
        cout<<endl;
    }
    
}
int main(){
    int n;
    cin>>n;
    //pattern1(n);
    //pattern2(n);
    //pattern3(n);
    //pattern4(n);
    //pattern5(n);
    //pattern6(n);
    //pattern7(n);
    //pattern8(n);
    //pattern9(n);
    //pattern10(n);
    //pattern11( n);
    //pattern12(n);
    //pattern13(n);
    //pattern14(n);
    //pattern15(n);
    //pattern16(n);
    pattern17(n);
    return 0;
}