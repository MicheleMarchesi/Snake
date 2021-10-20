package snake;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;

import snake.elementi.Mela;
import snake.elementi.Serpente;
import snake.interfaccia.Updatable;

public class SnakeGame extends Timer implements ActionListener {

	private int larghezza;
	private int altezza;
	private boolean continuare;
	private Updatable updatable;
	private Serpente serpente;
	private Mela mela;

	public SnakeGame(int width, int height) {
		super(1000, null);

		this.larghezza = width;
		this.altezza = height;
		this.continuare = true;
		this.serpente = new Serpente(width / 2, height / 2, Direzione.DOWN);
		this.mela = new Mela(new Random().nextInt(width), new Random().nextInt(height));

		while (mela.getX() == width / 2 && mela.getY() == height / 2) {
			this.mela = new Mela(new Random().nextInt(width), new Random().nextInt(height));
		}

		addActionListener(this);
		setInitialDelay(2000);

	}

	public boolean continues() {
		return continuare;
	}

	public void setUpdatable(Updatable updatable) {
		this.updatable = updatable;
	}

	public int getHeight() {
		return altezza;
	}

	public int getWidth() {
		return larghezza;
	}

	public Serpente getWorm() {
		return serpente;
	}

	public void setWorm(Serpente serpente) {
		this.serpente = serpente;

	}

	public Mela getApple() {
		return mela;
	}

	public void setApple(Mela mela) {
		this.mela = mela;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		serpente.move();

		if (serpente.runsInto(mela)) {
			setApple(new Mela(new Random().nextInt(larghezza), new Random().nextInt(altezza)));// da fixare per non spawnare
																							// su verme
			serpente.grow();
		}

		if (serpente.runsIntoItself()) {
			continuare = false;
		}

		if (serpente.getPieces().get(serpente.getLength() - 1).getX() == larghezza
				|| serpente.getPieces().get(serpente.getLength() - 1).getX() == 0
				|| serpente.getPieces().get(serpente.getLength() - 1).getY() == altezza
				|| serpente.getPieces().get(serpente.getLength() - 1).getY() == 0) {
			continuare = false;

		}
		updatable.update();

		setDelay(1000 / serpente.getLength());
	}

}
