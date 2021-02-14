import java.util.*;
public class stringss{


    static Scanner scn=new Scanner(System.in);
    
    public static void printChar(String str){
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            System.out.println(ch);
        }
    }

    public static void substring(String str){
        for(int i=0;i<str.length();i++){
            for(int j=i+1 ; j<= str.length() ; j++ ){
                String ch=str.substring(i , j);
                System.out.println(ch);
            }
        }
    }

    public static boolean palindrome(String str){
        int i=0;
        int j=str.length() - 1 ; 
        while(j>=i){
            if(str.charAt(i) != str.charAt(j) ){   // we cannot chcek reverse as it will check on at a time and is it is equal it will return true
                return false;       
            }
            i++;
            j--;
        }
        return true;
    }

    public static void palindromeSubstring(String str){
         for(int i=0;i<str.length();i++){
            for(int j=i+1 ; j<= str.length() ; j++ ){
                String ch=str.substring(i , j);
                if(palindrome(ch) == true){
                    System.out.println(ch);
                }
            }
        }

    }

    public static String toggleChar(String str){
        String ans= "";
        for(int i=0;i<str.length() ; i++){
            char ch=str.charAt(i);
            if(ch>='a' && ch<='z'){
                ch=  (char)(ch - 'a' + 'A' ); //typecasting
            }else{
                ch= (char) ( ch - 'A' + 'a'); 
            }
           ans=ans+ch;
            
        }
        return ans;
    }
    public static String chngascii(String str){
        String ans="";
        for(int i=0;i<str.length() ; i++){
            char ch=str.charAt(i);
            if(i%2 == 0){
                ch=(char) (ch - 1);
            }else{
                ch=( char)  (ch+1);
            }
            ans=ans+ch;
        }
        return ans;
    }
    public static void modify(String str){
        for(int i=0;i<str.length() - 1 ;i++){
            char ch1=str.charAt(i);
            char ch2=str.charAt(i+1);
            System.out.print(ch1);
            int diff = (int ) (ch2 - ch1);
            System.out.print( diff );
        }
        System.out.println(str.charAt(str.length() - 1));
    }

    public static void compress1(String str){
        for(int i=0;i<str.length() - 1  ;i++){
            char ch1=str.charAt(i);
            char ch2=str.charAt(i+1);
            if(ch1!=ch2){
                System.out.print(ch1);
            }
        }
        System.out.println(str.charAt(str.length()-1));
    }

    public static void compress2(String str){
        int counter=1;
        for(int i=0;i<str.length() - 1  ;i++){
            char ch1=str.charAt(i);
            char ch2=str.charAt(i+1);
            if(ch1!=ch2){
                System.out.print(ch1);
                if(counter > 1){
                    System.out.print(counter);
                }
                counter=1;
            }else{
                counter++;
            }
        }
        System.out.print(str.charAt(str.length()-1));
        if(counter > 1){
                    System.out.print(counter);
                }
    }

    



    public static void main(String[] args){
        //String str="aaabbcaaaddeefff";
        
        //printChar(str);
        //substring(str);
        //System.out.println(palindrome(str));
        //palindromeSubstring(str);
        //System.out.println(toggleChar(str));
        //System.out.println(chngascii(str));
        //modify(str);
        //compress2(str);
       
    }
}