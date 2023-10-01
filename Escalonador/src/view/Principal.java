package view;

import javax.swing.JOptionPane;

import br.edu.fateczl.lipe.FilaString.Fila;
import controller.EscalonadorController;

public class Principal {

	public static void main(String[] args) {
		int op = 0;
		Fila filaProcessos = new Fila();
		EscalonadorController eContr = new EscalonadorController();
		String processo;
		
		do {
			op = Integer.parseInt(JOptionPane.showInputDialog("=========== MENU ===========\n"
					+ "Escolha a operacao:\n"
					+ "1 - Inserir processo\n"
					+ "2 - Executar os processos\n"
					+ "0 - Sair"));
			switch(op) {
				case 0:
					JOptionPane.showMessageDialog(null, "Ate a proxima!");
					break;
				case 1:
					processo = JOptionPane.showInputDialog("Informe o processo");
					if (validarProcesso(processo))
						filaProcessos.insert(processo);
					else
						JOptionPane.showMessageDialog(null, "Processo invalido!");
					break;
				case 2:
					try {
						eContr.escalonador(filaProcessos);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				default:
					JOptionPane.showMessageDialog(null, "Operacao invalida, tente novamente!");
			}
		} while(op > 0);
	}

	private static boolean validarProcesso(String processo) {
		try {
			String[] partesProcesso = processo.split(";");
			int numProcesso = Integer.parseInt(partesProcesso[1]);
			partesProcesso = partesProcesso[0].split("\\.");
			if (!partesProcesso[1].equals("exe"))
				return false;
			
			return true;
		} catch(Exception e) {
			return false;
		}	
	}

}
