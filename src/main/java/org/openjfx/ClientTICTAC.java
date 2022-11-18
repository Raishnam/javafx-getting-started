package org.openjfx;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientTICTAC {
    public static void main(String[] args){
        try{
            ServerSocket ss =new ServerSocket(6666);
            Socket s=ss.accept();
            while (ISGAMEOVER==0)
            {if(ISITURN==0){
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                int PLAYPOSITION=Integer.parseInt(br.readLine());
                System.out.println("message="+PLAYPOSITION);
                GAMEGRID.update(str);
                DataOutputStream dout= new DataOutputStream(s.getOutputStream());
                dout.writeUTF(PLAYPOSITION);
                dout.flush();
                dout.close();
            };
                if(ISITURN==1) {
                    DataInputStream dis=new DataInputStream(s.getInputStream());
                    String str=(String)dis.readUTF();
                    GAMEGRID.update(str);
                    System.out.println("message="+str);

                }/*inverse symetric of the server side*/

            }
            DataOutputStream doutend= new DataOutputStream(s.getOutputStream());
            doutend.writeUTF("END OF GAME");
            doutend.flush();
            doutend.close();
            ss.close();
        }catch (Exception e){
            System.err.println(e);}
    }
}
