public class Ground {
    private GroundCell[][] landscape;
    private int length,width;

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public Ground(int length, int width){
        landscape = new GroundCell[width][length];
        this.length = length;
        this.width = width;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                landscape[i][j] = new GroundCell(i,j,CellState.FREE);
            }
        }
    }
}
