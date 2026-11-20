package Sedmica7;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Konverter {
    private JPanel panel1;
    private JButton izračunajButton;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JComboBox comboBox2;
    private JLabel konvertovaniIznos;

    public Konverter() {
        comboBox1.addItem("KM");
        comboBox1.addItem("USD");
        comboBox1.addItem("EUR");
        comboBox1.addItem("GBP");
        comboBox2.addItem("KM");
        comboBox2.addItem("USD");
        comboBox2.addItem("EUR");
        comboBox2.addItem("GBP");
        izračunajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tekst = textField1.getText().trim();
                tekst = tekst.replace(',', '.');

                try {
                    double iznos = Double.parseDouble(tekst);

                    if (!Double.isFinite(iznos) || iznos < 0) {
                        JOptionPane.showMessageDialog(null, "Unesite ispravan pozitivan iznos");

                    }
                    double rezultat = izračun(iznos);
                    konvertovaniIznos.setText(String.format("%.2f", rezultat));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Unesite ispravan broj");

                }
            }
            });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Konverter");
        frame.setContentPane(new Konverter().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private double izračun(double iznos) {
        String valuta =comboBox1.getSelectedItem().toString();
        double kurs = 1.0;
        switch (valuta) {
            case "KM":
                kurs = 1.0;
                break;
            case "USD":
                kurs = 0.55;
                break;
            case "EUR":
                kurs = 0.51;
                break;
            case "GBP":
                kurs = 0.43;
                break;

        }


            double iznosUKM = iznos / kurs;
        valuta =comboBox2.getSelectedItem().toString();
        switch (valuta) {
            case "KM":
                kurs = 1.0;
                break;
            case "USD":
                kurs = 0.55;
                break;
            case "EUR":
                kurs = 0.51;
                break;
            case "GBP":
                kurs = 0.43;
                break;

        }
            double rezultat = iznosUKM * kurs;
            return rezultat;

    }

}
