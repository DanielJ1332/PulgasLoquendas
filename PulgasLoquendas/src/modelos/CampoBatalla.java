package modelos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
/**
 *
 * @author Daniel Muñoz
 */
public class CampoBatalla implements Boundable{
    private int ancho;
    private int alto;
    public static final int CONST_MARGEN_X = 8;
    public static final int CONST_MARGEN_Y = 30;
    private ArrayList<Pulga> pulgas;

    public CampoBatalla(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
        pulgas = new ArrayList<>();
    }
    
    public void agregarPulga(int opc){
        int anchoPulga = Pulga.ANCHO;
        int altoPulga = Pulga.ALTO;
        int[] coor = calcularCoordenadas(anchoPulga, altoPulga);
        Pulga pulga = null;
        if(opc == KeyEvent.VK_P){
            pulga = new Pulga(coor[0], coor[1]);
            pulgas.add(pulga);
        }
        if(opc == KeyEvent.VK_M){
            pulga = new PulgaMutante(coor[0], coor[1]);
            pulgas.add(pulga);
        }
        if(opc == KeyEvent.VK_F){
            Boundable bound = this;
            PulgaFantasma pulgaf = new PulgaFantasma(coor[0], coor[1], bound);
            new Thread(pulgaf).start();
            pulgas.add(pulgaf);
        }
        
    }
    
    public void saltarPulgas(){
        
        for(Pulga p : pulgas){
            p.saltar(ancho, alto);
        }
    }
    
    public boolean dispararPulguipium(int x, int y){
        for(int i = 0; i < getCantidadPulgas(); i++){
            int verifica = pulgas.get(i).verificarImpacto(x, y);
            if(verifica == Pulga.IMPACTO){
                pulgas.remove(i);
                return true;
            }else if(verifica == PulgaMutante.IMPACTO_MUTANTE){
                Pulga pulga = new Pulga(pulgas.get(i).getX(), pulgas.get(i).getY());
                pulgas.set(i, pulga);
            }
        }
        return false;
    }
    
    public int lanzarPulgoson(){
        int pEliminadas = 0;
        int limitePulgas = getCantidadPulgas()/2;
        for(int i = 0; i < limitePulgas; i++){
            pulgas.remove(0);
            pEliminadas += 1;
        }
        return pEliminadas;
    }
    
    private int[] calcularCoordenadas(int anchoP, int altoP){
        boolean control = true;
        int x = 0;
        int y = 0;
        int[]coor = {0, 0};
        
        while (control){
            x = (int) (Math.random() * (ancho - anchoP - CONST_MARGEN_X)) + CONST_MARGEN_X;
            y = (int) (Math.random() * (alto - altoP - CONST_MARGEN_Y)) + CONST_MARGEN_Y;
            
            control = false;
            for (Pulga p : pulgas) {
                if (x + anchoP > p.getX() & x < p.getX() + anchoP
                  & y + altoP > p.getY() & y < p.getY() + altoP) {
                    control = true;
                }
            }
        }
        coor[0] = x;
        coor[1] = y;
        return coor;
    }
    
    public boolean quedanPulgas(){
        if(getCantidadPulgas() <= 0){
            return true;
        }
        return false;
    }
    
    public void dibujar(Graphics g){
        for(Pulga p : pulgas){
            p.dibujar(g);
        }
    }
    
    public int getCantidadPulgas(){
    
          return pulgas.size();
          
    }

    @Override
    public int getBoundX() {
        return ancho;
    }

    @Override
    public int getBoundY() {
        return alto;
    }
    
}
