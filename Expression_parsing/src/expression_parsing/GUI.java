package expression_parsing;

// test test
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

public class GUI extends JFrame {

    JButton convertButton , evaluateButton;
    JTextField iF, prF, poF, prefixEvaluationField, EvaluationField;
    JLabel infixLabel, postfixLabel, prefixLabel;
    JComboBox evaluateChoice;
    String[] Postfix_Or_Prefix = {"Postfix evaluate", "Prefix evaluate"};

    public GUI() {
        super("Expression Parsing");
        setLayout(null);

        Border blackline = BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.BLACK, Color.BLACK, Color.black, Color.BLACK);
        convertButton = new JButton("Convert ");
        
        evaluateButton = new JButton("Evaluate ");
        
        evaluateChoice = new JComboBox(Postfix_Or_Prefix);


        iF = new JTextField(20);
        prF = new JTextField(20);
        poF = new JTextField(20);
        prefixEvaluationField = new JTextField(20);
        EvaluationField = new JTextField(20);


        infixLabel = new JLabel("  Enter the infix expression");
        postfixLabel = new JLabel("  Postfix Expression");
        prefixLabel = new JLabel("  Prefix Expression");

        prF.setEditable(false);
        poF.setEditable(false);
        EvaluationField.setEditable(false);

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
        evaluateChoice.setBounds(10, 223, 220, 50);
        prefixEvaluationField.setBounds(260, 223, 200, 50);
        EvaluationField.setBounds(470, 223, 200, 50);
        evaluateButton.setBounds(535, 75, 100, 50);

        convertButton.setBounds(535, 1, 100, 50);

        add(infixLabel);
        add(iF);
        add(postfixLabel);
        add(poF);
        add(prefixLabel);
        add(prF);
        add(prefixEvaluationField);
        add(convertButton);
        add(evaluateButton);
        add(EvaluationField);
        add(evaluateChoice);


        convertButton.addActionListener((ActionEvent e) -> {
            poF.setText(Methods.Postfix(iF.getText()));
            prF.setText(Methods.Prefix(iF.getText()));

        });
        evaluateButton.addActionListener((ActionEvent e) -> {
            if (evaluateChoice.getSelectedItem().toString() == "Postfix evaluate") {
                EvaluationField.setText(Methods.evaluatePostfix(prefixEvaluationField.getText()) + " ");
            }
            if (evaluateChoice.getSelectedItem().toString() == "Prefix evaluate") {
                EvaluationField.setText(Methods.evaluatePrefix(prefixEvaluationField.getText()) + " ");
            }
        });

    }
}
