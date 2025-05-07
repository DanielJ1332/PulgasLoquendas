package vistas;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import modelos.Simulador;

/**
 *
 * @author Daniel Muñoz
 */

public class VentanaPrincipal extends javax.swing.JFrame {

    Simulador sim;

    public void setSim(Simulador sim) {
        this.sim = sim;
    }
        
    public VentanaPrincipal() {
        initComponents();
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        sim.dibujar(g);
        repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        int opc = evt.getKeyCode();
        if(opc == KeyEvent.VK_Q){
            cerrarPrograma();
        }
        sim.gestionarPulgas(opc);
        
        repaint();  
    }//GEN-LAST:event_formKeyPressed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        
        int x = evt.getX();
        int y = evt.getY();
        
        if(sim.disparar(x, y)){
            if(mostrarDialogReiniciar()){
                sim.reiniciarPartida();
            }else{
                cerrarPrograma();
            }
        }
        repaint();
        
    }//GEN-LAST:event_formMouseClicked

    private boolean mostrarDialogReiniciar(){

        int puntajeTotal = sim.getPuntaje();
        DialogReiniciarPartida dialogo = new DialogReiniciarPartida(this, true, puntajeTotal);
        dialogo.setVisible(true);
        boolean control = dialogo.isControl();
        return control;
        
    }
    
    private void cerrarPrograma(){
        System.exit(0);
    }
    
    public static void main(String args[]) {
        
        VentanaPrincipal ventana = new VentanaPrincipal();
        Simulador sim = new Simulador(900, 550);
        ventana.setSim(sim);
        ventana.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
