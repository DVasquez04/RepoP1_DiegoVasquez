/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package repop1_diegovasquez;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author Diego Vasquez
 */
public class RepoP1_DiegoVasquez {
    static Scanner lea = new Scanner(System.in);
    static Random ran = new Random();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean seguir = true;
        while (seguir){
            System.out.println("=MENU=");
            System.out.println("1.Encriptacion simple");
            System.out.println("2.Tokens");
            System.out.println("3.Inicio de sesión");
            System.out.println("4.Salir");
            int opcion = lea.nextInt();
            switch (opcion){
                case 1:{
                    System.out.println("Ingrese una cadena:");
                    String original = lea.next();
                    System.out.println("Ingrese la llave:");
                    int key = lea.nextInt();
                    while(key <= 0 || key > 10){
                        System.out.println("numero invalido \n intentelo de nuevo:");
                        key = lea.nextInt();
                    }
                    String kript = Encriptacion(original,key);
                    System.out.println("La cadena encriptada es: "+kript);
                }//fin case 1
                break;
                case 2:{
                    System.out.println("Ingrese su cadena con caracter:");
                    String og = lea.next();
                    System.out.println("Ingrese el caracter:");
                    String split = lea.next();
                    String[] SplitString = Tokens(og,split);
                    PrintStrArr(SplitString);
                }//fin case 2
                break;
                case 3:{
                    System.out.println("Arreglos creados: ");
                    String[] usuarios = new String[3];
                    usuarios = Usuarios();
                    PrintUsers(usuarios);
                    String[] contras = new String[3];
                    contras = Contras();
                    PrintContras(contras);
                    System.out.println("");
                    System.out.println("Ingrese el Usuario: ");
                    String user = lea.next();
                    System.out.println("Ingrese la contraseña: ");
                    String pass = lea.next();
                    boolean authentic = authentication(user,pass);
                    if(authentic){
                        System.out.println("La autenticación fue exitosa!");
                    }else{
                        System.out.println("Error, el usuario y la contraseña no son las mismas");
                    }
                    
                }//fin case 3
                break;
                case 4:{
                    seguir = false;
                }//fin case 4
                break;
                default:{
                    System.out.println("Opcion invalida");
                }
                break;
            }//fin switch
        }//fin while
        // TODO code application logic here
    }//fin main
    public static String Encriptacion(String og, int n){
        String out = "";
        boolean par_non = true;
        //true == par, false == non
            int let = og.charAt(0);
            if (let % 2 != 0){
                par_non=false;
            }else{
                par_non = true;
            }//fin what it is
            if(par_non){
                for (int i = 0; i < og.length(); i++) {
                    let = og.charAt(i);
                    let = let + n;
                    char a = (char)let;
                    out += a;
                }//fin for par
            }else{
                for (int i = 0; i < og.length(); i++) {
                    let = og.charAt(i);
                    let = let - n;
                    char a = (char)let;
                    out += a;
                }// fin for non
            }//fin if
        return out;
    }//fin encriptaciao
    public static String[] Tokens(String ori, String ch){
        char split = ch.charAt(0);
        int acum_chars = 0;
        for (int i = 0; i < ori.length(); i++) {
            char there = ori.charAt(i);
            if(there == split){
                acum_chars ++;
            }//fin if
        }//fin for pa averiguar cuantos splits hay
        String[] star = new String[acum_chars+1];
        String temp = "";
        int ArrLoc = 0;
        for (int i = 0; i < ori.length(); i++) {
            char let = ori.charAt(i);
            if(let != split){
                temp += let;
            }else{
                star[ArrLoc]=temp;
                ArrLoc++;
                temp = "";
            }//fin if
        }//fin for pa asignar strings al array
        star[ArrLoc]=temp;
        return star;
    }//fin token
    public static void PrintStrArr(String[] star){
        for (int i = 0; i < star.length; i++) {
            System.out.print("["+star[i]+"]");
        }//fin for
        System.out.println("");
    }//fin print
    public static String[] Usuarios(){
        String [] temp = new String[3];
            String Nick = "Admin";
            temp[0]=Nick;
            String Nick1 = "Guest";
            temp[1]=Nick1;
            String Nick2 = "Otro";
            temp[2]=Nick2;
        return temp;
    }//fin usuarios
    public static void PrintUsers(String[] ori){
        System.out.print("ArreglosUsers = {"+ori[0]+","+ori[1]+","+ori[2]+"}");
        System.out.println("");
    }//fin print Users
    public static String[] Contras(){
        String[] temp = new String[3];
        String Nick = "Drowssap";
        temp[0]=Nick;
        Nick = "1234";
        temp[1]=Nick;
        Nick = "8877";
        temp[2] = Nick;
        return temp;
    }//fin contras
    public static void PrintContras(String[] ori){
        System.out.print("ArreglosContra = {"+ori[0]+","+ori[1]+","+ori[2]+"}");
        System.out.println("");
    }//fin print contras
    public static boolean authentication(String ID, String pass){
        boolean same = false;
        //true = same, false = not same
        if(ID.contains("Admin") && pass.contains("Drowssap")){
            same = true;
        }else if(ID.contains("Guest")&& pass.contains("1234")){
            same = true;
        }else if (ID.contains("Otro")&& pass.contains("8877")){
            same = true;
        }
        
        return same;
    }
}
