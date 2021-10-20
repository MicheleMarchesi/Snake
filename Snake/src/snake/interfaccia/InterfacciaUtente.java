package snake.interfaccia;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import snake.SnakeGame;


public class InterfacciaUtente implements Runnable {

    private JFrame frame;
    private SnakeGame game;
    private int lunghezza;
    private DrawingBoard drawingBoard;

    public InterfacciaUtente(SnakeGame game, int sideLength) {
        this.game = game;
        this.lunghezza = sideLength;
    }

    @Override
    public void run() {
        frame = new JFrame("Snake");
        int width = (game.getWidth() + 1) * lunghezza + 10;
        int height = (game.getHeight() + 2) * lunghezza + 10;

        frame.setPreferredSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    public void createComponents(Container container) {
        drawingBoard = new DrawingBoard(game, lunghezza);
        container.add(drawingBoard);
        frame.addKeyListener(new KeyboardListener(game.getWorm()));

    }

    public JFrame getFrame() {
        return frame;
    }

    public Updatable getUpdatable() {
        return drawingBoard;
    }
}
