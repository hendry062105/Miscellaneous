/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asignacion5;
//agregar la clase Nodo

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hendryf
 * 26.09.21
 */
public class Estudiante {
   private String nombre;
   private double altura;

    public Estudiante(String nombre, double altura) {
        this.nombre = nombre;
        this.altura = altura;
    }
    
    public Estudiante(Estudiante obj) {
        nombre = obj.nombre;
        altura = obj.altura;
    }
   
        public String toString(){
            return String.format("%1$1.2f ",altura);
        }
        
        public int compareTo(Estudiante obj){
            int resp= 0;
//            int resp = (int)Math.round(altura - obj.altura);
            if (altura -obj.altura > 0){
                resp = 1;
            }else if (altura -obj.altura > 0){
                resp = -1;
            }
            return resp;
        }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    
    public static Lista<Estudiante> leer (String nombre){
        File archivo = new File("datos.txt");//la direccion es relativa, el va tratar de ubicar el archivo de datos en la misma estructura del proyecto
        Lista<Estudiante> lista = new Lista<>();
        try {
            Scanner entrada = new Scanner(archivo);
            entrada.useDelimiter(";");//el separador es el ;
            entrada.useLocale(Locale.US);
            while (entrada.hasNext()) {                
                String name = entrada.next().trim();
                Double altura = Double.parseDouble(entrada.next());
//                Double altura = Double.parseDouble(entrada.next());
                lista.addUltimo(new Estudiante(name,altura) );
            }
            entrada.close();
        }catch(FileNotFoundException ex){
            Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE,null,ex);
        }
        return lista;
    }
}
