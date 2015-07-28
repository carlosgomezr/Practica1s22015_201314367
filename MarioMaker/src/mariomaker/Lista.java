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
public class Lista {
    public NodoLista primerNodo;
    public NodoLista ultimoNodo;
    public String nombre;
    public Lista(){
        this("lista");
    }
    
    public Lista(String nombreLista){
        nombre = nombreLista;
        primerNodo = ultimoNodo = null;
        
    }
    
    public void insertarAlFrente(Object elementoInsertar){
        if( estaVacia())
            primerNodo = ultimoNodo = new NodoLista(elementoInsertar);
        else
            primerNodo = new NodoLista(elementoInsertar);
        
    }
    
    public void insertarAlFinal(Object elementoInsertar){
        if( estaVacia())
            primerNodo = ultimoNodo = new NodoLista(elementoInsertar);
        else
            ultimoNodo = ultimoNodo.siguienteNodo = new NodoLista(elementoInsertar);
            
    }
    
    public Object eliminarDelFrente() throws ExcepcionListaVacia
    {
	if( estaVacia())
		throw new ExcepcionListaVacia(nombre);

	Object elementoEliminado = primerNodo.datos;

	if( primerNodo == ultimoNodo )
		primerNodo = ultimoNodo = null;
	else
		primerNodo = primerNodo.siguienteNodo;

	return elementoEliminado;
    }
    
    public Object eliminarDelFinal() throws ExcepcionListaVacia
    {
	if( estaVacia())
		throw new ExcepcionListaVacia( nombre );

	Object elementoEliminado = ultimoNodo.datos;

	if( primerNodo == ultimoNodo )
		primerNodo = ultimoNodo = null;
	else
	{
		NodoLista actual = primerNodo;
		while( actual.siguienteNodo != ultimoNodo)
			actual = actual.siguienteNodo;
		
		ultimoNodo = actual;
		actual.siguienteNodo = null;
	}

	return elementoEliminado;
    }
    
    public boolean estaVacia()
{
	return primerNodo == null;
}

public void imprimir()
{
	if( estaVacia() )
	{
		System.out.printf("%s vacia\n",nombre);
	}
	
	System.out.printf("La %s es: ", nombre);
	NodoLista actual = primerNodo;
	
	while( actual != null)
	{
		System.out.printf("%s ",actual.datos);
		actual = actual.siguienteNodo;
	}
	System.out.println("\n");
}


}
