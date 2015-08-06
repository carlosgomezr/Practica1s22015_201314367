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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author Carlos Gomez
 */
public class Portada {
    
    public void crear(listasdobles lista,JPanel panel, String album, String portada, int id,int mario, int castillo,JButton bmario, JButton bcastillo){
   album = album + " ";     
   JLabel numero = new JLabel("No. "+id);
   numero.setVisible(true);
   numero.setSize(100,100);
   panel.add(numero);
   
   JLabel nombre = new JLabel(album);
    nombre.setVisible(true);
    nombre.setSize(100,100);
    panel.add(nombre);
    
    
    JButton icon = new javax.swing.JButton();
    icon.setVisible(true);
    icon.setSize(75, 75);
    ImageIcon icono = new ImageIcon(portada);
    icon.setIcon(icono);
    
    panel.add(icon);
    panel.validate();
    
    JTextField name = new javax.swing.JTextField();
    name.setVisible(true);
    name.setText("(cambiar nombre)");
    name.setBounds(0, 0, 100, 60);
    panel.add(name);
    panel.validate();
    
    JButton modificar = new javax.swing.JButton();
    modificar.setVisible(true);
    modificar.setText("MODIFICAR");
    modificar.setSize(100,50);
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
    eliminar.setBounds(icon.getX(),icon.getY(), 100, 50);
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
     
     
     public void crearMatriz(JPanel objeto,JPanel panel,String portada,int x,int y,int nombrex,int nombrey,listasdobles lista, int estructura, Raiz r){
    JButton icon = new javax.swing.JButton();
    icon.setVisible(true);
    String name = nombrex+","+nombrey;
    icon.setName(name);
    
    
    ImageIcon icono = new ImageIcon(portada);
    icon.setIcon(icono);
    icon.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent ae) {
            System.out.println("boton de la matriz "+icon.getName());
            System.out.println("    estructura: "+estructura);
            try{ 
            if(estructura==0){
                int cola = lista.buscaridCola();
                System.out.println("    cola: "+cola);
                Personaje nodoaux = lista.DarObjetoCola();
                r.darPersonaje(nombrex, nombrey, nodoaux);
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
                r.darPersonaje(nombrex, nombrey, nodoaux);
                ImageIcon icono = new ImageIcon(nodoaux.PathImagen);
                icon.setIcon(icono);
                lista.delete(pila);
                objeto.remove(0);
                objeto.repaint();
                objeto.updateUI();
                System.out.println("    pila: "+pila);
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
     
     public void crearLabel(JPanel panel,int nombre,int x,int y){
    JLabel icon = new javax.swing.JLabel();
    icon.setText(nombre+"");
    icon.setVisible(true);
    String name = "label"+x+","+y;
    icon.setName(name);
    
    icon.setBounds(x, y, 10, 10);
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
