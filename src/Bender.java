import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        StringBuilder resultado = new StringBuilder();
        char[] direction = new char[]{'S','N','W','E'};
        int[] position = xposition();
        int direct = 0;

        while (true){
            int[] aux = avance(position,direction[direct]);

            if (map[aux[0]][aux[1]] == ' '){
                position = aux;
                resultado.append(direction[direct]);
            }

            if (map[aux[0]][aux[1]] == '#'){
                if (direct == 3){
                    direct = 0;
                }else{
                    direct++;
                }
                continue;
            }

            if (map[aux[0]][aux[1]] == 'T'){}

            if (map[aux[0]][aux[1]] == 'I'){}

            if (map[aux[0]][aux[1]] == '$'){
                resultado.append(direction[direct]);
                return resultado.toString();
            }

        }

    }

    private int[] xposition(){
        int[] position = new int[2];

        for (int i = 0,y = 1,x = 0; i <(map.length*map.length)- map[0].length ; i++) {
            if (map[y][x] == 'X'){
                position[0] = y;
                position[1] = x;
                return position;
            }

            if (x == map[0].length-1){
                x = 0;
                y++;
                continue;
            }
            x++;
        }

        return null;
    }

    private int[] avance(int[] position,char brujula){
        switch (brujula){

            case 'S':
                position[0]++;
                return position;

            case 'N':
                position[0]--;
                return position;

            case 'W':
                position[1]--;
                return position;

            case 'E':
                position[1]++;
                return position;

        }
        return null;
    }
}