/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asignacion3;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;
import java.util.*;

/**
 *
 * @author hendryf
 * 18.09.21
 */
public class Tablero extends JPanel{
    private Pieza m[][];
    public Oyente oyente;
    private Pieza pieza1;
    
    public int count_intercambios;
    public int count_giros;
    public JTextField giros_txt = new JTextField("0");
    public JTextField intercambios_txt = new JTextField("0");
    private ArrayList<Integer> ubicaciones;
    /**
     * M'etodo constructor de un objeto de la clase Tablero con Piezas ubicadas y giradas de manera aleatoria.
     */
    public Tablero(){
        super();
        giros_txt.setEnabled(false);
        giros_txt.setDisabledTextColor(Color.BLACK);
        intercambios_txt.setEnabled(false);
        intercambios_txt.setDisabledTextColor(Color.BLACK);
        //layout
        setLayout(new BorderLayout());
        JPanel panel_centro = new JPanel();
        panel_centro.setLayout(new GridLayout(3, 3, 2, 2));//panel_centro.setLayout(new GridLayout(3, 3)
        //creacion
        m = new Pieza[3][3];
        oyente = new Oyente();
        ubicaciones = vectorSinRepetidos(9, 0, 8);
        for (int k = 0; k < m.length*m[0].length;k++){
            int r_g = (int) (Math.random()*(3 - 0 + 1) + 0);
            int r_u = ubicaciones.get(k);// todo depende de k
            int i_r = r_u/3;int j_r = r_u%3;//i_r = f(r_u) //j_r = g(r_u)
            String ruta = String.format("/imagenes/LogoUC_%1$1d_%2$1d.jpg", i_r + 1, j_r + 1); 
            ImageIcon img = new ImageIcon(getClass().getResource(ruta));
            m[i_r][j_r] = new Pieza(i_r,j_r,r_u,img);//k++: primero la utilizo, ella vale 0, y luego se auto incrementa a 1
            m[i_r][j_r].setGiro(r_g);
            m[i_r][j_r].addMouseListener(oyente);
            panel_centro.add(m[i_r][j_r]);
        }
        add(panel_centro,BorderLayout.CENTER);
    }
    /**
     * M'etodo que ordena las Piezas de un objeto de la clase Tablero que hace el llamado.
     * * * Puede aplicar mostrar simplemente la imagen ordenada, pero, en este caso decid'i aplicar un m'etodo para ordenar como lo indica el JButton. * * *
     */
    public void ordenar_tablero(){
        for (int l = 0; l < ubicaciones.size() ; l++) {
            for (int u = l + 1; u < ubicaciones.size(); u++) {
                int i_l = l/3;int j_l = l%3;int i_u = u/3;int j_u = u%3;

                if (ubicaciones.get(l) > ubicaciones.get(u)){
                    int temp = ubicaciones.get(l);
                    ubicaciones.set(l, ubicaciones.get(u));
                    ubicaciones.set(u,temp);
                    m[i_l][j_l].intercambiar(m[i_u][j_u]);
                }
            }
        }
        for (int idx = 0; idx < m.length*m[0].length; idx++) {
            int i = idx/3;int j = idx%3;
            while(m[i][j].getGiro() != 0){
                m[i][j].setGiro(m[i][j].getGiro() - 1);
            }
        }
    }
    /**
     * Metodo que que le aplica removeMouseListener a m[i][j] para todo i, y j, en el caso de que el Tablero tenga giros y ubicaciones ordenadas para cada Pieza.
     */
    public void fin() {
        int s = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                s += m[i][j].getGiro();
            }
        }
        boolean resp = true;
        for (int i = 0; i < ubicaciones.size(); i++) {
            resp &= ubicaciones.get(i) == i;
        }
        if (s == 0 && resp){
            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < m[0].length; j++) {
                    m[i][j].removeMouseListener(oyente);
                }
            }
            if (pieza1 != null){
                pieza1.setBorder(BorderFactory.createEmptyBorder());
                pieza1 = null;
            }
        System.out.println("Fin del juego");
        }
    }
    
    //valores al azar sin valores repetidos entre [a, b]
    public static ArrayList<Integer> vectorSinRepetidos(int n, int a, int b){//del paquete java.util
        int i = 0;
        ArrayList<Integer> vector = new ArrayList<>();
        while (vector.size() < n){
        //    while (i < n){//Alternativa
            int valor = (int) (Math.random()*(b - a + 1) + a);
            //arreglo no contiene el valor
            if (!vector.contains(valor)){
                vector.add(valor);
        //            i++;//Alternativa
            }
        }
        return vector;
    }
    
    private class Oyente extends MouseAdapter{
        @Override
        public void mouseEntered(MouseEvent me) {
            super.mouseEntered(me); //To change body of generated methods, choose Tools | Templates.
            setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        @Override
        public void mouseClicked(MouseEvent me) {
            super.mouseClicked(me); //To change body of generated methods, choose Tools | Templates.
            if (me.getButton() == MouseEvent.BUTTON3){
                Pieza pieza0 = (Pieza) me.getSource();
                if ((pieza0.getGiro() + 1) > 3){pieza0.setGiro(0);
                }else{pieza0.setGiro(pieza0.getGiro() + 1);
                }
                Pieza aux = null;
                if (pieza1 != null){
                pieza1.setBorder(BorderFactory.createEmptyBorder());
                pieza1 = null;
                }
                count_giros++;
                System.out.println("Giros totales: "+ count_giros);
                giros_txt.setText(count_giros + "");
            }

            if (me.getButton() == MouseEvent.BUTTON1){
                Pieza aux = (Pieza) me.getSource();
                if (pieza1 == null){
                pieza1 = aux;
                pieza1.setBorder(BorderFactory.createLineBorder(Color.GREEN,5));
                }else{
                    if (aux != pieza1){
                        //intercambio
                        int idx1 = (aux.getFila())*(3) + aux.getColumna();
                        int idx2 = (pieza1.getFila())*(3) + pieza1.getColumna();
                        int temp = ubicaciones.get(idx1);
                        ubicaciones.set(idx1, ubicaciones.get(idx2));
                        ubicaciones.set(idx2,temp);
                        aux.intercambiar(pieza1);
                        pieza1.setBorder(BorderFactory.createEmptyBorder());
                        pieza1 = null;
                        count_intercambios++;
                        System.out.println("Intercambios totales:"+ count_intercambios);
                        intercambios_txt.setText(count_intercambios + "");
                    }
                }
            }
            fin();
        }
    }
    /*
        0  1 (2)
        3  4  5
        6  7  8
    2 --> Fila: 2/3 = 0; Columna: 2%3 = 2
    */

    public ArrayList<Integer> getUbicaciones() {
        return ubicaciones;
    }
}
           

