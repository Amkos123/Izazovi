import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    private JTextField textField1;
    private JButton a0Button;
    private JButton a2Button;
    private JButton a3Button;
    private JButton decimalBtn;
    private JButton a1Button1;
    private JButton ACButton;
    private JButton a4Button;
    private JButton a5Button;
    private JButton a6Button;
    private JButton a7Button;
    private JButton a8Button;
    private JButton a9Button;
    private JButton modBtn;
    private JButton ABSBtn;
    private JButton percentBtn;
    private JButton divideBtn;
    private JButton multiplyBtn;
    private JButton subBtn;
    private JButton addBtn;
    private JButton equalsBtn;
    private JPanel panel;
    private double firstNum = 0.0;
    private double secondNum = 0.0;
    private double result = 0.0;
    private String operator = "";
    private boolean isnewOperation = true;
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(new Calculator().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
    private void clear() {
        textField1.setText("0");
        firstNum = 0.0;
        secondNum = 0.0;
        result = 0.0;
        operator = "";
        isnewOperation = true;
    }
    private void calculateResult() {
        if (operator.isEmpty()) return;
        secondNum = Double.parseDouble(textField1.getText());
        double result = switch (operator) {
            case "+" -> firstNum + secondNum;
            case "-" -> firstNum - secondNum;
            case "*" -> firstNum * secondNum;
            case "/" -> secondNum != 0 ? firstNum / secondNum : 0;
            case "%" -> secondNum != 0 ? firstNum % secondNum : 0;
            default -> 0;
        };
        textField1.setText(String.valueOf(result));
        firstNum = result;
        operator = "";
        isnewOperation = true;
    }
    private void setOperator(String op) {
        if (!operator.isEmpty()) {
            calculateResult();
        }
        firstNum = Double.parseDouble(textField1.getText());
        operator = op;
        isnewOperation = true;
    }
    private class NumberListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String value = ((JButton) e.getSource()).getText();
            if (isnewOperation) {
                textField1.setText(value);
                isnewOperation = false;
            } else {
                textField1.setText(textField1.getText() + value);
            }
        }
    }
    private void addDecimalPoint() {
        String text = textField1.getText();
        if (isnewOperation) {
            textField1.setText("0.");
            isnewOperation = false;
        } else if (!text.contains(".")) {
            textField1.setText(text + ".");
        }
    }
    private void applyPercent(){
        double result=Double.parseDouble(textField1.getText())/100;
        textField1.setText(String.valueOf(result));
    }



    private void applyAbs() {
        double value = Double.parseDouble(textField1.getText());
        textField1.setText(String.valueOf(-value));
    }



    public Calculator(){
        ActionListener numberListener=new NumberListener();
        a0Button.addActionListener(numberListener);
        a1Button1.addActionListener(numberListener);
        a2Button.addActionListener(numberListener);
        a3Button.addActionListener(numberListener);
        a4Button.addActionListener(numberListener);
        a5Button.addActionListener(numberListener);
        a6Button.addActionListener(numberListener);
        a7Button.addActionListener(numberListener);
        a8Button.addActionListener(numberListener);
        a9Button.addActionListener(numberListener);
        percentBtn.addActionListener(e->applyPercent());
        ABSBtn.addActionListener(e->applyAbs());
        decimalBtn.addActionListener(e->addDecimalPoint());
        addBtn.addActionListener(e->setOperator("+"));
        subBtn.addActionListener(e->setOperator("-"));
        multiplyBtn.addActionListener(e->setOperator("*"));
        divideBtn.addActionListener(e->setOperator("/"));
        modBtn.addActionListener(e->setOperator("%"));

        ACButton.addActionListener(e->clear());
        equalsBtn.addActionListener(e->calculateResult());
        textField1.setHorizontalAlignment(SwingConstants.RIGHT);
    }

}
