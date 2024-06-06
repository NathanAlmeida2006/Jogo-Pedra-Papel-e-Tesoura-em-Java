package game;

import javax.swing.JOptionPane;

/**
 * Classe que contém a lógica do jogo Pedra, Papel e Tesoura.
 */
public class GameLogic {

    /**
     * Enumeração das possíveis escolhas do jogo.
     */
    public enum Escolha {
        PEDRA, PAPEL, TESOURA;

        /**
         * Retorna a escolha correspondente ao índice fornecido.
         * 
         * @param index Índice da escolha.
         * @return Escolha correspondente ao índice.
         * @throws IllegalArgumentException se o índice for inválido.
         */
        public static Escolha getEscolha(int index) {
            if (index < 0 || index >= values().length) {
                throw new IllegalArgumentException("Índice inválido: " + index);
            }
            return values()[index];
        }
    }

    /**
     * Exibe uma mensagem em uma janela de diálogo.
     * 
     * @param mensagem A mensagem a ser exibida.
     */
    public static void mostrarMensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }

    /**
     * Determina o vencedor do jogo e retorna o resultado.
     * 
     * @param usuario Escolha do usuário.
     * @param bot Escolha do computador.
     * @return String com o resultado do jogo.
     */
    public static String determinarVencedor(Escolha usuario, Escolha bot) {
        if (usuario == bot) {
            return "Empate!";
        } else if ((usuario == Escolha.PEDRA && bot == Escolha.TESOURA) ||
                   (usuario == Escolha.PAPEL && bot == Escolha.PEDRA) ||
                   (usuario == Escolha.TESOURA && bot == Escolha.PAPEL)) {
            return "Usuário venceu!";
        } else {
            return "Computador venceu!";
        }
    }
}
