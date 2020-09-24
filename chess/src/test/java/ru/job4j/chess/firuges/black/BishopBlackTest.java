package ru.job4j.chess.firuges.black;


import junit.framework.TestCase;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class BishopBlackTest extends TestCase {

    @Test
    public void testWhenPositionThenPosition(){
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        assertThat(bishopBlack.position(), equalTo(Cell.findBy(2,7)));
    }
    @Test
    public void testWhenCopyWork(){
        BishopBlack bishopBlack = new BishopBlack(Cell.C7);
        assertThat(bishopBlack.copy(Cell.C7).position(), equalTo(Cell.C7));
    }
//    @Test
//    public void testWhenWayWork(){
//        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
//        List<Cell> expected = new ArrayList<>();
//        expected.add(Cell.B2);
//        assertThat(bishopBlack.way(Cell.B2), is(expected));
//    }
    @Test
    public void testWhenIsDiagonal(){
        BishopBlack bishopBlack = new BishopBlack(Cell.C7);
        boolean expected = bishopBlack.isDiagonal(Cell.C7, Cell.B2);
        assertEquals(expected, (true));
    }
}