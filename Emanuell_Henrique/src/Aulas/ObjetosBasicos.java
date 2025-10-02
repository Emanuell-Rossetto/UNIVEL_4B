package Aulas;

import javax.swing.*;

public class ObjetosBasicos {
    public static void main(String[] args) {
        // Criando uma janela simples
        JFrame frame = new JFrame("Exemplo de JFrame");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        // Adicionando um botão
        JButton button = new JButton("Clique Aqui");
        button.setBounds(20, 70, 120, 30);
        frame.add(button);

        button.addActionListener(e -> JOptionPane.showMessageDialog(frame,"OI"));

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(20, 20, 80, 30);
        frame.add(lblNome);

        JTextField txtNome = new JTextField();
        txtNome.setBounds(100, 20, 150, 30);
        frame.add(txtNome);

        JRadioButton rdbMasculino = new JRadioButton("Masculino");
        rdbMasculino.setBounds(20, 110, 100, 30);
        JRadioButton rdbFeminino = new JRadioButton("Feminino");
        rdbFeminino.setBounds(120, 110, 100, 30);

        ButtonGroup grupoSexo = new ButtonGroup();
        grupoSexo.add(rdbMasculino);
        grupoSexo.add(rdbFeminino);

        frame.add(rdbMasculino);
        frame.add(rdbFeminino);

        JCheckBox chkProgramador = new JCheckBox("Programador");
        chkProgramador.setBounds(20, 150, 150, 30);
        JCheckBox chkProfessor = new JCheckBox("Professor");
        chkProfessor.setBounds(120, 150, 150, 30);
        frame.add(chkProgramador);
        frame.add(chkProfessor);

        String[] cores = {"Vermelho", "Verde", "Azul", "Amarelo"};
        JComboBox<String> cbxCores = new JComboBox<>(cores);
        cbxCores.setBounds(20, 190, 100, 30);
        frame.add(cbxCores);

        String[] frutas = {"Maçã", "Banana", "Laranja", "Uva", "Pera"};
        JList<String> lstFrutas = new JList<>(frutas);
        lstFrutas.setBounds(20, 230, 100, 80);
        frame.add(lstFrutas);

        JSlider slider = new JSlider(0, 100, 50);
        slider.setBounds(20, 320, 200, 50);
        frame.add(slider);

        ImageIcon icon = new ImageIcon("F://Faculdade/POO/Java/Emanuell_Henrique/resources/imagens/image.png"); // Substitua pelo caminho da sua imagem
        JLabel lblIcone = new JLabel(icon);
        lblIcone.setBounds(280, 20, 200, 150);
        frame.add(lblIcone);

        // Tornando a janela visível
        frame.setVisible(true);
    }
}
