import java.util.Scanner;

public class Testes {

    String getCurrentDirectory() {
        return this.getClass().getClassLoader().getResource("").getPath();
    }

    public static void main(String[] args) {
    	
    	String s = "";
    	
    	String result = s.getClass().getSimpleName();

    	System.out.println(result);
    	
    	
    	
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o primeiro valor para somar:");
        int soma1 = (int) scanner.nextDouble();

        System.out.println("Digite o segundo valor para somar:");
        double soma2 = scanner.nextDouble();

        double resultado = somar(soma1, soma2);
        System.out.println("Resultado da Soma: " + resultado);
        scanner.close();
    }

    private static double somar(double soma1, double soma2) {
        double resultado = soma1 + soma2;
        return resultado;

    }
    
   
    
}
