import java.io.*;
import java.util.Scanner;
 class queue{
    int q[],r=0;
    void insert(int n){
        Scanner src = new Scanner(System.in);
        q =new int[10];
        for(int i=0;i<n;i++){
            System.out.println("Enter the "+i+"element");
            int ele = src.nextInt();
            if(r+1>10){
                System.out.println("Queue is full \n Leaked packet:"+ele);
                break;
            }
            else{
                r++;
                q[i]=ele;
            }
        }
    }
    void delete(){
        Thread t = new Thread();
        for(int i=0;i<r;i++){
            try{
                t.sleep(1000);
            }
            catch(Exception e){}
            System.out.println("Leaked packet"+q[i]);
        }
    }
}
public class LeakyBucket {
    public static void main(String[] args) throws IOException {
            queue q= new queue();
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the number of packets to be inserted:");
            int n= input.nextInt();
            q.insert(n);
            q.delete();
        }
}