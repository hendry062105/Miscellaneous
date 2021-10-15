/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asignacion4;

import java.util.*;
import javax.swing.JOptionPane;
import javax.xml.transform.Source;

/**
 *
 * @author hendryf
 * 24.09.21
 */
public class MaquinaPostfija {

    private Pila<Integer> p;

    public MaquinaPostfija() {
        p = new Pila<>();
    }
    
    public static boolean valid1(String exp){
        boolean ans = true;
        for (int i = 0; i < exp.length(); i++) {
            ans = ans & "0123456789+-*/^ ".contains(exp.substring(i,i + 1));
        }
        return ans;
    }
    
    public Integer evaluar(String exp, ArrayList<String> respuesta)  {
        if (!valid1(exp)){
            JOptionPane.showMessageDialog(null,"La expresi'on posee un caracter no valido");
            exp = "";
        }
        Scanner scan = new Scanner(exp);
        while (scan.hasNext()) {
            String valor_txt = scan.next();
            System.out.println("Valor:" + valor_txt);
            try {
                Integer valor = Integer.parseInt(valor_txt);
                //se encuentra un operando
                //apilar en pila p
                p.push(valor);
            } catch (Exception e) {
                //posiblemente sea un operador
                Integer izquierdo, derecho;
                Integer resultado;
                if (p.size() >= 2) {
                    derecho = p.pop();
                    izquierdo = p.pop();
                    switch (valor_txt) {
                        case "+":
                            resultado = izquierdo + derecho;
                            p.push(resultado);
                            break;
                        case "-":
                            resultado = izquierdo - derecho;
                            p.push(resultado);
                            break;
                        case "*":
                            resultado = izquierdo * derecho;
                            p.push(resultado);
                            break;
                        case "/":
                            resultado = izquierdo / derecho;
                            p.push(resultado);
                            break;
                        case "^":
                            resultado = (int) Math.pow(izquierdo, derecho);
                            p.push(resultado);
                            break;
                        default:
                            //validaciones requeridas
                    }

                } else {
                  //no se dispone de la cantidad de operandos requerida
                  if (valid1(exp)){
                    JOptionPane.showMessageDialog(null, "No se dispone de la cantidad de operandos requerida, en alguna de las etapas del proceso. \n* * * Verificar expresi'on * * *");
                    exp = "";
                  }
                }

            }
            respuesta.add(p + "");
        }
        Integer resp = null;
        if (p.size() == 1 ) {
            resp = p.peek();
        }
        return resp;
    }

    @Override
    public String toString() {
        return p + "";
    }
}
