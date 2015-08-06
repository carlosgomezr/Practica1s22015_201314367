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
    
    public String buscarNombreInverso(int id){
        String nombre="";
        nodo actual;
        actual = primero;
        for(int i=id;i>=1;i--){ 
            if(actual!=null){
            nombre = actual.personaje.nombre;
            actual = actual.next;
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
    
      
       public String buscarPathInverso(int id){
        String path="";
        nodo actual;
        actual = primero;
        for(int i=id;i>=1;i--){
            if(actual!=null){
                path = actual.personaje.PathImagen;
                actual = actual.next;
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
      
      
      public int buscaridInverso(int id){
        int numeroid=0;
        nodo actual;
        actual = primero;
        for(int i=id;i>=1;i--){
            if(actual!=null){
                numeroid = actual.personaje.dato;
                actual = actual.next;
            }
        }
        return numeroid;
    }
      
      
      public Personaje buscarXY(int x, int y){
        Personaje aux= new Personaje(0,"","",0,"");
          if( estavacio() )
	{
		System.out.printf("%s vacia\n");
	}
	nodo actual = ultimo;
	while( actual != null)
	{
                if(actual.personaje.PosX==x){
                    System.out.println("Encontre X");
                    if(actual.personaje.PosY==y){
                        System.out.println("Encontre Y");
                        aux = actual.personaje;
                    }
                }
		actual = actual.ant;
	}
        return aux;
    }
      
      
      public int buscaridPila(){
        nodo actual;
        actual = ultimo;
        return actual.personaje.dato;
    }
      
      
      public int buscaridCola(){
        nodo actual;
        actual=primero;
        return actual.personaje.dato;
      }
      
      
      public Personaje DarObjetoCola(){
          Personaje auxiliar = new Personaje(0,"","",0,"");
          nodo actual = ultimo;
          while(actual!=null){
              auxiliar = actual.personaje;
              actual = actual.ant;
          }
         // Personaje auxiliar = new Personaje(0,"","",0,"");
         // auxiliar = primero.personaje;
          return auxiliar;
      }
      
      
      public Personaje DarObjetoPila(){
          Personaje auxiliar = new Personaje(0,"","",0,"");
          auxiliar = ultimo.personaje;
          return auxiliar;
      }
      
    public void reset(){
        primero = null;
        ultimo = null;
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
        public int tamaño(){
        int t=1;
        if( estavacio() )
	{
		t=0;
	}
	nodo actual = ultimo;
	while( actual != null)
	{
                t = t+1;
		actual = actual.ant;
	}
        return t;
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
        
        
        public void modificarNombre(int numero,String nombre)
{
	if( estavacio() )
	{
		System.out.printf("%s vacia\n");
	}
	nodo actual = ultimo;
	while( actual != null)
	{
                if(actual.personaje.dato==numero){
                    System.out.println("lo encontre");
                    actual.personaje.nombre = nombre;
                }
		actual = actual.ant;
	}
   
}
        
        
}
