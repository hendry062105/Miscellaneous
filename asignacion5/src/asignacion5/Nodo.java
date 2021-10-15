/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asignacion5;

/**
 *
 * @author hendryf
 * 24.09.21
 * @param <AnyType> Tipo de dato que almacena el nodo
 */
public class Nodo<AnyType> {
    private AnyType dato;
    private Nodo<AnyType> enlace; //proximo nodo de la estructura
    
    /**
     * Metodo constructor para ultimo nodo
     * Nodo sin enlace
     * @param dato 
     */
    public Nodo(AnyType dato){
        this.dato = dato;
        enlace = null;  
    }
    
    /**
     * Metodo constructor a partir de las especificaciones
     * @param dato
     * @param enlace 
     */
    public Nodo(AnyType dato, Nodo<AnyType> enlace ){
        this.dato = dato;
        this.enlace = enlace;
    }

    public AnyType getDato() {
        return dato;
    }

    public void setDato(AnyType dato) {
        this.dato = dato;
    }

    public Nodo<AnyType> getEnlace() {
        return enlace;
    }

    public void setEnlace(Nodo<AnyType> enlace) {
        this.enlace = enlace;
    }
    
    @Override
    public String toString(){
        return String.valueOf(dato) ;
    }
}
