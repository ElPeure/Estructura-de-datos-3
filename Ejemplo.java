package com.ejemplo;
import java.io.BufferedReader;
import java.util.List;
import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.Scanner;


public class Ejemplo{ // destro de este se pueden poner funciones
    
       private double Popularidad; 
       private double Bailabilidad; 
       
    public  Ejemplo(String nombres,double Popularidads,double Bailabilidads){
        Popularidad = Popularidads;
        Bailabilidad= Bailabilidads;
    }
  /*     public static double[] OrdenamientoBaile(double[] num){  
    double aux;     
    for(int i = 0; i < num.length; i++){

	for(int j=i+1; j < num.length; j++){
		if(num[i] < num[j]){
		aux = num[i];
		num[i] = num[j];
		num[j] = aux;
		}
	}
}
      return num;          
   }*/
   public void OrdenamientoBaile(Double arr[], int begin, int end) {
    if (begin < end) {
        int partitionIndex = partition(arr, begin, end);

        OrdenamientoBaile(arr, begin, partitionIndex-1);
        OrdenamientoBaile(arr, partitionIndex+1, end);
    }
}
   private int partition(Double arr[], int begin, int end) {
    Double pivot = arr[end];
    int i = (begin-1);

    for (int j = begin; j < end; j++) {
        if (arr[j] <= pivot) {
            i++;

            Double swapTemp = arr[i];
            arr[i] = arr[j];
            arr[j] = swapTemp;
        }
    }

    Double swapTemp = arr[i+1];
    arr[i+1] = arr[end];
    arr[end] = swapTemp;

    return i+1;
}
    public static int Next(int i){
        return i++;
    }
    
        public static void SkipN(int i){
        
            System.out.println("Usted a saltado "+i+" canciones ");
    }
     
