import java.io.*;
import java.util.Scanner;
import java.math.*;
class rsa{
    static double gcd(double number1, double number2){
        if(number2==0){
            return number1;
        }
        return gcd(number2,number1%number2);
    }
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        Double p,q,pn,n,msg,cipher,ptext;
        int publickey=0,d=0;
        System.out.println("Enter the no:");
        p= input.nextDouble();
        q= input.nextDouble();
        n=(p*q);
        pn=(p-1)*(q-1);
        for(int e=2;e<pn;e++){
            if(gcd(e,pn)==1){
                publickey=e;
                System.out.println("Public key:"+e);
                break;
            }
        }
            for(int i=0;i<pn;i++){
                d=i;
                if(((d*publickey)%pn)==1)
                break;
            }
            System.out.println("private key:"+d);
            System.out.println("Enter the message:");
            msg = input.nextDouble();
            cipher= (double)Math.pow(msg,publickey);
            cipher= cipher%n;
            System.out.println("The Encrypted message:"+cipher);
            ptext = (double)Math.pow(cipher,d);
            ptext= ptext%n;
            System.out.println("The Decrypted message:"+ptext);
        }
    }
