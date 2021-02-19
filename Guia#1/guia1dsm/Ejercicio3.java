package guia1dsm;

import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String... args) {
        Scanner input = new Scanner(System.in);
        int n = 0, npares = 0, nimpares = 0; 
        int numeros[]; 
        System.out.printf("Cuantos numeros desea ingresar?: ");
        n = input.nextInt();
        numeros = new int [n];
        for(int i = 0; i < n; i++){
            System.out.printf("Ingrese el numero entero %d: ", i + 1);
            numeros[i] = input.nextInt();
            if ((numeros[i] % 2) == 0)
                npares++;
            else
                nimpares++;
        }
        System.out.printf("Hay %d pares y %d impares\n", npares, nimpares);
    }
}
