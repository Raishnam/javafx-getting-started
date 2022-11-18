package org.openjfx;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args){
        for(int i=0;i<5;i++){
        try

    {

        Socket s = new Socket("localhost",6666);

        /*TOUR 1: Coté Client on envoie*/

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String  PLAYPOSITION;
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
    }catch (Exception e){
        System.err.println(e);}
        }
        try{
            Socket s = new Socket("localhost",6666);

            /*TOUR 1: On envoie un message de match nul si on arrive a la fin de la boucle for sans victoire*/
            System.out.println("Matchnul");
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            dout.writeUTF("Matchnul");
            dout.flush();
            dout.close();
            s.close();
        }
        catch(Exception e)
        {
            System.err.println(e);
        }

}}
