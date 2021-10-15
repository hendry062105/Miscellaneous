/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asignacion1;

/**
 *
 * @author hendryf
 * 04.09.21
 */
public class Polinomio {
    //Campo de datos
    private int coef[];
    private int grado;
    private final int MAX_GRADO = 100;
    //Campo de metodos
    /**
     * M'etodo constructor vac'io por defecto 0x^0
     */
    public Polinomio(){
        grado = 0;
        //creacion del arreglo
        coef = new int[grado + 1];
        coef[0] = 0;     
    }
    /**
     * M'etodo constructor a partir de las especificaciones
     * @param coef Referencia de un arreglo tipo int con los coeficientes almacenados como estructura de datos
     */
    public Polinomio(int coef[]){
        grado = coef.length - 1;
        //creacion del arreglo vector
        this.coef = new int[grado + 1];
        //recorrido sobre el arreglo this.coef[]
        for (int i = 0; i < coef.length; i++){
            this.coef[i] = coef[i]; 
        }
    }
    /**
     * M'etodo constructor a partir de un objeto de la clase Polinomio 
     * @param obj 
     */
    public Polinomio(Polinomio obj){
        grado = obj.grado;
        //creacion del arreglo coef[]
        coef = new int[obj.coef.length];
        //recorrido del arreglo coef (asignacion de valores)
        for (int i = 0;i < coef.length;i++){
            coef[i] = obj.coef[i];
        } 
    }
    /**
     * M'etodo que retorna la representacion en string de un objeto de la clase Polinomio
     * @return
     */
    @Override
    public String toString(){ 
        String resp = "";
        int t_coef = coef.length - 1;
        if (coef.length == 1){
            resp += coef[0];
            return resp;
        }
        for (int i = t_coef; i >= 1;i--){
            String str = "";
            int abs_coef_i = Math.abs(coef[i]);
            if (abs_coef_i != 0 ){
                if (coef[i] > 0){str += "+";}else{str += "-";}
                if (abs_coef_i == 1 ){str += "x";}else {str += abs_coef_i + "x";}
                if (i != 1){str += "^" + i;}
                if (i == t_coef && coef[i] > 0){str = str.substring(1,str.length());}
            }
            resp += str;
        }
        if (coef[0] > 0){resp += "+" + coef[0];}else if(coef[0] < 0){resp += coef[0];}
        if (resp.substring(0,1).equals("+")){resp = resp.substring(1,resp.length());}
        return resp;        
    }
    /**
     * M'etodo que retorna un valor logico (TRUE) si el Polinomio que hace el llamado es igual a Polinomio que se recibe como parametro
     * @param obj
     * @return 
     */
    public boolean equals(Polinomio obj){
        boolean resp = true;
        if (grado != obj.grado){
        return false;
        }else{
            for (int i = 0; i < coef.length; i++) {
            if (coef[i] != obj.coef[i])
                return false;
            }
        }
        return resp;
    }
    /**
     * Metodo que retorna la suma del Polinomio que hace el llamado y Polinomio que se recibe como parametro (obj)
     * @param obj
     * @return 
     */
    public Polinomio sumar(Polinomio obj){
        Polinomio mayor,menor;
        if (grado > obj.grado){
           mayor = this;
           menor = obj;
        }else{
           menor = this;
           mayor = obj;
        }
        int v[] = new int[mayor.coef.length];
        for (int i = 0; i < v.length; i++) {
            if (i < menor.coef.length){
            v[i] = menor.coef[i] + mayor.coef[i];
            }else{
            v[i] = mayor.coef[i];
            }
        }
        //* * * Ajuste del tamano del vector de salida para tomar en cuenta el ajuste del grado del polinomio * * *
        int n_adj = v.length-1;
        for (int i = v.length - 1; i >= 0; i--) {
            n_adj = i;
            if (v[i] != 0) {
            break;
            };
        }
        int u[] = new int[n_adj + 1];
        for (int i = 0; i < u.length; i++){
            u[i] = v[i];
        }
        return new Polinomio(u);
    }
    /**
     * M'etodo que retorna la resta del Polinomio que hace el llamado y Polinomio que se recibe como parametro 
     * @param obj
     * @return 
     */
    // * * * Simplificado usando el metodo sumar * * *
     public Polinomio restar(Polinomio obj){
        Polinomio mayor,menor;
        int obj_coef[] = new int[obj.coef.length];
        Polinomio obj_neg = new Polinomio(obj_coef);
         for (int i = 0; i < obj_neg.coef.length; i++) {
             obj_neg.coef[i] = - obj.coef[i];
         }
        return this.sumar(obj_neg);
    }
     /**
      * Metodo que retorna la multiplicacion del Polinomio que hace el llamado y Polinomio que se recibe como parametro 
      * @param obj
      * @return 
      */
    public Polinomio multiplicar(Polinomio obj){
    Polinomio p,q, resp;
    p = this;
    q = obj; 
    int v[] = new int[(p.coef.length - 1) + (q.coef.length - 1) + 1];
    resp = new Polinomio(v);
    resp.grado = (this.coef.length - 1) + (obj.coef.length - 1);
    resp.coef = new int[resp.grado + 1];
            for (int i = 0; i < p.coef.length; i++) {
                for (int j = 0; j < q.coef.length; j++) {
                    resp.coef[i + j] += p.coef[i]*q.coef[j];
                }
            }
    return resp;
    }
    /**
     * M'etodo que retorna la evaluaci'on del Polinomio que hace el llamado en valor de x que se recibe como parametro
     * @param x
     * @return 
     */
    public double evaluar(double x){
        double resp = 0;
        for (int i = 0; i < coef.length; i++) {
            resp += coef[i]*Math.pow(x,i);
        }
        return resp;
    }
    /**
     * M'etodo que retorna un Polinomio (correspondiente a la derivada del Polinomio que hace el llamado)
     * @return 
     */
    public Polinomio derivar() {
        Polinomio p = this;
        int coef0[] = new int[p.coef.length - 1];
        Polinomio resp = new Polinomio(coef0);
        for (int i = 0; i < resp.coef.length; i++) {
            resp.coef[i] = p.coef[i + 1]*(i + 1);
        }
        return resp;
    }
}
