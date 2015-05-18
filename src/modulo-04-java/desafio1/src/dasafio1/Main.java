package dasafio1;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static List<Integer> indiceMaiusculas(String s){
		List<Integer> indices = new ArrayList<>();
		String minuscula = s.toLowerCase();
		
		for (int i = 0; i < s.length(); i++) {
				if(minuscula.charAt(i) != s.charAt(i)){
					indices.add(i);				
					}		
		}			
		return indices;
	}
	public static void main(String[] args) {
		
		List<Integer> indices = new ArrayList<>();
		String cwi = "_#!! NeGrEscO";
		
		indices = indiceMaiusculas(cwi);
		
		for (Integer integer : indices) {
			System.out.println(integer);
		}
		
	}
}
