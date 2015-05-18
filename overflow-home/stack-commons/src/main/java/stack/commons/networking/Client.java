package stack.commons.networking;

import  java.io.*;
import  java.net.*;

class Client 
{
    public static void main(String[] args) 
    {
        try
        {
            String host = "localhost";
            Socket socket = new Socket(host,25000);

            OutputStream os = socket.getOutputStream();

            OutputStreamWriter osw = new OutputStreamWriter(os);

            BufferedWriter bufferedwriter = new BufferedWriter(osw);
            String sendMessage = "hello from Client";

            bufferedwriter.write(sendMessage);
            bufferedwriter.newLine();
           
            bufferedwriter.flush();

            InputStream is = socket.getInputStream();

            InputStreamReader isr = new InputStreamReader(is);

            BufferedReader br = new BufferedReader(isr);

            String input = br.readLine();

            System.out.println("The message recieved from server is : "+ input);
            socket.close();


        }
        catch (Exception e) {
            e.printStackTrace();
        }



    }
}
