package comparables;

public class Point implements Comparable<Point> {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int compareTo(Point o) {
        if (this.y != o.y) {
            return Integer.compare(this.y, o.y);
        }
        return Integer.compare(this.x, o.x);
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", x, y);
    }
}
