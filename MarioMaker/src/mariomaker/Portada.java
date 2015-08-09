/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mariomaker;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author Carlos Gomez
 */
public class Portada {
    
    public void crear(listasdobles lista,JPanel panel, String album, String portada, int id,int mario, int castillo,JButton bmario, JButton bcastillo,int posy){
   album = album + " ";     
   JLabel numero = new JLabel("No. "+id);
   numero.setVisible(true);
   numero.setBounds(10, posy, 25, 50);
  // numero.setSize(100,100);
   panel.add(numero);
   
   JLabel nombre = new JLabel(album);
    nombre.setVisible(true);
    nombre.setBounds(45, posy, 100, 50);
    //nombre.setSize(100,100);
    panel.add(nombre);
    
    
    JButton icon = new javax.swing.JButton();
    icon.setVisible(true);
    icon.setBounds(155, posy, 75, 75);
    //icon.setSize(75, 75);
    ImageIcon icono = new ImageIcon(portada);
    icon.setIcon(icono);
    
    panel.add(icon);
    panel.validate();
    
    JTextField name = new javax.swing.JTextField();
    name.setVisible(true);
    name.setText("(cambiar nombre)");
    //name.setBounds(0,0,100,60);
    name.setBounds(240, posy, 100, 60);
    panel.add(name);
    panel.validate();
    
    JButton modificar = new javax.swing.JButton();
    modificar.setVisible(true);
    modificar.setText("MODIFICAR");
    modificar.setBounds(350,posy,100,50);
    //modificar.setSize(100,50);
    modificar.addActionListener(new ActionListener() {

       @Override
       public void actionPerformed(ActionEvent ae) {
           String auxname = name.getText();
           lista.modificarNombre(id,auxname);
           nombre.setText(auxname);
           name.setText("(cambiar nombre)");
           panel.updateUI();
           panel.repaint();
       }
   });
    panel.add(modificar);
    panel.validate();
    
    
    JButton eliminar = new javax.swing.JButton();
    eliminar.setVisible(true);
    eliminar.setText("ELIMINAR");
    eliminar.setBounds(460, posy, 100, 50);
    //eliminar.setBounds(icon.getX(),icon.getY(), 100, 50);
    eliminar.addActionListener(new ActionListener() {

       @Override
       public void actionPerformed(ActionEvent ae) {    
        try{
           panel.remove(numero);
            panel.remove(nombre);
            panel.remove(icon);
            panel.remove(eliminar);
            panel.remove(name);
            panel.remove(modificar);
            System.out.println("este es el clic id "+id);
            lista.delete(id);
            panel.updateUI();
            if(mario==id){
                bmario.setEnabled(true);
            }
            if(castillo==id){
                bcastillo.setEnabled(true);
            }
       }catch(Exception ex){
       
       }
       }
   });
    panel.add(eliminar);
    panel.validate();
    System.out.println("    name: "+ album);
   
 
    }
    
     public void crear1(JScrollPane panel, String album, String portada, int id){
   JLabel nombre = new JLabel("Album: "+album);
    nombre.setVisible(true);
    nombre.setSize(100,100);
    panel.add(nombre);
   
    
    JButton icon = new javax.swing.JButton();
    icon.setVisible(true);
    icon.setSize(75, 75);
    ImageIcon icono = new ImageIcon(portada);
    icon.setIcon(icono);
    
    /*JLabel porta = new JLabel();
    porta.setVisible(true);
    porta.setSize(100,100);
    porta.setIcon(icono);
    
    panel.add(porta);*/
    panel.add(icon);
    panel.validate();
    
    
    /* boton2 = new javax.swing.JButton();
 boton2.setBounds(220,40,70,100);
 ImageIcon icon2 = new ImageIcon("2.jpg");
 boton2.setIcon(icon2);
 add(boton2);*/
    }
     public void eliminarT(JPanel panel,String name){
     int contador=panel.getComponentCount();
     String auxname="";
     //String name =nombrex+","+nombrey;
        for(int i=0;i<contador;i++){
         try{   
           auxname=panel.getComponent(i).getName();
           System.out.println("setname: "+auxname);
            if((auxname.compareTo(name)==0))
           {
                System.out.println("lo encontre");
                panel.remove(i);
                panel.repaint();
                panel.updateUI();
           }
         }
         catch(Exception ex){
            
            }
     }
   }
     
     public void crearImagen(JPanel panel,String portada,String name){
        
    
    
    JButton icon = new javax.swing.JButton();
    icon.setVisible(true);
    icon.setName(name);
    icon.setSize(75, 75);
    ImageIcon icono = new ImageIcon(portada);
    icon.setIcon(icono);
    
    panel.add(icon);
    panel.validate();
    }
     public void crearPlay(JPanel objeto,int x,int y, int nombrex, int nombrey, Raiz matriz){
        JLabel icon = new javax.swing.JLabel();
        icon.setVisible(true);
        icon.setSize(75,75);
        String name = nombrex+","+nombrey;
        icon.setName(name);
        Personaje p = matriz.getPersonaje(nombrey, nombrex);
        String imagen = p.PathImagen;
        ImageIcon icono = new ImageIcon(imagen);
        icon.setIcon(icono);
        icon.setBounds(x, y, 75, 75);
        objeto.setLayout(null);
        objeto.add(icon);
        objeto.repaint();
        objeto.updateUI();
     }
     
