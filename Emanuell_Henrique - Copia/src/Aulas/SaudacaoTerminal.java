package Aulas;
import java.util.Scanner;


public class SaudacaoTerminal {
    public static void main(String[] args){
        //Le entrada de usuario
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite seu nome");
        String nome = entrada.nextLine();


        System.out.println("Ola, " + nome + "! Seja bem vindo");

        entrada.close();
    }
}
