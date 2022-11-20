package org.openjfx;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args){
        boolean IsGameOver=false;
        boolean IsEvenMatch=true;
        for(int i=0;i<5;i++){
            if (IsGameOver = false) {//A chaque etape on verifie si le jeu est toujours sensé etre en cours
                try {

                    Socket s = new Socket("localhost", 6666);

                    /*TOUR 1: Coté Client on envoie*/

                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                    String PLAYPOSITION;
                    PLAYPOSITION = br.readLine();
                    System.out.println("message=" + PLAYPOSITION);
                    DataOutputStream dout = new DataOutputStream(s.getOutputStream());
                    dout.writeUTF(PLAYPOSITION);
                    dout.flush();
                    // dout.close();

                    //TOUR 2 Cote server on envoie

                    DataInputStream dis = new DataInputStream(s.getInputStream());
                    String str = (String) dis.readUTF();
                    System.out.println("message=" + str);
                    s.close();
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
                Socket s = new Socket("localhost", 6666);

                /*TOUR 1: On envoie un message de match nul si on arrive a la fin de la boucle for sans victoire*/
                System.out.println("Matchnul");
                DataOutputStream dout = new DataOutputStream(s.getOutputStream());
                dout.writeUTF("Matchnul");
                dout.flush();
                dout.close();
                s.close();
            } catch (Exception e) {
                System.err.println(e);
            }
        }

}}
