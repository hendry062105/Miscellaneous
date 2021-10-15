/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asignacion5;

import java.util.ArrayList;

/**
 *
 * @author hendryf
 * 26.09.21
 */
public class Lista_estudiantes {
    private Lista<Estudiante> lista;
        
    public  Lista_estudiantes(Lista<Estudiante> lista){
            this.lista = lista;
    }
        
    public void ordenamiento(){
        //metodo de seleccion
        Nodo<Estudiante> aux1 = lista.getCabecera();
        for (int i = 0; i < lista.size() - 1; i++) {
            Nodo<Estudiante> aux2 = aux1.getEnlace(); 
            for (int j = 0; j < lista.size(); j++) {
                if (aux2 == null){break;}
                if(aux2.getDato().compareTo(aux1.getDato()) == 1){;//{ agregada
                    Estudiante estudiante = aux1.getDato();
                    aux1.setDato(aux2.getDato()); 
                    aux2.setDato(estudiante);
                }
                //System.out.println(lista);// * * * * * * * * * * * * * 
                aux2 = aux2.getEnlace();
            }
            aux1 = aux1.getEnlace();
        }
    }
        
   public String toString(){
       return lista + "";
   }
   
   public ArrayList<Lista_estudiantes> generarArreglos(int n){
           ArrayList<Lista_estudiantes> vector = new ArrayList<Lista_estudiantes>();
           int k = 1;
           ordenamiento();
           Nodo<Estudiante> aux = lista.getCabecera();
           int i = 1;
           Lista_estudiantes sublista = new Lista_estudiantes(null);
           while(aux != null){
               if (i == 1){
                    sublista.setLista(new Lista<Estudiante>());
               }
               if(i%2 == 0){
                   //agregar a la nueva sublista (rear)
                    sublista.getLista().addUltimo(new Estudiante(aux.getDato()));
               }else{
                   //impares en la cabecera
                    sublista.getLista().addCab(new Estudiante(aux.getDato()));
               }    
                i++;k++;
                //anadir al ArrayList
                if (i == n + 1 || k == lista.size()/**agregado**/){
                    vector.add(new Lista_estudiantes(sublista.getLista()));
                    i = 1;
                }
          aux = aux.getEnlace();
        }
        return vector;
    }

    public Lista<Estudiante> getLista() {
        return lista;
    }

    public void setLista(Lista<Estudiante> lista) {
        this.lista = lista;
    }
}
