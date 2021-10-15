/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asignacion5;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author hendryf
 * 26.09.21
 */
public class Main {
//F7 F8 Debuggin
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Lista_estudiantes> Lista_filas = new ArrayList<>();
        Lista<Estudiante> lista =  Estudiante.leer("datos.txt");
        Lista_estudiantes lista_estudiantes = new Lista_estudiantes(lista);
        System.out.println("* * * LOS TRES DATOS INICIALES DE LA SIGUIENTE LISTA SON LOS ORIGINALES DEL PROBLEMA, EL RESTO SON ADICIONALES");
        System.out.println("Lista: " + lista);
        lista_estudiantes.ordenamiento();
        System.out.println("Lista ordenada: " + lista_estudiantes.getLista());
        int n = 3;
        System.out.println("Para el caso en que cada fila se le fija un máximo de n = " + n + " estudiantes, el listado es:");
        Lista_filas = lista_estudiantes.generarArreglos(n);
        for (int i = 0; i < Lista_filas.size()-0; i++) {
            System.out.println("Fila" + i + ": " + (Lista_filas.get(i)));
        }
    }
}
