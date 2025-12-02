import java.util.Random;

// -----------------------------------------------------------------------------------

public class Tamagushi {
    private String nome;
    public String humorAscii;
    private int energia, saude, idade, idadeMorte;
    private final Random random;

// -----------------------------------------------------------------------------------

    public Tamagushi(String nome, int energia, int saude, int idade) {
        this.nome = nome;
        this.energia = energia;
        this.saude = saude;
        this.idade = idade;
        this.random = new Random();
        gerarIdadeMorte();
    }

// -----------------------------------------------------------------------------------

    private void gerarIdadeMorte(){
        this.idadeMorte = 70 + random.nextInt(21) + random.nextInt(11);
    }

    public void setNome(String novoNome) {
        this.nome = novoNome;
    }

    public void setEnergia(int novaEnergia) {
        if ((energia + novaEnergia) < 0)
            this.energia = 0;
        else
            this.energia = energia+novaEnergia;
    }

    public void setSaude(int novaSaude) {
        if ((saude + novaSaude) < 0)
            this.saude = 0;
        else
            this.saude = saude+novaSaude;
    }

    public void setIdade(int novaIdade) {
        this.idade = Math.min(idadeMorte, this.idade + novaIdade);
    }

// -----------------------------------------------------------------------------------

    public void alimentar() {
        if ((this.energia + 15) <= 100){
            setEnergia(15);
            if ((saude + 4) <= 100){
                setSaude(4);
            }
        } else if ((this.energia + 15) > 100){
            this.energia = 100;
            if((this.saude - 4) < 0)
                this.saude = 0;
            else
                setSaude(-4);
        }
    }

    public void brincar() {
        if ((this.saude + 10) <= 100){
            setSaude(10);
            setEnergia(-6);
        } else if ((this.saude + 10) > 100){
            this.saude = 100;
            if((this.energia - 8) < 0)
                this.energia = 0;
            else
                setEnergia(-8);
        }
    }

// -----------------------------------------------------------------------------------

    public String getNome() {
        return nome;
    }

    public int getEnergia() {
        return energia;
    }

    public int getSaude() {
        return saude;
    }

    public int getIdade() {
        return idade;
    }

// -----------------------------------------------------------------------------------

    public void setAscii(String humor){
        String Neutro = Ascii.getNeutro();
        String Morto = Ascii.getMorto();
        String Obeso = Ascii.getObeso();
        String Magro = Ascii.getMagro();
        String Caveira = Ascii.getCaveira();
        String Feliz = Ascii.getFeliz();
        String Triste = Ascii.getTriste();

        if (null == humor)
            this.humorAscii = Neutro;
        else switch (humor) {
            case "Neutro":
                this.humorAscii = Neutro;
                break;
            case "Morto":
                this.humorAscii = Morto;
                break;
            case "Obeso":
                this.humorAscii = Obeso;
                break;
            case "Magro":
                this.humorAscii = Magro;
                break;
            case "Caveira":
                this.humorAscii = Caveira;
                break;
            case "Feliz":
                this.humorAscii = Feliz;
                break;
            case "Triste":
                this.humorAscii = Triste;
                break;
            default:
                this.humorAscii = Neutro;
                break;
        }
    }

// -----------------------------------------------------------------------------------

    public String getHumor() {
        int totalHumor = energia + saude;


        if (energia > 70 && saude < 15) {
            setAscii("Obeso");
            return "Infartando de tanto comer";
        } else if (saude > 70 && energia < 15) {
            setAscii("Magro");
            return "Morrendo de fome (literalmente)";
        } else if (totalHumor <= 10) {
            setAscii("Caveira");
            return "Arrependido de ter sido seu";
        } else if (totalHumor <= 25 && totalHumor >= 11) {
            setAscii("Morto");
            return "Na beira da morte";
        } else if (totalHumor <= 40 && totalHumor >= 26) {
            setAscii("Triste");
            return "Depressivo";
        } else if (totalHumor <= 60 && totalHumor >= 41) {
            setAscii("Triste");
            return "Triste";
        } else if (totalHumor >= 120 && totalHumor <= 179) {
            setAscii("Feliz");
            return "Feliz";
        } else if (totalHumor >= 180) {
            setAscii("Feliz");
            return "Extremamente alegre";
        } else {
            setAscii("Neutro");
            return "Neutro";
        }
    }

// -----------------------------------------------------------------------------------

    public boolean estaMorto() {
        return energia <= 0 || saude <= 0 || idade >= idadeMorte;
    }
}