package Aulas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TratamentoExcessoes extends JFrame{
    private JTextField txtNumero;
    private JButton btnCalc, btnForcarNull;

    public TratamentoExcessoes(){
        setTitle("Tratamento de Exceções");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        txtNumero = new JTextField(10);
        btnCalc = new JButton("Calcular");
        btnForcarNull = new JButton("Forçar NullPointerException");
        
        btnCalc.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                try {
                    int n = Integer.parseInt(txtNumero.getText());
                    JOptionPane.showMessageDialog(null, "Quadrado é: " + (n * n));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Erro: Entrada inválida. Por favor, insira um número inteiro.", "Erro", JOptionPane.ERROR_MESSAGE);
                }catch (ArithmeticException ex) {
                    JOptionPane.showMessageDialog(null, "Não é possivel dividir por zero: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }catch (NullPointerException ex) {
                    JOptionPane.showMessageDialog(null, "Informacao Obrigatoria.", "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (ArrayIndexOutOfBoundsException ex) {
                    JOptionPane.showMessageDialog(null, "Erro: Índice invalido", "Erro", JOptionPane.ERROR_MESSAGE);
                }catch (OutOfMemoryError ex) {
                    JOptionPane.showMessageDialog(null, "Erro: Memória insuficiente", "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro desconhecido : " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        }       
        );
     
        btnForcarNull.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtNumero.setText(null); 
            }
        });

        add(new JLabel("Digite um numero:"));
        add(txtNumero);
        add(btnCalc);
        add(btnForcarNull);
    }

    public static void main(String[] args) {
        new TratamentoExcessoes().setVisible(true);
    }


}
