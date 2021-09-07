//This class is used to implement multithreading in the system to enable the two connections run parralely

import java.io.IOException;

public class ServerThread extends Thread
{
    int port;

    public ServerThread(int portNumber )
    {
        port = portNumber;
    }
    public void run()
    {
        try {
            ServerProtocol ss = new ServerProtocol(port);

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
