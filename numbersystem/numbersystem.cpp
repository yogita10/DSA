#include<iostream>
using namespace std;
int deciToAnybase(int n , int b){
    int pow=1;
    int ans=0;
    while(n!=0){
        int rem=n%b;
        n=n/b;
        ans=ans + rem*pow;
        pow=pow*10;
    }
    return ans;
}

int anybaseToDecimal(int n, int b){
    int pow=1;
    int ans=0;
    while(n!=0){
        int rem=n%10;
        n=n/10;
        ans=ans+rem*pow;
        pow=pow*b;
    }
    return ans;
}

int anybaseToAnybase(int n,int a,int b){
    int div=anybaseToDecimal(n,a);
    int ans=deciToAnybase(div,b);
    return ans;
}

int main(){
    int n,b,a;
    cin>>n>>a>>b;
    //cout<<deciToAnybase(n,b);
    //cout<<anybaseToDecimal(n,b);
    cout<<anybaseToAnybase(n,a,b);
    return 0;
}