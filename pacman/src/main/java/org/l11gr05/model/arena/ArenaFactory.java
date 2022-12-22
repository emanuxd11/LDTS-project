package org.l11gr05.model.arena;

import org.l11gr05.model.elements.*;
import org.l11gr05.model.elements.*;
import org.l11gr05.model.elements.ghost.Blinky;
import org.l11gr05.model.elements.ghost.Clyde;
import org.l11gr05.model.elements.ghost.Inky;
import org.l11gr05.model.elements.ghost.Pinky;
import org.l11gr05.model.elements.ghost.ghostStrategies.BlinkyStrategy;
import org.l11gr05.model.elements.ghost.ghostStrategies.ClydeStrategy;
import org.l11gr05.model.elements.ghost.ghostStrategies.InkyStrategy;
import org.l11gr05.model.elements.ghost.ghostStrategies.PinkyStrategy;

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
                switch (line.charAt(j)) {
                    case '#' -> arena.addWall(new Wall(new Position(j, i)));
                    case '.' -> arena.addPacDot(new PacDot(new Position(j, i)));
                    case 'o' -> arena.addPowerPellet(new PowerPellet(new Position(j, i)));
                    case 'P' -> arena.setPacman(new Pacman(new Position(j, i), '0', "src/main/resources/scores/highscore.txt"));
                    case 'B' -> arena.setBlinky(new Blinky(j, i, new BlinkyStrategy()));
                    case 'I' -> arena.setInky(new Inky(j, i, new InkyStrategy()));
                    case 'N' -> arena.setPinky(new Pinky(j, i, new PinkyStrategy()));
                    case 'C' -> arena.setClyde(new Clyde(j, i, new ClydeStrategy()));
                    case 'H' -> arena.setHouseSpawn(new Position(j, i));
                    case 'U' -> arena.setHunterSpawn(new Position(j, i));
                    case 'L' -> arena.setLeftPortal(new Position(j, i));
                    case 'R' -> arena.setRightPortal(new Position(j, i));
                }
            }
        }
    }
}



