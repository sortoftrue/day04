package day04;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    
    public static void main(String[] args) throws IOException {
        
        ServerSocket server = new ServerSocket(3000);

        System.out.println("Waiting");
        Socket socket = server.accept();
        System.out.println("Connected");
        Boolean isExit = false;

        while(isExit != true){
            System.out.println("Wait read");
            //READ-IN
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            String input = ois.readUTF();
            System.out.println(input);
            String answer ="";

            switch (input){
                case "exit":{
                    isExit = true;
                    break;
                }
                default:{
                    String[] splitString = input.split(" ");
                    Double result = Calculator.calc(Integer.parseInt(splitString[0]), Integer.parseInt(splitString[2]), splitString[1]); 
                    answer = result.toString();
                }
            }
            
            if(isExit) break;

            //SEND
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            //input=input.toUpperCase();

            oos.writeUTF(answer);
            oos.flush();
        }
        

    }

    

}
