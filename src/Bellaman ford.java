import java.io.*;
import java.util.Scanner;
class Bellaman_ford{
     public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         Scanner src = new Scanner(System.in);
         int n=0;
         System.out.println("Enter no of vertices:");
         //n=Integer.parseInt(br.readLine());
        n= src.nextInt();
         int a[][] = new int[n+1][n+1];
         System.out.println("Enter the adjacency matrix: ");
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
             //   a[i][j]=Integer.parseInt(br.readLine());
               a[i][j]=src.nextInt();
            }
        }
        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    if(a[i][j]>a[i][k]+a[k][j]){
                        a[i][j]=a[i][k]+a[k][j];
                    }
                }
            }
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i==j){
                    a[i][j]=0;
                }
            }
        }
        System.out.println("output matrix:");
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                System.out.print(" "+a[i][j]);
            }
            System.out.println();
        }
     }

}