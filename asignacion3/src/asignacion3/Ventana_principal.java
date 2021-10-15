/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asignacion3;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.*;
import java.util.ArrayList;
/**
 *
 * @author hendryf
 * 18.09.21
 */
public class Ventana_principal extends JFrame {
    private Tablero tablero1;
    
    private JPanel panel_north;
        private JLabel intercambios_lbl;
        private JLabel giros_lbl;
       
    private JPanel panel_south;
        private JSeparator separador_l = new JSeparator(); 
        private JButton ordenar_btn;
        private JSeparator separador_r = new JSeparator(); 
        
    public Ventana_principal(){
        super();
        setTitle("Logo UC");
        setSize(300,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container contenedor = getContentPane();
        contenedor.setLayout(new BorderLayout());
        tablero1 = new Tablero();
        contenedor.add(tablero1,BorderLayout.CENTER);
        panel_north = new JPanel();
        panel_north.setLayout(new GridLayout(1,4));
            intercambios_lbl = new JLabel();
            intercambios_lbl.setText("Intercambios: ");
            panel_north.add(intercambios_lbl);
            panel_north.add(tablero1.intercambios_txt);
            
            giros_lbl = new JLabel();
            giros_lbl.setText("Giros: ");
            panel_north.add(giros_lbl);
            panel_north.add(tablero1.giros_txt);
            contenedor.add(panel_north,BorderLayout.NORTH);
            
        panel_south = new JPanel();
        panel_south.setLayout(new GridLayout(1, 3));
            panel_south.add(separador_l);
            ordenar_btn = new JButton("Ordenar");
            panel_south.add(ordenar_btn );
            panel_south.add(separador_r);
            contenedor.add(panel_south,BorderLayout.SOUTH);
        
        ordenar_btn.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                  tablero1.ordenar_tablero();
            }
        }
        );
        
    }
}
