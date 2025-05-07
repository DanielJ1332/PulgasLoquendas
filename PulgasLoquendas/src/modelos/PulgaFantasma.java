/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.awt.Color;
import java.awt.Graphics;
import static modelos.Pulga.ALTO;
import static modelos.Pulga.ANCHO;
import static modelos.Pulga.NO_IMPACTO;

/**
 *
 * @author Daniel Muñoz
 */
public class PulgaFantasma extends Pulga implements Runnable{
    
    public static final int IMPACTO_FANTASMA = 3;
    private Boundable bound;
    private int velocidadX;
    private int velocidadY;
    private boolean ejecutar;

    public PulgaFantasma(int x, int y, Boundable bound) {
        super(x, y);
        this.bound = bound;
        this.velocidadX = 3;
        this.velocidadY = 3;
        this.ejecutar = true;
    }
    
    @Override
    public int verificarImpacto(int dx, int dy){
        if(dx > x & dx < x+ANCHO & dy > y & dy < y+ALTO){
            gritar();
            ejecutar = false;
            return IMPACTO;
        }
        return NO_IMPACTO;
    }
    
    @Override
    public void dibujar(Graphics g) {
        g.setColor(Color.blue);
        g.fillOval(x, y, ANCHO, ALTO);
    }
    
    private void mover(){
        x += velocidadX;
        y += velocidadY;
        if(x + ANCHO >= bound.getBoundX() | x <= CampoBatalla.CONST_MARGEN_X){
            velocidadX *= -1;
        }
        if (y + ALTO >= bound.getBoundY() | y <= CampoBatalla.CONST_MARGEN_Y) {
            velocidadY *= -1;
        }
    }

    @Override
    public void run() {
        while (ejecutar) {
            mover();
            try {
                Thread.sleep(50); // ajusta la velocidad de movimiento
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
}
