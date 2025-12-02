import java.util.Scanner;
import java.util.Random;

public class MainTerminal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // 1. Criação do Tamaguchi (Inicia com nome "Tama", Energia 50, Saúde 50, Idade 0)
        Tamagushi tamagushi = new Tamagushi("Tama", 50, 50, 0);

        boolean rodando = true;

        System.out.println("=== INICIANDO TAMAGUCHI NO TERMINAL ===");
        
        // Loop principal do jogo
        while (rodando) {
            // Verifica se morreu antes de desenhar
            if (tamagushi.estaMorto()) {
                System.out.println("\n\n" + Ascii.getCaveira());
                System.out.println("R.I.P.");
                System.out.println("Seu Tamaguchi " + tamagushi.getNome() + " morreu :(");
                System.out.println("Idade final: " + tamagushi.getIdade() + " anos.");
                break;
            }

            // 2. Atualiza o Humor (isso define qual desenho ASCII será usado)
            String descricaoHumor = tamagushi.getHumor();

            // 3. Imprime a interface no Terminal
            System.out.println("\n------------------------------------------------");
            // Exibe a arte ASCII atual (tamagushi.humorAscii é atualizado ao chamar getHumor)
            System.out.println(tamagushi.humorAscii); 
            
            System.out.println(" Nome: " + tamagushi.getNome());
            System.out.println(" [E] Energia: " + tamagushi.getEnergia() + "/100");
            System.out.println(" [S] Saúde:   " + tamagushi.getSaude() + "/100");
            System.out.println(" [I] Idade:   " + tamagushi.getIdade() + " anos");
            System.out.println(" Status: " + descricaoHumor);
            System.out.println("------------------------------------------------");
            System.out.println("Escolha uma ação:");
            System.out.println("1. Alimentar");
            System.out.println("2. Brincar");
            System.out.println("3. Mudar Nome");
            System.out.println("4. Não fazer nada (Passar tempo)");
            System.out.println("0. Sair");
            System.out.print("> ");

            String opcao = scanner.nextLine();

            // 4. Executa a ação escolhida
            switch (opcao) {
                case "1":
                    tamagushi.alimentar();
                    System.out.println("Você alimentou o " + tamagushi.getNome() + "!");
                    break;
                case "2":
                    tamagushi.brincar();
                    System.out.println("Você brincou com o " + tamagushi.getNome() + "!");
                    break;
                case "3":
                    System.out.print("Digite o novo nome: ");
                    String novoNome = scanner.nextLine();
                    tamagushi.setNome(novoNome);
                    System.out.println("Nome alterado com sucesso!");
                    break;
                case "4":
                    System.out.println("O tempo passou...");
                    break;
                case "0":
                    rodando = false;
                    System.out.println("Saindo...");
                    continue; // Pula a parte de envelhecer se for sair
                default:
                    System.out.println("Opção inválida.");
            }

            // 5. Simulação da passagem do tempo (Timer)
            // No modo terminal, cada ação conta como um "ciclo" de tempo.
            tamagushi.setIdade(1); // Envelhece 1 ano por rodada

            // Lógica de decaimento aleatório (igual ao timerStatus do GUI original)
            if (random.nextBoolean()) {
                int diminuiEnergia = 1 + random.nextInt(3);
                tamagushi.setEnergia(-diminuiEnergia);
            }
            if (random.nextBoolean()) {
                int diminuiSaude = 1 + random.nextInt(3);
                tamagushi.setSaude(-diminuiSaude);
            }
        }
        
        scanner.close();
    }
}
