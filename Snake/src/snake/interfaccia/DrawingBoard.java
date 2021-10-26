package snake.interfaccia;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import snake.SnakeGame;
import snake.elementi.Parte;

public class DrawingBoard extends JPanel implements Updatable {

    private SnakeGame game;
    private int pezzi;

    public DrawingBoard(SnakeGame game, int lunghezza) {
        this.game = game;
        this.pezzi = lunghezza;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.GREEN);
        for (Parte p : game.getWorm().getPieces()) {
            g.fill3DRect(p.getX() * pezzi, p.getY() * pezzi, pezzi, pezzi, true);
        }
        g.setColor(Color.RED);
        g.fillOval(pezzi * game.getApple().getX(), pezzi * game.getApple().getY(), pezzi, pezzi);

    }

    @Override
    public void update() {
        super.repaint();
    }

}
