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
    icon.setSize(100, 100);
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
    icon.setSize(100, 100);
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
}
