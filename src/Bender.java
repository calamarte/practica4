import java.util.ArrayList;
import java.util.Arrays;

class Bender {
    char[][] map;

    // Constructor: ens passen el mapa en forma d'String
    public Bender(String mapa) {
        int y = 0;
        int x = 0;

        String[] xy = mapa.split("\n");

        char[][] map = new char[xy.length][xy[0].length()];

        mapa = mapa.replaceAll("\n","");

        for (int i = 0; i < map.length*map[0].length ; i++) {
            if (x == map[0].length-1){
                map[y][x] = mapa.charAt(i);
                x = 0;
                y++;
                continue;
            }
            map[y][x] = mapa.charAt(i);
            x++;
        }

        this.map = map;
    }

    // Navegar fins a l'objectiu («$»).
    // El valor retornat pel mètode consisteix en una cadena de
    // caràcters on cada lletra pot tenir els valors «S», «N», «W» o «E»,
    // segons la posició del robot a cada moment.
    public String run() {

        return null;
    }
}