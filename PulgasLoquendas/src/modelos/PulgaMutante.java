package modelos;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Daniel Muñoz
 */

public class PulgaMutante extends Pulga{
    
    public static final int IMPACTO_MUTANTE = 2;
    
    public PulgaMutante(int x, int y) {
        super(x, y);
    }
    
    @Override
    public int verificarImpacto(int dx, int dy){
        if(dx > x & dx < x+ANCHO & dy > y & dy < y+ALTO){
            gritar();
            return IMPACTO_MUTANTE;
        }
        return NO_IMPACTO;
    }
    
    @Override
    public void dibujar(Graphics g) {
        g.setColor(Color.green);
        g.fillOval(x, y, ANCHO, ALTO);
    }
    
    @Override
    public void gritar(){
        
        voz.reproducirDolor(false);
        
    }
}
