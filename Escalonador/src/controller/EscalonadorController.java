package controller;

import br.edu.fateczl.lipe.FilaString.Fila;

public class EscalonadorController {

	public EscalonadorController() { }
	
	public void escalonador(Fila p) throws Exception {
		String[] processo;
		int numProcesso;
		while(!p.isEmpty()) {
			processo = p.remove().split(";");
			System.out.println("Processo: " + processo[0] + " esta sendo executado.");
			Thread.sleep(500);
			numProcesso = Integer.parseInt(processo[1]);
			numProcesso--;
			if (numProcesso > 1)
				p.insert(processo[0] + ";" + numProcesso);
		}
	}
}
