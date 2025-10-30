package Aulas;
import javax.swing.*;
public class HelloWorldGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello, World!");
        JButton button = new JButton("clique-me!");
        frame.add(button);
        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
