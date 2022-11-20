package org.openjfx;
import java.io.*;
import java.net.*;

public class ServerDemo {
    public static void main(String[] args){
        boolean IsGameOver=false;
        boolean IsEvenMatch=true;
    for(int i=0;i<5;i++) {
        if (IsGameOver = false) {//A chaque etape on verifie si le jeu est toujours sensé etre en cours
            try {
                ServerSocket ss = new ServerSocket(6666);
                Socket s = ss.accept();

                /*TOUR 1: Coté server on attend*/
                DataInputStream dis = new DataInputStream(s.getInputStream());
                String str = (String) dis.readUTF();
                System.out.println("message=" + str);


                //TOUR 2 Cote server on envoie

                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String PLAYPOSITION;
                PLAYPOSITION = br.readLine();
                System.out.println("message=" + PLAYPOSITION);
                DataOutputStream dout = new DataOutputStream(s.getOutputStream());
                dout.writeUTF(PLAYPOSITION);
                dout.flush();
                dout.close();

                ss.close();
            } catch (Exception e) {
                System.err.println(e);
            }
        }
        if(IsGameOver=true){/*Si le jeu est terminé on arrête la boucle.
         Etant donné que le client et le server on chacun leur version du jeu qu'il update ensemble
         a chaque etape, pas besoin de s'envoyer l'etat du jeu pqrce que leur etat du jeu sont synchronise par construction*/
            System.out.println("GameEND");
            IsEvenMatch=false;//If the game ends before the end of the loop, one of the player has to have won
            break;
        }
        }
        if(IsEvenMatch=true) {
            try {
                ServerSocket ss = new ServerSocket(6666);
                Socket s = ss.accept();

                /*TOUR 1: On envoie un message de match nul si on arrive a la fin de la boucle for sans victoire*/
                DataInputStream dis = new DataInputStream(s.getInputStream());
                String str = (String) dis.readUTF();
                System.out.println("message=" + str);
                ss.close();
            } catch (Exception e) {
                System.err.println(e);
            }
        }




}}
