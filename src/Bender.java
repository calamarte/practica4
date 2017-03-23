import java.util.Arrays;

class Bender {
    char[][] map;

    // Constructor: ens passen el mapa en forma d'String
    public Bender(String mapa) {

        //Creo y lleno un array bidimensional segun las directrizes de el array xy
        //que contiene la información adaptada por el método .split.
        String[] xy = mapa.split("\n");

        char[][] map = new char[xy.length][xy[0].length()];

        for (int i = 0; i < xy.length ; i++) {
            for (int j = 0; j < xy[0].length() ; j++) {
                map[i][j] = xy[i].charAt(j);
            }
        }

        this.map = map;
    }

    // Navegar fins a l'objectiu («$»).
    // El valor retornat pel mètode consisteix en una cadena de
    // caràcters on cada lletra pot tenir els valors «S», «N», «W» o «E»,
    // segons la posició del robot a cada moment.
    public String run() {
        StringBuilder resultado = new StringBuilder();
        char[] normal = new char[]{'S','E','N','W'};
        char[] invertido = new char[]{'N','W','S','E'};
        char[] direction;
        int[] position = xposition();
        int direct = 0;
        boolean perimetro = false;
        boolean inverter = false;

        while (true){

            if (inverter)direction = invertido;
            else direction = normal;

            int[] aux = avance(position,direction[direct]);

            if (map[aux[0]][aux[1]] == ' ' || map[aux[0]][aux[1]]== 'X'){
                position = aux;
                perimetro = false;
                resultado.append(direction[direct]);
                continue;
            }

            if (map[aux[0]][aux[1]] == '#'){
                if (perimetro)direct++;
                else{
                    direct = 0;
                    perimetro = true;
                }
                continue;
            }

            if (map[aux[0]][aux[1]] == 'T'){
                position = portalPosition(aux);
                resultado.append(direction[direct]);
                continue;
            }

            if (map[aux[0]][aux[1]] == 'I'){
                if (inverter)inverter = false;
                else inverter = true;
                perimetro = false;
                position = aux;
                resultado.append(direction[direct]);
                direct = 0;
                continue;
            }

            if (map[aux[0]][aux[1]] == '$'){
                resultado.append(direction[direct]);
                return resultado.toString();
            }

        }

    }

    private int[] xposition(){
        int[] position = new int[2];

        for (int i = 0,y = 1,x = 0; i <(map.length*map[0].length)- map[0].length ; i++) {
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
        int[] resultado = Arrays.copyOf(position, 2);

        switch (brujula){

            case 'S':
                resultado[0]++;
                return resultado;

            case 'E':
                resultado[1]++;
                return resultado;

            case 'N':
                resultado[0]--;
                return resultado;

            case 'W':
                resultado[1]--;
                return resultado;

        }

        return null;
    }

    private int[] portalPosition(int[] position){
        int[] portal = new int[2];

        for (int i = 0,y = 1,x = 0; i <(map.length*map[0].length)- map[0].length ; i++) {
            if (map[y][x] == 'T' && position[0] != y && position[1] != x){
                portal[0] = y;
                portal[1] = x;
                return portal;
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
}