/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mariomaker;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Carlos Gomez
 */
public class Portada {
    
    public void crear(JPanel panel, String album, String portada, int id){
        
   JLabel numero = new JLabel("No. "+id);
   numero.setVisible(true);
   numero.setSize(100,100);
   panel.add(numero);
   
   JLabel nombre = new JLabel("Nombre: "+album);
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
     
     
     public void crearMatriz(JPanel panel,String portada,int x,int y){
    JButton icon = new javax.swing.JButton();
    icon.setVisible(true);
    String name = x+","+y;
    icon.setName(name);
    
    
    ImageIcon icono = new ImageIcon(portada);
    icon.setIcon(icono);
    
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
