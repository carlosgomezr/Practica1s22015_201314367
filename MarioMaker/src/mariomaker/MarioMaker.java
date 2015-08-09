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
    
    public static void main(String[] args) throws Exception{
    
     
        Ventana v = new Ventana();
        v.setVisible(true);
        // TODO code application logic here
        /*
        Lista lista = new Lista();
        lista.insertarAlFrente( 2 );
        lista.imprimir();
        lista.insertarAlFrente( 0 );
        lista.imprimir();
        lista.insertarAlFinal( 1 );
        lista.imprimir();
        lista.insertarAlFinal( 8 );
        lista.imprimir();
    */
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
      /*
        Funcion f = new Funcion();
        f.generarArchivo(lista);
        f.generar("lista simple");
       listasdobles a;
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
       System.out.println(" elimino 70 ");
       a.delete(70);
       a.imprimir2();
       System.out.println(" elimino 40 ");
       a.delete(40);
       a.imprimir2();
       f.generarListaDoble(a);
       f.generar("lista doble xd");
       */
       Raiz r = new Raiz();
      /* r.insertarFila(0);
       r.insertarFila(1);
       r.insertarFila(3);
       r.insertarFila(5);
       r.insertarColumna(7);
       r.insertarColumna(9);
       r.insertarColumna(11);
       System.out.println("FILA------->");
       r.fila.reportarFila();
       System.out.println("COLUMNA------->");
       r.columna.reportarColumna();
       System.out.println("buscar 7");
       System.out.pri       r.insertarColumna(25);
ntln(r.buscarcolumna(7));
       System.out.println("buscar 25 xD");
       System.out.println(r.buscarcolumna(25));*/
       Raiz h = new Raiz();
       r.insertarFila(-1);
       r.insertarColumna(-1);
      /* 
       r.insertar(r,10, 0, 1);
       r.insertar(r,20, 7, 2);
       r.insertar(r,30, 7, 4);
       r.insertar(r,40, 1, 2);
       r.insertar(r,50, 1, 3);
       r.insertar(r,60, 5, 4);
       r.insertar(r,70, 1, 8);
       r.insertar(r,80, 5, 3);
   */
       for(int i=0;i<3;i++){
           for(int j=0;j<3;j++){
               r.insertar(r,0,i,j);
           }
       }
       System.out.println("vamos come on");
       Personaje prueba = new Personaje(10,"kaya","prueba.txt",100,"heroe");
       r.darPersonaje(2,1, prueba);
      // r.buscarnodo(2, 1);
       r.getPersonaje(2, 1);
       //r.darPersonaje(3,1, prueba);
       //System.out.println(" dar personaje a un nodo de la orto");
       r.fila.reportarFila();
       r.columna.reportarColumna();
       r.eliminarF(r.fila.ultimo,2);
       r.columna.graphMatriz(r.fila.ultimo, r.columna.ultimo);
     
      // r.changePersonaje(2, 1, prueba);
       
       Funcion fun = new Funcion();
       fun.generar("Matriz Ortogonal");
    }
    
}
