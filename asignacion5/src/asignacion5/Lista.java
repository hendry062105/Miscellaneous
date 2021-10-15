/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asignacion5;

/**
 *
 * @author hendryf
 * 26.09.21
 * <Anytype> implements comparable
 */
public class Lista<AnyType> {
    private Nodo<AnyType> cabecera;
    private Nodo<AnyType> ultimo;
    private Integer count;
    
    public Lista(){
        cabecera = null;
        ultimo = null;
        count = 0;
    }
    
    public int size(){
        return count;
    }
    
    public boolean isEmpty(){
        return count == 0;
    }
    
    public void addCab(AnyType dato){
        cabecera = new Nodo(dato, cabecera);
        if(isEmpty()){
            ultimo = cabecera;
        }
        count++;
    }
    
    public void addUltimo(AnyType dato){
        if (isEmpty()){
            addCab(dato);
        }else{
            Nodo<AnyType> aux = new Nodo(dato);
            //actualizar el enlace del ultimo Nodo
            ultimo.setEnlace(aux);
            //desplazer el ultimo
            ultimo = ultimo.getEnlace();
//            ultimo = aux;// la misma instrucci'on que la anterior
            
        }
        count++;
    }
    
    public AnyType removeCab(/**AnyType dato**/){
        AnyType resp = null;
        if(isEmpty()){
            resp = cabecera.getDato();
            cabecera = cabecera.getEnlace();
            count--;
        }
        return null;
    }
    
//    public abstract int compareTo(Object obj);
    
    
//    public void ordenamiento(){
//        //metodo de seleccion
//        Nodo<AnyType> aux1 = cabecera;
//        for (int i = 0; i < count - 1; i++) {
//            Nodo<AnyType> aux2 = aux1.getEnlace(); 
//            for (int j = 0; j < count; j++) {
//                if(aux2.getDato().compareTo(aux1.getDato()) == 1);
//                aux2 = aux2.getEnlace();
//            }
//            aux1 = aux1.getEnlace();
//        }
//    }
    
    public void remove(int index){
       Nodo<AnyType> node_i = cabecera;
       Nodo<AnyType> cabecera1 = node_i;
        for (int i = 0; i <= index; i++) {
            if (i == index - 1){
                node_i.setEnlace(node_i.getEnlace().getEnlace());
            }
            
            node_i = node_i.getEnlace();
            
        }
        node_i=cabecera1;
        while (node_i != null){
             node_i = node_i.getEnlace();
             System.out.println(node_i + "Prueba");
        }
    }
    
    public void add(int index){
    
    }
    
    @Override
    public String toString(){
    Nodo<AnyType> aux = cabecera;
    String resp = "";
        while (aux != null) {            
            resp += aux.getDato() + "";
            //Desplazamiento
            aux = aux.getEnlace();
        }
        return resp;
    }

    public Nodo<AnyType> getCabecera() {
        return cabecera;
    }

    public void setCabecera(Nodo<AnyType> cabecera) {
        this.cabecera = cabecera;
    }

    public Nodo<AnyType> getUltimo() {
        return ultimo;
    }

    public void setUltimo(Nodo<AnyType> ultimo) {
        this.ultimo = ultimo;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
    
}
