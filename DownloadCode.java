package malwarePack;

import java.io.*;
import java.net.*;

public class DownloadCode {
	String url;
	String local;
	public DownloadCode(String link, String localdireccion) {
		url = link;
		local = localdireccion;
	}
	private void wget() throws IOException {
		URL imagen = new URL(url);
		InputStream reader = imagen.openStream();
		int i=0;
		String texto = "";
		while(i != -1) {
			i = reader.read();
			char caracter = (char) i;
			texto += Character.toString(caracter);
		}
		FileWriter file = new FileWriter(local);
		file.write(texto);
		file.close();
	}

	public static void main(String args[]) throws IOException {
		DownloadCode code = new DownloadCode("Direccion","Direccion Local");
		code.wget();
	}
	
}
