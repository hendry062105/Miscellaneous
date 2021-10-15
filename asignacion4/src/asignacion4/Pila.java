/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asignacion4;

/**
 *
 * @author hendryf
 * 24.09.21
 */
public class Pila<AnyType> {

    private Nodo<AnyType> tope;//tope = cabecera
    private Integer count;

    /**
     * Metodo Contructor pila vacía
     */
    public Pila() {
        tope = null;
        count = 0;
    }

    /**
     * Metodo para añadir un elemento en el tope de la pila
     *
     * @param dato
     */
    public void push(AnyType dato) {
        tope = new Nodo(dato, tope);
        count++;
    }

    /**
     * Metodo para eliminar el elemento del tope de la pila
     *
     * @return Primer de la estructura
     */
    public AnyType pop() {
        AnyType resp = null;
        if (!isEmpty()) {
            resp = tope.getDato();
            //remover el primero se desplaz el tope al siguiente nodo
            tope = tope.getEnlace();
            count--;
        }
        return resp;
    }

    /**
     * Metodo para retornar el primer elemento de la pila
     *
     * @return
     */
    public AnyType peek() {
        AnyType resp = null;
        if (!isEmpty()) {
            resp = tope.getDato();
        }
        return resp;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    @Override
    public String toString(){
        String resp = "";
        Nodo<AnyType> aux = tope;
        while(aux != null){
            resp += aux.getDato() + "\n";
            //desplazamiento
            aux = aux.getEnlace();
        }
        return resp;
    }
}
