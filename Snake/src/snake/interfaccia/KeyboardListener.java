package snake.interfaccia;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import snake.Direzione;
import snake.elementi.Serpente;

public class KeyboardListener implements KeyListener {

	    private Serpente serpente;

	    public KeyboardListener(Serpente serpente) {
	        this.serpente = serpente;
	    }

	    @Override
	    public void keyPressed(KeyEvent e) {
	        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
	            serpente.setDirection(Direzione.LEFT);
	        }
	        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
	            serpente.setDirection(Direzione.RIGHT);
	        }
	        if (e.getKeyCode() == KeyEvent.VK_UP) {
	            serpente.setDirection(Direzione.UP);
	        }
	        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
	            serpente.setDirection(Direzione.DOWN);
	        }

	    }

	    @Override
	    public void keyReleased(KeyEvent e) {
	    }

	    @Override
	    public void keyTyped(KeyEvent e) {
	    }

	}
