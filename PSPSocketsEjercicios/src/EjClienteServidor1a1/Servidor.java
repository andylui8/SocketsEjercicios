package EjClienteServidor1a1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor
{
	static int PUERTO=-1;
	
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		//1)Creación del socket
		ServerSocket servidor = null;
		Socket sc = null;
		
		DataInputStream in;
		DataOutputStream out;
		
		try 
		{
			//2) Asignación de puerto, de IP vamos a utilizar la nuestra
			System.out.println("Introduzca el PUERTO de escucha");
			PUERTO = scan.nextInt();
			
			servidor = new ServerSocket(PUERTO);
			System.out.println("Escuchando en el puerto " + PUERTO + "...");
			
			while (true)//3)Escuchar, en este intervalor ya estamos escuchando alguna petición por parte del cliente
			{
				//4) Aceptamos la conexión
				sc = servidor.accept();
				System.out.println("Ha entrado un cliente desde su puerto " + sc.getPort());
				//5) Envío y recepción de mensajes
				System.out.println("Mensajes recibidos:" + "\n" + "-------------------------------");
				//Lectura de mensajes
				in = new DataInputStream(sc.getInputStream());
				out = new DataOutputStream(sc.getOutputStream());
				
				//Leemos el mensaje
				while(true) {
				String mensaje = in.readUTF();
				System.out.println(mensaje);
				if(mensaje.equals("")) break;
				}
				
				//sc.close();
				//System.out.println("Cliente desconectado");
				
			}
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

}
