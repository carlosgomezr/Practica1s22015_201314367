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
public class MarioMaker {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        Ventana v = new Ventana();
        v.setVisible(true);
        // TODO code application logic here
        Lista lista = new Lista();
        lista.insertarAlFrente( 2 );
        lista.imprimir();
        lista.insertarAlFrente( 0 );
        lista.imprimir();
        lista.insertarAlFinal( 1 );
        lista.imprimir();
        lista.insertarAlFinal( 8 );
        lista.imprimir();
    
    try
{
        /*Object objetoEliminado = lista.eliminarDelFrente();
        System.out.printf( "%s eliminado\n", objetoEliminado );
        lista.imprimir();
        objetoEliminado = lista.eliminarDelFrente();
        System.out.printf( "%s eliminado\n", objetoEliminado );
        lista.imprimir();
        objetoEliminado = lista.eliminarDelFinal();
        System.out.printf( "%s eliminado\n", objetoEliminado );
        lista.imprimir();
        objetoEliminado = lista.eliminarDelFinal();
        System.out.printf( "%s eliminado\n", objetoEliminado );
        lista.imprimir();*/
        } 
        catch ( ExcepcionListaVacia excepcionListaVacia )
        {
        excepcionListaVacia.printStackTrace();
        }
        Funcion f = new Funcion();
        f.generarArchivo(lista);
        f.generar("lista simple");
      /*
       a=new listasdobles();
       Personaje b = new Personaje(10,"","",1,"");
       Personaje c = new Personaje(20,"","",1,"");
       Personaje d = new Personaje(30,"","",1,"");
       Personaje e = new Personaje(40,"","",1,"");
       Personaje ff = new Personaje(50,"","",1,"");
       a.alta(b);
       a.alta(c);
       a.alta(d);
       a.alta(e);
       a.alta(ff);
       a.imprimir2();
       a.delete(25);
       a.imprimir2();
       f.generarListaDoble(a);
       f.generar("lista doble xd");*/
    }
    
}