
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

public class GUI extends JFrame {

    JButton convertButton;
    JTextField iF, prF, poF;
    JLabel infixLabel, postfixLabel, prefixLabel;

    public GUI() {
        super("Expression Parsing");
        setLayout(null);

        Border blackline = BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.BLACK, Color.BLACK, Color.black, Color.BLACK);
        convertButton = new JButton("Convert ");

        iF = new JTextField(20);
        prF = new JTextField(20);
        poF = new JTextField(20);

        infixLabel = new JLabel("  Enter the infix expression");
        postfixLabel = new JLabel("  Postfix Expression");
        prefixLabel = new JLabel("  Prefix Expression");

        prF.setEditable(false);
        poF.setEditable(false);

        infixLabel.setBorder(blackline);
        postfixLabel.setBorder(blackline);
        prefixLabel.setBorder(blackline);

        Font font = new Font("Serif", Font.PLAIN, 18);

        infixLabel.setFont(font);
        postfixLabel.setFont(font);
        prefixLabel.setFont(font);

        infixLabel.setBounds(10, 1, 220, 50);//x,y,w,h
        iF.setBounds(260, 1, 200, 50);
        postfixLabel.setBounds(10, 75, 220, 50);
        poF.setBounds(260, 75, 200, 50);
        prefixLabel.setBounds(10, 149, 220, 50);
        prF.setBounds(260, 149, 200, 50);
        // evaluationLabel.setBounds(10, 223, 220, 50);

        convertButton.setBounds(535, 1, 100, 50);

        add(infixLabel);
        add(iF);
        add(postfixLabel);
        add(poF);
        add(prefixLabel);
        add(prF);
        add(convertButton);

        convertButton.addActionListener((ActionEvent e) -> {
            poF.setText(Methods.Postfix(iF.getText()));
            prF.setText(Methods.Prefix(iF.getText()));

        });

    }
}
