package Ping;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Ping {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int intentos, tiempoEspera;
		String direccion = "";
		InetAddress ping;
		boolean alcanzado;
		try 
		{
			
			System.out.println("Introduca el numero de intentos entre 3 y 5");
			intentos = sc.nextInt();
			
			System.out.println("<------------------------>");
			
			System.out.println("Escriba en milisegundos un tiempo máximo de espera");
			tiempoEspera = sc.nextInt();
			
			System.out.println("<------------------------>");
			
			
			
			while(!direccion.equals("quit")) {
				
			System.out.println("Introduzca un host a conectar || 'quit' para salir");
			direccion = sc.next();
			ping = InetAddress.getByName(direccion);
			
			System.out.println("<------------------------>");
					
			for(int i=0 ; i<intentos ;i++)
			{
				System.out.println("Desea comprobar acceso total ('t') o parcialmente ('p')");
				char acceso = sc.next().charAt(0);
				
				alcanzado = ping.isReachable(tiempoEspera);	
				
				if(acceso=='t') {
					
					if(alcanzado) {
						System.out.println("Se ha accedido correctamente al host " + direccion);
					}else {
						System.out.println("No se ha podido acceder al host " + direccion);
					}
				
				}else if(acceso=='p'){
					
					if(alcanzado) {
						System.out.println("Conexion exitosa");
					}else {
						System.out.println("Conexion fallida");
					}
					
				}else {
					System.out.println("Caracter no valido");
					
				}
				System.out.println("<------------------------>");
			}
			
			}
			System.out.println("<------------------------>");
			System.out.println("Programa finalizado");
			

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
