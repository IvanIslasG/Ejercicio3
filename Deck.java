/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package islas.deck;

/**
 *
 * @author Ivan Islas
 */

import java.util.*;
import java.util.Scanner;

public class Deck {

    public static void main(String[] args)
    {
        Card card = new Card(); // se crea el objeto de tipo Card
        int PALOS = card.palo.length; // declaracion de auxiliares 
        int VALORES = card.valor.length;
        int opc = 0;
        int ban = 0;
        
        Scanner leer = new Scanner(System.in); // creacion de objeto itpo scanner para poder leer de teclado


        ArrayList<String> deck = new ArrayList<String>(); // se crea el deck como un arraylist
        
        for (int i = 0; i < VALORES ; i++)  // a partir de estos bucles se puede recorrer el arraylist y trabajar con él
        {
            for (int j = 0; j < PALOS; j++) 
            {
                
                if (card.palo[j].equals("Corazon")  || card.palo[j].equals("Diamante")) //condicional para que solo los corazones y diamantes puedan ser rojos
                deck.add(card.palo[j]+ card.color[0] + card.valor[i]);//se insertan los valores en el array para cartas Rojas.
                
                else if(card.palo[j].equals("Trebol")|| card.palo[j].equals("Pica"))//Solo los treboles y picas pueden ser negros
                deck.add(card.palo[j]+ card.color[1] + card.valor[i]);//se insertan los valores en el array para cartas Negras.
            }
        }
        
        
        Iterator<String> nombreIterator = deck.iterator(); // trabajamos con un iterador para poder recorrer el arraylist
        while(nombreIterator.hasNext()){
            String elemento = nombreIterator.next();
            System.out.print(elemento+" | ");
        }
        
        /*System.out.println("\n cartas : ");   pruebas para conocer los valores con los que trabajamos
        System.out.println(deck.size());
        System.out.println("palos: ");
        System.out.println(PALOS);
        System.out.println("Valores: ");
        System.out.println(VALORES);
        System.out.println("colores: ");
        System.out.println(COLORES);*/
        
        
        System.out.println("\n** Bienvenido al sistema de Pocker**\n");
        /// Menu de programa
        do
        {
            try{
                
            System.out.println("\nSeleccione la opción deseada:\n");
                System.out.println("MEZCLAR DECK  -------------  [1]");
                System.out.println("TOMAR LA PRIMERA CARTA ----  [2]");
                System.out.println("TOMAR UNA CARTA ALEATORIA -  [3]");
                System.out.println("TOMAR 5 CARTAS  -----------  [4]");
                System.out.println("SALIR ---------------------  [5]");
            
                opc = leer.nextInt();
                
                
                switch(opc)
                {
                    case 1:
                        shuffle(deck); // llamado a metodo de mezcla
                        break;
                    
                    case 2:
                        head(deck);// llamado a metodo de primera carta
                        break;
                    
                    case 3:
                        pick(deck);// llamado a metodo de carta aleatoria
                        break;
                        
                    case 4:
                        if(deck.size()>= 5) // solo si tenemos suficientes cartas podemos llamar al metodo de 5 cartas
                        hand(deck);
                        
                        else
                            System.out.println("No quedan cartas suficientes. Seleccione otra opcion\n"); 
                        break;
                     
                    case 5:
                        System.out.println("Saliendo\n");
                        ban = 1;
                        break;
                        
                    default:
                        System.out.println("Opción incorrecta\n");
                        break;
                        
                    
                }
                
                if(deck.size() == 0){
                    System.out.println("\n<<Se terminaron las cartas>>\n");// mensaje de que se terminaron las cartas
                    break;
                }
            }
            catch (Exception e)
            {
                System.out.println("ERROR !!\n");
                break;

            }
                
            
        }while(ban == 0);
   
    }


///////Metodo de mezcla del deck
    public static void shuffle(ArrayList deck){
        ArrayList<String> values = deck;
        Collections.shuffle(values);
        System.out.println("\n Se mezcló el Deck.");
        Iterator<String> nombreIterator2 = deck.iterator();
        while(nombreIterator2.hasNext()){
            String elemento = nombreIterator2.next();
            System.out.print(elemento+" | ");
        }
    }

///////Metodo para tomar la primera carta del deck
    public static void head(ArrayList deck){
        System.out.println(deck.get(0));
        deck.remove(0);
        System.out.println("Quedan " + deck.size() + " cartas \n");
    }

///////Metodo de para tomar una carta aleatoria
    public static void pick(ArrayList  deck){
        Random aleatorio = new Random();
        System.out.println(deck.get(aleatorio.nextInt(deck.size())));
        deck.remove(aleatorio.nextInt(deck.size()));
        System.out.println("Quedan " + deck.size() + " cartas \n");
    }

  ///////Metodo para tomar una mano de 5 cartas
    public static void hand(ArrayList deck){
        for(int i=0; i<=4; i++){
            System.out.println(deck.get(i));
        }
        for(int i=0; i<=4; i++){
            deck.remove(i);
        }
        System.out.println("Quedan " + deck.size()+ " cartas");
    }
}