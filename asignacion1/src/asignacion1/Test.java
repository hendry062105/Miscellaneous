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
public class Test {
    /**
 * M'etodo que retorna un arreglo Polinomio[] con los n polinomios de Chebyshev de primer orden. 
 * La f'ormula general para generarlos es: T(n) = 2x*T(n - 1) - T(n - 2)
 * @param n n'umero de elementos del arreglo
 * @return 
 */
    public static Polinomio[] chebyshev_array(int n) {
        Polinomio[] resp = new Polinomio[n];
        int coef0[] = {1}    ;Polinomio T_0 = new Polinomio(coef0);
        int coef1[] = {0,1}  ;Polinomio T_1 = new Polinomio(coef1);
        int coef_2x[] = {0,2};Polinomio p_2x = new Polinomio(coef_2x);
        
        Polinomio T_temp;
        
        resp[0] = T_0;
        resp[1] = T_1;

        for (int i = 2; i < resp.length; i++) {
            T_temp = T_1;
            T_1 = p_2x.multiplicar(T_1).restar(T_0);
            T_0 = T_temp;
            resp[i] = T_1;
        }
        return resp;
    }
    /**
     * Metodo que retorna un Polinomio a partir de la suma de los elementos de un arreglo Polinomio[]
     * @param obj Referencia de un arreglo tipo Polinomio con los coeficientes almacenados como estructura de datos
     * @return 
     */
    public static Polinomio sumar(Polinomio obj[]){
        Polinomio resp = new Polinomio();
        for (int i = 0; i < obj.length; i++) {
            resp = resp.sumar(obj[i]);
        }
        return resp;
    }
    
    public static void main(String[] args) {
        //Run File: Shift + F6
        //#################################### Parte2 ####################################
        System.out.println("* * * * * * * * * * * * * Parte2 * * * * * * * * * * * * * *\nRESP:");
        
        int n = 10;
        System.out.println("Los " + n + " primeros polinomios de Chebyshev son:");
        Polinomio chebyshev_arr[] = chebyshev_array(n);
        for (int i = 0; i < chebyshev_arr.length; i++) {
            System.out.println("T(" + i + ") = " + chebyshev_arr[i]);
        }
        System.out.println("\nLa suma de los " + n + " primeros polinomios de Chebyshev es:");
        
        System.out.println(sumar(chebyshev_arr));
    }
    
}
