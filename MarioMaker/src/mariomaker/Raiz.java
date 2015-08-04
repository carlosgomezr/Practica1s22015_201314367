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
public class Raiz {
    ListaOrto fila;
    ListaOrto columna;
    Raiz()
    {
        fila=null;
        columna=null;
    }
    public boolean estavacio()
    {
        if(fila==null) return true;
        else return false;
    }
    public boolean estavaciocol()
    {
        if(columna==null) return true;
        else return false;
    }
  public Raiz insertarFila(int dat)
    {
        if(estavacio())
        {
            ListaOrto nuevo = new ListaOrto();
            nuevo.alta(dat,-1,-1);
            fila=nuevo;
        }
        else
        {
            fila.alta(dat,-1,-1);
        }
        return this;
    }
  
  public Raiz insertarColumna(int dat)
    {
        if(estavaciocol())
        {
            ListaOrto nuevo = new ListaOrto();
            nuevo.alta(dat,-1,-1);
            columna=nuevo;
        }
        else
        {
            columna.alta(dat,-1,-1);
        }
        return this;
    }
    public void darPersonaje(int fil,int col,Personaje p){
    Personaje aux = p;
        nodoorto q = fila.ultimo;
        while(q!=null){
            if(q.a==fil){
                System.out.println("    si existe la fila");
                nodoorto t = q;
                while(t!=null){
                    if(t.a==col){
                       System.out.println("    si existe la columna");
                        t.personaje = aux;
                        q = t;
                    }
                    else{
                        System.out.println("    NO existe la columnaa");
                       
                    }
                        t = t.ant;
                }
            }
            else{
                System.out.println("    NO existe la fila");
               
            }
             q = q.ant;
        }
        
    
    }
  
    public int buscarfila(int fil){
        nodoorto q = fila.ultimo;
        int i = 1, band = 0;
        int flag=0;
        while (q != null)
        {
            if (q.a== fil)
            {
                band = 1;
                flag = 1;
            }
            q = q.ant;
            i++;
        }
        if (band == 0){
                flag = 0;
        }
        return flag;
    }
    
  
    
    public int buscarcolumna(int col){
        nodoorto q = columna.ultimo;
        int i = 1, band = 0;
        int flag=0;
        while (q != null)
        {
            if (q.a == col)
            {
                band = 1;
                flag=1;
            }
            q = q.ant;
            i++;
        }
        if (band == 0){
                flag=0;
        }
        return flag;
    }
    
    
        public nodoorto buscarR(nodoorto lista,int numero){
        nodoorto q = lista;
        nodoorto t=new nodoorto(-2,-2,-2);
        int i = 1, band = 0;
        while (q != null)
        {
            if (q.a == numero)
            {
                t = q;
                band = 1;
                return t;
            }
            q = q.next;
        }
        if (band == 0){
              //  return 0;
        }
        return t;
    }
    
        
        
     public nodoorto buscarF(int numero){
        nodoorto aux;
        nodoorto t=new nodoorto(-2,-2,-2);
        aux=buscarR(fila.ultimo,numero);
        while(aux != null){
            if(aux.derecha==null){
                t = aux;
                return t;
            }
            aux = aux.derecha;

        }
        return t;
    }
    
    public nodoorto buscarC(nodoorto lista,int numero){
        nodoorto aux;
        nodoorto t = new nodoorto(-2,-2,-2);
        aux=buscarR(columna.ultimo,numero);
        while(aux != null){
            if(aux.abajo==null){
                t = aux;
                return t;
            }
            aux = aux.abajo;

        }
        return t;
    }

    public Raiz insertar(Raiz raiz,int dato,int c, int f){
        Raiz aux = new Raiz();
        nodoorto a;
        System.out.println("probando metodo insertar");
        if(raiz==null){
            a = new nodoorto(dato,c,f);
            aux=raiz;
            aux.insertarFila(f);
            a.izquierda = aux.fila.ultimo;
            aux.fila.ultimo.derecha = a;
            raiz = aux;
            aux = raiz;
            aux.insertarColumna(c);
            a.arriba = aux.columna.ultimo;
            aux.columna.ultimo.abajo = a;
            raiz = aux;
        }
        else{
            a = new nodoorto(dato,c,f);
            aux = raiz;
            if(aux.buscarfila(f)==0){
                aux.insertarFila(f);
                nodoorto nuevo;
                nuevo = aux.buscarR(fila.ultimo,f);
                a.izquierda = nuevo;
                nuevo.derecha = a;
                raiz = aux;
                
            }
            else{
                 if(aux.buscarcolumna(c)==0)
                {
                    nodoorto nuevo;
                    nuevo = aux.buscarF(f);
                    a.izquierda = nuevo;
                    nuevo.derecha = a;
                    raiz = aux;
                }
            }
            if(aux.buscarcolumna(c)==0)
            {
                aux.insertarColumna(c);
                nodoorto nuevo;
                nuevo = aux.buscarR(columna.ultimo,c);
                a.arriba = nuevo;
                nuevo.abajo = a;
                raiz = aux;
            }
            else
            {
                  if(aux.buscarfila(f)==0){
                     nodoorto nuevo;
                     nuevo = aux.buscarC(columna.ultimo,c);
                     a.arriba = nuevo;
                     nuevo.abajo = a;
                     raiz = aux;
                 }
            
            }
        }
        aux.fila.reportarFila();
        aux.columna.reportarColumna();
        /*
        aux.insertarFila(100);
        aux.insertarColumna(500);
        aux.insertarFila(200);
        aux.insertarColumna(300);
        aux.fila.reportarFila();
        aux.columna.reportarColumna();
        */
        return this;
    }
}
