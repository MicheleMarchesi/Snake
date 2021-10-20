package snake.elementi;

public class Parte {

    private int x;
    private int y;

    public Parte(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean runsInto(Parte parte) {
        if (getX() == parte.getX() && getY() == parte.getY()) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        //(x,y)
        return "(" + getX() + "," + getY() + ")";
    }

}