package dasafio1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class desafio1Test {
	@Test
	public void testName() throws Exception {
		List<Integer> indices = new ArrayList<>();
		String cwi = "NeGrEscO";
		indices = Main.indiceMaiusculas(cwi);
		for (Integer integer : indices) {
			System.out.println(integer);
		}
	}
}
