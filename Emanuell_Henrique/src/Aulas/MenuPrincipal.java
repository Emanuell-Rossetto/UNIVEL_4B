package Aulas;

import javax.swing.*;

public class MenuPrincipal extends JFrame {
    public MenuPrincipal() {
        setTitle("Menu Principal");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Criação de um menu
        JMenuBar menuBar = new JMenuBar();
        
        JMenu menuProgramas = new JMenu("Programas");
        addMenuItem(menuProgramas, "Aula 1 - Hello World", "Aulas.HelloWorldGUI");
        addMenuItem(menuProgramas, "Aula 2 - Saudacao", "Aulas.SaudacaoGUI");
        addMenuItem(menuProgramas, "Aula 3 - SwitchGUI", "Aulas.SwitchGUI");
        addMenuItem(menuProgramas, "Aula 4 - EntradaGrafica", "Aulas.EntradaGrafica");
        addMenuItem(menuProgramas, "Aula 4 - EntradaGrafica", "Aulas.RepetirNome");
        addMenuItem(menuProgramas, "Aula 5 - TratamentoExcessoes", "Aulas.TratamentoExcessoes");
        addMenuItem(menuProgramas, "Aula 6 - HashMap", "Aulas.ExerciciosHashMap");
        addMenuItem(menuProgramas, "Aula 7 - ObjetosBasicos", "Aulas.ObjetosBasicos");
        
        menuBar.add(menuProgramas);
        setJMenuBar(menuBar);
      }

    private void addMenuItem(JMenu menu, String nome, String nomeClasse) {
        JMenuItem menuItem = new JMenuItem(nome);
        menuItem.addActionListener(e -> {
            try {
                Class<?> clazz = Class.forName(nomeClasse);
                Object instancia = clazz.getDeclaredConstructor().newInstance();

                if (instancia instanceof JFrame) {
                    ((JFrame) instancia).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "A classe " + nomeClasse + " não é um JFrame.", "Erro", JOptionPane.ERROR_MESSAGE);
                }

            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao abrir " + nome, "Erro", JOptionPane.ERROR_MESSAGE);
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao abrir programa " + nomeClasse + ": " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

            menu.add(menuItem);
        } 

        public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MenuPrincipal menu = new MenuPrincipal();
            menu.setVisible(true);
        });
    }    
}
