package Aulas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ProgramaNotas {
    public static void main(String[] args){
        JFrame frame = new JFrame("Calculo da media dos alunos");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        

        JLabel lblNomeAluno = new JLabel("Nome Aluno:");
        lblNomeAluno.setBounds(1, 1, 100, 100);
        frame.add(lblNomeAluno);

        JTextField txtNomeAluno = new JTextField();
        txtNomeAluno.setBounds(80, 40, 300, 20);
        frame.add(txtNomeAluno);

        JLabel lblNota1 = new JLabel("Nota 1:");
        lblNota1.setBounds(1, 40, 100, 100);
        frame.add(lblNota1);

        JTextField txtNota1 = new JTextField();
        txtNota1.setBounds(80, 80, 300, 20);
        frame.add(txtNota1);

        JLabel lblNota2 = new JLabel("Nota 2:");
        lblNota2.setBounds(1, 80, 100, 100);
        frame.add(lblNota2);

        JTextField txtNota2 = new JTextField();
        txtNota2.setBounds(80, 120, 300, 20);
        frame.add(txtNota2);
        
        
        JButton btnCalcular = new JButton("Calcular");
        JButton.setBounds(150, 160, 100, 30);

        frame.setVisible(true);
    }
}
