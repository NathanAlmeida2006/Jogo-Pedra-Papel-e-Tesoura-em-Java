package Game;
import java.util.Random;
import javax.swing.JOptionPane;

import Game.GameLogic.Escolha;

/**
 * Classe principal que implementa o jogo Pedra, Papel e Tesoura.
 */
public class RockPaperScissorMain {

    /**
     * Método principal que inicia o jogo.
     * 
     * @param args argumentos de linha de comando (não utilizados)
     */
    public static void main(String[] args) {
        Random random = new Random();
        Escolha[] escolhas = Escolha.values();
        int botIndex = random.nextInt(escolhas.length);
        Escolha bot = escolhas[botIndex];
        int usr = JOptionPane.showOptionDialog(null,
                "Selecione uma opção:",
                "RockPaperScissor!",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                escolhas,
                escolhas[0]);

        Escolha usuario = Escolha.getEscolha(usr);
        GameLogic.mostrarMensagem("O computador escolheu: " + bot);
        GameLogic.determinarVencedor(usuario, bot);
    }
}
