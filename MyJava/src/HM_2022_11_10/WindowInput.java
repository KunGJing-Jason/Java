package HM_2022_11_10;
import java.awt.*;
import javax.swing.*;

public class WindowInput extends JFrame{
    public JTextField InputText;
    public JTextArea OutputText;
    PoliceListen listener;
    public WindowInput(){
        Init();
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    void Init(){
        setLayout(new FlowLayout());
        Font font = new Font("微软雅黑",Font.PLAIN,20);
        InputText = new JTextField(30);
        InputText.setFont(font);
        OutputText = new JTextArea(15,30);
        OutputText.setBackground(Color.lightGray);
        OutputText.setFont(font);

        listener = new PoliceListen();
        listener.setInput(this);
        InputText.addActionListener(listener);
        add(InputText);
        add(OutputText);
        add(new JScrollPane(OutputText));
    }
}

