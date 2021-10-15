/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asignacion4;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author hendryf
 * 24.09.21
 */
public class Ventana_principal extends JFrame{
    
    private Panel_maquina panel;
    
    public Ventana_principal(){
        super();
        setTitle("Maquina PostFija");
        setSize(800,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container contenedor = getContentPane();
        contenedor.setLayout(new BorderLayout());
        
        panel = new Panel_maquina();
        contenedor.add(panel, BorderLayout.CENTER);
    }
}
