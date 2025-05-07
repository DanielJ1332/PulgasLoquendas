package sonidos;

import java.applet.AudioClip;
import java.net.URL;
import java.applet.Applet;
/**
 *
 * @author Daniel Muñoz
 */

public class ReproductorDolor {
    
    private boolean tipoDolor;
    private AudioClip sonidoDolor;
    private URL url;
    
    public void reproducirDolor(boolean tipoDolor){
        
        this.tipoDolor = tipoDolor;
        
        if(tipoDolor){
            
            url = getClass().getResource("/sonidos/PulgaNormal.wav");
            
        }
        else{
            
            url = getClass().getResource("/sonidos/PulgaMutante.wav");
            
        }
        
        sonidoDolor = Applet.newAudioClip(url);
        sonidoDolor.play();
        
    }
}
