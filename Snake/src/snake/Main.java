package snake;

import javax.swing.SwingUtilities;
import snake.interfaccia.InterfacciaUtente;

public class Main {

	public static void main(String[] args) {
		SnakeGame game = new SnakeGame(20, 20);

		InterfacciaUtente ui = new InterfacciaUtente(game, 20);
		SwingUtilities.invokeLater(ui);

		while (ui.getUpdatable() == null) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException ex) {
				System.out.println("La DrawingBoard non e' stata creata");
			}
		}

		game.setUpdatable(ui.getUpdatable());
		game.start();
	}
}
