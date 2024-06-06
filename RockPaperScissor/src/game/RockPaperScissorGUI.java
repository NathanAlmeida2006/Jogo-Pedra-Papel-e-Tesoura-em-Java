package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import game.GameLogic.Escolha;

/**
 * A classe RockPaperScissorGUI representa a interface gráfica do usuário (GUI) para o jogo Pedra, Papel e Tesoura.
 * Ela cria uma janela baseada em Swing com botões para o jogador escolher seu movimento e exibe o resultado do jogo.
 */
public class RockPaperScissorGUI extends JFrame {

    private static final int JANELA_WIDTH = 450;
    private static final int JANELA_HEIGHT = 200;

    private JLabel resultadoLabel;
    private JButton pedraButton;
    private JButton papelButton;
    private JButton tesouraButton;
    private JButton sairButton;

    /**
     * Constrói um novo objeto RockPaperScissorGUI, configurando a janela e adicionando os componentes necessários.
     */
    public RockPaperScissorGUI() {
        setTitle("Jogo Pedra, Papel e Tesoura");
        setSize(JANELA_WIDTH, JANELA_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Criação dos componentes
        resultadoLabel = new JLabel("Escolha uma opção para jogar", SwingConstants.CENTER);
        pedraButton = new JButton("PEDRA");
        papelButton = new JButton("PAPEL");
        tesouraButton = new JButton("TESOURA");
        sairButton = new JButton("Sair");

        // Centraliza a janela na tela
        setLocationRelativeTo(null);

        // Adiciona os componentes ao layout
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(pedraButton);
        buttonPanel.add(papelButton);
        buttonPanel.add(tesouraButton);

        add(resultadoLabel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.NORTH);
        add(sairButton, BorderLayout.SOUTH);

        // Adiciona os listeners aos botões
        pedraButton.addActionListener(new EscolhaListener(Escolha.PEDRA));
        papelButton.addActionListener(new EscolhaListener(Escolha.PAPEL));
        tesouraButton.addActionListener(new EscolhaListener(Escolha.TESOURA));
        sairButton.addActionListener(e -> System.exit(0));

        // Centraliza a janela na tela
        setLocationRelativeTo(null);
    }

    /**
     * A classe EscolhaListener é uma classe interna que implementa a interface ActionListener.
     * Ela é responsável por lidar com a escolha do jogador e determinar o vencedor do jogo.
     */
    private class EscolhaListener implements ActionListener {
        private final Escolha escolhaUsuario;

        /**
         * Constrói um novo objeto EscolhaListener com a escolha do jogador.
         *
         * @param escolhaUsuario a escolha do jogador (pedra, papel ou tesoura)
         */
        public EscolhaListener(Escolha escolhaUsuario) {
            this.escolhaUsuario = escolhaUsuario;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Random random = new Random();
            Escolha[] escolhas = Escolha.values();
            Escolha escolhaBot = escolhas[random.nextInt(escolhas.length)];

            String resultado = "O computador escolheu: " + escolhaBot + ". ";
            resultado += GameLogic.determinarVencedor(escolhaUsuario, escolhaBot);
            resultadoLabel.setText(resultado);
        }
    }

    /**
     * O método main cria e exibe a janela RockPaperScissorGUI.
     *
     * @param args argumentos de linha de comando (não utilizados)
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RockPaperScissorGUI frame = new RockPaperScissorGUI();
            frame.setVisible(true);
        });
    }
}