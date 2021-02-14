import java.util.*;
public class linkedlist{
    
    //humari banayi hui data type 
    //blueprint - class kaobject banega jb bhi toh usme data and next aayega 
    //prototype
    public static class Node{
        int data;
        Node next;
    }
    //saare nodes ka data rakhegi
    //summary of all linked list
    public static class LinkList{
        Node head; //first node ka address //initailly null
        Node tail; //last node ka address  //initially null
        int size;  //size of linkedlist    //initially 0


      //functions in this calss are beahviour for eg. 
      //main values ko manipulate krne ke kaam aateh func.
        public void addlast(int val){
            Node temp=new Node();
            temp.data=val;
            temp.next=null;
            if(size==0){
                head=temp;
                tail=temp; 
            }else{
                tail.next=temp;
                tail=temp;
            }
            size++;
        }

        public int size(){
            return size;
        }
        public void display(){
            Node temp=head;
            while(temp!=null){
                System.out.print(temp.data+" ");
                temp=temp.next;
            }
            System.out.println();
        }

        public void removefirst(){
            if(size==1){
                head=tail=null;
                size--;
                return;   
            }else if(size<1){
                System.out.print("Underflow");
                return;
            }else{
            Node temp=head;
            head=head.next;
            temp.next=null;  //we need todelete the whole address including the pointr to the first nde so that nobody can acceess that in future and our data remains safe. 
            size--;
            }
        }
        
        public int getfirst(){
            if(size==0){
                System.out.println("List is empty");
                return -1;
            }else{
              return head.data;
            }
        }
        public int getlast(){
            if(size==0){
                System.out.println("List is empty");
                return -1;
            }else{
               return tail.data;
            }
        }
        public int getAt(int idx){
            if(size==0){
                System.out.println("List is empty");
                return -1;
            }else if(idx<0 || idx>=size){
                System.out.println("Invalid Arguments");
                return -1;
            }else{
                Node temp=head;
                for(int i=0;i<idx;i++){
                    temp=temp.next;
                }
                return temp.data;
            }

        }

        public void addfirst(int val){
           Node temp=new Node();
                temp.data=val;
           if(size==0){
                head=tail=temp;    
            }else{
                temp.next=head;
                head=temp;
            }
            size++;
        }

        public void addAt(int idx,int val){
            if(idx<0 || idx>size){
                System.out.println("Invalid argumemts");
            }else if(idx==0){
                addfirst(val);
            }else if(idx==size){
                addlast(val);
            }else{
                Node x=new Node();
                x.data=val;
                Node temp=head;
                for(int i=0;i<idx-1;i++){
                    temp=temp.next;
                }
                x.next=temp.next;
                temp.next=x;
                size++;
            }
        }

        public void removelast(){
            if(size==0){
                System.out.println("Underflow");
                return;
            }else if(size==1){
                head=tail=null;
                size--;
            }else {
                Node temp=head;
                while(temp.next.next!=null){
                    temp=temp.next;
                }
                temp.next=null;
                tail=temp;
                size--;
            }
        }

        public void removeAt(int idx){
            if(idx<0 || idx>=size){
                System.out.println("Invalid arguments ");
            }else if(idx==0){
                removefirst();
            }else if(idx==size-1){
                removelast();
            }else{
                Node temp=head;
                for(int i=0;i<idx-1;i++){
                    temp=temp.next;
                }
                //it is not used because data permanently delete ni hota h , koi aur hamara data use kar skta h isliye it is necessary to remove that permanently 
                //temp.next=temp.next.next;
                Node rem=temp.next;
                temp.next=rem.next;
                rem.next=null;
                size--;
            }
        }
        //private functions are those jo class ke bahar se call nhi kare jaa skte h  
        //get node at function will return the whole node of a particular index not just the data value of that index.
        public Node getNodeAt(int idx){
            Node temp=head;
            for(int i=0;i<idx;i++){
                temp=temp.next;
            }
            return temp; 
        }
 
        public void reverseDI(){
            int i=0;
            int j=size-1;
            while(i<j){
                Node left=getNodeAt(i);
                Node right=getNodeAt(j);
                int temp=left.data;
                left.data=right.data;
                right.data=temp;
                i++;
                j--;
            }

        }
       
       //Time Complexity -O(n)
        public void reversePI(){
            Node prev=null;
            Node curr=head;
            while(curr!=null){
               Node temp=curr.next;  //we need to save curr.next cox curr=curr.next will not work every time 
               curr.next=prev;
               prev=curr;
               curr=temp;
            }
            tail=head;
            head=prev;
        }

        public int kthElementFromLast(int k){
            Node slow=head;
            Node fast=head;
            for(int i=0;i<k;i++){
                fast=fast.next;
            }
            while(fast!=tail){
                slow=slow.next;
                fast=fast.next;
            }
            return slow.data;
        }

        public int mid(){
            Node slow=head;
            Node fast=head;
            while(fast.next!=null && fast.next.next!=null){
                slow=slow.next;
                fast=fast.next.next;
            }
            return slow.data;
        }

        public static LinkList mergetwosortedlist(LinkList l1 , LinkList l2){
            Node one=l1.head;
            Node two=l2.head;
            LinkList l3=new LinkList();
            while(one!=null && two!=null){
            if(one.data < two.data){
                l3.addlast(one.data);
                one=one.next;
            }else{
                l3.addlast(two.data);
                two=two.next;
            }
            }
            while(one!=null){
                l3.addlast(one.data);
                one=one.next;
            }
            while(two!=null){
                l3.addlast(two.data);
                two=two.next;
            }

            return l3;
        }

