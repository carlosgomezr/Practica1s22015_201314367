/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mariomaker;

/**
 *
 * @author Carlos Gomez
 */
public class Personaje {
    int dato;
    String nombre;
    String PathImagen;
    String tipo;
    int vida;
    int PosX;
    int PosY;
    public Personaje(int datos,String nombre, String PathImagen, int vida, String tipo)
    {
    this.dato = datos;
    this.nombre=nombre;
    this.PathImagen=PathImagen;
    this.vida=vida;
    this.tipo=tipo;
    }
    int getX()
    {
    return this.PosX;
    }
    int getY()
    {
    return this.PosY;
    }
    void setX(int x)
    {
        this.PosX=x;
    }
    void setY(int y)
    {
        this.PosY=y;
    }
}
