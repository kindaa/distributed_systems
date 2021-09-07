// This is the class that creates the user interface to start up the system.

import javax.swing.*;
import java.awt.*;

public class Startup extends JFrame
{
    JButton submit = new JButton("Submit");
    JButton exit = new JButton("Exit");
    JLabel ipLabel = new JLabel("Enter Server IP address : ");
    JTextField ip = new JTextField();
    JLabel portLabel = new JLabel("Enter Port number : ");
    JTextField port = new JTextField();
    JLabel windows = new JLabel("Select the windows to launch : ");
    JCheckBox client = new JCheckBox("Client");
    JCheckBox server = new JCheckBox("Server");

    public Startup()
    {
        ipLabel.setBounds(10,10,200,50);
        ipLabel.setFont(new Font(Font.DIALOG,Font.PLAIN,15));
        ipLabel.setBackground(new Color(255, 255, 255));
        ipLabel.setForeground(Color.black);

        ip.setBounds(200,10,200,40);
        ip.setFont(new Font(Font.DIALOG,Font.PLAIN,15));
        ip.setBackground(new Color(255, 255, 255));
        ip.setForeground(Color.black);

        portLabel.setBounds(10,80,200,50);
        portLabel.setFont(new Font(Font.DIALOG,Font.PLAIN,15));
        portLabel.setBackground(new Color(255, 255, 255));
        portLabel.setForeground(Color.black);

        port.setBounds(200,80,200,40);
        port.setFont(new Font(Font.DIALOG,Font.PLAIN,15));
        port.setBackground(new Color(255, 255, 255));
        port.setForeground(Color.black);

        windows.setBounds(10,140,250,40);
        windows.setFont(new Font(Font.DIALOG,Font.PLAIN,15));
        windows.setBackground(new Color(255, 255, 255));
        windows.setForeground(Color.black);

        server.setBounds(250,140,100,40);
        server.setFont(new Font(Font.DIALOG,Font.PLAIN,15));
        server.setBackground(new Color(255, 255, 255));
        server.setForeground(Color.black);

        client.setBounds(350,140,100,40);
        client.setFont(new Font(Font.DIALOG,Font.PLAIN,15));
        client.setBackground(new Color(255, 255, 255));
        client.setForeground(Color.black);

        submit.setBounds(10,200,200,50);
        submit.setFont(new Font(Font.DIALOG,Font.PLAIN,15));
        submit.setBackground(new Color(255, 255, 255));
        submit.setForeground(Color.black);

        exit.setBounds(250,200,200,50);
        exit.setFont(new Font(Font.DIALOG,Font.PLAIN,15));
        exit.setBackground(new Color(255, 255, 255));
        exit.setForeground(Color.black);

        add(ipLabel);
        add(ip);
        add(portLabel);
        add(port);
        add(windows);
        add(client);
        add(server);
        add(submit);
        add(exit);

        setTitle("Startup");
        setLayout(null);
        setSize(500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        submit.addActionListener(e -> {
            try {
                int portNumber = Integer.parseInt(port.getText().trim());
                String ipAddress = ip.getText().trim();

                dispose();

                if(server.isSelected())
                {
                    ServerThread sp = new ServerThread(portNumber);
                    sp.start();
                }

                if(client.isSelected())
                {
                    ClientThread cp = new ClientThread(ipAddress,portNumber);
                    cp.start();
                }

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        });

        exit.addActionListener(e -> System.exit(0));
    }

    public static void main(String[] args)
    {
        Startup st = new Startup();
        st.setVisible(true);
    }

}
