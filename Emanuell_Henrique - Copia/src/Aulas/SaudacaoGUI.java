package Aulas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SaudacaoGUI extends JFrame {
    private JTextField CampoNome;
    private JButton BotaoSaudar;
    private JLabel LabelMensagem;
    


public SaudacaoGUI(){
    setTitle("Programa saudacao");

    setSize(350, 350);
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    setLocationRelativeTo(null);

    JPanel painel = new JPanel();
    painel.setLayout(new FlowLayout());

    CampoNome = new JTextField(20);

    BotaoSaudar = new JButton("Saudar");

    LabelMensagem = new JLabel("Digite seu nome em saudar");

    painel.add(new JLabel("nome"));
    painel.add(CampoNome);
    painel.add(BotaoSaudar);
    painel.add(LabelMensagem);

    BotaoSaudar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){

            String nome = CampoNome.getText().trim();

            if (nome.isEmpty()){
                LabelMensagem.setText("Por favor digite seu nome");
            }
            else{
                LabelMensagem.setText("Ola, " + nome + "! Seja bem vindo");
            }
        }
    });
    add(painel);
    }

public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SaudacaoGUI janela = new SaudacaoGUI();
            janela.setVisible(true);
        });
    }



}