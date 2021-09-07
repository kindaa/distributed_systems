//This is the logic behind the server

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SocketServer
{
    public SocketServer(int port) throws IOException
    {
        ServerSocket ss = new ServerSocket(port);
        System.out.println("Server Socket is online on port " + port);
        Socket s = ss.accept();
        System.out.println("Connection with client established");

        ArrayList<String> questions = new ArrayList<String>();
        ArrayList<String> responses = new ArrayList<String>();
        questions.add("Enter Student Number : ");
        questions.add("Enter Student Name : ");
        questions.add("Enter Faculty, Course and Degree : ");
        questions.add("Enter Personal Code : ");

        DataInputStream inputData = new DataInputStream(s.getInputStream());
        DataOutputStream outputData = new DataOutputStream(s.getOutputStream());

        for(int i=0; i<4; i++)
        {
            outputData.writeUTF(questions.get(i));
            outputData.flush();

            responses.add(inputData.readUTF());

            outputData.writeUTF("Response received : " + responses.get(i));
        }

    }

}
