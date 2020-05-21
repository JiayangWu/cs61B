package byog.lab5;
import org.junit.Test;
import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {
    private static final int WIDTH = 60;
    private static final int HEIGHT = 30;

    public static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void addHexagon(TERenderer ter, TETile[][] world, Position p, int size, TETile t) {
//        for (int j = 0; j < size * 2; j++) {
//            world[p.x][p.y]
//        }
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size + 2 * (size - i - 1) + i; j++) {
                world[p.x + j][p.y - i] = t;
                world[p.x + j][p.y + i + 1] = t;
            }
            ter.renderFrame(world);
        }
    }
    /* Calculate the position of the left upper neighbor hex */
    public static Position leftUpperNeighbor(Position p) {
        return new Position(p.x - 5, p.y - 3);
    }

    public static Position rightUpperNeighbor(Position p) {
        return new Position(p.x + 5, p.y - 3);
    }

    public static void main(String[] args) {
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);

        // initialize tiles
        TETile[][] world = new TETile[WIDTH][HEIGHT];

        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }

        Position p = new Position(10, 15);
        addHexagon(ter, world, p, 3, Tileset.WALL);
        addHexagon(ter, world, new Position(10, 15 - 6), 3, Tileset.TREE);
        addHexagon(ter, world, leftUpperNeighbor(p), 3, Tileset.FLOWER);
        addHexagon(ter, world, rightUpperNeighbor(p), 3, Tileset.FLOWER);
    }
}
