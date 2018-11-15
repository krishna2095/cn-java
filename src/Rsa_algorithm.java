
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//wrong


/**
 *
 * @author Krishna
 */
public class Rsa_algorithm {
   static int p,q,e,n,Qn,d,m,c;
    public static void main (String[] args){
        
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the values of p & q:");
        p = sc.nextInt();
        q = sc.nextInt();
        n=p*q;
        Qn= (p-1)*(q-1);
        for(int i=2;i<Qn;i++){
            e=i;
            if(gcd(e,Qn)==1){
                System.out.print("public key:"+e);
                break;
            }
        }
        for(int i=0;i<Qn;i++){
            d=i;
            if(((d*e)%Qn)==1)
                break;
            }
            System.out.print("private key:"+d);
            System.out.print("Enter the message:");
            m=sc.nextInt();
            c=(int) Math.pow((double)m, (double)e);
            c= c%n;
            System.out.print("cypherText:"+c);
            m=(int) Math.pow((double)c,(double)d);
            m=m%n;
            System.out.print("decrypted message:"+m);
            
            
        }

    private static int gcd(int e, int Qn) {
                if(Qn==0)
            return e;
        return gcd(Qn,e%Qn);
    }
       
    }
     

