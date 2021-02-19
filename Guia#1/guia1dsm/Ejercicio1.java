package guia1dsm;

import java.util.Scanner;

public class Ejercicio1 {

    public static void main(String... args) {
        Scanner input = new Scanner(System.in);
        int n1, n2;
        System.out.print("Ingrese el numerador:");
        n1 = input.nextInt();
        System.out.print("Ingrese el denominador (no puede ser 0):");
        n2 = input.nextInt();
        
        if((n1 % n2) == 0)
            System.out.printf("El numero %d es divisible por %d", n1, n2);
        else
            System.out.println("No son Divisibles");
        
    }
    
}
