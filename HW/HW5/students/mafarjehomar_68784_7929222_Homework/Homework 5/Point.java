package comparables;

public class Point implements Comparable<Point> {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point other) {
        if (this.y > other.y) {
            return 1;
        } else if (this.y < other.y) {
            return -1;
        } else {
            return Integer.compare(this.x, other.x);
        }
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