        public static Node midNode(Node head, Node tail){
            Node fast=head;
            Node slow=head;
            while(fast!=tail && fast.next!=tail){
                fast=fast.next.next;
                slow=slow.next;
            }
            return slow;
        }

        public static LinkList mergesort( Node head , Node tail){
            if(head==tail){
                LinkList ans=new LinkList();
                ans.addlast(head.data);
                return ans;
            }
            
            //mid node nikalenge kyunki hume hame head aur tail bhi node me h isliye pass krne ke liye
            Node mid=midNode(head,tail);
            //first half- sorted faith
            LinkList fh=mergesort(head,mid);
            //second half - sorted faith
            LinkList sh=mergesort(mid.next,tail);

            LinkList a=LinkList.mergetwosortedlist(fh,sh);

            return a;
        }

        public void removeDublicates(){
            LinkList temp=new LinkList();
            while(this.size > 0){
                int val=this.getfirst();  //this.head.data 
                this.removefirst();
                if(temp.head==null || temp.tail.data!=val){
                    temp.addlast(val);
                }
            }

            this.head=temp.head;
            this.tail=temp.tail;
            this.size=temp.size;
        }

        public void oddeven(){
            LinkList odd=new LinkList();
            LinkList even=new LinkList();

            while(this.size > 0){
                int val=this.getfirst();
                this.removefirst();
                if(val%2 == 0 ){
                    even.addlast(val);
                }else{
                    odd.addlast(val);
                }
            }

            if(odd.head!=null && even.head!=null){
                odd.tail.next=even.head;
                this.head=odd.head;
                this.tail=even.tail;
        }else if(odd.head==null){
            this.head=even.head;
            this.tail=even.tail;
        }else {
            this.head=odd.head;
            this.tail=odd.tail;
        }

        this.size=odd.size + even.size ; 
    }

    public boolean isplaindrome(){
        if(this.size<=1){
            return true;
        }
        Node mid=midNode(this.head,this.tail) ;
        LinkList helper=new LinkList();
        helper.head=mid.next;
        helper.tail=this.tail;
        helper.size=this.size/2;

        mid.next=null;
        helper.reversePI();
        Node t1=this.head;
        Node t2=helper.head;
        boolean ispalin = true;

        while(t1!=null && t2!=null){
            if(t1.data!=t2.data){
                ispalin=false;
                break;
            }
            t1=t1.next;
            t2=t2.next;
        }

        helper.reversePI();
        mid.next=helper.head;

        return ispalin;
    }


    public void fold(){
        Node mid = midNode(this.head , this.tail);
        LinkList helper=new LinkList();
        helper.head=mid.next;
        helper.tail=this.tail;
        helper.size=this.size/2;   //helper.size==0
        mid.next=null;
        helper.reversePI();
        Node t1=this.head;
        Node t2=helper.head;
        while(t1!=null && t2!=null){
            Node t1n=t1.next;
            Node t2n=t2.next;
            t1.next=t2;
            t2.next=t1n;
            t1=t1n;
            t2=t2n;
        }
        if(this.size % 2 == 0 ){
            this.tail=helper.tail;
        }else{
            this.tail=mid;
        }
    }

    public static int findIntersection(LinkList one , LinkList two){
        Node t1=one.head;
        Node t2=two.head;
        if(one.size > two.size){
            int diff=one.size-two.size;
            while(diff > 0){
                t1=t1.next;
                diff--;
            }
        }else{
            int diff=two.size-one.size;
            while(diff > 0 ){
                t2=t2.next;
                diff--;
            }
        }
        while(t1!=t2){
            t1=t1.next;
            t2=t2.next;
        }

        return t1.data;
    }
    }
    
    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        LinkList l1=new LinkList();
        LinkList l2=new LinkList();
        int t1=scn.nextInt();
        while(t1>0){
        int val=scn.nextInt();
        l1.addlast(val);
        t1--;
        }
        l1.display();
        System.out.println(l1.size());
        // l1.removeDublicates();
        // l1.oddeven();
        // l1.display();
        // System.out.println(l1.size());
        //System.out.println(l1.isplaindrome());
        //l1.fold();
        //l1.display();

        int t2=scn.nextInt();
        while(t2>0){
        int val=scn.nextInt();
        l2.addlast(val);
        t2--;
        }
        l2.display();
        System.out.println(l2.size());  

        int ans= LinkList.findIntersection(l1,l2);
        System.out.println(ans);

        // LinkList ans = LinkList.mergetwosortedlist(l1,l2);
        // ans.display();
        // System.out.println(ans.size());

        //LinkList ans=LinkList.mergesort(l1.head , l1.tail);
        //ans.display();

        //l1.removefirst();
        //int idx=scn.nextInt();
        //int val=scn.nextInt();
        //l1.addfirst(val);
        //l1.addAt(idx,val);
        //l1.removelast();
        //l1.removeAt(idx);
        //l1.reverseDI();
        //l1.reversePI();
        //int k=scn.nextInt();
        //System.out.println(l1.kthElementFromLast(k));
        //System.out.println(l1.mid());
        //l1.display();
        //System.out.println(l1.size());
        // int idx=scn.nextInt();
        // System.out.println(l1.getfirst());
        // System.out.println(l1.getlast());
        // System.out.println(l1.getAt(idx));
    }
}