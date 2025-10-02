package Aulas;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SwitchGUI {
    public static void main(String[] args) {
        String opcaoStr = JOptionPane.showInputDialog("Menu:\n1 - Novo\n2 - Abrir\n3 - Sair\nEscolha uma opção: ");
        int opcao = Integer.parseInt(opcaoStr);
        
        String msg;

        switch (opcao) {
            case 1:
                msg = "Você escolheu 'Novo'.";
                break;
            case 2:
                msg = "Você escolheu 'Abrir'.";
                break;
            case 3:
                msg = "Saindo...";
                break;
            default:
                msg = "Opção inválida. Por favor, escolha 1, 2 ou 3.";
                break;
        }

        JFrame janela = new JFrame();

        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setSize(300, 200);
        janela.setVisible(true); // Torna o frame visível

        JOptionPane.showMessageDialog(janela, msg);
    }
}
