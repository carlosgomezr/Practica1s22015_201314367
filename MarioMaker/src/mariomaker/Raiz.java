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
               
                //System.out.println("    existe fila "+actual.fila+" col: "+actual.columna);
               // System.out.println("        parametros() f "+fil+"  c " + col);
                if(actual.columna==col){
               //     System.out.println("        existe columna :B "+actual.columna+" fil: "+actual.fila);
                    actual.personaje = p;
             //       System.out.println(" hice el cambio ");
                }
            }
            else{
           //     System.out.println("    no existe fila "+actual.fila+" col: "+actual.columna);
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
               
         //       System.out.println("    existe fila "+actual.fila+" col: "+actual.columna);
                if(actual.fila==fil){
     //               System.out.println("        existe columna :B "+actual.columna+" fil: "+actual.fila);
                    actual.personaje = p;
       //             System.out.println(" hice el cambio ");
                }
            }
            else{
   //             System.out.println("    no existe fila "+actual.fila+" col: "+actual.columna);
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
    
    public void changePersonaje(int f, int c,Personaje p){
        nodoorto q = fila.ultimo;
        while(q !=null){
            if(q.a ==f){
                nodoorto t = q;
                System.out.println("     ENCONTRE FILA ");
                while(t !=null){
                    if(t.columna == c){
                            t.personaje = p;
                    }
                    else{
                        System.out.println("     NO ENCONTRE COLUMNA "+c +" COLUMNA ACTUAL "+t.columna);
                    }
                     t = t.derecha;
                }
            }else{
                System.out.println("     NO ENCONTRE FILA ");
            }
            q = q.ant;
        }
        
    }
    
    public Personaje buscarnodo(int f, int c){
        nodoorto q = fila.ultimo;
        Personaje p = new Personaje(0,"","",0,"");
        while(q !=null){
            if(q.a ==f){
                nodoorto t = q;
                System.out.println("     ENCONTRE FILA ");
                while(t !=null){
                    if(t.columna == c){
                       System.out.println("     DATO PERSONAJE NODO "+t.personaje.nombre);
                       p = t.personaje;
                    }
                    else{
                        System.out.println("     NO ENCONTRE COLUMNA "+c +" COLUMNA ACTUAL "+t.columna);
                    }
                     t = t.derecha;
                }
            }else{
                System.out.println("     NO ENCONTRE FILA ");
            }
            q = q.ant;
        }
        return p;
    }
    public Personaje getPersonaje(int f, int c){
    Personaje p = buscarnodo(f,c);
        System.out.println("    Personaje");
        System.out.println("        nombre "+p.nombre);
        System.out.println("        paht   "+p.PathImagen);
        return p;
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
        return t;
    }
    
        public nodoorto buscarCabecera(nodoorto lista,int numero){
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
            q = q.ant;
        }
        return t;
    }
    
        public void eliminarC(nodoorto lista,int numero){
        nodoorto actual = buscarCabecera(lista, numero);
        if(actual.next!=null){
            actual = actual.abajo;
            while (actual != null)
            {
                System.out.println("    actual = "+actual.a);
                nodoorto aux = actual.izquierda;
                aux.derecha = actual.derecha;
                
                nodoorto aux2 = actual.derecha;
                aux2.izquierda = actual.izquierda;
                
                aux = aux2 = null;
                
                actual = actual.abajo;
            }
                actual = buscarCabecera(lista,numero);
                nodoorto auxc = actual.ant;
                auxc.next = actual.next;
                nodoorto auxc2 = actual.next;
                auxc2.ant = actual.ant;
        }
        if(actual.next==null){
                System.out.println("    actual.next = null");
                System.out.println("    actual = "+actual.a);
                actual = actual.abajo;
                while(actual!=null){
                    nodoorto aux = actual.izquierda;
                    aux.derecha = null;
                    actual=actual.abajo;
                }
                    actual = buscarCabecera(lista,numero);
                    nodoorto auxc = actual.ant;
                    auxc.next = null;
        }
                
        }
        
    
        public void eliminarF(nodoorto lista,int numero){
        nodoorto actual = buscarCabecera(lista, numero);
        if(actual.next!=null){
            actual = actual.derecha;
            while (actual != null)
            {
                System.out.println("    actual = "+actual.a);
                nodoorto aux = actual.arriba;
                aux.abajo = actual.abajo;
                
                nodoorto aux2 = actual.abajo;
                aux2.arriba = actual.arriba;
                
                aux = aux2 = null;
                
                actual = actual.derecha;
            }
                actual = buscarCabecera(lista,numero);
                nodoorto auxc = actual.ant;
                auxc.next = actual.next;
                nodoorto auxc2 = actual.next;
                auxc2.ant = actual.ant;
        }
        if(actual.next==null){
                System.out.println("    actual.next = null");
                System.out.println("    actual = "+actual.a);
                actual = actual.derecha;
                while(actual!=null){
                    nodoorto aux = actual.arriba;
                    aux.abajo = null;
                    actual=actual.derecha;
                }
                    actual = buscarCabecera(lista,numero);
                    nodoorto auxc = actual.ant;
                    auxc.next = null;
                    actual.derecha = null;
                    
        }
                
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

     public nodoorto encontrarfila(int fil){
        nodoorto q = fila.ultimo;
        nodoorto t= new nodoorto(-2,-2,-2);
        int i = 1, band = 0;
        while (q != null)
        {
            if (q.a== fil)
            {
                band = 1;
                t = q;
                return t;
            }
            q = q.ant;
            i++;
        }
        return t;
    }
    
     public nodoorto encontrarcolumna(int col){
         nodoorto q = columna.ultimo;
         nodoorto t = new nodoorto(-2,-2,-2);
          int i = 1, band = 0;
        while (q != null)
        {
            if (q.a== col)
            {
                band = 1;
                t = q;
                return t;
            }
            q = q.ant;
            i++;
        }
        return t;
     }
    public nodoorto FinalFila(nodoorto lista){
        nodoorto q = lista;
        nodoorto t=new nodoorto(-2,-2,-2);
        while (q != null)
        {
            t = q;
            q = q.derecha;
        }
        return t;
    }
    
    public nodoorto FinalColumna(nodoorto lista){
        nodoorto q = lista;
        nodoorto t= new nodoorto(-2,-2,-2);
         while (q != null)
        {
                t = q;         
                q = q.abajo;
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
            if((aux.buscarfila(f)==1)&(aux.buscarcolumna(c)==1)) {
                    nodoorto auxnuevo;
                    auxnuevo = aux.FinalColumna(aux.encontrarcolumna(c));
                    System.out.println("    nodo aux.FinalFila f "+auxnuevo.fila+" c "+auxnuevo.columna);
                    a.arriba = auxnuevo;
                    auxnuevo.abajo = a;
                    
                    
                    nodoorto auxnuevo2;
                    auxnuevo2 = aux.FinalFila(aux.encontrarfila(f));
                    System.out.println("    nodo de aux.FinalColumna f "+auxnuevo2.fila+" c "+auxnuevo2.columna);
                    a.izquierda = auxnuevo2;
                    auxnuevo2.derecha = a;
                    raiz = aux;            
            }
            if((aux.buscarfila(f)==0)&(aux.buscarcolumna(c)==0)) {
                aux.insertarFila(f);
                aux.insertarColumna(c);
                nodoorto nuevo;
                nuevo = aux.buscarR(fila.ultimo,f);
                nodoorto nuevoc;
                nuevoc = aux.buscarR(columna.ultimo,c);
                a.izquierda = nuevo;
                nuevo.derecha = a;
                a.arriba = nuevoc;
                nuevoc.abajo = a;
                raiz = aux;
               
            }
             if((aux.buscarfila(f)==0)&(aux.buscarcolumna(c)==1)){
                    aux.insertarFila(f);
                    nodoorto nuevof;
                    nuevof = aux.buscarR(fila.ultimo,f);
                    nodoorto auxnuevo;
                    auxnuevo = aux.FinalColumna(aux.encontrarcolumna(c));
                    System.out.println("    nodo de aux.FinalColumna "+auxnuevo.fila+" c "+auxnuevo.columna);
                    a.izquierda = nuevof;
                    nuevof.derecha = a;
                    a.arriba = auxnuevo;
                    auxnuevo.abajo = a;
                    raiz = aux;   
             }
                
            if((aux.buscarcolumna(c)==0)&(aux.buscarfila(f)==0)){
                aux.insertarColumna(c);
                aux.insertarFila(f);
                nodoorto nuevo;
                nuevo = aux.buscarR(columna.ultimo,c);
                nodoorto nuevof;
                nuevof = aux.buscarR(fila.ultimo,f);
                a.arriba = nuevo;
                nuevo.abajo = a;
                a.izquierda = nuevof;
                nuevof.derecha = a;
                raiz = aux;
                
            }
            if((aux.buscarcolumna(c)==0)&(aux.buscarfila(f)==1)){
                    aux.insertarColumna(c);
                    nodoorto nuevoc;
                    nuevoc = aux.buscarR(columna.ultimo,c);
                    nodoorto auxnuevo;
                    auxnuevo = aux.FinalFila(aux.encontrarfila(f));
                    System.out.println("    nodo de aux.FinalFila f "+auxnuevo.fila+" c "+auxnuevo.columna);
                    a.izquierda = auxnuevo;
                    auxnuevo.derecha = a;
                    a.arriba = nuevoc;
                    nuevoc.abajo = a;
                    raiz = aux;
                }
            else{
                    
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
