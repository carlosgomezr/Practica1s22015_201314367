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
public class ListaFigura {
    NodoFigura primero;
    NodoFigura ultimo;
    ListaFigura()
    {
        primero=null;
        ultimo=null;
    }
    
    public boolean estavacio()
    {
        if(primero==null) return true;
        else return false;
    }
    
    public ListaFigura baja(Figura dat)
    {
        if((ultimo==null))
        {
            NodoFigura nuevo=new NodoFigura(dat);
            primero=nuevo;
            ultimo=nuevo;
        }
        else
        {
            NodoFigura nuevo=new NodoFigura(dat);
            ultimo.next=nuevo;
            nuevo.ant=ultimo;
            ultimo=nuevo;
        }
        return this;
    }
    
    public NodoFigura buscarFigura(int id){
        NodoFigura fig= null;
        NodoFigura actual;
        actual = ultimo;
        for(int i=1;i<=id;i++){
            if(actual!=null){
                fig = actual;
                actual = actual.ant;
            }
        }
        return fig;
    }
    
    public int tamaño(){
        int t=1;
        if( estavacio() )
	{
		t=0;
	}
	NodoFigura actual = ultimo;
	while( actual != null)
	{
                t = t+1;
		actual = actual.ant;
	}
        return t;
        }
}
