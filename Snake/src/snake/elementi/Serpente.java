package snake.elementi;

import java.util.ArrayList;
import java.util.List;
import snake.Direzione;

public class Serpente {

    private int x;
    private int y;
    private Direzione direzione;
    private ArrayList<Parte> partiSerpente;
    private boolean cresci;

    public Serpente(int originalX, int originalY, Direzione originalDirection) {
        this.x = originalX;
        this.y = originalY;
        this.direzione = originalDirection;
        this.partiSerpente = new ArrayList<Parte>();
        partiSerpente.add(new Parte(this.x, this.y));
        this.cresci = false;
    }

    public Direzione getDirection() {
        return direzione;
    }

    public void setDirection(Direzione dir) {
        this.direzione = dir;
    }

    public int getLength() {
        return partiSerpente.size();
    }

    public List<Parte> getPieces() {
        return partiSerpente;
    }

    public void move() {
        int nuovaX = partiSerpente.get(partiSerpente.size() - 1).getX();
        int nuovaY = partiSerpente.get(partiSerpente.size() - 1).getY();

        if (getDirection() == Direzione.UP) {
            nuovaY--;
        }
        if (getDirection() == Direzione.DOWN) {
            nuovaY++;
        }
        if (getDirection() == Direzione.LEFT) {
            nuovaX--;
        }
        if (getDirection() == Direzione.RIGHT) {
            nuovaX++;
        }

        if (getLength() > 2 && !cresci) {
            partiSerpente.remove(0);
        }
        if (cresci) {
            cresci = false;
        }
        partiSerpente.add(new Parte(nuovaX, nuovaY));

    }

    public void grow() {
        cresci = true;
    }

    public boolean runsInto(Parte parte) {
        for (Parte p : partiSerpente) {
            if (p.getX() == parte.getX() && p.getY() == parte.getY()) {
                return true;
            }
        }
        return false;
    }

    public boolean runsIntoItself() {
        Parte testa = partiSerpente.get(getLength() - 1);
        for (int i = 0; i < getLength() - 1; i++) {
            if (testa.getX() == partiSerpente.get(i).getX() && testa.getY() == partiSerpente.get(i).getY()) {
                return true;
            }
        }
        return false;
    }
}

