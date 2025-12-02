import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class aaaMain {
    public static void main(String[] args) {
        // Cria a janela principal
        JFrame mainFrame = new JFrame("Tamagushi");
        mainFrame.setSize(100, 60);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setUndecorated(true); // Remove a borda da janela

        // Cria um painel com fundo escuro e sem bordas
        JPanel panel = new JPanel();
        panel.setBackground(Color.black);
        panel.setBorder(BorderFactory.createEmptyBorder()); // Remove a borda do painel
        panel.setLayout(new BorderLayout()); // Usa o BorderLayout para ocupar toda a janela

        // Cria o botão "Iniciar"
        JButton startButton = new JButton("Iniciar");
        startButton.setFont(new Font("Arial", Font.BOLD, 20));
        startButton.setForeground(Color.WHITE);
        startButton.setBackground(Color.BLACK);
        startButton.setBorder(BorderFactory.createEmptyBorder()); // Remove a borda do botão
        startButton.setFocusPainted(false); // Remove o efeito de foco do botão

        // Configura o botão para ocupar toda a área do painel
        panel.add(startButton, BorderLayout.CENTER);

        mainFrame.add(panel);
        mainFrame.setVisible(true);

        // Adiciona um listener para o botão "Iniciar"
        startButton.addActionListener((ActionEvent e) -> {
            mainFrame.dispose(); // Fecha a janela de início
            SplashScreen.main(null); // Inicia a tela de splash
        });
    }
}
