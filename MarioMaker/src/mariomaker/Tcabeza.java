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
public class Tcabeza {
    Cabeza raiz;
    Tcabeza()
    {
        raiz = null;
    }
    
     void insertar(int numero,int col, int fil,String imagen){
         Cabeza aux= new Cabeza();
         NodoOrto a;
         System.out.println("INSERTAR");
            if(raiz==null){
                a = new NodoOrto(numero,col,fil,imagen);
                aux = raiz;
                aux.insertarfila(fil);
                a.izquierda = aux.fila;
                aux.fila.derecha = a;
                raiz = aux;
                aux = raiz;
                aux.insertarcolumna(col);
                a.arriba = aux.columna;
                aux.columna.abajo = a;
                raiz = aux;
            }
            else{
                a= new NodoOrto(numero,col,fil,imagen);
                aux = raiz;
            }
            if(raiz.buscarfila(fil)==0)
            {
                aux.insertarfila(fil);
                NodoOrto nuevoNodo;
                nuevoNodo = aux.buscarR(aux.fila,numero);
                a.izquierda = nuevoNodo;
                nuevoNodo.derecha = a;
                raiz = aux;
            }
            else
            {
                if(raiz.buscarcolumna(col)==0)
                {
                    NodoOrto nuevoNodo;
                    nuevoNodo = aux.buscarF(fil);
                    a.izquierda = nuevoNodo;
                    nuevoNodo.derecha = a;
                    raiz = aux;
                }


            }
            if(raiz.buscarcolumna(col)==0)
            {
            aux.insertarcolumna(col);
            NodoOrto nuevoNodo;
            nuevoNodo = aux.buscarR(aux.columna,col);
            a.arriba = nuevoNodo;
            nuevoNodo.abajo = a;
            raiz = aux;
            }
             else
            {
                 if(aux.buscarfila(fil)==0){
                     NodoOrto nuevoNodo;
                     nuevoNodo = aux.buscarC(col);
                     a.arriba = nuevoNodo;
                     nuevoNodo.abajo = a;
                     raiz = aux;
                 }
                 
            }
             raiz.reportarFila();
             raiz.reportarColumna();
        }
}
