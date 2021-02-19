package guia1dsm;

import java.util.Scanner;

public class Ejercicio4 {

    public static void main(String... args) {
        Scanner input = new Scanner(System.in);
        int x[], y[], n = 0; 
        String r[];
        System.out.printf("Cuantos pares coordenados desea ingresar? ");
        n = input.nextInt();
        x = new int [n];
        y = new int [n];
        r = new String [n];
        for(int i = 0; i < n; i++){
            System.out.printf("Ingrese la coordenada X del punto %d: ", i + 1);
            x[i] = input.nextInt();
            System.out.printf("Ingrese la coordenada Y del punto %d: ", i + 1);
            y[i] = input.nextInt();
            
            if (x[i] > 0 && y[i] > 0)   r[i] = "Cuadrante 1";
            else if (x[i] > 0 && y[i] < 0)  r[i] = "Cuadrante 4";
            else if (x[i] < 0 && y[i] > 0)  r[i] = "Cuadrante 2";
            else    r[i] = "Cuadrante 3";       
        }
        for(int i = 0; i < n; i++)
            System.out.printf("El punto (%d, %d) esta en el %s \n", x[i], y[i], r[i]);
    }
}
