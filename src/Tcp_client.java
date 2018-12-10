import java.net.*;
import java.io.*;
public class Tcp_client{
    public static void main(String[] args) throws IOException {
        Socket soc = new Socket("127.0.0.1",4000);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
        String fname;
        System.out.println("Enter the file name");
        fname = br.readLine();
        try{
            OutputStream ostream = soc.getOutputStream();
            PrintWriter pwrite = new PrintWriter(ostream,true);
            pwrite.println(fname);
            InputStream istream = soc.getInputStream();
            BufferedReader contentReader = new BufferedReader(new InputStreamReader(istream));
            String str;
            while((str=contentReader.readLine())!=null){
                System.out.println(str);
            }
            contentReader.close();
            pwrite.close();
            br.close();
        }
        catch(Exception e){
            System.out.println("error occured while in opening the file in client");
        }
    }
}