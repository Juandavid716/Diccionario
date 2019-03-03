/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diccionario;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author JuanBojato
 */
public class Diccionario {
   
  private static BigInteger numero;
private static String caracter;
private static BigInteger numgrande;

    public static BigInteger getMayor() {
        return Mayor;
    }

    public static void setMayor(BigInteger Mayor) {
        Diccionario.Mayor = Mayor;
    }

    public static int getMenor() {
        return Menor;
    }

    public static void setMenor(int Menor) {
        Diccionario.Menor = Menor;
    }
private static BigInteger Mayor= BigInteger.valueOf(-999999999);
private static int MayorLetra= -999999;
private static int MayorRepetido= 1;
private static int Indice;
private static String MayorASCII;
private static int Menor=99999999;
private static int prom;
private static BigInteger promGrande;
private static long TInicio, tiempo; 
private static int contRegistro=0;
private static int contcampos=0;
public static ArrayList <String> tipo= new ArrayList<String>();
public static ArrayList<Integer> longitudes= new ArrayList<Integer>();
public static ArrayList<ArrayList<String>> tmp = new ArrayList<>();
public static ArrayList<ArrayList<String>> Camp = new ArrayList<>();
public static ArrayList<ArrayList<String>> copia = new ArrayList<>();

    public static BigInteger getNumgrande() {
        return numgrande;
    }

    public static void setNumgrande(BigInteger numgrande) {
        Diccionario.numgrande = numgrande;
    }
    public static String getCaracter() {
        return caracter;
    }

    public static void setCaracter(String caracter) {
        Diccionario.caracter = caracter;
    }
    public static BigInteger getNumero() {
        return numero;
    }