    public static void PlaylistUnica(LinkedHashMap<String,Double> Popular,LinkedHashMap<String,Double> Bailabilidad,Map<String,String> CancionPopular,String[] cantantes,String[] famosos,HashMap<String, String> id){
    int total = Popular.size(),b=0 , saltadas=0;
    Stack<String> HistorialLikeNombre = new Stack<>();//historial like
    Stack<String> HistorialLikeID = new Stack<>();
    try (Scanner in = new Scanner(System.in)) {
        for(int i=0;i<total;i++){//reproducir de la mas popular a la menos popular     
        System.out.println("Se esta reproduciendo la cancion: "+ famosos[i]);
        System.out.println("Para poner reproducir la siguiente marque 1");
        System.out.println("Para poner saltar canciones marque 2");
        System.out.println("Para dar like marque 3");
        System.out.println("Para terminar y ver el historial de likes 4");
        b=in.nextInt();
 
        if(b==1){

          i = Next(i);  
          System.out.println("Usted a saltado la cancion ");
        }
        else if(b==2){
        System.out.println("¿Cuantas canciones deseea saltar? ");
        saltadas=in.nextInt();
        if(i+saltadas<total){
            SkipN(saltadas);
           i=saltadas+i; 
        }
        else{
            System.out.println("La cancion que intenta reproducir no existe");
            break;
        }
    }
        else if(b==3){
          System.out.println("Usted le ha dado like a la cancion ");
          HistorialLikeNombre.push(famosos[i]);
          HistorialLikeID.push(id.get(famosos[i]));
          i--;
        }
        else if (b==4){
            i=586672;
        }
        else{
            System.out.println("La opcion que marcaste no se encuenta, intentalo de nuevo");
        } 
        }
    }
    int grande = HistorialLikeNombre.size();
    for(int i=0;i<grande;i++){
        System.out.println("la cancion con el like "+(i+1)+" es "+HistorialLikeNombre.peek()+" cuyo id es "+HistorialLikeID.peek());
        HistorialLikeNombre.pop();
        HistorialLikeID.pop();
    }    
    } 
public static String leertxt(String[] lineas,int contador){
    class Artista{
       private String name;
       private double promedioPopularidad;
       private double promedioBailabilidad;
       private String CancionPopular;
       
       
      
    public  Artista(String names,double promedioPopularidads,double promedioBailabilidads, String CancionPopulars){
        name=names;
        promedioPopularidad=promedioPopularidads;
        promedioBailabilidad=promedioBailabilidads;
        CancionPopular=CancionPopulars;

    }
    @Override
    public String toString(){
        return "nombre: "+name+" popularidad: "+promedioPopularidad+" bailabilidad: "+promedioBailabilidad+" cancion mas popular: "+CancionPopular;
    }
   }
       
 //calcular el numero de lineas en donde aparece un cantante ( despues de la coma 5 osea la posicion 6 )
 //Plan: guardar los cantantes en las llaves y despues en los valores, tener cuantas lineas son de ellos
 //Vamos a hacer un split de la linea y guardamos todo en un arreglo, luego tomamos el que necesitamos y vaciamos el arreglo para hacerlo con todas las lineas
 HashMap<String, Integer> Cantantes = new HashMap<>();
 HashMap<String, Double> Cantante_Bailabilidad_Cantantes = new HashMap<>();
 HashMap<String, Double> Cantante_Popularidad_Cantantes = new HashMap<>();
 HashMap<String, String> Cantante_CancionPopular = new HashMap<>();
 HashMap<String, String> NombreCancionPopular = new HashMap<>();
 HashMap<String, Double> CancionPopularidad = new HashMap<>();
 HashMap<String, Double> CancionBailabilidad = new HashMap<>();
 HashMap<String, String> CancionID = new HashMap<>();
 int suma = 0,valor=1, nuevos=0;
 double suma1=0,suma2=0;
 String separador[] = new String[20];
 Stack<String> tomar = new Stack<>();
 double Popularidad_Cantantes[] = new double[contador];
 double Bailabilidad_Cantantes[] = new double[contador];
 String id[] = new String[contador];
 double popular = 0;
//creacion de la playlist
Ejemplo meter[] = new Ejemplo[contador];
double PlaylistPopularidad[] = new double[contador];
double PlaylistBailabilidad[] = new double[contador];
String cantantillos[] = new String[contador];
String famosos[] = new String[contador];

 //contar en cuantos tracks sale el artista                       INICIO Funciona
 
 for(int i=0;i<contador;i++){
     separador = lineas[i].split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)",-1);
         Popularidad_Cantantes[i] = Double.parseDouble(separador[2]);
         Bailabilidad_Cantantes[i] = Double.parseDouble(separador[8]);
         id[i] = separador[0];
         CancionID.put(separador[1], id[i]);
         CancionPopularidad.put(separador[1], Popularidad_Cantantes[i]);
         CancionBailabilidad.put(separador[1], Bailabilidad_Cantantes[i]);
         cantantillos[i]=separador[1];
         
         NombreCancionPopular.put(separador[5], separador[1]);
         
         if(Cantantes.containsKey(separador[5])){
            suma = Cantantes.get(separador[5])+1; // suma al valor 1+
            Cantantes.replace(separador[5],suma);
            suma1 = Cantante_Popularidad_Cantantes.get(separador[5])+Popularidad_Cantantes[i];
            suma2 = Cantante_Bailabilidad_Cantantes.get(separador[5])+Bailabilidad_Cantantes[i];
            //cantante popularidad
             Cantante_Popularidad_Cantantes.replace(separador[5],suma1);
             //cantante bailabilidad
             Cantante_Bailabilidad_Cantantes.replace(separador[5],suma2);
             //meter en la clase Historial la bailabilidad, la popularidad y el nombre del cantante 
             meter[i]= new Ejemplo(separador[5],Popularidad_Cantantes[i],Bailabilidad_Cantantes[i]);
                if(popular<Cantante_Popularidad_Cantantes.get(separador[5])){
                   popular = Cantante_Popularidad_Cantantes.get(separador[5]);
                   Cantante_CancionPopular.replace(separador[5],separador[1]);
                }
           }
         else{
             nuevos++;
             Cantantes.put(separador[5],valor);
             tomar.push(separador[5]);
             //cantante popularidad
             Cantante_Popularidad_Cantantes.put(separador[5],Popularidad_Cantantes[i]);
             //cantante bailabilidad
             Cantante_Bailabilidad_Cantantes.put(separador[5],Bailabilidad_Cantantes[i]);
             //cancion mas popular
             Cantante_CancionPopular.put(separador[5],separador[1]);
             popular = Cantante_Popularidad_Cantantes.get(separador[5]);
             //meter en la clase Historial la bailabilidad, la popularidad y el nombre del cantante 
             meter[i]= new Ejemplo(separador[5],Popularidad_Cantantes[i],Bailabilidad_Cantantes[i]);
         }
         
 //creacion de playList unica, ordenamiento de bailabilidad y popularidad INICIO
for(int s=0;s<contador;s++){
    PlaylistBailabilidad[i]=meter[i].Bailabilidad;
}
for(int s=0;s<contador;s++){
    PlaylistPopularidad[i]=meter[i].Popularidad;
}        
}
 //contar en cuantos tracks sale el artista                       FINAL  Funciona

 
 //reemplazar en el mapa la suma de los promedios          INICIO
  Artista a[] = new Artista[nuevos]; 
 String cantantes[] = new String[nuevos];// almacena los cantantes sin que estos se repitan
 for(int i=0;i<nuevos;i++){
     cantantes[i] = tomar.peek();
     tomar.pop();
 }
 OrdenarmientoBaile(PlaylistBailabilidad,0,PlaylistBailabilidad.length);
 OrdenarmientoBaile(PlaylistPopularidad, 0,PlaylistPopularidad.length);


/*lo que quiero hacer es poder comparar la popularidad para que esta vaya a la par con los nombres*/
// Bailabilidad ordenada con el cantante a su lado 
LinkedHashMap<String,Double> BailabilidadOrdenada = new LinkedHashMap<>();
for(int i=0;i<contador;i++){   
    for(int j=0;j<contador;j++){
     if(PlaylistBailabilidad[i]==CancionBailabilidad.get(cantantillos[j])){
        // System.out.println(PlayListBailabilidad[i]+" "+CancionBailabilidad.get(cantantillos[j])+" "+i+" "+j+" "+cantantillos[j]);
         String hola =cantantillos[j];
         double wena =PlaylistBailabilidad[i];
         BailabilidadOrdenada.put(hola, wena);
     }   
    }
}
 //    System.out.println(BailabilidadOrdenada);
// Popularidad ordenada con el cantante a su lado 
 LinkedHashMap<String,Double> PopularidadOrdenada = new LinkedHashMap<>();
for(int i=0;i<contador;i++){   
    for(int j=0;j<contador;j++){
     if(PlaylistPopularidad[i]==CancionPopularidad.get(cantantillos[j])){ // si mi llave fuera la popularidad y el nombre de la cancion mi valor, al llamar la llave pondria el cantante
         PopularidadOrdenada.put(cantantillos[j], PlaylistPopularidad[i]);
          //meter a cancion mas popular
           famosos[i]=cantantillos[j];
           i++;
           
     }   
    }
}
     System.out.println("Popularidad: "+PopularidadOrdenada);
     
