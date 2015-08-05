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
  
    public void darNodofila(nodoorto ultimo,int fil,int col, Personaje p){
      nodoorto actual = ultimo;
        actual= actual.derecha;
        while (actual != null)
        {
            if(actual.fila==fil){
               
                System.out.println("    existe fila "+actual.fila+" col: "+actual.columna);
                System.out.println("        parametros() f "+fil+"  c " + col);
                if(actual.columna==col){
                    System.out.println("        existe columna :B "+actual.columna+" fil: "+actual.fila);
                    actual.personaje = p;
                }
            }
            else{
                System.out.println("    no existe fila "+actual.fila+" col: "+actual.columna);
            }
                actual = actual.derecha;
        }
    }
    
    public void darNodoColumna(nodoorto ultimo,int fil,int col, Personaje p){
      nodoorto actual = ultimo;
        actual= actual.abajo;
        while (actual != null)
        {
            if(actual.columna==col){
               
                System.out.println("    existe fila "+actual.fila+" col: "+actual.columna);
                if(actual.fila==fil){
                    System.out.println("        existe columna :B "+actual.columna+" fil: "+actual.fila);
                    actual.personaje = p;
                }
            }
            else{
                System.out.println("    no existe fila "+actual.fila+" col: "+actual.columna);
            }
                actual = actual.abajo;
        }
    }
    
    public void darFila(int fil,int col,Personaje p){
        Personaje aux = p;
        if( estavacio() )
	{
		System.out.printf("%s vacia\n");
	}
	nodoorto actual = fila.ultimo;
	while( actual != null)
	{
                darNodofila(actual,fil,col,p);
		actual = actual.ant;
	}
	System.out.println("\n");
    }

    
    public void darColumna(int fil,int col,Personaje p){
        Personaje aux = p;
        if( estavacio() )
	{
		System.out.printf("%s vacia\n");
	}
	nodoorto actual = columna.ultimo;
	while( actual != null)
	{
                darNodoColumna(actual,fil,col,p);
		actual = actual.ant;
	}
	System.out.println("\n");
    }
    
    public void darPersonaje(int fil,int col,Personaje p){
        darFila(fil,col,p);
        darColumna(fil,col,p);
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
    
        
        
     public nodoorto buscarF(nodoorto lista,int numero){
        nodoorto aux;
        nodoorto t=new nodoorto(-2,-2,-2);
        aux=buscarR(lista,numero);
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
        aux=buscarR(lista,numero);
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
                System.out.println("        if aux.buscarfila");
                aux.insertarFila(f);
                nodoorto nuevo;
                nuevo = aux.buscarR(fila.ultimo,f);
                a.izquierda = nuevo;
                nuevo.derecha = a;
                raiz = aux;
                
            } else
            {
                if(aux.buscarcolumna(c)==0)
                {
                    System.out.println("    else aux.buscarcolumna");
                    nodoorto nuevoNodo;
                    nuevoNodo = buscarF(aux.fila.ultimo,f);
                    a.izquierda = nuevoNodo;
                    nuevoNodo.derecha = a;
                    raiz = aux;
                }


            }
           
            if(aux.buscarcolumna(c)==0)
            {
                System.out.println("        if aux.buscarcolumna");
                nodoorto colaux=columna.ultimo;
                aux.insertarColumna(c);
                nodoorto nuevo;
                nuevo = aux.buscarR(columna.ultimo,c);
                a.arriba = nuevo;
                nuevo.abajo = a;
                raiz = aux;
            }
             else
            {
                 if(buscarfila(f)==0){
                     System.out.println("    else aux.buscarfila");
                     nodoorto nuevoNodo;
                     nuevoNodo = buscarC(aux.columna.ultimo,c);
                     a.arriba = nuevoNodo;
                     nuevoNodo.abajo = a;
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
