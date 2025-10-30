package Aulas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;

public class ExerciciosHashSet extends JFrame {
    private JTextField txtNome;
    private JTextArea areaResultado;
    private JButton btnVerificar;
    private HashSet<String> nomes;

    public ExerciciosHashSet() {
        setTitle("Exercício HashSet com Border Laylot");

        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        setLocationRelativeTo(null);

        nomes = new HashSet<>();
        nomes.add("Ana");
        nomes.add("Bruno");
        nomes.add("Carlos");

        JPanel painelSuperior = new JPanel();
        painelSuperior.add(new JLabel("Digite um nome:"));
        txtNome = new JTextField(20);
        painelSuperior.add(txtNome);

        btnVerificar = new JButton("Verificar Nome");

        areaResultado = new JTextArea();
        areaResultado.setEditable(false); 

        btnVerificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Conjunto inicial: ").append(nomes).append("\n");
                String nome = txtNome.getText();
                if (nomes.contains(nome)) {
                    sb.append("Resultado: ").append(nome).append("Esta na lista\n");
                } else {
                    nomes.add(nome);
                    sb.append("Resultado: ").append(nome).append("Nao esta na lista\n");
                }
            }
        });
        add(painelSuperior, BorderLayout.NORTH);
        add(new JScrollPane(areaResultado), BorderLayout.CENTER);
        add(btnVerificar, BorderLayout.SOUTH);

    }
    public static void main(String[] args) {
        new ExerciciosHashSet().setVisible(true);
    }
} 