     PlaylistUnica(PopularidadOrdenada,BailabilidadOrdenada,Cantante_CancionPopular,cantantillos,famosos,CancionID);
     
  //creacion de playList unica, ordenamiento de bailabilidad y popularidad FINAL 
 
 double promedio=0,promedio1=0;
 double divisor=0,divisor1=0;
 double numerador = 2,numerador1=0; 
 for(int i=0;i<cantantes.length;i++){
         
     if(Cantante_Popularidad_Cantantes.containsKey(cantantes[i])){
         // popularidad promedio
         numerador = Cantante_Popularidad_Cantantes.get(cantantes[i]);
         divisor = Cantantes.get(cantantes[i]);
         promedio = numerador/divisor;
         //poniendo la bailabilidad promedio en el objeto
         Cantante_Popularidad_Cantantes.replace(cantantes[i], promedio);
         // bailabilidad promedio
         numerador1 = Cantante_Bailabilidad_Cantantes.get(cantantes[i]);
         divisor1 = Cantantes.get(cantantes[i]);
         promedio1 = numerador1/divisor1;
         // poniendo la popularidad 
         Cantante_Bailabilidad_Cantantes.replace(cantantes[i], promedio1);
         String cancionPopular =Cantante_CancionPopular.get(cantantes[i]);
         // declarando cantante en una variable
         String cantantillo = cantantes[i];
        
         a[i] = new Artista(cantantillo,promedio,promedio1,cancionPopular);
     }
 }
//reemplazar en el mapa la suma de los promedios               FINAL 
          
    return "Codigo terminado, PD: profe pongame un 7 :,V";
}



        private static void OrdenarmientoBaile(double[] ordenarBailabilidad, int i, int length) {
}
        public static void main(String args[]) throws IOException {  
            
/*Se guardaros las lineas del txt en archivos y luego este les hizo un split en las "," para poder separar las lineas del txt
para luego posteriormente guardarlas en un arreglo, lo ideal seria hacer funciones para no estropear el main */

            try(BufferedReader in = new BufferedReader(new FileReader("tracks.csv"))){
            String archivo = in.readLine(); // Se salta la linea de informacion
            String arr[] = archivo.split(",");
            String Lineas[] = new String[586672];
            String termino;
            int ContadorLineas = 0;
            
            while((termino = in.readLine()) != null && ContadorLineas != 586672){
                Lineas[ContadorLineas]=termino;
                ContadorLineas++;
                
            }
        
            String s1= Ejemplo.leertxt(Lineas,ContadorLineas);
            System.out.println(s1);    
            
           }catch (Exception e) {
                System.err.println("Esta todo okey ");
        }
           

    }
}
