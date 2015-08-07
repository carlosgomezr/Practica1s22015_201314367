/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mariomaker;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.lang.*;

/**
 *
 * @author Carlos Gomez
 */
public class Funcion {
String ruta = "C:\\Users\\estua_000\\Documents\\NetBeansProjects\\MarioMaker\\src\\graph.txt";

    public void generar(String nombre) {
    String rutaimagen = ruta;
    System.out.println("RUTA DE GENERAR " + rutaimagen);
        
        try {

//path del dot.exe,por lo general es la misma, pero depende de donde hayas instalado el paquete de Graphviz
            String dotPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";

//path del archivo creado con el codigo del graphviz que queremos
            String fileInputPath = rutaimagen;

//path de salida del grafo, es decir el path de la imagen que vamos a crear con graphviz
            String fileOutputPath = "C:\\Users\\estua_000\\Documents\\NetBeansProjects\\MarioMaker\\src\\"+nombre+".png";

//tipo de imagen de salida, en este caso es jpg
            String tParam = "-Tpng";

            String tOParam = "-o";

//concatenamos nuestras direcciones. Lo que hice es crear un vector, para poder editar las direcciones de entrada y salida, usando las variables antes inicializadas
//recordemos el comando en la consola de windows: C:\Archivos de programa\Graphviz 2.21\bin\dot.exe -Tjpg grafo1.txt -o grafo1.jpg Esto es lo que concatenamos en el vector siguiente:
            String[] cmd = new String[5];
            cmd[0] = dotPath;
            cmd[1] = tParam;
            cmd[2] = fileInputPath;
            cmd[3] = tOParam;
            cmd[4] = fileOutputPath;

//Invocamos nuestra clase 
            Runtime rt = Runtime.getRuntime();

//Ahora ejecutamos como lo hacemos en consola
            rt.exec(cmd);

        } catch (IOException ex) {
            System.out.println("fallo");
        } finally {
        }
    }
    
    public void generarArchivo(Lista lista){
            Lista aux = lista;
	    File f;
	    FileWriter escribir;
	    try{
	    System.out.println(ruta);
	    f = new File(ruta);
	    escribir = new FileWriter(f);
	    BufferedWriter bw = new BufferedWriter(escribir);
	    PrintWriter pw = new PrintWriter(bw);
            pw.write("digraph grafica { \n");
            pw.write("label= \"LISTA DOBLE\"");
            pw.write("node [shape=record];\n");
	    pw.write("subgraph g { \n "); 
            if(lista!=null){
                if(lista==null){
                }
                else{
                    if(aux.primerNodo.siguienteNodo!=null){
                        while(aux.primerNodo.siguienteNodo!=null){
                            pw.write("node"+aux.primerNodo.datos+"[label=\" id: "+aux.primerNodo.datos+" \"];\n");
                            pw.write("node"+aux.primerNodo.siguienteNodo.datos+"[label=\" id: "+aux.primerNodo.siguienteNodo.datos+" \"];\n");
                            pw.write("node"+aux.primerNodo.datos+"->node"+aux.primerNodo.siguienteNodo.datos+";\n");
                            aux.primerNodo = aux.primerNodo.siguienteNodo;
                        }
                    }
                    else{
                        pw.write("node"+aux.primerNodo.datos+"[label=\" id: "+aux.primerNodo.datos+" \"];\n");     
                    }
                }
            }
            pw.write("}\n");
	    pw.write("}\n");
	    pw.close();
	    bw.close();
	    }
	    catch(IOException e){System.out.println("Error: "+e.getMessage());
            
            }
            
       
            
	    }

    
     public void generarListaDoble(listasdobles lista){
            listasdobles aux = lista;
	    File f;
	    FileWriter escribir;
	    try{
	    System.out.println(ruta);
	    f = new File(ruta);
	    escribir = new FileWriter(f);
	    BufferedWriter bw = new BufferedWriter(escribir);
	    PrintWriter pw = new PrintWriter(bw);
            pw.write("digraph grafica { \n");
            pw.write("label= \"LISTA DOBLE  PERSONAJES\"");
            pw.write("node [shape=record];\n");
	    pw.write("subgraph g { \n "); 
            if(lista.primero!=null){
                
         
                    if(aux.primero.next!=null){
                        while(aux.primero.next!=null){
                            pw.write("node"+aux.primero.personaje.dato+"[label=\" id: "+aux.primero.personaje.dato+" nombre: "+aux.primero.personaje.nombre +" tipo: "+aux.primero.personaje.tipo+" \"];\n");
                            pw.write("node"+aux.primero.next.personaje.dato+"[label=\" id: "+aux.primero.next.personaje.dato+" nombre: "+aux.primero.next.personaje.nombre+" tipo: "+aux.primero.next.personaje.tipo+" \"];\n");
                            pw.write("node"+aux.primero.personaje.dato+"->node"+aux.primero.next.personaje.dato+";\n");
                            pw.write("node"+aux.primero.next.personaje.dato+"->node"+aux.primero.personaje.dato+";\n");
                            aux.primero = aux.primero.next;
                        }
                    }
                    else{
                        pw.write("node"+aux.primero.personaje.dato+"[label=\" id: "+aux.primero.personaje.dato+" nombre: "+aux.primero.personaje.nombre+" tipo: "+aux.primero.personaje.tipo+" \"];\n");     
                    }
                
            }
            else{
                    System.out.println("    lista vacia xd ");
            }
            pw.write("}\n");
	    pw.write("}\n");
	    pw.close();
	    bw.close();
	    }
	    catch(IOException e){System.out.println("Error: "+e.getMessage());
            
            }
            
       
            
	    }

     
         
       
}
