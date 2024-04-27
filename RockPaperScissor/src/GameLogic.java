package Game;
import javax.swing.JOptionPane;

/**
 * Classe que contém a lógica do jogo e os métodos auxiliares.
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
         * @param index índice da escolha
         * @return Escolha correspondente ao índice
         */
        public static Escolha getEscolha(int index) {
            return values()[index];
        }
    }

    /**
     * Exibe uma mensagem em uma janela de diálogo.
     * 
     * @param mensagem a mensagem a ser exibida
     */
    public static void mostrarMensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }

    /**
     * Determina o vencedor do jogo e exibe o resultado.
     * 
     * @param usuario escolha do usuário
     * @param bot escolha do computador
     */
    public static void determinarVencedor(Escolha usuario, Escolha bot) {
        if (usuario == bot) {
            mostrarMensagem("Empate!");
        } else if ((usuario == Escolha.PEDRA && bot == Escolha.TESOURA) ||
                   (usuario == Escolha.PAPEL && bot == Escolha.PEDRA) ||
                   (usuario == Escolha.TESOURA && bot == Escolha.PAPEL)) {
            mostrarMensagem("Usuário venceu!");
        } else {
            mostrarMensagem("Computador venceu!");
        }
    }
}
