``` diff
- Paulo Vinícius Kuss
- BSI23 – 2023001138

########################################################################################################################

- Atividade Bichinho Virtual
+   Crie uma Classe que modele um Tamaguchi (Bichinho Eletrônico)

! a. Atributos:
        └ Nome, Fome, Saúde e Idade;
! b. Métodos:
        └ Alterar Nome, Fome, Saúde e Idade;
        └ Retornar Nome, Fome, Saúde e Idade;

! Obs:
    └ Existe mais uma informação que devemos levar em consideração, o Humor do nosso Tamagushi;
    └ Este humor é uma combinação entre os atributos Fome e Saúde, ou seja, um campo calculado;
    └ Não devemos criar um atributo para armazenar essa informação porque ela pode ser calculada a qualquer momento;

########################################################################################################################

+ Classes Criadas:
!   Main         
        └ Classe principal para inicialização do projeto com Janela Inicial de introdução;
!   Tamaguchi    
        └ Classe para todas as informações referentes ao Bichinho;
!   TamagushiGUI 
        └ Classe para os dados da Interface Gráfica;
!   Ascii        
        └ Classe para as artes do Bichinho de acordo com o humor;

########################################################################################################################

+ Atributos Criados:
!   Geral
-       └ random
            └ Atributo para gerar valores aleatórios;
!   Classe Tamaguchi 
-       └ nome
            └ Nome do seu Bichinho, podendo ser alterado na interface;
-       └ energia
            └ Representação da satisfação, uma alternativa para "Fome". Aumenta quando alimenta e diminui quando brinca;
-       └ saude
            └ Saúde do seu Bichinho, aumenta quando você brinca mas diminui caso alimente demais;
-       └ idade
            └ A idade passa para todos, não seria diferente com seu amiguinho. Cada 1 segundo nosso equivale a 1 ano de vida dele;
-       └ humorAscii
            └ Atributo que guarda a arte ascii;
-       └ idadeMorte
            └ Define uma idade máxima para o Bichino, sendo mais comum entre 70 e 90, mas podendo chegar a 100;
!   Classe TamagushiGUI 
-        └ nomeField
            └ Área onde o Usuário pode alterar o nome do Bichinho;
-       └ statusNome, statusEnergia, statusSaude, statusIdade, statusHumor
            └ Apenas campos para mostrar o nome de cada Status;
-       └ valorEnergia, valorSaude, valorIdade
            └ Valor de cada Status, de 0 a 100;
-       └ barraEnergia, barraSaude, barraIdade
            └ Barras mostrando visualmente os valores de cada Status, apenas para estética;
-       └ timerIdade, timerStatus
            └ Timers separados. Um envelhece o Bichinho e o outro diminui os valores de Energia e Saúde, ambos aleatoriamente;
-       └ asciiBichinho
            └ Área de texto onde é mostrada a arte ascii do Bichinho;
!   Classe Ascii 
-       └ neutro, morto, obeso, magro, caveira, feliz, triste
            └ Artes ascii em si;

```