import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

// -----------------------------------------------------------------------------------

public class Main {
    public static void main(String[] args) {
        JFrame splashFrame = new JFrame("Tamagushi");
        splashFrame.setSize(400, 300);
        splashFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        splashFrame.setLocationRelativeTo(null);
        splashFrame.setUndecorated(true);

// -----------------------------------------------------------------------------------

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.BLACK);

        JLabel label = new JLabel("TAMAGUSHI", JLabel.CENTER);
        label.setForeground(Color.BLACK);
        label.setFont(new Font("Arial", Font.BOLD, 24));

        panel.add(label, BorderLayout.CENTER);
        splashFrame.add(panel);
        splashFrame.setVisible(true);

// -----------------------------------------------------------------------------------

        Timer fadeTimer = new Timer(40, null);
        Timer displayTimer = new Timer(1000, null);
        String[] frases = {"TAMAGUSHI", "by: Paulo Vinícius Kuss"};
        final int[] currentTextIndex = {0};

// -----------------------------------------------------------------------------------

        fadeTimer.addActionListener(new ActionListener() {
            private float opacity = 0.0f;
            private boolean fadingIn = true;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (fadingIn) {
                    if (opacity < 1.0f) {
                        opacity += 0.05f;
                        label.setForeground(new Color(255, 255, 255, (int) (opacity * 255)));
                    } else {
                        fadingIn = false;
                        opacity = 1.0f;
                        ((Timer) e.getSource()).stop();
                        displayTimer.start();
                    }
                } else {
                    if (opacity > 0.0f) {
                        opacity -= 0.05f;
                        label.setForeground(new Color(255, 255, 255, (int) (opacity * 255)));
                    } else {
                        if (currentTextIndex[0] < (frases.length - 1)) {
                            currentTextIndex[0]++;
                            label.setText(frases[currentTextIndex[0]]);
                            label.setForeground(Color.BLACK);
                            opacity = 0.0f;
                            fadingIn = true;
                            fadeTimer.start();
                        } else {
                            fadeTimer.stop();
                            Timer finalTimer = new Timer(100, (ActionEvent e1) -> {
                                ((Timer) e1.getSource()).stop();
                                splashFrame.dispose();
                                Tamagushi tamagushi = new Tamagushi("Tama", 50, 50, 0);
                                TamagushiGUI bichinho = new TamagushiGUI(tamagushi);
                                System.out.println("Tamgushi ID: " + bichinho);
                            });
                            finalTimer.setRepeats(false);
                            finalTimer.start();
                        }
                    }
                }
            }
        });

// -----------------------------------------------------------------------------------

        displayTimer.addActionListener((ActionEvent e) -> {
            displayTimer.stop();
            fadeTimer.start();
        });

        fadeTimer.start();
    }
}