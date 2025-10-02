package Aulas;

import java.util.Calendar;

import javax.swing.JOptionPane;

public class WhileTryCalendarGUI {
    public static void main(String[] args) {
        String nome = JOptionPane.showInputDialog("Digite seu nome: ");

        int idade = 0;

        while (idade < 0) {
            try{
                String idadeStr = JOptionPane.showInputDialog("Digite sua idade: ");
                idade = Integer.parseInt(idadeStr);
                
                if (idade < 0) {
                    JOptionPane.showMessageDialog(null, "Idade inválida. Por favor, digite um número positivo.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, digite um número inteiro.");
            }
            
        }

        Calendar calendario = Calendar.getInstance();
        int anoAtual = calendario.get(Calendar.YEAR);
        int anoNascimento = anoAtual - idade;

        String mensagem = "Olá " + nome + "!\nVoce nasceu em " + anoNascimento;
        JOptionPane.showMessageDialog(null, mensagem);

    }

}
