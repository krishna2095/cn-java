import java.net.*;
import java.util.Scanner;
class udps{
    public static void main(String[] args) {
        DatagramSocket skt;
        Scanner input = new Scanner(System.in);
        String ch;
        try{
            skt= new DatagramSocket(6788);
            while(true){
                byte[] buffer = new byte[1000];
                DatagramPacket request = new DatagramPacket(buffer,buffer.length);
                skt.receive(request);
                System.out.println("Enter the data");
                ch=input.nextLine();
                byte[] sendmsg = (ch+"server processed").getBytes();
                DatagramPacket reply = new DatagramPacket(sendmsg,sendmsg.length,request.getAddress(),request.getPort());
                skt.send(reply);
            }
        }
        catch(Exception ex){}
    }
}