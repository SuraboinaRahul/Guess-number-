import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GuessNumber {
    JButton button;
    JButton button1;
    JTextField num;
    JTextField message;
    JTextField key;
    JPanel panel;
    int num2;

    public GuessNumber() {
        button = new JButton("Guess");
        button1 = new JButton("Show");
        num = new JTextField(5);
        message = new JTextField(30);
        key = new JTextField(5);
        panel = new JPanel();
        panel.add(new JLabel("ENTER NUMBER "));
        panel.add(num);
        panel.add(button);
        panel.add(message);
        panel.add(button1);

        num.setFont(new Font("Arial", Font.PLAIN, 18));
        message.setFont(new Font("Arial", Font.PLAIN, 18));
        button.setFont(new Font("Arial", Font.PLAIN, 18));
        button1.setFont(new Font("Arial", Font.PLAIN, 18));
        key.setFont(new Font("Arial", Font.PLAIN, 18));
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                key.setText(Integer.toString(num2));
                panel.add(key);

            }
        });
        panel.setBackground(Color.WHITE);
        num2 = (int) (Math.random() * 100);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int myno = Integer.parseInt(num.getText());
                // int num2 = (int) (Math.random() * 100);
                if (myno < 0 || myno > 100) {
                    message.setText("SELECT NUMBER : ");
                } else if (myno == num2) {
                    message.setText("Hurray!! You guessed the correct number.");
                    button.setEnabled(false);
                } else if (myno + 1 == num2 || myno - 1 == num2) {
                    message.setText("Woooh!! You are too close.");
                } else if ((myno > num2) && (myno % 2 == 0)) {
                    message.setText("You number is larger!!!, but its an even number");
                } else if ((myno < num2) && (myno % 2 == 0)) {
                    message.setText("Smaller number!!! , but its an even number");
                }
                key.setText(Integer.toString(num2));

            }
        });
    }

    public static void main(String[] args) {
        JFrame f = new JFrame("Number Guessing");
        GuessNumber guessNumber = new GuessNumber();
        f.setContentPane(guessNumber.panel);
        f.setSize(550, 650);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

    }

}
