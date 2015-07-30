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
public class Cabeza {
    int numero;
    NodoOrto fila;
    NodoOrto columna;
    
    Cabeza()
    {
        fila = null;
        columna = null;
    }
      public boolean estavacio()
    {
        if(fila==null) return true;
        else return false;
    }
      
      public boolean estavacioc()
    {
        if(columna==null) return true;
        else return false;
    }
      
     public void insertarfila(int dat)
    {
        if(estavacio())
        {
            NodoOrto nuevo = new NodoOrto(dat,-1,-1,"");
            fila = nuevo;
        }
        else
        {
            NodoOrto nuevo = new NodoOrto(dat,-1,-1,"");
            fila.siguiente = nuevo;
            nuevo.anterior = fila;
            fila= nuevo;
        }
       
    }
     
     public Cabeza insertarcolumna(int dat){
          if(estavacioc())
        {
            NodoOrto nuevo = new NodoOrto(dat,-1,-1,"");
            columna = nuevo;
        }
        else
        {
            NodoOrto nuevo = new NodoOrto(dat,-1,-1,"");
            columna.siguiente = nuevo;
            nuevo.anterior = columna;
            columna= nuevo;
        }
         return this;
     }
     
     
     
     public Cabeza insertarprof(int c,int f,int dat){
         
            NodoOrto nuevo = new NodoOrto(dat,c,f,"");
            columna.siguiente = nuevo;
            nuevo.anterior = columna;
            columna= nuevo;
        
         return this;
     }

    public void reportarNodoProf()
    {
        NodoOrto actual;
        actual=columna.abajo.siguiente;
        while(actual!=null)
        {
            System.out.println(" datop: "+actual.numero+" imagenc "+actual.imagen);
            actual=actual.siguiente;
        }
    }
    
    public void reportarNodoProf2()
    {
        NodoOrto actual;
        actual=fila.derecha.siguiente;
        while(actual!=null)
        {
            System.out.println(" datop: "+actual.numero+" imagenc "+actual.imagen);
            actual=actual.siguiente;
        }
    }
    
     public void reportarNodoFila()
    {
        NodoOrto actual;
        actual=fila.derecha;
        while(actual!=null)
        {
            System.out.println(" datop: "+actual.numero+" imagenc "+actual.imagen);
            actual=actual.derecha;
        }
    }
  
     
       public void reportarFila()
    {
        NodoOrto actual;
        System.out.println("filas-------");
        actual = fila;
        while(actual!=null)
        {
            // cout << i << "(" << " numero "<<lista->numero<<endl;
            System.out.println(" numero: "+actual.numero);
            reportarNodoFila();
            reportarNodoProf2();
            actual = actual.siguiente;
        }
    }
       
        void reportarNodoColumna()
    {
        NodoOrto actual;
        actual = columna.abajo;
        while (actual != null)
        {
            System.out.println(" datop: "+actual.numero+" imagenc "+actual.imagen);
            actual = actual.abajo;
        }
    }
       
        void reportarColumna()
    {
        System.out.println("COLUMNA-------");
        NodoOrto actual;
        actual = columna;
        while (actual!= null)
        {
            System.out.println(" numero "+actual.numero);
            reportarNodoColumna();
            reportarNodoProf();
            //cout << i << "(" << " numero "<<lista->numero<<endl;
            actual = actual.siguiente;
        }
    }
       
        int buscarfila(int f){
            NodoOrto q = fila;
            int i = 1, band = 0;
            int res=0;
            while (q != null)
            {
                if (q.numero == f)
                {
                    band = 1;
                    res = 1;
                }
            q = q.siguiente;
            i++;
        }
        if (band == 0){
                res = 0;
        }
        return res;
        }
       
        
        int buscarcolumna(int c){
            NodoOrto q = columna;
            int i = 1, band = 0;
            int res=0;
            while (q != null)
            {
                if (q.numero == c)
                {
                    band = 1;
                    res = 1;
                }
            q = q.siguiente;
            i++;
        }
        if (band == 0){
                res = 0;
        }
        return res;
        }

        NodoOrto buscarR(NodoOrto lista,int numero){
            NodoOrto q = lista;
            NodoOrto t= null;
        int i = 1, band = 0;
        while (q != null)
        {
            if (q.numero == numero)
            {
                t = q;
                band = 1;
                return t;
            }
            q = q.siguiente;
            i++;
        }
        if (band == 0){
              //  return 0;
        }
            return t;
    }

        NodoOrto buscarF(int numero){
        NodoOrto aux = null;
        NodoOrto t = null;
        aux=buscarR(fila,numero);
        while(aux != null){
            if(aux.derecha==null){
                t = aux;
                System.out.println("buscarF encontro ");
                return t;
            }
            aux = aux.derecha;

          }
             return t;
        }
       NodoOrto buscarC(int numero){
       NodoOrto aux = null;
       NodoOrto t = null;
       aux=buscarR(columna,numero);
        while(aux != null){
            if(aux.abajo==null){
                t = aux;
                System.out.println("buscarC encontro ");
                return t;
            }
            aux = aux.abajo;

        }
            return t;
    }
    
         
        NodoOrto crearNodo(int numero,int c, int f,String imagen){
            NodoOrto nuevoNodo = null;
            nuevoNodo.numero = numero;
            nuevoNodo.c = c;
            nuevoNodo.f = f;
            nuevoNodo.imagen = imagen;
            nuevoNodo.abajo = null;
            nuevoNodo.arriba = null;
            nuevoNodo.siguiente = null;
            nuevoNodo.anterior = null;
            nuevoNodo.derecha = null;
            nuevoNodo.izquierda = null;
        return nuevoNodo;
         }

        
        void insertar(int numero,int col, int fil,String imagen){
       
        }
}
