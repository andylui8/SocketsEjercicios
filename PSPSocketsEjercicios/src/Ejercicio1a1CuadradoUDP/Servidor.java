package Ejercicio1a1CuadradoUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class Servidor 
{
	final static int PUERTO = 5001;
	public static void main(String[] args) 
	{
		byte[] buffer = new byte[1024];
		
		try 
		{
			System.out.println("Inicializado servidor UDP");
			//Creamos el socket
			DatagramSocket socketUDP = new DatagramSocket (PUERTO);
			String mensaje;
			while (true)
			{
				
				//Creamos el contenedor del mensaje que vamos a recibir, UDP
				DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);
				//Recibimos el mensaje
				socketUDP.receive(peticion);
				System.out.println("Recibimos la petición del cliente");
				mensaje = new String(peticion.getData());
				System.out.println(mensaje);
				int numero=Integer.parseInt(mensaje.trim());
				int cuadrado=numero*numero;
				
				//Obtenemos los datos de la persona que nos ha mandado el paquete
				int puertoCliente = peticion.getPort();
				InetAddress direccion = peticion.getAddress();
				mensaje = "El cuadrado del numero " + numero + " es " + cuadrado;
				System.out.println(mensaje);
				buffer = mensaje.getBytes();
				//Le enviamos una respuesta
				System.out.println(buffer.length);
				DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length, direccion, puertoCliente);
				
				System.out.println("Enviamos información al cliente");			
				socketUDP.send(respuesta);
				
				System.out.println("Finalizado servidor UDP");
				
			}
			
			//Cerramos el socket
			//socketUDP.close();
			//Estamos en un bucle infinito...
		} 
		catch (SocketException e) 
		{
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