     public void crearMatriz(JPanel objeto,JPanel panel,String portada,int x,int y,int nombrex,int nombrey,listasdobles lista, int estructura, Raiz r){
    JButton icon = new javax.swing.JButton();
    icon.setVisible(true);
    String name = nombrex+","+nombrey;
    icon.setName(name);
   
    Personaje creo = r.getPersonaje(nombrey, nombrex);
    
  
            ImageIcon icono = new ImageIcon(portada);
            icon.setIcon(icono);
    
    icon.addActionListener(new ActionListener() {
        int contador=0;
        @Override
        public void actionPerformed(ActionEvent ae) {
            
            contador++;
            System.out.println("boton de la matriz "+icon.getName()+" conteo "+contador);
            System.out.println("    estructura: "+estructura);
  
            try{
            if((contador % 2)!=0)
            {
                
                        if(estructura==0){
                            int cola = lista.buscaridCola();
                            System.out.println("    cola: "+cola);
                            Personaje nodoaux = lista.DarObjetoCola();
                            r.darPersonaje(nombrey, nombrex, nodoaux);
                            ImageIcon icono = new ImageIcon();
               
                            if(nodoaux.PathImagen!=null){
                                icono = new ImageIcon(nodoaux.PathImagen);
                            }
                            else{
                                icono = new ImageIcon(portada);
                            }
                            icon.setIcon(icono);
                            lista.delete(cola);
                            objeto.getComponentCount();
                            objeto.remove(0);
                            objeto.repaint();
                            objeto.updateUI();
                            System.out.println("    cola: "+cola);

                        }
                        if(estructura==1){
                            int pila = lista.buscaridPila();
                            System.out.println("    pila: "+pila);
                            Personaje nodoaux = lista.DarObjetoPila();
                            r.darPersonaje(nombrey, nombrex, nodoaux);
                            ImageIcon icono = new ImageIcon(nodoaux.PathImagen);
                            icon.setIcon(icono);
                            lista.delete(pila);
                            objeto.remove(0);
                            objeto.repaint();
                            objeto.updateUI();
                            System.out.println("    pila: "+pila);
                        }
                
                lista.imprimirlista();
            }   
            else{
                
                      if(estructura==0){
                            Personaje auxobjeto = r.getPersonaje(nombrey, nombrex);
                            if((auxobjeto.dato!=0)){
                            lista.baja(auxobjeto);
                            ImageIcon icono = new ImageIcon(portada);
                            icon.setIcon(icono);
                            Personaje auxpersonaje = new Personaje(0,"vacio","vacio.txt",0,"vacio");
                            r.darPersonaje(nombrey, nombrex, auxpersonaje);
                            JButton botoncola = new JButton();
                            botoncola.setSize(75, 75);
                            ImageIcon bcola = new ImageIcon(auxobjeto.PathImagen);
                            botoncola.setIcon(bcola);
                            objeto.add(botoncola, 0);
                            objeto.repaint();
                            objeto.updateUI();
                            lista.imprimirlista();
                            }
                        }
                      if(estructura==1){
                            Personaje auxobjeto = r.getPersonaje(nombrey, nombrex);
                            if(auxobjeto.dato!=0){
                            lista.alta(auxobjeto);
                            System.out.println("    auxobjeto: "+auxobjeto.nombre);
                            ImageIcon icono = new ImageIcon(portada);
                            icon.setIcon(icono);
                            Personaje auxpersonaje = new Personaje(0,"vacio","vacio.txt",0,"vacio");
                            r.darPersonaje(nombrey, nombrex, auxpersonaje);
                            JButton botonpila = new JButton();
                            botonpila.setSize(75,75);
                            ImageIcon bpila = new ImageIcon(auxobjeto.PathImagen);
                            botonpila.setIcon(bpila);
                            objeto.add(botonpila,0);
                            objeto.repaint();
                            objeto.updateUI();
                            lista.imprimirlista();
                            }
                      }
            
            }
                
            
            }catch(Exception ex){
            }

        }
    });
    icon.setBounds(x, y, 75, 75);
    panel.setLayout(null);
    
    panel.add(icon);
    panel.validate();
    
    
    /* boton2 = new javax.swing.JButton();
 boton2.setBounds(220,40,70,100);
 ImageIcon icon2 = new ImageIcon("2.jpg");
 boton2.setIcon(icon2);
 add(boton2);*/
    }
     
     public void crearLabel(JPanel panel,String nombre,int x,int y,Raiz matriz){
    JLabel icon = new javax.swing.JLabel();
    String auxnombre="";
if(y==0){
    auxnombre = "c"+x;
}
else{
    auxnombre = "f"+y;
}
    icon.setText(nombre);
    icon.setVisible(true);
    String name = auxnombre;
    icon.setName(name);
    
    icon.setBounds(x, y, 15, 15);
    panel.setLayout(null);
    panel.add(icon);
    panel.validate();
    
    
    /* boton2 = new javax.swing.JButton();
 boton2.setBounds(220,40,70,100);
 ImageIcon icon2 = new ImageIcon("2.jpg");
 boton2.setIcon(icon2);
 add(boton2);*/
    }
     
  
}
