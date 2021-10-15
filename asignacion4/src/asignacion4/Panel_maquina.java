/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asignacion4;

import static asignacion4.MaquinaPostfija.valid1;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author hendryf
 * 24.09.21
 */
public class Panel_maquina extends JPanel {

    private JTextField expresion_txt;
    private JTextField filas_txt;
    private JTextField columnas_txt;
    private JButton evaluar_btn;
    private JPanel panel_centro;
    
    public Panel_maquina() {
        super();
        setLayout(new BorderLayout());

        JPanel panel_norte = new JPanel();
        panel_norte.setLayout(new FlowLayout());

        expresion_txt = new JTextField("1 2 - 4 5 ^ 3 * 6 * 7 2 2 ^ ^ / -");//   (– != -)
        expresion_txt.setColumns(20);
        panel_norte.add(expresion_txt);

        panel_norte.add(new JLabel("Filas:"));
        filas_txt = new JTextField("3");
        filas_txt.setColumns(3);
        panel_norte.add(filas_txt);
        panel_norte.add(new JLabel("Columnas:"));
        columnas_txt = new JTextField("6");
        columnas_txt.setColumns(3);
        panel_norte.add(columnas_txt);
        evaluar_btn = new JButton("Evaluar");
        evaluar_btn.addActionListener(new Oyente());
        panel_norte.add(evaluar_btn);

        //agregar panel norte al contenedor
        add(panel_norte, BorderLayout.NORTH);

        panel_centro = new JPanel();
        panel_centro.setLayout(null);
        panel_centro.setBackground(Color.WHITE);
        add(panel_centro, BorderLayout.CENTER);
    }

    private class Oyente implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            MaquinaPostfija maquina = new MaquinaPostfija();

            panel_centro.removeAll();
            int filas, columnas;
            try {// * * 
                filas = Integer.parseInt(filas_txt.getText());
                columnas = Integer.parseInt(columnas_txt.getText());
                panel_centro.setLayout(new GridLayout(filas, columnas, 10, 5));
                
                String[] v_str = expresion_txt.getText().split(" ");
                if (!expresion_txt.getText().isEmpty()) {
                    //solucion de la expresion
                    ArrayList<String> respuesta = new ArrayList<>();
                    maquina.evaluar(expresion_txt.getText().trim(), respuesta);
                    JPanel first_jpanel = new JPanel();
                    first_jpanel.setLayout(new BorderLayout());
                    first_jpanel.setBackground(Color.WHITE);
                        JTextPane_custom jtextpane_cm = new JTextPane_custom("\n\n\n\n");
                        first_jpanel.add(jtextpane_cm);
                        JLabel_custom first_jlabel_cm = new JLabel_custom(" ");
                        first_jpanel.add(first_jlabel_cm,BorderLayout.SOUTH);
                        panel_centro.add(first_jpanel);
                    
                    for (int i = 0; i < filas*columnas - 1; i++) {
                        JPanel jpanel = new JPanel();
                        jpanel.setBackground(Color.WHITE);
                        jpanel.setLayout(new BorderLayout());
                            JTextPane_custom jtextpane_cm_i = new JTextPane_custom(respuesta.get(i));
                            jpanel.add(jtextpane_cm_i);
                            JLabel_custom jlabel_cm = new JLabel_custom(v_str[i]);
                            jpanel.add(jlabel_cm,BorderLayout.SOUTH);
                            panel_centro.add(jpanel);
                    }
                    //ciclo para agregar al panel central todos los JTextArea con cada una 
                    //de las respuestas.
                    System.out.println("");
                    panel_centro.validate(); //actualizacion de la distribucion 
                    panel_centro.repaint();
                }
            } catch (Exception exc) {
                if (valid1(expresion_txt.getText())){
                    JOptionPane.showMessageDialog(null, "Falla conversión de filas y columnas \n * * * Verificar filas y columnas * * *");
                }
            }// * * * 
        }
    }
    
            
    public class JLabel_custom extends JLabel{
        public JLabel_custom(String str){
            super(str);
            setPreferredSize(new Dimension(18, 18));
            setHorizontalAlignment(JLabel.CENTER);
            setBackground(Color.WHITE);
            Font f = getFont();
            setFont(f.deriveFont(f.getStyle() & ~Font.BOLD));
        }
    }
    
    public class JTextPane_custom extends JTextPane{
        JTextPane jtextpane = new JTextPane();
        public JTextPane_custom(String str) {
            super();
            setLayout(new BorderLayout());
            String[] v_str = str.split("\n");
            int n = v_str.length ;
            if (n == 1){str = "\n\n" + str;};if (n == 2){str = "\n" + str;}
            str = str.replaceAll("\n$", "");
            jtextpane.setText(str);
            add(jtextpane, BorderLayout.SOUTH);
        }

        @Override
        protected void paintComponent(Graphics grphcs) {
            super.paintComponent(grphcs); //To change body of generated methods, choose Tools | Templates.
            setBackground(Color.WHITE);
            jtextpane.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.BLACK));
            StyledDocument doc = jtextpane.getStyledDocument();
            SimpleAttributeSet center = new SimpleAttributeSet();
            StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
            doc.setParagraphAttributes(0, doc.getLength(), center, false);
        }
    }
}
