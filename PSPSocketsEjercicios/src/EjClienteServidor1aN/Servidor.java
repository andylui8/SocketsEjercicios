package EjClienteServidor1aN;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor extends Thread
{

		private static int PUERTO=-1;
		//1)Creación del socket

		private Socket sc = null;
		private DataInputStream in;
		private DataOutputStream out;
		private int id;
		
		public Servidor(Socket socket, int id) {
			this.sc=socket;
			this.id=id;
			try {
			in = new DataInputStream(sc.getInputStream());
			out = new DataOutputStream(sc.getOutputStream());
			}catch(IOException ex) {
				ex.printStackTrace();
			}	
		}
		
		public void desconectar() {
			try {
			sc.close();
			}catch(IOException ex) {
				ex.printStackTrace();
			}
		}
		
		
		@Override
		public void run() {
			try {
				while (true) {
					String mensaje = in.readUTF();
					System.out.println(mensaje);
					if (mensaje.equals("Adios")) {
						break;
					}
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			desconectar();
			System.out.println("Cliente desconectado");
		}
		

		public static void main(String args[]) throws IOException {
			
			Scanner scan = new Scanner(System.in);
			ServerSocket servidor = null;
			System.out.println("Introduzca el PUERTO de escucha");
			PUERTO = scan.nextInt();
			System.out.println("Escuchando en el puerto " + PUERTO + "...");
	        try {
	            servidor = new ServerSocket(PUERTO);
	            int idSession = 0;
	            while (true) {
	                Socket socket;
	                socket = servidor.accept();
	                System.out.println("Ha entrado Cliente "+idSession+ " desde su puerto " +socket.getPort());
	                ((Servidor) new Servidor(socket, idSession)).start();
	                idSession++;    
	            }
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	    }
}
