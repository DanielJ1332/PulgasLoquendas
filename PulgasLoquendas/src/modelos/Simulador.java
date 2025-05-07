package modelos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import sonidos.ReproductorMusica;
/**
 *
 * @author Daniel Muñoz
 */
public class Simulador {
    private int puntaje;
    private int anchoCampo;
    private int altoCampo;
    private CampoBatalla campo;
    private ReproductorMusica repMusic;
    
    public Simulador(int ancho, int alto){
        this.puntaje = 0;
        this.anchoCampo = ancho;
        this.altoCampo = alto;
        this.campo = new CampoBatalla(ancho, alto);
        repMusic = new ReproductorMusica();
    }
    
    public void gestionarPulgas(int opc){
        if(opc == KeyEvent.VK_P | opc == KeyEvent.VK_M | opc == KeyEvent.VK_F){
            campo.agregarPulga(opc);
        }else if(opc == KeyEvent.VK_S){
            campo.saltarPulgas();
        }else if(opc == KeyEvent.VK_SPACE){
            lanzarBomba();
        }else if(opc == KeyEvent.VK_Q){
            reiniciarPartida();
        }
    }
    
    private void reproducirMusica(){
        
        if(repMusic.comprobarRepeticionReproduccion()){
            
            repMusic.reproducirMusica();
            
        }
    }
    
    private void detenerMusica(){
        
        if(campo.getCantidadPulgas() == 0){
            
            repMusic.detenerMusica();
            
        }
        
    }
    
    public boolean disparar(int x, int y){
        if(campo.dispararPulguipium(x, y)){
            puntaje += 1;
            detenerMusica();
        }
        return campo.quedanPulgas();
    }
    
    public boolean lanzarBomba(){
        int bajasTotales = campo.lanzarPulgoson();
        puntaje += bajasTotales;
        detenerMusica();
        return campo.quedanPulgas();
    }
    
    public void reiniciarPartida(){
        puntaje = 0;
        campo = new CampoBatalla(anchoCampo, altoCampo);
        repMusic.reiniciarRepeticionReproduccion();
    }
    
    public void dibujar(Graphics g){
        campo.dibujar(g);
        g.setFont(new Font("Tw Cen MT", Font.PLAIN, 30));
        g.setColor(Color.red);
        g.drawString("Puntaje: "+puntaje, 20, 60);
    }

    public int getPuntaje() {
        return puntaje;
    }
}
