package sonidos;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

/**
 *
 * @author Daniel Muñoz
 */

public class ReproductorMusica {
    
    private AudioClip musica;
    private URL url;
    private int repeticionReproduccion;
    
    public ReproductorMusica(){
        
        establecerURL();
        reiniciarRepeticionReproduccion();
        
    }
    
    private void establecerURL(){
        
        url = getClass().getResource("/sonidos/PulgasLocas.wav");
        musica = Applet.newAudioClip(url);
        
    }
    
    public void reproducirMusica(){
        
        repeticionReproduccion ++;
        musica.loop();
        
    }
    
    public void detenerMusica(){
        
        musica.stop();
        
    }
    
    public void reiniciarRepeticionReproduccion(){
        
        repeticionReproduccion = 0;
        
    }
    
    public boolean comprobarRepeticionReproduccion(){
        
        if(repeticionReproduccion == 0){
            
            return true;
            
        }
        
        return false;
        
    }
    
}
