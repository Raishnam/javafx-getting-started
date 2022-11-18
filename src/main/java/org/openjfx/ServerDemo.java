package org.openjfx;
import java.io.*;
import java.net.*;

public class ServerDemo {
    public static void main(String[] args){try

    {
        ServerSocket ss = new ServerSocket(6666);
        Socket s = ss.accept();

        /*TOUR 1: Coté server on attend*/
        DataInputStream dis = new DataInputStream(s.getInputStream());
        String str = (String) dis.readUTF();
        System.out.println("message=" + str);


        //TOUR 2 Cote server on envoie

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String  PLAYPOSITION;
        PLAYPOSITION = br.readLine();
        System.out.println("message=" + PLAYPOSITION);
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        dout.writeUTF(PLAYPOSITION);
        dout.flush();
        dout.close();

        ss.close();
    }catch (Exception e){
        System.err.println(e);}




}}
