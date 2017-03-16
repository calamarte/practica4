import java.util.ArrayList;
import java.util.Arrays;

class Bender {
    // Constructor: ens passen el mapa en forma d'String
    public Bender(String mapa) {
        int y = 0;
        int x = 0;

        //Miramos las columnas que hay en el String
        while (mapa.charAt(x) != '\n')x++;

        //Miramos las filas que hay en el String
        for (int i = 0; i < mapa.length() ; i++) {
            if (mapa.charAt(i) == '\n')y++;
        }
        y++;

        char[][] map = new char[y][x];

        mapa = mapa.replaceAll("\n","");

        y = 0;
        x = 0;

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
    }

    // Navegar fins a l'objectiu («$»).
    // El valor retornat pel mètode consisteix en una cadena de
    // caràcters on cada lletra pot tenir els valors «S», «N», «W» o «E»,
    // segons la posició del robot a cada moment.
    public String run() {
        return null;
    }
}