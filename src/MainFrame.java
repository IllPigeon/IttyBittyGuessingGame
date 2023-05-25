import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MainFrame extends JFrame {
    private JTextField InputField;
    private JButton Submit;
    private JLabel CorrectGuesses;
    private JPanel MainPanel;
    private JLabel FailedGuesses;
    private JLabel GeneralDisplay;

    public MainFrame(){
        //TODO: Make it more pretty
        setContentPane(MainPanel);
        setTitle("The Guessing Game");
        setSize(450, 450);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Submit.addActionListener(new ActionListener() {
            final Random randy = new Random();
            int question = randy.nextInt(1, 101);
            int correct = 0;
            int fails = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                int guess = Integer.parseInt(InputField.getText());
                //TODO: Improper data type handling, ie like when they put in a string rather than an int or a float.

                if(guess == question){
                    correct++;
                    CorrectGuesses.setText("Correct Guesses: "+ correct);
                    question = randy.nextInt(1, 101);
                    GeneralDisplay.setText("I am thinking of a new number between 1 and 100...");
                    fails = 0;
                }
                else{
                    fails++;
                    FailedGuesses.setText("Incorrect Guesses: "+ fails);
                    if(guess > question){
                        GeneralDisplay.setForeground(Color.RED);
                        GeneralDisplay.setText("Too high, try again!");
                    }
                    else{
                        GeneralDisplay.setForeground(Color.RED);
                        GeneralDisplay.setText("Too low, try again!");
                    }
                }
            }
        });
    }
}
