package Aulas;

import javax.swing.*;
import java.io.*;

public class ExemploArquivos {
    public static void main(String[] angs){
        try {
            String valor = JOptionPane.showInputDialog("Digite um numero: ");
            int numero = Integer.parseInt(valor);

            int resultado = 10 / numero;
            JOptionPane.showMessageDialog(null, "O resultado é: " + resultado);

            FileReader fr = new FileReader("arquivo.txt");
            fr.close();
        }
        catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Erro: Entrada inválida. Por favor, digite um número válido.");
        }
        catch (ArithmeticException e){
            JOptionPane.showMessageDialog(null, "Erro: Divisão por zero não é permitida.");
        }
        catch (FileNotFoundException e){
            JOptionPane.showMessageDialog(null, "Erro: Arquivo não encontrado.");
        }
        catch (IOException e){
            JOptionPane.showMessageDialog(null, "Erro: erro ao ler o arquivo.");
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro inesperado: " + e.getMessage());
        }
    }
}
