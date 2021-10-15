/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asignacion3;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import javax.swing.*;

/**
 *
 * @author hendryf
 * 18.09.21
 */
public class Pieza extends JLabel{
    private  int fila;
    private int columna;
    private int giro;
    private int ubicacion;
    private ImageIcon imagenes[];
    
    public Pieza(int fila, int columna, int ubicacion, ImageIcon img){
        super();
        this.fila = fila;
        this.columna =  columna;
        this.ubicacion = ubicacion;
        giro = 0;//0:sin giro, 1,2,3: 90,180,270
        imagenes = new ImageIcon[4];
        imagenes[0] = img;
        rotaciones(imagenes);
    }
    
    private void rotaciones(ImageIcon vector[]){
        for (int i = 0; i < 3; i++) {
            vector[i + 1] = rotateIcon(vector[i], 90);
        }
    } 
    
    public static ImageIcon rotateIcon(ImageIcon icon, int angle) { 
        int w = icon.getIconWidth();
        int h = icon.getIconHeight();
        int type = BufferedImage.TYPE_INT_RGB;
        BufferedImage image = new BufferedImage(h, w, type);
        Graphics2D g2 = image.createGraphics(); double x = (h - w) / 2.0;
        double y = (w - h) / 2.0; 
        AffineTransform at = AffineTransform.getTranslateInstance(x, y);
        at.rotate(Math.toRadians(angle), w / 2.0, h / 2.0); 
        g2.drawImage(icon.getImage(), at, null);//g2.drawImage(icon.getImage(), at, this);/estoy usando el this como observador si le paso null, entonces si se convierte en algo totalmente estatico
        //el ultimo componente es el observador, el observador o es un objeto que establezca alguna referencia con el paqueta javax swing o con un componente de gui, o puede ser null como en este momento
        g2.dispose(); return icon = new ImageIcon(image); 
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs); //To change body of generated methods, choose Tools | Templates.
        grphcs.drawImage(imagenes[giro].getImage(), 0, 0, getWidth(),getHeight(),null);
    }

    public int getGiro() {
        return giro;
    }

    public void setGiro(int giro) {
        this.giro = giro;
        repaint();//si llamo a repaint estaria obligandolo a llamar a su paintcomponent
    }
    
    public void intercambiar(Pieza obj){
        int aux;
        // * * * COMENTADO EN CLASE * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
//        aux = fila;
//        fila = obj.fila;
//        obj.fila = aux;
//        
//        aux = columna;//la variable aux la puedo reutilizar, en cada uno de los espacios vacios que estoy dejando culminan esos procesos de intercambio
//        columna = obj.columna;
//        obj.columna = aux;
        // * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
        
        aux = giro;
        giro = obj.giro;
        obj.giro = aux;
        
        aux = ubicacion;
        ubicacion = obj.ubicacion;
        obj.ubicacion = aux;
        
        ImageIcon imagenes_aux[];
        imagenes_aux = imagenes;
        imagenes = obj.imagenes;
        obj.imagenes = imagenes_aux;
        //son intercambios que afectaron objetos, a la pieza que hizo el llamado de intercambiar y a obj que fue recibida en la cabecera del metodo
        repaint();//se actualiza la pieza que hace el llamado al metodo
        obj.repaint();//
    }

    public ImageIcon[] getImagenes() {
        return imagenes;
    }

    public void setImagenes(ImageIcon[] imagenes) {
        this.imagenes = imagenes;
    }

    public int getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(int ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
}
