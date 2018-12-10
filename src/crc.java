import java.io.*;
class crc{
    static int[] divide(int[] div,int[] divisor,int[] rem){
        int cur=0;
        while(true){
            for(int i=0;i<divisor.length;i++){
                rem[cur+i]=rem[cur+i]^divisor[i];
            }
            while(rem[cur]==0&&cur!=rem.length-1)
            cur++;
            if((rem.length-cur)<divisor.length)
            break;
        }
        return rem;
    }
     public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] data;
        int[] div;
        int[] rem;
        int[] divisor;
        int[] crc;
        int data_length,divisor_length,total_length;
        System.out.println("Enter the number of data_bits");
        data_length=Integer.parseInt(br.readLine());
        data= new int[data_length];
        System.out.println("Enter the data_bits");
        for(int i=0;i<data_length;i++){
            data[i]=Integer.parseInt(br.readLine());
        }
        System.out.println();
        System.out.println("Enter the length of divisor_bits");
        divisor_length=Integer.parseInt(br.readLine());
        divisor= new int[divisor_length];
        System.out.println("Enter the divisor_bits");
        for(int i=0;i<divisor_length;i++){
            divisor[i] = Integer.parseInt(br.readLine());
        }
        System.out.println();
        total_length=data_length+divisor_length-1;
        div= new int[total_length];
        rem= new int[total_length];
        crc= new int[total_length];
        for(int i=0;i<data_length;i++){
            div[i]=data[i];
        }
        System.out.println("Dividend after appending zero's");
        for(int i=0;i<div.length;i++){
            System.out.println(div[i]);
        }
        for(int i=0;i<rem.length;i++){
            rem[i]=div[i];
        }
        rem=divide(div,divisor,rem);
        /*------CRC GENRATION------*/
        for(int i=0;i<total_length;i++){
            crc[i]=div[i]^rem[i];
        }
        System.out.println("generated crc");
        for(int i=0;i<crc.length;i++){
            System.out.println(crc[i]);
        }
        /*------CRC CHECKER------*/
        System.out.println("Enter the crc _bits of "+total_length+":");
        for(int i=0;i<crc.length;i++){
            crc[i]=Integer.parseInt(br.readLine());
        }
        for(int i=0;i<crc.length;i++){
            rem[i]=crc[i];
        }
        rem= divide(crc,divisor,rem);
        for(int i=0;i<rem.length;i++){
            if(rem[i]!=0){
                System.out.println("ERROR");
                break;
            }
            else if(i==rem.length-1){
                System.out.println("NO ERROR");
            }
        }
    }
}