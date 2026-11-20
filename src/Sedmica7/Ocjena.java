package Sedmica7;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ocjena {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton izračunajButton;
    private JPanel panel;
    private JTextField textField6;
    private JLabel polozeno;

    public Ocjena() {
        izračunajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int m1, m2, m3;
                m1=Integer.parseInt(textField2.getText());
                m2=Integer.parseInt(textField3.getText());
                m3=Integer.parseInt(textField4.getText());
                int total = m1 + m2 + m3;
                textField6.setText(String.valueOf(total));
                int ocjena=(total>=95)?10:(total>=85)?9:(total>=75)?8:(total>=65)?7:(total>=55)?6:5;
                textField5.setText(String.valueOf(ocjena));
                polozeno.setText(total>=55?"Student je položio.":"Student nije položio.");            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ocjena");
        frame.setContentPane(new Ocjena().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
