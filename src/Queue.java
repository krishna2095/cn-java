
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Krishna
 */
public class Queue {
            int[] q ;
            int r,ele;
            void insert(int n) throws IOException{
                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                    q = new int[10];
                     for(int i=0;i<n;i++){
                          System.out.println("Enter the element in queue:");
                        ele = Integer.parseInt(br.readLine());
                     if(r+1>10){
                            System.out.println("Queue is full");
                            break;
                        }
                     else{
                            q[i]=ele;
                            r++;
                        }
                      }
         }
    void delete()
    {
        Thread t = new Thread();
        if(r==0){
            System.out.println("queue is empty");
        }
        else{
                for(int i = 0;i<r-1;i++){
                    try {
                        t.sleep(1000);
                    } catch (Exception ex) {}
                    System.out.print("\nLeaked packet  is "+q[i]);
                }
        }
    }
}
   
    class LeakyBucket {
  
   public static void main(String[] ar)throws Exception{   
        int n;
    Scanner sc = new Scanner(System.in);
        Queue q = new Queue();
        System.out.print("Enter the no of elements to be entered:");
        n= sc.nextInt();
        q.insert(n);
        q.delete();
   }   
         
}
   
                    

        

