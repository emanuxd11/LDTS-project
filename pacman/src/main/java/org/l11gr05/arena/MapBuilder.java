package org.l11gr05.arena;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MapBuilder {

    private int height;

    private enum MapElement {
        Wall('#'),  PacDot('.'), INVALID('\0');

        final char symbol;

        MapElement(char symbol) {
            this.symbol = symbol;
        }

        public char getSymbol() {
            return symbol;
        }

        public static MapElement fromChar(char symbol) {
            for (MapElement mapElement : MapElement.values())
                if (mapElement.getSymbol() == symbol)
                    return mapElement;
            return INVALID;
        }
    }

    public Arena createArena(String mapName) throws IOException {
        Arena arena = new Arena();
        String rootPath = new File(System.getProperty("user.dir")).getPath();
        String mapLocation = rootPath + "/src/main/resources/" + mapName;

        BufferedReader br = Files.newBufferedReader(Paths.get(mapLocation), Charset.defaultCharset());

        int width = Integer.parseInt(br.readLine());
        height = Integer.parseInt(br.readLine());
        arena.setSize(width, height);
        readElements(arena, br);
        return arena;
    }

    @SuppressWarnings("MissingCasesInEnumSwitch")
    private void readElements(Arena arena, BufferedReader br) throws IOException {
        for (int i = 0; i < height; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                switch (line.charAt(j)){
                    //case Red -> map.setRed(new Red(new Position(i * 8+1, j * 12)));
                    //case Pink -> map.setPink(new Pink(new Position(i * 8+1, j * 12)));
                    //case Orange -> map.setOrange(new Orange(new Position(i * 8+1, j * 12)));
                    //case Cyan -> map.setCyan(new Cyan(new Position(i * 8+1, j * 12)));
                    //case Pacman -> map.setPacman(new Pacman(new Position(i * 8, j * 12)));
                    case '#' -> arena.addWall(new Wall(new Position(j, i)));
                    case '.' -> arena.addPacDot(new PacDot(new Position(j, i)));
                    case 'o' -> arena.addPowerPellet(new PowerPellet(new Position(j, i)));
                }
            }
        }
    }
}



