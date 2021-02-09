package Ejercicio1a1CuadradoTCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Cliente 
{
	//final static String HOST = "127.0.0.1";
	final static String HOST = "192.168.43.238";
	final static int PORT = 5001;
	
	public static void main(String[] args) 
	{
		DataInputStream in;
		DataOutputStream out;
		
		try 
		{
			//1) Creación del socket 
			Socket sc;
			//2) Conexión con el socket
			sc = new Socket(HOST, PORT);

			//3) Envío y recepción de mensajes
					//Recepción de mensajes
					in = new DataInputStream(sc.getInputStream());
					//Envío de mensajes
					out = new DataOutputStream(sc.getOutputStream());
					
					//Escritura de un numero
					Scanner scanner = new Scanner(System.in);
					System.out.println("Introduzca un número");
		   		    int numero=scanner.nextInt();
					out.writeUTF(numero+"");
					//Lectura de mensaje
					String mensaje = in.readUTF();
					System.out.println(mensaje);
			//4) Cierre de la conexión
			sc.close();
			
			System.out.println("Cerramos el cliente.java");
		}
		catch (Exception e)
		{
			// TODO: handle exception
		}
	}
}
