package Ejercicio1a1CuadradoUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente 
{
	final static int PUERTO_SERVIDOR = 5001;
	public static void main(String[] args) 
	{
		byte[] buffer = new byte[1024];
		
		try 
		{
			//Otra forma de obtener nuestra IP
			InetAddress direccionServidor = InetAddress.getByName("localhost");//Misma función InetAddress.getLocalHost()
			
			
			DatagramSocket socketUDP = new DatagramSocket();//No es necesario un puerto, se lo asigna automática mente el OS
			

			System.out.println("Introduzca un numero");
			Scanner scanner = new Scanner(System.in);
			int numero=scanner.nextInt();
			String mensaje=numero+"";
			
			buffer = mensaje.getBytes();
			//Creamos el paquete, mensaje
			DatagramPacket peticion  = new DatagramPacket(buffer, buffer.length, direccionServidor, PUERTO_SERVIDOR);
			
			//enviamos el mensaje
			System.out.println("Enviamos el datagrama");
			socketUDP.send(peticion);
			
			//recibimos la respuesta del servidor
			buffer = new byte[50];
			DatagramPacket respuesta  = new DatagramPacket(buffer, buffer.length);	
			socketUDP.receive(respuesta);
			System.out.println("Recibido la petición del servidor");
			
			mensaje = new String(respuesta.getData());
			System.out.println(mensaje);
			//Cerramos el socket
			socketUDP.close();
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
