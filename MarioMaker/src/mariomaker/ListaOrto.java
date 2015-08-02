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
public class ListaOrto {
    nodoorto ultimo;
    ListaOrto()
    {
        ultimo=null;
    }
 
    public boolean estavacio()
    {
        if(ultimo==null) return true;
        else return false;
    }
    
    
    public ListaOrto alta(int dat,int c,int f)
    {
        if(estavacio())
        {
            nodoorto nuevo=new nodoorto(dat,c,f);
            ultimo=nuevo;
        }
        else
        {
            nodoorto nuevo=new nodoorto(dat,c,f);
            ultimo.next=nuevo;
            nuevo.ant=ultimo;
            ultimo=nuevo;
        }
        return this;
    }

        public void reportarNodoFila()
    {
        nodoorto actual = ultimo;
        actual= actual.derecha;
        while (actual != null)
        {
            System.out.println("    numero: "+actual.a);
            ultimo = ultimo.derecha;
            
        }
    }
        
        public void reportarNodoColumna()
    {
        nodoorto actual = ultimo;
        actual = actual.abajo;
        while (actual != null)
        {
            System.out.println("    numero: "+actual.a);
            actual = actual.abajo;
        }
    }
    
    public void reportarFila()
{
	if( estavacio() )
	{
		System.out.printf("%s vacia\n");
	}
	nodoorto actual = ultimo;
	while( actual != null)
	{
                System.out.println(" dato :B "+actual.a);
		actual = actual.ant;
	}
	System.out.println("\n");
}
    
    public void reportarColumna()
{
	if( estavacio() )
	{
		System.out.printf("%s vacia\n");
	}
	nodoorto actual = ultimo;
	while( actual != null)
	{
                System.out.println(" dato :B "+actual.a);
		actual = actual.ant;
	}
	System.out.println("\n");
}
}
