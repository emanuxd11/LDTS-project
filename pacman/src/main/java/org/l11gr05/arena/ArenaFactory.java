package org.l11gr05.arena;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ArenaFactory {

    private int height;
    private int width;

    public Arena createArena(String arenaName) throws IOException {
        Arena arena = new Arena();
        String rootPath = new File(System.getProperty("user.dir")).getPath();
        String mapLocation = rootPath + "/src/main/resources/" + arenaName;

        BufferedReader br = Files.newBufferedReader(Paths.get(mapLocation), Charset.defaultCharset());

        width = Integer.parseInt(br.readLine());
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
                    case '#' -> arena.addWall(new Wall(new Position(j, height - i-1)));
                    case '.' -> arena.addPacDot(new PacDot(new Position(j, height - i -1)));
                    case 'o' -> arena.addPowerPellet(new PowerPellet(new Position(j, height -i - 1)));
                }
            }
        }
    }
}



