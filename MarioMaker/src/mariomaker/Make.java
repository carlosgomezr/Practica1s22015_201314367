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
    public static int horiginal=0;
    public static int voriginal=315;
    public static int rr=0;
    private JPanel jPanel0;
    private JScrollPane scroll;
    private JPanel jPanel1;
    private JScrollPane scroll1;
    private JPanel jpanelver;
    private JPanel jpanelhor;
    private JScrollPane scrollh;
    private JScrollPane scrollv;
    public static listasdobles lista = Ventana.otra;
    public static listasdobles auxiliar = lista;
    public Make() {
        
        
        jPanel0 = new JPanel(new GridBagLayout());
        jPanel0.setBounds(20,200,695,405);
        add(jPanel0);
        scroll = new JScrollPane(jPanel0);
      //scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(20,200,695,405);
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
        for(int x=0; x<9;x++){
            int posx=x*75+50;
            int posy=0;
            Portada nuevo = new Portada();
            nuevo.crearLabel(jPanel0, x, posx, posy);
        }
        
        
        for(int y=0; y<6;y++){
            int posx=0;
            int posy=345-y*75;
            Portada nuevo = new Portada();
            nuevo.crearLabel(jPanel0, y, posx, posy);
        }
        
        for(int x = 0; x<9; x++){
            for(int y = 0;y<5;y++){
                Portada nuevo = new Portada();
                int posx= x*75+20;
                int posy= 315-y*75;
                System.out.println("set Bounds: "+posx+","+posy);
                nuevo.crearMatriz(jPanel0,"cielo.png", posx, posy);
            }
        }
        Raiz matriz = new Raiz();
        matriz.insertarFila(-1);
        matriz.insertarColumna(-1);
        System.out.println("MATRIZ ORTOGONAL--------");
        for(int x = 0; x<9;x++){
            for(int y=0; y<5;y++){
                matriz.insertar(matriz, 0, x, y);
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("xD:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 11, 111, 29));

        jLabel3.setText("PERSONAJES:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 20, -1, -1));

        jLabel4.setText("TABLERO:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 280, -1, -1));

        jLabel5.setText("X:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 60, -1, -1));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 60, 100, -1));

        jLabel6.setText("Y:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 110, -1, -1));

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 110, 100, -1));

        jButton1.setText("AGREGAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 160, -1, -1));

        jButton2.setText("ELIMINAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 210, -1, -1));

        jButton3.setText("ADD X");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 310, 80, -1));

        jButton4.setText("ADD Y");
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 360, 80, -1));

        jLabel9.setText("X:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 460, 40, -1));

        jLabel10.setText("Y:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 560, -1, -1));
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 460, 120, -1));
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 560, 120, -1));

        jButton5.setText("ELIMINAR X");
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 490, 120, -1));

        jButton6.setText("ELIMINAR Y");
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 590, 120, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

                
// TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    try{
        int auxX;
        String posx= jTextField1.getText();
        auxX = Integer.parseInt(posx);
        
        int auxY;
        String posy= jTextField2.getText();
        auxY = Integer.parseInt(posy);
        
        if(estructura==0){
            Personaje nodoaux = auxiliar.buscarXY(auxX, auxY);
            lista.baja(nodoaux);
            auxiliar.delete(nodoaux.dato);
        }
        if(estructura==1){
            Personaje nodoaux = auxiliar.buscarXY(auxX, auxY);
            lista.alta(nodoaux);
            auxiliar.delete(nodoaux.dato);
        }
      
    }
    catch(Exception ex){
    
    }    

        
// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    try{
        int auxX;
        String posx= jTextField1.getText();
        auxX = Integer.parseInt(posx);
        
        int auxY;
        String posy= jTextField2.getText();
        auxY = Integer.parseInt(posy);
        
        if(estructura==0){
            int cola = lista.buscaridCola();
            Personaje nodoaux = lista.DarObjeto(cola);
            nodoaux.setX(auxX);
            nodoaux.setY(auxY);
            auxiliar.alta(nodoaux);
            System.out.println("ESTA ES LA COLA CON POS X Y");
            auxiliar.imprimirlista();
            lista.delete(cola);
        }
        if(estructura==1){
            int pila = lista.buscaridPila();
            Personaje nodoaux = lista.DarObjeto(pila);
            nodoaux.setX(auxX);
            nodoaux.setY(auxY);
            auxiliar.alta(nodoaux);
            System.out.println("ESTA ES LA PILA CON POS X Y");
            auxiliar.imprimirlista();
            lista.delete(pila);
        }
      
    }
    catch(Exception ex){
    
    }    
    // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    public static javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
