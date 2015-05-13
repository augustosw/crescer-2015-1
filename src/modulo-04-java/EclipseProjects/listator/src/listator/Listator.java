package listator;

import java.io.File;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Listator{
	public static File[] getFiles(String[] args){
		File f = new File(args[0]);
		File[] lista = f.listFiles();
		return lista;
	}
	
	public static void imprime(String[] args){
		File[] lista = getFiles(args);
		for (File arquivo : lista) {
			System.out.println(arquivo.getName());
		}
	}

	public static void main(String[] args) {
		imprime(args);
		
		//JOptionPane.showMessageDialog();
		
	}
}