import java.net.*;
import java.io.*;
public class  TCP_server{
    public static void main(String[] args) throws IOException{
        try{
        ServerSocket sersoc = new ServerSocket(4000);
        System.out.println("Server is ready for connection");
        Socket soc = sersoc.accept();
        System.out.println("Connection is succesful");
        InputStream istream = soc.getInputStream();
        BufferedReader filename = new BufferedReader(new InputStreamReader(istream));
        String fname;
        fname= filename.readLine();
        OutputStream ostream = soc.getOutputStream();
        PrintWriter pwrite = new PrintWriter(ostream,true);
        BufferedReader contentReader = new BufferedReader(new FileReader(fname));
        String str;
        while((str=contentReader.readLine())!=null){
            pwrite.println(str);
        }
        pwrite.close();
        contentReader.close();
        filename.close();
        }
        catch(Exception e){
            System.out.println("Error occured while opening the file in server");
        }
    }
}