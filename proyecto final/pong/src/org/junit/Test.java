package org.junit;
import aplicacion.*;
import static org.junit.Assert.*;
import org.junit.Test;



public class Test {
	@Test
	public void deberiaMoverPlataformaDerecha() {
		Pong game = new Pong(1000, 1000, 1, " ", " ");
		int inicial = game.getRaquetas().get(0).getXPosition();
		game. moverRaquetaDerecha(0);
		int movimiento = game.getRaquetas().get(0).getXPosition();
		assertTrue(inicial + 2 == movimiento);
	}
	@Test
	public void deberiaMoverPlataformaIzquierda() {
		Pong game = new Pong(1000, 1000, 1, " ", " ");
		int inicial = game.getRaquetas().get(0).getXPosition();
		game. moverRaquetaIzquierda(0);
		int movimiento = game.getRaquetas().get(0).getXPosition();
		assertTrue(inicial + 2 == movimiento);
	}
	@Test
	public void deberiaExistirPoder() {
		Pong game = new Pong(1000, 1000, 1, " ", " ");
		assertTrue(game.getPoderes().size() != 0);
	}
	@Test
	public void deberiaExistirJugador() {
		Pong game = new Pong(1000, 1000, 1, " ", " ");
		assertTrue(game.getRaquetas().size() > 0);
	}
	@Test
	public void noDeberiaCrearBola() {
		Pong game = new Pong(1000, 1000, 1, " ", " ");
		int cont = 0;
		try {
			game.addBola(20, 20, 20, 20, 20,20);
			game.addBola(20, 20, 20, 20, 20,20);
		} catch (PongException e) {
			cont++;
		}
		assertTrue(cont == 1);
	}
	@Test
	public void deberiaAñadirRaqueta() {
		Pong game = new Pong(1000, 1000, 1, " ", " ");
		game.addRaquetas(476,660,132,23,"Raqueta");
		assertTrue(game.getRaquetas().size() == 2);
	}
}
