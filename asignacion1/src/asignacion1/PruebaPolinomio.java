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
public class PruebaPolinomio {
    /**
    * M'etodo que retorna un vector de enteros (int[]) cuyo n'umero de elementos est'a entre 1 y 11
    * (Lo que corresponde a Polinomios de grado entre 0 y 10) y cada elemento es un valor entero 0 y 100
    * @return 
    */
    public static int[] generate_coef(){
//    int coef_length = (int) (Math.round(Math.random()*10) + 1); Alternativa
    int coef_length = (int) (Math.random()*((11 - 1) + 1)) + 1;
    int coef[] = new int[coef_length];
        for (int i = 0; i < coef.length; i++) {
//            coef[i] = (int) Math.round(Math.random()*100); Alternativa
            coef[i] = (int) (Math.random()*((100 - 0) + 1)) + 0;//En este CASO se le asign'o valores Enteros, (pero tambi'en pueden ser valores Reales)
        }
    return coef;
    }
    
   public static void main(String[] args) {
        //Run File: Shift + F6
        //#################################### Parte1 ####################################
        System.out.println(" * * * * * * * * * * * * * Parte1 * * * * * * * * * * * * * *");
        
        int p_coef[] = generate_coef();
        int q_coef[] = generate_coef();
        Polinomio p = new Polinomio(p_coef);
        Polinomio q = new Polinomio(q_coef);
        System.out.println("P(x) = " + p);
        System.out.println("Q(x) = " + q);
//        System.out.println("Derivada Polinomio Q(x) = " + q.derivar()); //Prueba de derivar()
       
        //Genera un valor aleatorio para una variable x
        double x = Math.random();//Sin especificaci'on en el enunciado sobre el rango de valores de x, asumido un rango entre 0 y 1
        //Muestra el resultado de evaluar P(x) y Q(x).
        System.out.println(String.format("x = %1$.2f", x));
        System.out.println(String.format("\nRESP:\nP(%1$.2f) = %2$.2f" ,x, p.evaluar(x)));
        System.out.println(String.format("Q(%1$.2f) = %2$.2f" ,x, q.evaluar(x)));
        //Muestra por consola el resultado de P(x) + Q(x), P(x)- Q(x) y P(x).Q(x)
        System.out.println("P(x) + Q(x) = " + p.sumar(q));
        System.out.println("P(x) - Q(x) = " + p.restar(q));
        System.out.println("P(x).Q(x) = " + p.multiplicar(q));
        
        
        //PRUEBA DEL AJUSTE DEL GRADO DEL POLINOMIO
//        int p_coef_test[] = {0,1,1,1};Polinomio p_t = new Polinomio(p_coef_test);
//        int q_coef_test[] = {1,1,1,1};Polinomio q_t = new Polinomio(q_coef_test);
//        System.out.println(p_t.restar(q_t));
//        System.out.println(p_t.restar(q_t).grado);//CASO: public grado
        
        
    } 
}
