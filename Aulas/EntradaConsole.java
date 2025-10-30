package Aulas;
import java.util.Scanner;

public class EntradaConsole {

    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Digite seu nome: ");
        String nome = entrada.nextLine(); 

        System.out.print("Digite sua idade: ");
        int idade = entrada.nextInt();
        
        System.out.print("Digite sua altura: ");
        double altura = entrada.nextDouble();

        System.out.println("Seu nome é: " + nome);
        System.out.println("Sua idade é: " + idade);
        System.out.println("Sua altura é: " + altura);
        

    }
}