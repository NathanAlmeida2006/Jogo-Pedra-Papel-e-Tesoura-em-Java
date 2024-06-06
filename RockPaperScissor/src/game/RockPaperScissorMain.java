package game;

import java.util.Random;
import javax.swing.JOptionPane;

import game.GameLogic.Escolha;

/**
 * Classe principal que implementa o jogo Pedra, Papel e Tesoura.
 */
public class RockPaperScissorMain {

    /**
     * Método principal que inicia o jogo.
     * 
     * @param args Argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        Random random = new Random();
        Escolha[] escolhas = Escolha.values();

        while (true) {
            int botIndex = random.nextInt(escolhas.length);
            Escolha bot = escolhas[botIndex];

            String[] opcoes = { "PEDRA", "PAPEL", "TESOURA", "Sair" };
            int userChoiceIndex = JOptionPane.showOptionDialog(null,
                    "Selecione uma opção:",
                    "RockPaperScissor!",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opcoes,
                    opcoes[0]);

            if (userChoiceIndex == opcoes.length - 1) {
                // O usuário escolheu "Sair"
                break;
            }

            if (userChoiceIndex < 0 || userChoiceIndex >= escolhas.length) {
                GameLogic.mostrarMensagem("Escolha inválida. Tente novamente.");
                continue;
            }

            Escolha usuario = Escolha.getEscolha(userChoiceIndex);
            GameLogic.mostrarMensagem("O computador escolheu: " + bot);
            String resultado = GameLogic.determinarVencedor(usuario, bot);
            GameLogic.mostrarMensagem(resultado);
        }

        GameLogic.mostrarMensagem("Obrigado por jogar! Até a próxima.");
    }
}
