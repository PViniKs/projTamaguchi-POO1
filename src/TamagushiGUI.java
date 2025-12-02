import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.*;

// -----------------------------------------------------------------------------------

public class TamagushiGUI {
    private final Tamagushi tamagushi;
    private JFrame frame;
    private JTextField nomeField;
    private JLabel statusNome, statusEnergia, statusSaude, statusIdade, statusHumor;
    private JProgressBar barraEnergia, barraSaude, barraIdade;
    private JLabel valorEnergia, valorSaude, valorIdade;
    private Timer timerIdade, timerStatus;
    private JTextArea asciiBichinho;
    private final Random random;
    private boolean pausado = false;

// -----------------------------------------------------------------------------------

    public TamagushiGUI(Tamagushi tamagushi) {
        this.tamagushi = tamagushi;
        this.random = new Random();
        inicializar();
        comecarTimer();
    }

// -----------------------------------------------------------------------------------

    private void inicializar() {
        
        frame = new JFrame("Tamagushi");
        frame.setBounds(800, 200, 345, 540);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.black);

// -----------------------------------------------------------------------------------
        
        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setBounds(10, 10, 40, 30);
        nomeLabel.setForeground(Color.white);
        frame.getContentPane().add(nomeLabel);
        
        nomeField = new JTextField(tamagushi.getNome());
        nomeField.setBounds(60, 10, 260, 30);
        nomeField.setBackground(Color.darkGray);
        nomeField.setForeground(Color.white);
        nomeField.setHorizontalAlignment(JTextField.CENTER);
        nomeField.setEditable(false);
        frame.getContentPane().add(nomeField);
        
        // -----------------------------------------------------------------------------------
        
        JButton botaoAtualizar = new JButton("Mudar Nome");
        botaoAtualizar.setBounds(210, 50, 110, 25);
        botaoAtualizar.setBackground(Color.darkGray);
        botaoAtualizar.setForeground(Color.white);
        frame.getContentPane().add(botaoAtualizar);
        
        JButton botaoAlimentar = new JButton("Alimentar");
        botaoAlimentar.setBounds(210, 100, 110, 25);
        botaoAlimentar.setBackground(Color.darkGray);
        botaoAlimentar.setForeground(Color.white);
        frame.getContentPane().add(botaoAlimentar);
        
        JButton botaoBrincar = new JButton("Brincar");
        botaoBrincar.setBounds(210, 150, 110, 25);
        botaoBrincar.setBackground(Color.darkGray);
        botaoBrincar.setForeground(Color.white);
        frame.getContentPane().add(botaoBrincar);
        
        // -----------------------------------------------------------------------------------
        
        statusNome = new JLabel("Nome: ");
        statusNome.setBounds(10, 50, 180, 25);
        statusNome.setForeground(Color.white);
        frame.getContentPane().add(statusNome);
        
        // -----------------------------------------------------------------------------------
        
        statusEnergia = new JLabel("Energia:");
        statusEnergia.setBounds(10, 80, 60, 25);
        statusEnergia.setForeground(Color.white);
        frame.getContentPane().add(statusEnergia);
        
        valorEnergia = new JLabel("50");
        valorEnergia.setBounds(60, 80, 30, 25);
        valorEnergia.setForeground(Color.white);
        frame.getContentPane().add(valorEnergia);
        
        barraEnergia = new JProgressBar(0, 100);
        barraEnergia.setBounds(85, 80, 115, 25);
        barraEnergia.setBackground(Color.darkGray);
        barraEnergia.setForeground(new Color(150,250,150));
        frame.getContentPane().add(barraEnergia);
        
        // -----------------------------------------------------------------------------------
        
        statusSaude = new JLabel("Saúde:");
        statusSaude.setBounds(10, 115, 60, 25);
        statusSaude.setForeground(Color.white);
        frame.getContentPane().add(statusSaude);
        
        valorSaude = new JLabel("50");
        valorSaude.setBounds(60, 115, 30, 25);
        valorSaude.setForeground(Color.white);
        frame.getContentPane().add(valorSaude);
        
        barraSaude = new JProgressBar(0, 100);
        barraSaude.setBounds(85, 115, 115, 25);
        barraSaude.setBackground(Color.darkGray);
        barraSaude.setForeground(new Color(150,150,250));
        frame.getContentPane().add(barraSaude);
        
        // -----------------------------------------------------------------------------------
        
