package stack.commons.networking;

import java.io.*;
import java.net.*;

class Server 
{
    private static Socket socket;
    public static void main(String[] args) 
    {
        try 
        {
            ServerSocket serverSocket = new ServerSocket(25000);
            System.out.println("Server started listening at port 25000");
            socket = serverSocket.accept();

            InputStream is = socket.getInputStream();

            InputStreamReader isr = new InputStreamReader(is);

            BufferedReader br = new BufferedReader(isr);

            String input = br.readLine();

            System.out.println("The message recieved from client is : "+ input);


            OutputStream os = socket.getOutputStream();

            OutputStreamWriter osw = new OutputStreamWriter(os);

            BufferedWriter bufferedwriter = new BufferedWriter(osw);
            String sendMessage = "hello from Server";

            bufferedwriter.write(sendMessage);
            bufferedwriter.newLine();
            bufferedwriter.flush();


            socket.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
