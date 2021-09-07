import java.io.*;
import java.net.*;
import java.util.Scanner;

public class SocketClient
{
    public SocketClient(String ip, int port ) throws IOException
    {
        Socket s = new Socket(ip ,port);
        System.out.println("Connection with server established");

        String question;
        DataInputStream inputData = new DataInputStream(s.getInputStream());
        DataOutputStream outputData = new DataOutputStream(s.getOutputStream());

        for(int i=0; i<4; i++)
        {
            question = inputData.readUTF();
            System.out.println(question);

            Scanner inputScanner = new Scanner(System.in);

            outputData.writeUTF(inputScanner.nextLine());
            outputData.flush();
        }

    }

}
