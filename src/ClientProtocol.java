// This is the class that creates the user interface for the client


import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.io.IOException;

public class ClientProtocol extends JFrame
{
    JButton submit = new JButton("Submit");
    JButton exit = new JButton("Exit");
    JLabel inputLabel = new JLabel("Enter input here : ");
    JTextField input = new JTextField();
    JTextArea textArea = new JTextArea();

    public ClientProtocol(String ip, int port) throws IOException
    {
        textArea.setBounds(10,10, 1000,580);
        textArea.setFont(new Font(Font.DIALOG,Font.PLAIN,15));
        textArea.setBackground(new Color(255, 255, 255));
        textArea.setForeground(Color.black);
        textArea.setBorder(new MatteBorder(2, 2, 2, 2,Color.LIGHT_GRAY));

        inputLabel.setBounds(10,600,130,50);
        inputLabel.setFont(new Font(Font.DIALOG,Font.PLAIN,15));
        inputLabel.setBackground(new Color(255, 255, 255));
        inputLabel.setForeground(Color.black);

        input.setBounds(150,600,300,50);
        input.setFont(new Font(Font.DIALOG,Font.PLAIN,15));
        input.setBackground(new Color(255, 255, 255));
        input.setForeground(Color.black);

        submit.setBounds(10,680,200,50);
        submit.setFont(new Font(Font.DIALOG,Font.PLAIN,15));
        submit.setBackground(new Color(255, 255, 255));
        submit.setForeground(Color.black);

        exit.setBounds(250,680,200,50);
        exit.setFont(new Font(Font.DIALOG,Font.PLAIN,15));
        exit.setBackground(new Color(255, 255, 255));
        exit.setForeground(Color.black);

        add(textArea);
        add(inputLabel);
        add(input);
        add(submit);
        add(exit);

        setTitle("Client Protocol");
        setLayout(null);
        setVisible(true);
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SocketClient sc = new SocketClient(ip,port);

        submit.addActionListener(e -> {
            try {

                String inputText = input.getText();
                input.setText(null);

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        });

        exit.addActionListener(e -> System.exit(0));

    }


}
