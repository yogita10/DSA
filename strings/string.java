import java.util.*;
public class string{

    public static void sub(String str){
        for(int i=0;i<str.length();i++){
            for(int j=i+1;j<=str.length();j++){
                System.out.println(str.substring(i,j));
            }
        }
    }

    public static String toggle(String str){
        String ans=" ";
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
           int ch1=str.charAt(i);
           //System.out.println(ch1);
           if(ch>='a' && ch<='z'){
               ch=(char)(ch-'a' + 'A');
           }
           else{
               ch=(char)(ch-'A' + 'a');           
               }
               ans=ans+ch;
        }

        return ans;
    }

    public static boolean palindrome(String str){
        boolean abc=false;
        for(int i=0;i<str.length()/2;i++){
            if(str.charAt(i)==str.charAt(str.length()-1-i)){
            // temp=str.charAt(i);
            //str.charAt(i)=str.charAt(str.length()-1-i);
            //str.charAt(str.length()-1-i)=temp;
             abc=true;
            }
        }
            return abc;
        

        // if(abc==false){
        //      System.out.println("palindrome");
        //     }
        //     else{
        //         System.out.print("not a palindrome");
        //     }

    }

    public static void palindromeSubstring(String str){
       //boolean xyz=true;
        for(int i=0;i<str.length();i++){
            
            for(int j=i+1;j<=str.length();j++){
                if(palindrome(str.substring(i,j))==true){
                    System.out.println(str.substring(i,j));
                }
                
            }
        }
        
        
    }


    public static void insert_difference(String str){
        for(int i=0;i<str.length()-1 ; i++){
            System.out.print(str.charAt(i));
            int ans=str.charAt(i+1)-str.charAt(i);
            System.out.println(ans);

        }
        System.out.print(str.charAt(str.length()-1));
    }

    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        String str=scn.nextLine();
        //sub(str);
        System.out.println(toggle(str));
    }
}