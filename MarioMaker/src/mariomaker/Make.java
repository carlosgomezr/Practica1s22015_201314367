/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mariomaker;
import java.awt.GridBagLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Carlos Gomez
 */
public class Make extends javax.swing.JFrame {

    /**
     * Creates new form Make
     */
    public static int estructura;
    // 0 es cola
    // 1 es pila
    public static int rr=0;
    private JPanel jPanel0;
    private JScrollPane scroll;
    private JPanel jPanel1;
    private JScrollPane scroll1;
    public static listasdobles lista = Ventana.otra;
    public Make() {
        jPanel0 = new JPanel(new GridBagLayout());
        jPanel0.setBounds(20,200,675,395);
        add(jPanel0);
        scroll = new JScrollPane(jPanel0);
      //scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(20,200,675,395);
        add(scroll);
                
        
        jPanel1 = new JPanel();
        jPanel1.setBounds(20,40,700,120);
        add(jPanel1);
        scroll1 = new JScrollPane(jPanel1);
      //scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll1.setBounds(20,40,700,120);
        add(scroll1);
    
        System.out.println("-------PILA O COLA-----\n 0. cola \n 1. pila");
        System.out.println(estructura); 
        JOptionPane.showMessageDialog(rootPane,"-------PILA O COLA-----\n 0. cola \n 1. pila");
        
            
        initComponents();
        
        lista.imprimirlista();
        listasdobles auxiliar = lista;
        rr = lista.tamaño();
        System.out.println("esta es la r tamaño"+lista.tamaño());
        for(int i=1;i<rr;i++){
        
        String path = auxiliar.buscarPathInverso(i);
        String name = auxiliar.buscarNombreInverso(i);
        Portada nueva = new Portada();
        
        nueva.crearImagen(jPanel1,path,name);  
        
        }   
        
        
        jPanel1.updateUI();
        jPanel0.updateUI();
        for(int x = 0; x<9; x++){
            for(int y = 0;y<6;y++){
                Portada nuevo = new Portada();
                int posx= x*75;
                int posy= 375-y*75;
                System.out.println("set Bounds: "+posx+","+posy);
                nuevo.crearMatriz(jPanel0,"cielo.png", posx, posy);
            }
        }
        jPanel0.updateUI();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("xD:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 11, 111, 29));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 580, 60, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

                
// TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Make.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Make.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Make.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Make.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Make().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}