package Aulas;

import javax.swing.*;
import java.awt.*;

class IdadeInvalida extends Exception{
    public IdadeInvalida(String msg){
        super(msg);
    }
}

public class ExcecaoIdadeInvalida extends JFrame {

    public ExcecaoIdadeInvalida(){
        setTitle("Exceção de Idade Inválida");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1, 10, 10));
        setLocationRelativeTo(null);

        JButton btn1 = new JButton("Excação Personalizada");

        add(btn1);
        btn1.addActionListener(e -> {
            JFrame janela = new JFrame("Excação Personalizada");
            janela.setSize(300, 200);
            janela.setLayout(new FlowLayout());
            JTextField idade = new JTextField(5);
            JButton verificar = new JButton("Verificar");

            verificar.addActionListener(a -> {
                try {
                    int valor = Integer.parseInt(idade.getText());
                    if (valor < 0) {
                        throw new IdadeInvalida("Idade não pode ser negativa.");
                    }
                    JOptionPane.showMessageDialog(janela, "Idade válida: " + valor);
                } catch (IdadeInvalida ex) {
                    JOptionPane.showMessageDialog(janela, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(janela, "Digite um número válido!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            });
            janela.add(new JLabel("Digite sua idade:"));
            janela.add(idade);
            janela.add(verificar);
            janela.setVisible(true);
        });
    }

    public static void main(String[] args) {
        new ExcecaoIdadeInvalida().setVisible(true);
    }
}