        statusIdade = new JLabel("Idade:");
        statusIdade.setBounds(10, 150, 60, 25);
        statusIdade.setForeground(Color.white);
        frame.getContentPane().add(statusIdade);
        
        valorIdade = new JLabel("0");
        valorIdade.setBounds(60, 150, 30, 25);
        valorIdade.setForeground(Color.white);
        frame.getContentPane().add(valorIdade);
        
        barraIdade = new JProgressBar(0, 100);
        barraIdade.setBounds(85, 150, 115, 25);
        barraIdade.setBackground(Color.darkGray);
        barraIdade.setForeground(new Color(250,150,150));
        frame.getContentPane().add(barraIdade);
        
        // -----------------------------------------------------------------------------------
        
        statusHumor = new JLabel("Humor:");
        statusHumor.setBounds(10, 185, 250, 25);
        statusHumor.setForeground(Color.white);
        frame.getContentPane().add(statusHumor);

// -----------------------------------------------------------------------------------
        
        asciiBichinho = new JTextArea();
        asciiBichinho.setBounds(10, 210, 310, 280);
        asciiBichinho.setEditable(false);
        asciiBichinho.setBackground(Color.black);
        asciiBichinho.setForeground(Color.white);

        Font font = new Font("Consolas", Font.PLAIN, 20);
        asciiBichinho.setFont(font);

        String Neutro = Ascii.getNeutro();
        asciiBichinho.setText(Neutro);

        frame.getContentPane().add(asciiBichinho);

// -----------------------------------------------------------------------------------

        botaoAtualizar.addActionListener((ActionEvent e) -> {
            if (!pausado) {
                timerIdade.stop();
                timerStatus.stop();
                botaoAlimentar.setEnabled(false);
                botaoBrincar.setEnabled(false);
                nomeField.setEditable(true);
                botaoAtualizar.setText("Aplicar");
                pausado = true;
            } else {
                tamagushi.setNome(nomeField.getText());
                nomeField.setEditable(false);
                botaoAtualizar.setText("Mudar Nome");
                botaoAlimentar.setEnabled(true);
                botaoBrincar.setEnabled(true);
                comecarTimer();
                pausado = false;
            }
            atualizarStatus();
        });

        botaoAlimentar.addActionListener((ActionEvent e) -> {
            if (!pausado) {
                tamagushi.alimentar();
                atualizarStatus();
            }
        });

        botaoBrincar.addActionListener((ActionEvent e) -> {
            if (!pausado) {
                tamagushi.brincar();
                atualizarStatus();
            }
        });

        frame.setVisible(true);
    }

// -----------------------------------------------------------------------------------

    private void comecarTimer() {
        atualizarStatus();
        timerIdade = new Timer(1000, (ActionEvent e) -> {
            if (!tamagushi.estaMorto()) {
                tamagushi.setIdade(1);
                atualizarStatus();
            }
        });
        timerIdade.start();

// -----------------------------------------------------------------------------------

        timerStatus = new Timer(200, (ActionEvent e) -> {
            if (!tamagushi.estaMorto()) {
                if  (random.nextBoolean()){
                    int diminuiEnergia = 1 + random.nextInt(3);
                    tamagushi.setEnergia(-diminuiEnergia);
                }
                if (random.nextBoolean()) {
                    int diminuiSaude = 1 + random.nextInt(3);
                    tamagushi.setSaude(-diminuiSaude);
                }
                atualizarStatus();
            } else {
                timerIdade.stop();
                timerStatus.stop();
                JOptionPane.showMessageDialog(frame,    "Seu Tamagushi " + tamagushi.getNome() + " morreu :(\n" +
                        "Idade: " + tamagushi.getIdade() + " anos\n" +
                                "Humor: " + tamagushi.getHumor());
                frame.dispose();
            }
        });
        timerStatus.start();
    }

// -----------------------------------------------------------------------------------

    private void atualizarStatus() {
        statusNome.setText("Nome: " + tamagushi.getNome());
        barraEnergia.setValue(tamagushi.getEnergia());
        valorEnergia.setText(String.valueOf(tamagushi.getEnergia()));
        barraSaude.setValue(tamagushi.getSaude());
        valorSaude.setText(String.valueOf(tamagushi.getSaude()));
        barraIdade.setValue(tamagushi.getIdade());
        valorIdade.setText(String.valueOf(tamagushi.getIdade()));
        statusHumor.setText("Humor: " + tamagushi.getHumor());
        asciiBichinho.setText(tamagushi.humorAscii);
    }
}