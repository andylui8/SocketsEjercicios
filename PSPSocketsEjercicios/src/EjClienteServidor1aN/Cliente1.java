package EjClienteServidor1aN;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Cliente1 
{
	 static String HOST = "";
	 static int PORT = -1;
	
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		DataInputStream in;
		DataOutputStream out;
		
		System.out.println("Introduce el HOST del servicio remoto");
		HOST=scan.next();
		
		System.out.println("Introduce el PUERTO del servicio remoto");
		PORT=scan.nextInt();
		
		try 
		{
			//1) Creación del socket 
			Socket sc;
			//2) Conexión con el socket
			sc = new Socket(HOST, PORT);
			System.out.println("Conectado con el servidor");
			
			int localPort =  sc.getLocalPort();
			System.out.println("Puerto local: "+ localPort);
			
			System.out.println("Puerto remoto: "+ PORT);
			System.out.println("Host remoto: "+ HOST);
			//3) Envío y recepción de mensajes
					in = new DataInputStream(sc.getInputStream());
					out = new DataOutputStream(sc.getOutputStream());
					
					//Escritura de mensaje
					out.writeUTF("Qué tal?");
					out.writeUTF("Saludo al servidor");
					out.writeUTF("Adios");
					
			//4) Cierre de la conexión
			sc.close();		
			System.out.println("Cerramos el cliente");
		}
		catch (Exception e)
		{
			// TODO: handle exception
		}
	}
}