    public static void setNumero(BigInteger numero) {
        Diccionario.numero = numero;
    }
    public static void main(String[] args) throws IOException {
long tiempo1;   int n=0, ci=0,k,res;
    int longitud;
    String tipoNumCaracter;
      

    Scanner s = new Scanner(System.in);
        System.out.println("Digite que desea hacer 1.Leer Archivo 2. Crear archivo aleatorio");
        res = s.nextInt();
        while (res<1 && res> 2) {            
            System.out.println("Digite la opción 1 o 2");
                    res = s.nextInt();
        }
       
    if(res==2){
          s.nextLine();
    File archivo = new File("./Registro.txt");

   String answer;
        System.out.println("Digite la cantidad de registros");
        answer = s.nextLine();
        
        if(SoloNumeros(answer)==true){
        n = Integer.parseInt(answer);
        }else{
            while(SoloNumeros(answer)==false){
                System.out.println("Digite solamente números");
                answer= s.nextLine();
            }
            n = Integer.parseInt(answer);
        }
        while (n<0 && n > 999999999) {            
            System.out.println("Digite una cantidad de registro mayor que 0 y menor que 999999999");
                    n = s.nextInt();
        }
        System.out.println("Digite la cantidad de campos");
        
        ci = s.nextInt();
          for (int i = 0; i <= ci; i++) {
            longitudes.add(0);
            tipo.add("");
        }
         while (ci<0 && n > 999999999) {            
            System.out.println("Digite una cantidad de campos mayor que 0 y menor que 999999999");
                  ci = s.nextInt();
        }
            s.nextLine();
         for (int i = 1; i <= ci; i++) {
             System.out.println("Digite la longitud del campo "+i);
             longitud = s.nextInt();
             while (longitud<0 && longitud > 999999999) {            
           System.out.println("Digite una longitud mayor que 0 y menor que 999999999");
                 longitud = s.nextInt();
             }
             System.out.println("Digite el tipo de dato 1. Númerico 2. Caracteres \n");
             s.nextLine();
             tipoNumCaracter = s.nextLine();
               while (!tipoNumCaracter.equals("1") && !tipoNumCaracter.equals("2")) {            
           System.out.println("Digite 1. númerico 2. caracteres \n");
               tipoNumCaracter = s.nextLine();
             }
             longitudes.set(i, longitud);
             tipo.set(i, tipoNumCaracter);
        }
//            System.out.println("digite la longitud de los campos");
//            k = s.nextInt();
//              while (k<0 && k > 999999999) {            
//            System.out.println("Digite una longitud mayor que 0 y menor que 999999999");
//                  k = s.nextInt();
//        }
               System.out.println("**** DIRECCIONAMIENTO DE LOS DATOS****");
                 TInicio =  System.currentTimeMillis();  
      CrearArchivo(archivo,n,ci,longitudes,tipo);
       
        LeerArchivo(archivo);
         tiempo = System.nanoTime() - TInicio;
 
   System.out.println("El tiempo de ejecución es "+tiempo);
    } else {
         TInicio =  System.currentTimeMillis();  
        File archivo = new File("./nombre.txt");
LeerArchivoModificado(archivo);
 tiempo = System.nanoTime() - TInicio;
 
   System.out.println("El tiempo de ejecución es "+tiempo);
n = contRegistro;
ci = contcampos;
        System.out.println("NNN "+n);
        System.out.println("CAMPOS "+ci);
}
     
System.out.println("\n");
        System.out.println("**** ORDENAMIENTO DE LOS DATOS ****");
        
tmp = OrdenarRegistros(Camp,copia);
System.out.println("\n");
        
                
        System.out.println("¿Qué desea hacer?\n");
         System.out.println("1. Buscar por Clave");
        System.out.println("2. Buscar por Campo");
      
        int respuesta = s.nextInt();
        while (respuesta>2 && respuesta <=0) {            
            System.out.println("Digite una opción del menú");
              respuesta = s.nextInt();
              System.out.println("1. Buscar por Clave\n");
        System.out.println("2. Buscar por Campo\n");
        
        }
            
           switch(respuesta) {
    case 1:
        s.nextLine();
      System.out.println("digite la clave a buscar");

                 String claveABuscar = s.nextLine();
                 
                 while (claveABuscar.equals("")) {            
            System.out.println("Digite una clave valida");
                  claveABuscar = s.nextLine();
                  
        }
                 System.out.println("**** BUSQUEDA POR CLAVE *****");
                 BuscarPorClave(tmp,claveABuscar);
                System.out.println("\n");
                 
        break;
    case 2:
      System.out.println("Digite el campo en que buscar");
        int campoABuscar = s.nextInt();
     
        while(campoABuscar>ci){
            System.out.println("Digite una cantidad de campo inferior a "+ci);
                campoABuscar = s.nextInt();
        }
        s.nextLine();
         System.out.println("Digite el valor del campo a buscar ");
    String valoraBuscar = s.nextLine(); 
      while (valoraBuscar.equals("")) {            
            System.out.println("Digite un valor válido ");
                  valoraBuscar= s.nextLine();
        }
        System.out.println("**** BUSQUEDA POR CAMPO ****");
        BuscarPorCampo(tmp,campoABuscar,valoraBuscar);
           System.out.println("\n");
        System.out.println("**** VALOR MÁXIMO DEL CAMPO ****");
 ValorMaximo(campoABuscar);
        System.out.println("\n");
        System.out.println("**** PROMEDIO DEL CAMPO ****");
   promedio(campoABuscar,n);
      System.out.println("\n");
        System.out.println("**** MODA DEL CAMPO ****");
 moda(campoABuscar);
    System.out.println("\n");
        break;
    
       
        
}
        
    }
  public static void LeerArchivo(File archivo) throws  IOException {
//      TInicio =  System.currentTimeMillis();  
      String cadena;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
                  ArrayList ayuda = new ArrayList<>();
            String[]v = cadena.split(",");

            for (int j = 0; j < v.length; j++) {
  //Crea una sublista con los campos de cada registro
            ayuda.add(v[j]);
            }
//Agrega a la lista principal, las sublistas por cada registro
       Camp.add(ayuda);
            
        
         
         
        }
   
        
        b.close();
        // tiempo = System.nanoTime() - TInicio;
             
    }
    public static File CrearArchivo(File archivo, int numRegistro, int numCampos, ArrayList<Integer> longitudes, ArrayList<String> tipo) throws IOException{
//        TInicio =  System.currentTimeMillis();
        BufferedWriter doc;
     
      doc = new BufferedWriter(new FileWriter(archivo));
            for (int i = 1; i <= numRegistro; i++) {
              NumerosGrandes(); //en el primer campo(0) genera numeros grandes como clave única
                 doc.write(getNumgrande()+",");
                for (int j = 1; j <= numCampos; j++) {
                    
                    
                    if(tipo.get(j).equals("1")){
                    NumerosAleatorios(longitudes.get(j));
                        doc.write(getNumero()+",");
                    } else {
                        CaracteresAleatorios(longitudes.get(j));
                         doc.write(getCaracter()+",");
                    }
                   
                        
                          
                }
            
                
               doc.newLine();
            }
    


        doc.close();
//     tiempo = System.nanoTime() - TInicio;
               
    return archivo;
    
    }
    //Genera números aleatorios
    private static void  NumerosAleatorios(int k){
   
        String union="";
        for (int i = 0; i < k; i++) {
             int Numcaracter = (int) (Math.random() * 9);
             union = union + String.valueOf(Numcaracter);
        }
        BigInteger x = new BigInteger(union);
     
        setNumero(x);
    }
