import java.util.*;
public class stacks{

    public static void dublicatebracket(String str){
        Stack<Character> st=new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch==')'){
                if(st.peek()=='('){
                    System.out.println("true");
                    return;
                }else{
                    while(st.peek()!='('){
                        st.pop();
                    }
                    st.pop();
                }
            }else{
                st.push(ch);
            }
        }
        System.out.println("false");
    }

    public static void balancedbracket(String str){
        Stack<Character> st=new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            //sirf brackets hi push karane h code me 
            if(ch=='(' || ch=='{' || ch=='['){
                    st.push(ch);
            }else if(ch==')'){   //every closing bracket will deal differently.
                if(st.size()==0){
                    System.out.println("false");
                    return;
                }else if(st.peek()!='('){
                    System.out.println("false");
                    return;
                }else{
                    st.pop();
                }

            }else if(ch=='}'){
                if(st.size()==0){
                    System.out.println("false");
                    return;
                }else if(st.peek()!='{'){
                    System.out.println("false");
                    return;
                }else{
                    st.pop();
                }

            }else if(ch==']'){
                if(st.size()==0){
                    System.out.println("false");
                    return;
                }else if(st.peek()!='['){
                    System.out.println("false");
                    return;
                }else{
                    st.pop();
                }

            }
        }
        if(st.size()==0){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
    //time complexity of this code is O(n) 
    public static int[] nextgreaterelementtoright(int[] arr){
         Stack<Integer> st=new Stack<>();
         int[] ans=new int[arr.length];
         st.push(arr[arr.length-1]);
         ans[arr.length-1]=-1;
         //we traverse from backwards in this code. 
         for(int i=arr.length-2;i>=0;i--){
             while(st.size()>0 && arr[i]>=st.peek()){  //iski complexity n ni h constant h kyunki h jitne push hue h uthne hi pop hue h it cannot be more than n , so iski time complexity constant hogi kyunki kabhi kabhi hoga ye case. and defined baar hoga n baar ni 
                 st.pop();
             }
             if(st.size()==0){
                 ans[i]=-1;
             }else{
                 ans[i]=st.peek();
             }
             st.push(arr[i]);
         }
         return ans;
    }

    public static int[] nextgreaterelementtorightalternativeapproch(int[] arr){
        //we would traverse from starting in this code
        //hum isme stack me value ni dalenge vale ki position ko dalenge
        Stack<Integer> st=new Stack<>();
        int[] ans=new int[arr.length];
        st.push(0);
        for(int i=1;i<arr.length;i++){
            while(st.size()>0 && arr[i]>arr[st.peek()]){ //arr[st.peek()] isliye likha kyunki stack me toh arr ki position h , value ko access krne ke liye ye likhna padega
                int pos=st.peek();
                ans[pos]=arr[i];
                st.pop();
               
            }
            st.push(i);
        }
        while(st.size()>0){
            int pos=st.peek();
            ans[pos]=-1;
            st.pop();
        }
       return ans;
    }

    public static int[] stockspan(int[] arr){
        Stack<Integer> st=new Stack<>();
        int[] ans=new int[arr.length];
        st.push(0);
        ans[0]=1;
        for(int i=1;i<arr.length;i++){
            while(st.size()>0 && arr[i]>arr[st.peek()]){
                st.pop();
            }
            if(st.size()==0){
                ans[i]=i+1;     //aap hi max h 
            }else{
                ans[i]=i-st.peek();
            }
            st.push(i);

        }
        return ans;
    }

    public static int largestareahistogram(int[] arr){

        //we will write index of the next smaller index so that index mile hume and index me se index subratc krke hum width mile
        int[] rb=new int[arr.length]; //next smaller element on right
        Stack<Integer> st=new Stack<>();
        st.push(arr.length-1);
        rb[arr.length-1]=arr.length;
        for(int i=arr.length-2;i>=0;i--){
            while(st.size()>0 && arr[i]<arr[st.peek()]){
                st.pop();
            }
            if(st.size()==0){
                rb[i]=arr.length;
            }else{
                rb[i]=st.peek();
            }
            st.push(i);
        }

        int[] lb=new int[arr.length]; //netx smaller element on left 
        st=new Stack<>();
        st.push(0);
        rb[0]=-1;
        for(int i=1;i<arr.length;i++){
            while(st.size()>0 && arr[i]<arr[st.peek()]){
                st.pop();
            }
            if(st.size()==0){
                lb[i]=-1;
            }else{
                lb[i]=st.peek();
            }
            st.push(i);
        }

        
        int maxarea=0;
        for(int i=0;i<arr.length;i++){
            int width=rb[i]-lb[i]-1;
            int area=arr[i]*width;
            if(area>maxarea){
                maxarea=area;
            }
        }
        return maxarea;
    }


    //time complexity of this code is O(n) 
    public static void celebrityproblem(int[][] arr){
        Stack<Integer> st=new Stack<>();
        for( int i=0;i<arr.length;i++ ){
            st.push(i);
        }
        while(st.size()>=2){
            int i=st.pop();
            int j=st.pop();
            if(arr[i][j]==1){
                //if i knows j -> i is not a celeb
                st.push(j);

            }else{
                //if i doesnot knows j -> j is not a celeb
                st.push(i);
            }
        }
        int pot=st.pop();
        for(int i=0;i<arr.length;i++){
            if(i!=pot){
                if(arr[i][pot] == 0  || arr[pot][i]==1){
                    System.out.println("none");
                    return;
                }
            }
        }
        System.out.println(pot);

    }
    public static void slidingwindowmax(int[] arr,int k){
        Stack<Integer> st=new Stack<>();
        int[] nge=new int[arr.length];
        st.push(arr.length-1);
        nge[arr.length-1]=arr.length; //we need to take max value..
        for(int i=arr.length-2;i>=0;i--){
            while(st.size()>0 && arr[i]>=arr[st.peek()]){
                st.pop();
            }
            if(st.size()==0){
                nge[i]=arr.length;
            }else{
                nge[i]=st.peek();
            }
            st.push(i);
        }
        int j=0;
        for(int i=0;i<=arr.length-k;i++){
            //enter the loop to find the maximum of window starting at i
            if(j<i){
                j=i;
            }
            while(nge[j]<i+k){
                j=nge[j];
            }

            System.out.print(arr[j]+" ");

        }
    }

    public static void smallestnumberfollowingpattern(String str){
        Stack<Integer> st=new Stack<>();
        int num=1;
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch=='d'){
                st.push(num);
                num++;

            }else{
                st.push(num);
                num++;

                while(st.size()>0){
                    System.out.print(st.pop());
                }

            }
        }
        st.push(num);
        while(st.size()>0){
            System.out.print(st.pop());
        }
        
    }
  //evaluates the value of infix exprsession 
    public static int infixevaluate(String exp){
     Stack<Integer> num=new Stack<>();
     Stack<Character> optr=new Stack<>();
     for(int i=0;i<exp.length();i++){
         char ch=exp.charAt(i);
         
         if(ch>='0' && ch<='9'){
             num.push(ch-'0');  //'5'-'0'=5;
         }else if(ch=='('){
             optr.push(ch);
         }
         else if(ch==')'){
             
             //solve till opening
             
             while(optr.peek()!='('){
                 char op=optr.pop();
                 int op2=num.pop();
                 int op1=num.pop();
                 int val=solve(op , op1,op2);
                 num.push(val);
             }
             optr.pop();
         }else if( ch=='+' || ch=='-' || ch=='*' || ch=='/'){
             while(optr.size()>0 && optr.peek()!='(' && precedence(optr.peek()) >=precedence(ch) ) {
                 char op=optr.pop();
                 int op2=num.pop();
                 int op1=num.pop();
                 int val=solve(op , op1,op2);
                 num.push(val);
             }
             optr.push(ch);
         }
         
     }
     
     while(optr.size()>0){
          char op=optr.pop();
                 int op2=num.pop();
                 int op1=num.pop();
                 int val=solve(op , op1,op2);
                 num.push(val);
     }
     return num.peek();
 }
 
 public static int precedence(char ch){
     if(ch=='+' || ch=='-'){
         return 1;
     }else{
         return 2;
     }
 }
 
 public static int solve(char ch , int op1 , int op2){
     if(ch=='-'){
         return op1-op2;
     }else if(ch=='+'){
         return op1+op2;
     }else if(ch=='*'){
         return op1*op2;
     }else{
         return op1/op2;
     }
 }

  //converts infix into postfix and prefix 
 public static void infixconversions(String exp){
     
     Stack<Character> optr = new Stack<>();
     Stack<String> prefix =new Stack<>();
     Stack<String> postfix = new Stack<>();
     
     for(int i=0;i<exp.length();i++){
         char ch=exp.charAt(i);
         if( (ch>='0' && ch<='9') || (ch>='a' && ch<='z')  || (ch>='A' && ch<='Z') ){
             prefix.push(""+ch); //string me convert ho jayegaa
             postfix.push(""+ch);
         }else if(ch=='('){
             optr.push(ch);
         }else if(ch==')'){
             while(optr.peek()!='('){
                 char op=optr.pop();
                 //prefix 
                 String preop2=prefix.pop();
                 String preop1=prefix.pop();
                 prefix.push(op+preop1+preop2);
                 //postfix
                 String postop2=postfix.pop();
                 String postop1=postfix.pop();
                 postfix.push(postop1+postop2+op);
             }
             optr.pop();
         }else if(ch=='+' || ch=='-' || ch=='*' || ch=='/'){
             while(optr.size()>0 && optr.peek()!='(' && precedence(optr.peek()) >= precedence(ch) ) {
                 char op=optr.pop();
                 //prefix 
                 String preop2=prefix.pop();
                 String preop1=prefix.pop();
                 prefix.push(op+preop1+preop2);
                 //postfix
                 String postop2=postfix.pop();
                 String postop1=postfix.pop();
                 postfix.push(postop1+postop2+op);
             }
             optr.push(ch);
         }
     }
         while(optr.size() >0 ){
             char op=optr.pop();
                 //prefix 
                 String preop2=prefix.pop();
                 String preop1=prefix.pop();
                 prefix.push(op+preop1+preop2);
                 //postfix
                 String postop2=postfix.pop();
                 String postop1=postfix.pop();
                 postfix.push(postop1+postop2+op);
         }
         
         System.out.println(postfix.peek());
         System.out.println(prefix.peek());
 }
    /*    You are required to evaluate it and print it's value.
          You are required to convert it to infix and print it.
          You are required to convert it to prefix and print it.                  
   */
    public static void postfixevaluationandconversion(String exp){
     Stack<Integer> eval=new Stack<>();
     Stack<String> infix=new Stack<>();
     Stack<String> postfix=new Stack<>();
     for(int i=0;i<exp.length();i++){
         char ch=exp.charAt(i);
         if(ch=='-' || ch=='+' || ch=='*' || ch=='/'){
             //eval
             int op2=eval.pop();
             int op1=eval.pop();
             int val=solve(ch,op1,op2);
             eval.push(val);
             
             //infix 
             String iop2=infix.pop();
             String iop1=infix.pop();
             infix.push("("+iop1+ch+iop2+")");
             
             //prefix
             String pop2=postfix.pop();
             String pop1=postfix.pop();
             postfix.push(ch+pop1+pop2);
             
         }else{
             eval.push(ch-'0');
             infix.push(""+ch);
             postfix.push(""+ch);
         }
     }
     
     System.out.println(eval.peek());
     System.out.println(infix.peek());
     System.out.println(postfix.peek());
 }
    
    /*   You are required to evaluate it and print it's value.
         You are required to convert it to infix and print it.
         You are required to convert it to postfix and print it.
*/
    public static void prefixevalandconversion(String exp){
     Stack<Integer> eval=new Stack<>();
     Stack<String> infix=new Stack<>();
     Stack<String> postfix=new Stack<>();
     
     for(int i=exp.length()-1;i>=0;i--){
         char ch=exp.charAt(i);
         if(ch=='+' || ch=='-' || ch=='*' || ch=='/'){
             //eval 
             int op1=eval.pop();
             int op2=eval.pop();
             int val=solve(ch,op1,op2);
             eval.push(val);
             
             //infix 
             String iop1=infix.pop();
             String iop2=infix.pop();
             infix.push("("+iop1+ch+iop2+")");
             
             //postfix
             String pop1=postfix.pop();
             String pop2=postfix.pop();
             postfix.push(pop1+pop2+ch);
         }else{
             eval.push(ch-'0');
             infix.push(""+ch);
             postfix.push(""+ch);
         }
     }
     System.out.println(eval.peek());
     System.out.println(infix.peek());
     System.out.println(postfix.peek());
 }


    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        String str=scn.nextLine();
        //dublicatebracket(str);
        //balancedbracket(str);
        //smallestnumberfollowingpattern(str);
        //System.out.print(infixevaluate(str));
        //infixconversions(str);
        //postfixevaluationandconversion(str);
        prefixevalandconversion(str);
        //int n=scn.nextInt();
        // int[] arr=new int[n];
        // for(int i=0;i<arr.length;i++){
        //     arr[i]=scn.nextInt();
        // }
        // int k=scn.nextInt();
        //int[] ans=nextgreaterelementtoright(arr);
        //int[] ans=stockspan(arr);
        //for(int i=0;i<ans.length;i++){
          //  System.out.print(ans[i]+" ");
       // }
       // System.out.print(largestareahistogram(arr));

       //slidingwindowmax(arr,k);
    }       
}