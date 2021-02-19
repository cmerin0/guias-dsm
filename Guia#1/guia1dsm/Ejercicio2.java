package guia1dsm;

import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String... args) {
        Scanner input = new Scanner(System.in);
        int napro = 0, nrepro = 0, ns = 10; //ns es el numero de estudiantes, en nuestro caso 10
        int[] notas = new int[ns]; //para pruebas esta guardado en una variable y no es estatico
        for(int i = 0; i < ns; i++){
            System.out.printf("Ingrese el la nota #%d:", (i + 1));
            notas[i] = input.nextInt();
            if (notas[i] >= 7) 
                napro++;
            else
                nrepro++;
        }
        System.out.printf("Hay %d aprobados y %d reprobados\n", napro, nrepro);
    }
}
