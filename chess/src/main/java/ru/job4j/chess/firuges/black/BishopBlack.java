package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new IllegalStateException(
                    String.format("Could not move by diagonal to %s", dest)
            );
        }
        int size = Math.abs(dest.getX() - this.position.getX());
        Cell[] steps = new Cell[size];
        int deltaX = dest.getX() > this.position.getX() ? 1 : -1;
        int deltaY = dest.getY() > this.position.getY() ? 1 : -1;
        int x = this.position.getX();
        int y = this.position.getY();
        for (int index = 0; index < size; index++) {
             x += deltaX;
             y += deltaY;
            steps[index] = Cell.findBy(x, y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        boolean rsl = false;
        int deltaX = dest.getX() > source.getX() ? 1 : -1;
        int deltaY = dest.getY() > source.getY() ? 1 : -1;
            if (dest.getX() - source.getX() == 0){
                deltaX = 0;
            }
            if (dest.getY() - source.getY() == 0){
                deltaY = 0;
            }
        if ((deltaX != 0 || deltaY != 0)
                && (deltaX == deltaY)){
            rsl = true;
        }
        return rsl;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
