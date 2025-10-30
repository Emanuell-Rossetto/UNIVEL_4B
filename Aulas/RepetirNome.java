    package Aulas;

    import javax.swing.*;
    import java.awt.*;
    import java.awt.event.*;

    public class RepetirNome extends JFrame {
        private JTextField txtNome, txtQuantidade;
        private JTextArea txtResultado;
        private JButton btnExecutar;   

        public RepetirNome() {
            setTitle("Repetir Nome");
            setSize(1000, 300);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setLayout(new FlowLayout());

            JLabel lb1Nome = new JLabel("Digite seu nome Nome:");
            txtNome = new JTextField(5);

            JLabel lb2Qtd = new JLabel("Digite a quantidade de vezes que deseja repetir:");
            txtQuantidade = new JTextField(5);

            btnExecutar = new JButton("Repetir");
            txtResultado = new JTextArea(10, 35);
            txtResultado.setEditable(false);

            JScrollPane scroll = new JScrollPane(txtResultado);


            JPanel painel = new JPanel();
            painel.add(lb1Nome);
            painel.add(txtNome);
            painel.add(lb2Qtd);
            painel.add(txtQuantidade);
            painel.add(btnExecutar);
            painel.add(scroll);
            add(painel);


            btnExecutar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String nome = txtNome.getText().trim();
                    String quantidadeStr = txtQuantidade.getText().trim();
                    
                    if (nome.isEmpty() || quantidadeStr.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
                        return;
                    }
                    
                    int quantidade;
                    try {
                        quantidade = Integer.parseInt(quantidadeStr);
                        if (quantidade <= 0) {
                            JOptionPane.showMessageDialog(null, "A quantidade deve ser um número positivo.");
                            return;
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Quantidade inválida. Por favor, digite um número inteiro.");
                        return;
                    }

                    StringBuilder resultado = new StringBuilder();
                    for (int i = 0; i < quantidade; i++) {
                        resultado.append(nome).append("\n");
                    }
                    
                    txtResultado.setText(resultado.toString());
                }
            });

        }
        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                RepetirNome frame = new RepetirNome();
                frame.setVisible(true);
            });
        }
    }