//Genera caracteres aleatorios
    private static void CaracteresAleatorios(int k) {
        String suma = "";
        for (int i = 0; i < k; i++) {
             int Numcaracter = (int) (Math.random() * 26 + 97);
       char letra = (char) Numcaracter;
        suma = suma + letra;
     
        }
         setCaracter(suma);
       
    }
    // Genera números grandes aleatorios
    private static void NumerosGrandes(){
     int n = 30;

      String union="";
        for (int i = 0; i < n; i++) {
             int Numcaracter = (int) (Math.random() * 9);
             union = union + String.valueOf(Numcaracter);
        }
        BigInteger x = new BigInteger(union);

        setNumgrande(x);
    
    }
//Ordena los registros de la lista bidimensional
    private static ArrayList<ArrayList<String>> OrdenarRegistros(ArrayList<ArrayList<String>> Camp, ArrayList<ArrayList<String>> copia) {
         TInicio =  System.currentTimeMillis();
        ArrayList claves = new ArrayList<>();
        for (int i = 0; i < Camp.size(); i++) {
            claves.add(Camp.get(i).get(0));
        }
     
        Collections.sort(claves);
         
         
        for (int i = 0; i < Camp.size(); i++) {
            
            for (int j = 0; j < Camp.size(); j++) {
                if(claves.get(i).equals(Camp.get(j).get(0))){
            copia.add(Camp.get(j));
            } 
            }
           
        }
        tiempo = System.nanoTime() - TInicio;
                System.out.println("El tiempo de ejecución es "+tiempo);
        return copia;
    }
//Busca por la clave única y retorna la información de ese registro.
    private static void BuscarPorClave(ArrayList<ArrayList<String>> tmp, String claveABuscar) {
           TInicio =  System.currentTimeMillis();    
        boolean sw = false;
        for (int i = 0; i < tmp.size(); i++) {
            if(tmp.get(i).get(0).equals(claveABuscar)){
                 sw = true;
                System.out.println("La clave tiene como información \n"+tmp.get(i));
            }
        }
         if(sw==false){
           System.out.println("el valor del campo a buscar no existe");
       }
        System.out.println("       ");
         tiempo = System.nanoTime() - TInicio;
                System.out.println("El tiempo de ejecución es "+tiempo);
    }
//Busca en un registro, el dato de un campo en especifico.
    private static void BuscarPorCampo(ArrayList<ArrayList<String>> tmp, int campoABuscar, String valor) {
           TInicio =  System.currentTimeMillis();
        boolean sw = false;
        for (int i = 0; i < tmp.size(); i++) {
        
            if(tmp.get(i).get(campoABuscar).equals(valor)){
                sw = true;
                System.out.println("El campo tiene como información \n"+tmp.get(i));
            }
        }
         if(sw==false){
           System.out.println("el valor del campo a buscar no existe");
       }
         tiempo = System.nanoTime() - TInicio;
                System.out.println("El tiempo de ejecución es "+tiempo);
    }
    //Comprueba que la cadena enviada esté compuesta solo de números
 public static Boolean SoloNumeros(String ca) {
        int sw =0;
     String x = "0123456789";
        for (int i = 0; i < x.length(); i++) {
         
            for (int j = 0; j < ca.length(); j++) {
                 if(x.substring(i,i+1).equals(ca.substring(j, j+1))){
             sw++;
            }
            }
           
        }
        if(sw==ca.length()){
        return true;
        }
        return false;
    }
 //Halla el valor máximo de un campo en especifico
    private static void ValorMaximo(int campoABuscar) {
          TInicio =  System.currentTimeMillis();
        char caracter;
        int asciiValue=0;
     
if(SoloNumeros(tmp.get(1).get(campoABuscar).substring(0,1))==false){

    for (int i = 0; i < tmp.size(); i++) {
       String cadena = tmp.get(i).get(campoABuscar);
        for (int j = 0; j < cadena.length(); j++) {
             caracter = cadena.charAt(j);
             asciiValue =(int) caracter + asciiValue;
           
        }
   
        if(asciiValue> MayorLetra){
        MayorLetra = asciiValue;
        MayorASCII = cadena;
        }
    }
    System.out.println("El mayor valor en código ASCII del campo "+campoABuscar+" corresponde a la cadena: "+MayorASCII+" con la cantidad de "+MayorLetra);
} else {
   for (int i = 0; i < tmp.size(); i++) {
       BigInteger big = new BigInteger(tmp.get(i).get(campoABuscar));
      BigInteger mayorbig = getMayor();

            if(big.compareTo(mayorbig)==1){
               
                setMayor(big);
            }
        }
    System.out.println("El mayor valor del campo "+campoABuscar+" corresponde al número "+getMayor());
 
}
      tiempo = System.nanoTime() - TInicio;
                System.out.println("El tiempo de ejecución es "+tiempo);
      
    }
