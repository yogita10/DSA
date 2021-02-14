import java.util.*;
public class recursion { 

    static Scanner scn=new Scanner(System.in);
    
    public static void printDecreasing(int n){
        if(n==0){
            return;
        }
        System.out.print(n + " ");
        printDecreasing(n-1);
    }

    public static void printIncreasing(int n){
        if(n==0){
            return;
        }
        printIncreasing(n-1);
        System.out.print(n + " ");
    }

    public static void printDecreasingIncreasing(int n){
        if(n==0){
            return;
        }
        System.out.print(n+ " ");
        printDecreasingIncreasing(n-1);
        System.out.print(n+ " ");
    }

    public static int factorial(int n){
        if(n==1){
            return 1;
        }
        int i=1;
        i=n*factorial(n-1);
        return i;
    }

    public static int powerlinear(int n , int x){
        if(n==0){
            return 1;
        }
        int a=powerlinear(n-1 , x);
        int b= x*a;
        return b;
        }

        public static int powerlogarithmic(int x , int n){
            if(n==0){
                return 1;
            }
            int a= powerlogarithmic(n/2 , x );
            if(n%2==0){
                
                int b= a*a;
                return b;
            }
          int b=a*a*x;
          return b;
            
        }

        public static void towerOfHanoi(int n, String source ,String helper , String destination){
            if(n==0){
                return;
            }
            towerOfHanoi(n-1 , source, destination , helper );
            System.out.println(n + " " + source + " to " + destination );
            towerOfHanoi(n-1 , helper , source , destination); //faith 
        }

        public static void displayAnArray(int[] arr, int i){
            if(i==arr.length){
                return;
            }
            System.out.println(arr[i]);
            displayAnArray(arr , i+1);

        }

        public static void displayReverseInArray(int[] arr , int i){
            if(i==arr.length){
                return;
            }
            displayReverseInArray(arr , i+1);
            System.out.println(arr[i]);
        }

        public static int maxInArray(int[] arr ,int i){
            if(i==arr.length-1){  //last me voh no. khud hi max h uske aage kuch h hi nhi
                return arr[i];
            }
            int a=maxInArray(arr,i+1);
            if(arr[i] < a){
             return a;
            }
            return arr[i];
        }

        public static int firstOcc(int[] arr, int i , int x){
            if(i==arr.length){
                return -1;
            }
            //phle humne work kara and then call lagayi 
            //our work
            //pre area work
            if(arr[i]==x){  //phle call laga ke humne optimize kara jaate hue check krega
                return i;     //agar hum function call ke baad check krte toh vaapis aate hue check krta and we dont need it . kyunki first index chahiye . phle hi mil jayega end tak jaane ki zarurat ni h.
            }else{
                //baad me call
            int a=firstOcc(arr, i+1 , x);
            return a;
            }
        }

        public static int lastOcc(int[] arr , int i , int d){
            if(i==arr.length){
                return -1;
            }
            int a=lastOcc(arr , i+1 , d);
            if(a == -1){
                if(arr[i]==d){
                    return i;
                }
                else{
                    return -1;
                }
            }
            else{
                return a;
            }
        }

        public static int[] allIndices(int[] arr , int i , int d ,int fsf){
            if(i==arr.length){
                int[] ans=new int[fsf];  //jitni value fsf ki hogi utni baar d aya h 
                return ans;
            }
            if(arr[i]==d){
               int[] ans = allIndices(arr , i+1, d,fsf+1);
                   ans[fsf]=i;
                   return ans;
            }else{
               int[] ans = allIndices(arr , i+1 ,d ,fsf);
               return ans;
            }
 }


 public static void getkpc(String str , String[] codes , String ans){
        if(str.length()==0){
            System.out.println(ans);
            return;
        }

        char ch=str.charAt(0);
        String roq=str.substring(1);
        String codeforch = codes[ch-'0'];
        for(int i=0;i<codeforch.length();i++){
            char cho=codeforch.charAt(i);
            getkpc(roq ,codes , ans+cho);
        }

    }

    public static ArrayList<String> getKeyPad(String str , String[] codes){
        if(str.length() == 0){
            ArrayList<String> bres = new ArrayList<>();
            bres.add(""); //when no button is pressed a blank string is added . consider this as we consider 2^0 . 
                          // in this the size of array is 1 but the string inside it is blank. 
             return bres;             
        }

        char ch=str.charAt(0);
        String ros = str.substring(1);
        ArrayList<String> recAns=getKeyPad(ros , codes);
        ArrayList<String> myAns=new ArrayList<>();

        String codesforch=codes[ch-'0'];
        for(int i=0;i<codesforch.length();i++){
            char chcode=codesforch.charAt(i);
            for(int j=0 ; j<recAns.size() ; j++){
                myAns.add(chcode + recAns.get(j)); 
            }
        }
          
          return myAns;
    }

    public static void printStairCase(String str , int n){
        if(n==0){
            System.out.println(str);
            return;
        }
        if(n-1>=0){
        printStairCase("1" + str , n-1);
        }
        if(n-2>=0){
        printStairCase("2" + str , n-2);
        }
        if(n-3>=0){
        printStairCase("3" + str , n-3);
        }
    }

