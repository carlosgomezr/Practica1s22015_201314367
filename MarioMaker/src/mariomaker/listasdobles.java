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
public class listasdobles {
    nodo primero;
    nodo ultimo;
    listasdobles()
    {
        primero=null;
        ultimo=null;
    }
 
    public boolean estavacio()
    {
        if(primero==null) return true;
        else return false;
    }
 
    public listasdobles alta(Personaje dat)
    {
        if(estavacio())
        {
            nodo nuevo=new nodo(dat);
            primero=nuevo;
            ultimo=nuevo;
        }
        else
        {
            nodo nuevo=new nodo(dat);
            ultimo.next=nuevo;
            nuevo.ant=ultimo;
            ultimo=nuevo;
        }
        return this;
    }

    public listasdobles baja(Personaje dat)
    {
        if(estavacio())
        {
            nodo nuevo=new nodo(dat);
            primero=nuevo;
            ultimo=nuevo;
        }
        else
        {
            nodo nuevo=new nodo(dat);
            primero.ant=nuevo;
			nuevo.next = primero;
			primero = nuevo;
        }
        return this;
    }
    
    public String buscarNombre(int id){
        String nombre="";
        nodo actual;
        actual = ultimo;
        for(int i=1;i<=id;i++){
            if(actual!=null){
            nombre = actual.personaje.nombre;
            actual = actual.ant;
            }
        }
        return nombre;
    }
    
      public String buscarPath(int id){
        String path="";
        nodo actual;
        actual = ultimo;
        for(int i=1;i<=id;i++){
            if(actual!=null){
                path = actual.personaje.PathImagen;
                actual = actual.ant;
            }
        }
        return path;
    }
    
 
      public int buscarid(int id){
        int numeroid=0;
        nodo actual;
        actual = ultimo;
        for(int i=1;i<=id;i++){
            if(actual!=null){
                numeroid = actual.personaje.dato;
                actual = actual.ant;
            }
        }
        return numeroid;
    }
      
      
    public boolean delete(int num)
    {
        nodo anterior=null;
        nodo actual=primero;
        while(actual!=ultimo)
        {
            if(actual.personaje.dato==num)
            {
                if(anterior==null)
                {
                    primero=actual.next;
                    primero.ant=null;
                }
                else{
                    anterior.next=actual.next;
                    nodo temporal;
                    temporal=actual.next;
                    temporal.ant=anterior;
                }
                return true;
            }
            anterior=actual;
            actual=actual.next;
        }
        if(num==ultimo.personaje.dato)
        {
            ultimo=actual.ant;
            return true;
        }
        return false;
    }

    
        public int numeropop(){
            int num=0;
            num = ultimo.personaje.dato;
            return num;
        }
        
        public int numerocola(){
            int num=0;
            num = primero.personaje.dato;
            return num;
        }
    
        public void imprimir2()
    {
        nodo actual;
        actual=ultimo;
        while(actual!=primero)
        {
            System.out.println(actual.personaje.dato);
            actual=actual.ant;
        }
                System.out.println(actual.personaje.dato);
 
    }
        public void imprimir()
    {
        nodo actual;
        actual=primero;
        System.out.println("IMPRIMIR LISTA DOBLE");
        while(actual!=ultimo)
        {
            System.out.println(" id : "+actual.personaje.dato+" nombre: "+actual.personaje.nombre);
            actual=actual.next;
        }
                System.out.println(" id : "+actual.personaje.dato+" nombre: "+actual.personaje.nombre);
                 
    }
        
        public void imprimirlista()
{
	if( estavacio() )
	{
		System.out.printf("%s vacia\n");
	}
	
	
	nodo actual = ultimo;
	
	while( actual != null)
	{
                System.out.println(" id : "+actual.personaje.dato+" nombre: "+actual.personaje.nombre);
		actual = actual.ant;
	}
	System.out.println("\n");
}
}
