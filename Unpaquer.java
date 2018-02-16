package malwarePack;
import java.io.*;

public class Unpaquer {
	FileInputStream fileInput;
	public Unpaquer() throws IOException {
		fileInput = new FileInputStream("/home/angrymasther/Escritorio/Juan.png");
	}
	public String reader() throws IOException {
		String s = "";
		boolean fin = false;
		int character = 0;
		while(!fin) {
			if(character == -1) {fin=true;break;};
			character = fileInput.read();
			s += (char) character;
		}
	    fileInput.close();
		return s;
	}
	private static String getCode(String s) {
		int i = s.indexOf("_--------------------_") + 22;
		String subString = s.substring(i, s.length());
		return subString;
	}
	private static String pop(int cantidad, String s) {
		String value = "";
		for(int i=0;i<s.length()-cantidad;i++) {
			value += Character.toString(s.charAt(i));
		}
		return value;
	}
	private String pop(String s) {
		String value = "";
		value = s.substring(0,s.lastIndexOf("ï¿¿")) + s.substring(s.lastIndexOf("ï¿¿")+3 , s.length() );
		value = getCode(value);
		value = pop(1, value);
		return value;
	}
	private String get(String s, int index) {
		String value = "";
		for(int i=index+1;i<s.length();i++) {
			value += Character.toString(s.charAt(i));
		}
		return value;
	}
	public static void main(String args[]) throws IOException {
		Unpaquer unpaquer = new Unpaquer();
		String s = unpaquer.reader();
		String codigo = unpaquer.pop(s);
		String extension = unpaquer.get(codigo, codigo.lastIndexOf("\n"));
		String direccion = "/home/angrymasther/Escritorio/Juan.py";
		codigo = unpaquer.pop(extension.length(),codigo);
		File file = new File(direccion);
		FileWriter writer = new FileWriter(file);
		writer.write(codigo);
		writer.close();
	}
}