    public static ArrayList<String>  getStairCase(int n ){

        if(n==0){
            ArrayList<String> myans = new ArrayList<>();
            myans.add("");
            return myans;
        }
        ArrayList<String> ans = new ArrayList<>();
        for(int jump=1 ; n-jump>=0 && jump<=3;jump++){
       ArrayList<String> recAns = getStairCase(n-jump);
       for(int x=0;x<recAns.size();x++){
           ans.add(jump+recAns.get(x));
       }

   }
   return ans; 

    }

    public static void printMazePath(int sr , int er , int sc , int ec , String path){
        if(sr > er || sc>ec){
            return;
        }
        
        if(sc==ec && sr==er){
            System.out.println(path);
            return;
        }
        printMazePath(sr+1 ,er,sc,ec,path+"v");
        printMazePath(sr , er , sc+1 , ec , path+"h");

         

    }

    public static void printMazePathWithJumps(int sr , int sc , int er , int ec , String path){
        if(sr==er && sc==ec){
            System.out.println(path);
            return;
        }
        for(int i=1;i<=ec-sc ; i++){
            printMazePathWithJumps(sr, sc+1 , er ,ec ,path+"h"+i);
        }
        for(int i=1;i<=er-sr;i++){
            printMazePathWithJumps(sr+1 , sc , er ,ec , path+"v"+i);
        }
        for(int i=1;i<=er-sr && i<=ec-sc ; i++){
            printMazePathWithJumps(sr+1 , sc+1 ,er , ec , path+"d"+i);
        }
    }

    public static void permutation(String str , String ans){
        if(str.length()==0){
            System.out.println(ans);
            return;
        }

        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            String lp=str.substring(0,i);
            String rp=str.substring(i+1);
            String roq=lp+rp;
            permutation(roq , ans+ch);
        }
    }

    public static void floodfill(int[][] maze , int row , int col , String path , boolean[][] visited){
        if(row < 0 || col < 0 || row==maze.length || col==maze[0].length || maze[row][col]==1 || visited[row][col]==true){
            return;
        }
        if(row==maze.length -1 && col==maze[0].length-1){
            System.out.println(path);
            return;
        }

        visited[row][col]=true;
        floodfill(maze , row-1 , col , path+"t",visited);
        floodfill(maze , row , col-1 , path+"l",visited);
        floodfill(maze , row+1 , col , path+"d",visited);
        floodfill(maze , row , col+1 , path+"r",visited);
        visited[row][col]=false;

    }

    public static void nQueens(int[][] chess , String path , int row){
        if(row==chess.length){
            System.out.println(path + "");
            return;
        }

        for(int col=0;col<chess.length;col++){
            if(isItaSafePlaceForTheQueens(chess ,row , col)==true){
                chess[row][col]=1;
                nQueens(chess , path+row+col+" " ,row+1);
                chess[row][col]=0;
            }
        }
    }

    public static boolean isItaSafePlaceForTheQueens(int[][] chess , int row , int col){
        for(int i=row-1,j=col;i>=0;i--){
            if(chess[i][j]==1){
                return false;
            }
        }
        for(int i=row-1 , j=col-1 ; i>=0 && j>=0 ; i-- ,j--){
            if(chess[i][j]==1){
                return false;
            }
        }
        for(int i=row-1 , j=col+1 ; i>=0 && j<chess.length ; i-- , j++){
            if(chess[i][j]==1){
                return false;
            }
        }

        return true;

    }


    public static void main(String[] args){

        int n=scn.nextInt();
        //int x=scn.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<arr.length;i++){
          arr[i]=scn.nextInt();
        }
        //int d=scn.nextInt();
        //printDecreasing(n);
        //printIncreasing(n);
        //printDecreasingIncreasing(n);
        //System.out.println(factorial(n));
        //System.out.println(powerlinear(n, x));
        //towerOfHanoi(n,"Source","Helper","Destination");
        //displayAnArray(arr,0);
        //displayReverseInArray(arr ,0);
        System.out.println(maxInArray(arr,0));
        //System.out.println(firstOcc(arr , 0 , d));
        //System.out.println(lastOcc(arr , 0 , d));
        //int[] ans = allIndices(arr, 0 ,d, 0);
        //for(int i=0;i<ans.length;i++){
          //  System.out.print(ans[i] + " ");
        //}
        //String str="678";
        //String[] codes = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"}; //we use this because this acts as an array of strings.
         //ArrayList<String> get = getKeyPad(str , codes);
        //System.out.println(get);
        //getkpc(str , codes , "");
        //printStairCase("" , n);
        //ArrayList<String> abc = getStairCase(n);
        //System.out.print(abc);
        //printMazePath(1,3,1,3,"");
        //printMazePathWithJumps(1,1,3,3,"");
        //permutation("abc","");
        // int n=scn.nextInt();
        // int m=scn.nextInt();
        // int[][] arr=new int[n][m];
        // for(int i=0;i<arr.length;i++){
        //     for(int j=0;j<arr[0].length;j++){
        //         arr[i][j]=scn.nextInt();
        //     }
        // }
        //boolean[][] visited = new boolean[n][m];
        //floodfill(arr , 0, 0 , "" , visited);
        //nQueens(arr , "" , 0);

    }
}