//Promedio de un campo en especifico
    private static void promedio(int campoABuscar, int n) {
         
          TInicio =  System.currentTimeMillis();
        int suma = 0; BigInteger sumaGrande= BigInteger.ZERO;
       char caracter;
        int asciiValue=0;
   
if(SoloNumeros(tmp.get(1).get(campoABuscar).substring(0,1))==false){

    for (int i = 0; i < tmp.size(); i++) {
       String cadena = tmp.get(i).get(campoABuscar);
        for (int j = 0; j < cadena.length(); j++) {
             caracter = cadena.charAt(j);
             asciiValue =(int) caracter + asciiValue;
           
        }
      suma = suma + asciiValue;
      
    }
    BigDecimal  sumita = new BigDecimal(suma);
BigDecimal bd = sumita.divide(BigDecimal.valueOf(n),10,RoundingMode.UP);
   

    System.out.println("El promedio en código ASCII del campo "+campoABuscar+" es "+bd);
} else {
  
 
   for (int i = 0; i < tmp.size(); i++) {
       BigInteger big = new BigInteger(tmp.get(i).get(campoABuscar));
     
      sumaGrande = sumaGrande.add(big);
         
        }
   BigInteger tamano = BigInteger.valueOf(n);
      BigDecimal  sumita = new BigDecimal(sumaGrande);
BigDecimal bd = sumita.divide(BigDecimal.valueOf(n),10,RoundingMode.UP);

    System.out.println("El promedio del campo "+campoABuscar+" es "+bd);

     
}
    tiempo = System.nanoTime() - TInicio;
                System.out.println("El tiempo de ejecución es "+tiempo);
    
}
//Calcula el dato que más veces aparece en un campo en especifico.
    private static void moda(int campoABuscar) {
           TInicio =  System.currentTimeMillis();
        int suma=0;
       ArrayList ListaSustituta = new ArrayList<>();
       ArrayList<Integer> contadores = new ArrayList<>();
        for (int i = 0; i < tmp.size(); i++) {
            contadores.add(0);
        }
        for (int i = 0; i < tmp.size();i++) {
            ListaSustituta.add(tmp.get(i).get(campoABuscar));
        }
        for (int i = 0; i < tmp.size(); i++) {
            suma = 0;
            for (int j = 0; j < tmp.size(); j++) {
                if(tmp.get(j).get(campoABuscar).equals(ListaSustituta.get(i))){
                     suma++;
            contadores.set(i, suma);
            
            } 
            }
           
        }
        Boolean sw = false; //Verifica si la moda son todos los valores o si el conjunto de datos es unimodal
        for (int i = 0; i < tmp.size(); i++) {

           if(contadores.get(i)>MayorRepetido){
           MayorRepetido = contadores.get(i);
           Indice = i;
           sw = true;
           }
        }
        
      if(sw==true){
          System.out.println("El dato que mas se repite es "+tmp.get(Indice).get(campoABuscar)+" con un valor de "+MayorRepetido);
      } else {
          System.out.println("Todos los datos se repiten 1 vez");
      }
     tiempo = System.nanoTime() - TInicio;
                System.out.println("El tiempo de ejecución es "+tiempo);
    }

    private static void LeerArchivoModificado(File archivo) throws FileNotFoundException, IOException {
      String cadena;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        
        while((cadena = b.readLine())!=null) {
                  ArrayList ayuda = new ArrayList<>();
            String[]v = cadena.split(",");

            for (int j = 0; j < v.length; j++) {
  //Crea una sublista con los campos de cada registro
            ayuda.add(v[j]);
            }
//Agrega a la lista principal, las sublistas por cada registro
       Camp.add(ayuda);
            
        
         contcampos = v.length;
         
        }
   contRegistro = Camp.size();
   
        
        b.close();
    }
}
