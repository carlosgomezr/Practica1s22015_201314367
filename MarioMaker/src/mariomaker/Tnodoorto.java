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
public class Tnodoorto {
NodoOrto nodo;
NodoOrto nodoc;
Tnodoorto()
    {
        this.nodo = null;
    }

 public boolean estavacio()
    {
        if(nodo==null) return true;
        else return false;
    }
 
public Tnodoorto insertarCF(int dat)
    {
        if(estavacio())
        {
            System.out.println("esta vacia la lista");
            NodoOrto nuevo=new NodoOrto(dat,-1,-1,"");
            nodo=nuevo;
        }
        else
        {
            NodoOrto nuevo=new NodoOrto(dat,-1,-1,"");
            nodo.siguiente=nuevo;
            nuevo.anterior=nodo;
            nodo=nuevo;
        }
        return this;
    } 
     

     public void reportarFila()
{
        NodoOrto actual= nodo;
        System.out.println("reportar fila");
	if( estavacio() )
	{
		System.out.printf("%s vacia\n");
	}

	while( actual != null)
	{
                System.out.println(" numero : "+actual.numero);
		actual = actual.anterior;
	}
	System.out.println("\n");
}

     
      public void reportarColumna(Tnodoorto lista)
    {
        NodoOrto actual= nodo;
        System.out.println("reportar fila");
	if( estavacio() )
	{
		System.out.printf("%s vacia\n");
	}

	while( actual != null)
	{
                System.out.println(" numero : "+actual.numero);
		actual = actual.anterior;
	}
	System.out.println("\n");    
    
    }


     
}
