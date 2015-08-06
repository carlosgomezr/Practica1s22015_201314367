/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mariomaker;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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

        public void reportarNodoFila(nodoorto ultimo)
    {
        nodoorto actual = ultimo;
        actual= actual.derecha;
        while (actual != null)
        {
            System.out.println("    numero:T "+actual.a+" fila: "+actual.fila+" columna:"+actual.columna+" nombre: "+actual.personaje.nombre);
            actual = actual.derecha;
        }
    }
                
        public String graphNodoFila(nodoorto ultimo){
         
            String auxiliar ="";
            nodoorto actual = ultimo;
            actual = actual.derecha;
            while (actual != null)
            {
                if(actual.derecha!=null){
                    auxiliar = auxiliar+ "nodef"+actual.fila+"c"+actual.columna+"[label=\" \n id: "+actual.a+" \n nombre: "+actual.personaje.nombre +" \n tipo: "+actual.personaje.tipo+" \"];\n";
                    auxiliar = auxiliar+ "nodef"+actual.derecha.fila+"c"+actual.derecha.columna+"[label=\" \n id: "+actual.derecha.a+" \n nombre: "+actual.derecha.personaje.nombre +" \n tipo: "+actual.derecha.personaje.tipo+" \"];\n";
                    auxiliar = auxiliar+ "nodef"+actual.derecha.fila+"c"+actual.derecha.columna+"->nodef"+actual.fila+"c"+actual.columna+";\n";
                    auxiliar = auxiliar+ "nodef"+actual.fila+"c"+actual.columna+"->nodef"+actual.derecha.fila+"c"+actual.derecha.columna+";\n";
                }
                else{
                      auxiliar = auxiliar+ "nodef"+actual.fila+"c"+actual.columna+"[label=\" \n id: "+actual.a+" \n nombre: "+actual.personaje.nombre +" \n tipo: "+actual.personaje.tipo+" \"];\n";
                    //auxiliar = auxiliar+ "nodef"+actual.derecha.fila+"c"+actual.derecha.columna+"[label=\" id: "+actual.derecha.a+" nombre: "+actual.derecha.personaje.nombre +" tipo: "+actual.derecha.personaje.tipo+" \"];\n";
                    //auxiliar = auxiliar+ "nodef"+actual.derecha.fila+"c"+actual.derecha.columna+"->nodef"+actual.fila+"c"+actual.columna+";\n";
                    //auxiliar = auxiliar+ "nodef"+actual.fila+"c"+actual.columna+"->nodef"+actual.derecha.fila+"c"+actual.derecha.columna+";\n";

                }
                actual = actual.derecha;
            }
            
            return auxiliar;
        }

    public String graphFila(nodoorto ultimo)
{
    String aux="";
	if( estavacio() )
	{
		System.out.printf("%s vacia\n");
	}
	nodoorto actual = ultimo;
	while( actual != null)
	{
                aux = aux+ graphNodoFila(actual);
		actual = actual.ant;
	}
    return aux;
} 
    

        public String graphNodoColumna(nodoorto ultimo){
         
            String auxiliar ="";
            nodoorto actual = ultimo;
            actual = actual.abajo;
            while (actual != null)
            {
                if(actual.abajo!=null){
                    auxiliar = auxiliar+ "nodef"+actual.fila+"c"+actual.columna+"[label=\" \n id: "+actual.a+" \n nombre: "+actual.personaje.nombre +" \n tipo: "+actual.personaje.tipo+" \"];\n";
                    auxiliar = auxiliar+ "nodef"+actual.abajo.fila+"c"+actual.abajo.columna+"[label=\" \n id: "+actual.abajo.a+" \n nombre: "+actual.abajo.personaje.nombre +" \n tipo: "+actual.abajo.personaje.tipo+" \"];\n";
                    auxiliar = auxiliar+ "nodef"+actual.abajo.fila+"c"+actual.abajo.columna+"->nodef"+actual.fila+"c"+actual.columna+";\n";
                    auxiliar = auxiliar+ "nodef"+actual.fila+"c"+actual.columna+"->nodef"+actual.abajo.fila+"c"+actual.abajo.columna+";\n";
                }
                else{
                      auxiliar = auxiliar+ "nodef"+actual.fila+"[label=\" \n f: "+actual.fila+" \"];\n";
                      auxiliar = auxiliar+ "nodec"+actual.columna+"[label=\" \n c: "+actual.columna+" \"];\n";
                      auxiliar = auxiliar+ "nodef"+actual.fila+"c"+actual.columna+"[label=\" \n id: "+actual.a+" \n nombre: "+actual.personaje.nombre +" \n tipo: "+actual.personaje.tipo+" \"];\n";
                    //auxiliar = auxiliar+ "nodef"+actual.derecha.fila+"c"+actual.derecha.columna+"[label=\" id: "+actual.derecha.a+" nombre: "+actual.derecha.personaje.nombre +" tipo: "+actual.derecha.personaje.tipo+" \"];\n";
                    //auxiliar = auxiliar+ "nodef"+actual.derecha.fila+"c"+actual.derecha.columna+"->nodef"+actual.fila+"c"+actual.columna+";\n";
                    //auxiliar = auxiliar+ "nodef"+actual.fila+"c"+actual.columna+"->nodef"+actual.derecha.fila+"c"+actual.derecha.columna+";\n";
   //                   auxiliar = auxiliar + "nodef"+actual.fila+"->nodef"+actual.fila+"c"+actual.columna;
   //                   auxiliar = auxiliar + "nodec"+actual.columna+"->nodef"+actual.columna+"c"+actual.columna;
                        
                }
                actual = actual.abajo;
            }
            
            return auxiliar;
        }

    public String graphColumna(nodoorto ultimo)
{
    String aux="";
	if( estavacio() )
	{
		System.out.printf("%s vacia\n");
	}
	nodoorto actual = ultimo;
	while( actual != null)
	{
                aux = aux+ graphNodoColumna(actual);
		actual = actual.ant;
	}
    return aux;
} 
         public void graphMatriz(nodoorto ultimo, nodoorto ultimo2){
            String ruta = "C:\\Users\\estua_000\\Documents\\NetBeansProjects\\MarioMaker\\src\\graph.txt";
            String auxfila = graphFila(ultimo);
            String auxcolumna = graphColumna(ultimo2);
	    File f;
	    FileWriter escribir;
	    try{
	    System.out.println(ruta);
	    f = new File(ruta);
	    escribir = new FileWriter(f);
	    BufferedWriter bw = new BufferedWriter(escribir);
	    PrintWriter pw = new PrintWriter(bw);
            pw.write("digraph grafica { \n");
            pw.write("label= \"MATRIZ ORTOGONAL\"");
            pw.write("node [shape=record];\n");
            pw.write("rankdir=TB;\n");
            pw.write("rank=same");
	    pw.write("subgraph g { \n "); 
            pw.write(auxfila);
            pw.write("}\n");
            pw.write("randir=LR; \n");
            pw.write("subgraph d { \n ");
            pw.write(auxcolumna);
            pw.write("}\n");
	    pw.write("}\n");
	    pw.close();
	    bw.close();
	    }
	    catch(IOException e){System.out.println("Error: "+e.getMessage());
            
            }
          }

        public void reportarNodoColumna(nodoorto ultimo)
    {
        nodoorto actual = ultimo;
        actual = actual.abajo;
        while (actual != null)
        {
            System.out.println("    numero:T "+actual.a+" fila: "+actual.fila+" columna:"+actual.columna+" nombre: "+actual.personaje.nombre);
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
                System.out.println(" Fila "+actual.a);
                reportarNodoFila(actual);
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
                System.out.println(" Columna "+actual.a);
                reportarNodoColumna(actual);
                actual = actual.ant;
	}
	System.out.println("\n");
}
    public void reportarnodo(nodoorto nodo){
        
    }
}
