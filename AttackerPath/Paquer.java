package malwarePack;
import java.io.*;

public class Paquer {
	public Paquer(String imagen , String codigo, String direccion) {
		try {
			getImagen1(imagen, codigo, direccion);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void getImagen1(String s, String s1, String direccion) throws FileNotFoundException, IOException {
		File imagen = new File(s);
		File malware = new File(s1);
		File infectedImagen = new File(direccion);
		FileWriter infectedImagenWriter = new FileWriter(infectedImagen);
		
		String contenidoImagen = reader(imagen);
		String contenidoMalware = reader(malware);
		
		System.out.println(getExtensionFile("."+s1));
		
		infectedImagenWriter.write(contenidoImagen + "\n_--------------------_\n" + contenidoMalware+"\n."+getExtensionFile(s1));
		infectedImagenWriter.close();
}
static String reader(File f) throws FileNotFoundException {
		try {
			FileReader reader = new FileReader(f);
			String value = "";
			int c=0;
			while(c != -1) {
				c = reader.read();
				value += (char) c;
			}
			return value;
		}catch (FileNotFoundException e) {}catch (IOException e) {}
		return  "";
	}
public static String getExtensionFile(String filename) {
    File f = new File(filename);
    if (f == null || f.isDirectory()){
          return "nulo o directorio";
    }else if (f.isFile()){
          int index = filename.lastIndexOf('.');
          if (index == -1) {
                return "";
          } else {
                return filename.substring(index + 1);
          }
    }else{
          return "que has enviado?";
    }
}    

}
