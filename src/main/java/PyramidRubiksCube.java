import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

enum Color{Red, Green, Blue, Yellow}

// face class
class Face {
    private Color[] tiles;

    // constructor
    public Face(Color color) {
        tiles = new Color[9];
        Arrays.fill(tiles, color);
    }

    // getter for tiles
    public Color[] getTiles() {
        return tiles;
    }

}

public class PyramidRubiksCube {
    private final Face[] faces;
    // map to store edge relationships
    private Map<String, String> edgeMap;

    // constructor
    public PyramidRubiksCube() {
        faces = new Face[4];
        initializeFaces();
        initializeEdges();
    }

    // getter for faces
    public Face[] getFaces() {
        return faces;
    }

    // method to initialize faces
    private void initializeFaces() {
        // front = red, left = blue, right = green, bottom = yellow
        Color[] colors = {Color.Red, Color.Blue, Color.Green, Color.Yellow};
        for (int i = 0; i < faces.length; i++) {
            faces[i] = new Face(colors[i]);
        }
    }

    // method to define edge relationships
    private void initializeEdges() {
        edgeMap = new HashMap<>();

        int[][] adjacentFaces = {
                {0, 1}, {0, 2}, {0, 3}, // red-blue, red-green, red-yellow
                {1, 2}, {1, 3}, {2, 3} // blue-green, blue-yellow, green-yellow
        };

        int[][] edgeIndices = {
                {1, 3},  // red[1] -> blue[3]
                {3, 1},  // red[3] -> green[1]
                {6, 3},  // red[6] -> yellow[3]
                {1, 3},  // blue[1] -> green[3]
                {6, 1},  // blue[6] - > yellow[1]
                {6, 6}  // green[6] -> yellow[6]
        };

        for (int i = 0; i < adjacentFaces.length; i++) {
            int faceA = adjacentFaces[i][0];
            int faceB = adjacentFaces[i][1];
            int tileIndexA = edgeIndices[i][0];
            int tileIndexB = edgeIndices[i][1];
            // edge relationships are doubly linked
            String keyA = faceA + "-->" + tileIndexA;
            String keyB = faceB + "-->" + tileIndexB;
            // each pair can be interpreted as "face x, tile x shares an edge with face y, tile y"
            edgeMap.put(keyA, keyB);
            edgeMap.put(keyB, keyA);
        }
    }

    // check validity of cube: each face contains 9 tiles of the same color
    private boolean validateCube() {
        Color[] expectedColors = {Color.Red, Color.Blue, Color.Green, Color.Yellow};

        // check each face for uniform color
        for (int i = 0; i < faces.length; i++) {
            Face face = faces[i];
            if (face == null || faces.length != 4) {
                return false;
            }
            Color[] tiles = face.getTiles();
            if (tiles == null || tiles.length != 9) {
                return false;
            }
            for (Color tileColor : tiles) {
                if (tileColor != expectedColors[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    // main method to test if cube is set up properly
    public static void main(String[] args) {
        PyramidRubiksCube test = new PyramidRubiksCube();
        System.out.println("Valid cube: " + test.validateCube());

        // print each face of the cube
        Face[] faces = test.getFaces();
        for (int i = 0; i < faces.length; i++) {
            System.out.println("Face " + i + ":");
            Color[] tiles = faces[i].getTiles();

            System.out.printf("%24s%n", tiles[0]);
            System.out.printf("%12s%12s%12s%n", tiles[1], tiles[2], tiles[3]);
            System.out.printf("%8s%8s%8s%8s%8s%n", tiles[4],  tiles[5], tiles[6], tiles[7], tiles[8]);
            System.out.println();

        }
    }
}