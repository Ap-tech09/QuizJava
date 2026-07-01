import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Loginform {
    public Loginform(){
        JFrame frame = new JFrame("Login Form");
        frame.setSize(350, 280);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon("src/nature.jpg");

// Resize image to frame size
        Image img = icon.getImage().getScaledInstance(350, 280, Image.SCALE_SMOOTH);

// Create background label
        JLabel bg = new JLabel(new ImageIcon(img));
        bg.setBounds(0, 0, 350, 280);

// Set it as content pane
        frame.setContentPane(bg);
        bg.setLayout(null);
       // frame.setLayout(null);
        frame.setSize(350, 280);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel l1 = new JLabel("Username");
        JLabel l2 = new JLabel("Password");

        l1.setForeground(Color.WHITE);
        l2.setForeground(Color.WHITE);

        l1.setFont(new Font("Arial", Font.BOLD, 16));
        l2.setFont(new Font("Arial", Font.BOLD, 16));
                JTextField t1 = new JTextField();
                JPasswordField p1 = new JPasswordField();
        t1.setForeground(Color.BLACK);
        p1.setForeground(Color.BLACK);

        t1.setFont(new Font("Arial", Font.BOLD, 16));
        p1.setFont(new Font("Arial", Font.BOLD, 16));
                JButton b1 = new JButton("Login");

                l1.setBounds(50, 50, 120, 30);
                t1.setBounds(140, 50, 120, 30);

                l2.setBounds(50, 100, 120, 30);
                p1.setBounds(140, 100, 120, 30);
                b1.setBounds(100, 160, 100, 30);


        bg.add(l1);
        bg.add(t1);
        bg.add(l2);
        bg.add(p1);
        bg.add(b1);
        bg.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);frame.setLocationRelativeTo(null);
        frame.setVisible(true);
       // frame.getContentPane().setBackground(Color.blue);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String username = t1.getText();
                String password = new String(p1.getPassword());

                if (username.equals("Pawan") && password.equals("1234")) {

                    JOptionPane.showMessageDialog(frame, "Login Successful!");
                    frame.dispose();
                    new QuizTime();
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid password!");
                }







                }

});
}
}
 class QuizTime{

        JFrame f;
        JLabel question;

        JRadioButton op1, op2, op3, op4;
        ButtonGroup bg;

        JButton next, submit;

        public QuizTime() {
            f=new JFrame("Quiz made by pawan");
            question = new JLabel("Question will appear here");

            op1 = new JRadioButton("Option 1");
            op2 = new JRadioButton("Option 2");
            op3 = new JRadioButton("Option 3");
            op4 = new JRadioButton("Option 4");

            bg = new ButtonGroup();

            bg.add(op1);
            bg.add(op2);
            bg.add(op3);
            bg.add(op4);

            next = new JButton("Next");
            submit = new JButton("Submit");

            // Set Positions
            question.setBounds(30, 30, 350, 30);

            op1.setBounds(50, 80, 200, 30);
            op2.setBounds(50, 120, 200, 30);
            op3.setBounds(50, 160, 200, 30);
            op4.setBounds(50,200,200,30);
            next.setBounds(80, 260, 100, 35);
            submit.setBounds(220, 260, 100, 35);
            f.add(question);
            f.add(op1);
            f.add(op2);
            f.add(op3);
            f.add(op4);

            f.add(next);
            f.add(submit);
            submit.setEnabled(false);

            f.setLayout(null);
            f.setSize(450, 380);
            f.setLocationRelativeTo(null);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true); f.add(question);
            f.setVisible(true);
            loadQuestion(current);
            submit.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    checkAnswer();

                    JOptionPane.showMessageDialog(
                            f,
                            "Your Score is " + score + " / " + questions.length
                    );
                }
            });
            next.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    checkAnswer();

                    current++;

                    if(current < questions.length){

                        loadQuestion(current);

                        if(current == questions.length - 1){
                            next.setEnabled(false);
                            submit.setEnabled(true);
                        }

                    }
                }
            });



        }
     String questions[] = {
             "1. What is the 1st step of Swing?",
             "2. Java is a ______ language?",
             "3. Which package is used for Swing?",
             "4. Which method starts Java program?",
             "5. Java is developed by?"
     };

     String options[][] = {
             {"Class", "Frame", "Botton", "LAbel"},
             {"Compiled", "Interpreted", "Both", "None"},
             {"java.io", "java.util", "javax.swing", "java.net"},
             {"run()", "main()", "start()", "init()"},
             {"oracle", "Sun Microsystem", "James", "Apple"}
     };

     int answers[] = {2, 2, 2, 1, 1};

     int current = 0;
     int score = 0;void loadQuestion(int index) {

         question.setText(questions[index]);

         op1.setText(options[index][0]);
         op2.setText(options[index][1]);
         op3.setText(options[index][2]);
         op4.setText(options[index][3]);

         bg.clearSelection();
     }
     void checkAnswer() {

         int selected = -1;

         if(op1.isSelected())
             selected = 0;

         else if(op2.isSelected())
             selected = 1;

         else if(op3.isSelected())
             selected = 2;

         else if(op4.isSelected())
             selected = 3;

         if(selected == answers[current])
             score++;
     }

}
class Main{
    public static void main(String[]args) {
        Loginform l = new Loginform();

    }}
