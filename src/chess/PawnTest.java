package chess;

import static org.junit.Assert.*;
import org.junit.Test;

public class PawnTest {
	@Test
	public void testCreate() {
		Pawn p = new Pawn();
		assertEquals("white", p.getColor());
		
		Pawn black = new Pawn("black");
		assertEquals("black", black.getColor());
	}
}
