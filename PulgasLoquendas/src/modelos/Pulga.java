package modelos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import sonidos.ReproductorDolor;
/**
 *
 * @author Daniel Muñoz
 */
public class Pulga {
    protected int x;
    protected int y;
    public static final int ANCHO = 50;
    public static final int ALTO = 50;
    public static final int NO_IMPACTO = 0;
    public static final int IMPACTO = 1;
    ReproductorDolor voz;
    
    public Pulga(int x, int y){
        this.x = x;
        this.y = y;
        voz = new ReproductorDolor();
    }
    
    public void gritar(){
        
        voz.reproducirDolor(true);
        
    }
    
    public void saltar(int xMax, int yMax){
        
        x = (int) (Math.random() * (xMax - ANCHO));
        y = (int) (Math.random() * (yMax - ALTO));
    }
    
    public int verificarImpacto(int dx, int dy){
        if(dx > x & dx < x+ANCHO & dy > y & dy < y+ALTO){
            
            gritar();
            return IMPACTO;
        }
        return NO_IMPACTO;
    }
    
    public void dibujar(Graphics g){
        g.setColor(Color.black);
        g.fillRect(x, y, ANCHO, ALTO);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    
}
