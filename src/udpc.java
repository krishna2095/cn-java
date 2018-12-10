import java.net.*;
class udpc{
    public static void main(String[] args) {
        DatagramSocket skt;
        try{
            skt = new DatagramSocket();
            String msg = "text message";
            byte[] b = msg.getBytes();
            InetAddress host = InetAddress.getByName("127.0.0.1");
            int serversocket = 6788;
            DatagramPacket request = new DatagramPacket(b,b.length,host,serversocket);
            skt.send(request);
            byte[] buffer= new byte[1000];
            DatagramPacket reply = new DatagramPacket(buffer,buffer.length);
            skt.receive(reply);
            System.out.println("client recived"+new String(reply.getData()));
        }
         catch(Exception e){}
    }
   
}