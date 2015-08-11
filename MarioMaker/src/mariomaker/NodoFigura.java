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
public class NodoFigura {
    Figura f;
    NodoFigura next;
    NodoFigura ant;
    NodoFigura(Figura a){
        this.f = a;
        this.next = null;
        this.ant = null;
    }
}
