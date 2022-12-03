package org.l11gr05;

import org.l11gr05.ghost.Ghost;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Arena implements IArenaObservable{
    private int height;
    private int width;
    List<Ghost> ghosts;
    List<Wall> walls;
    List<PacDot> pacDots;
    List<PowerPellets> powerPellets;

    public Arena(int width, int heigth){
        this.width = width;
        this.height = heigth;
        this.walls = makeWalls();
    }

    public int getHeight(){
        return this.height;
    }

    public List<Wall> getWalls(){
        return this.walls;
    }

    public int getWidth(){
        return this.width;
    }

    private List<Wall> makeWalls(){

        List<Wall> wallsCreated = new ArrayList<Wall>();

        for (int i = 0; i < width;i++){
            Wall wall1 = new Wall(i, 0);
            Wall wall2 = new Wall(i, height-1);
            wallsCreated.add(wall1);
            wallsCreated.add(wall2);
        }

        for (int i = 1; i <= 8; i++){
            Wall wall1 = new Wall(0, i);
            Wall wall2 = new Wall(width-1, i);
            wallsCreated.add(wall1);
            wallsCreated.add(wall2);
        }

        for (int i = 14; i<=20;i++){
            Wall wall1 = new Wall(0, i);
            Wall wall2 = new Wall(width-1,i);
            wallsCreated.add(wall1);
            wallsCreated.add(wall2);
        }

        for (int i = 2; i<=7;i++){
            Wall wall = new Wall(2,i);
            wallsCreated.add(wall);
        }

        for (int i = 11; i<=16;i++){
            Wall wall = new Wall(2, i);
            wallsCreated.add(wall);
        }

        for (int i = 2;i<=4;i++){
            Wall wall = new Wall(9, i);
            wallsCreated.add(wall);
        }

        wallsCreated.add(new Wall(6, 3));
        wallsCreated.add(new Wall(6, 4));
        wallsCreated.add(new Wall(12, 3));
        wallsCreated.add(new Wall(12, 4));
        wallsCreated.add(new Wall(8,4));
        wallsCreated.add(new Wall(10, 4));

        wallsCreated.add(new Wall(1, 4));
        wallsCreated.add(new Wall(2, 4));

        wallsCreated.add(new Wall(16, 4));
        wallsCreated.add(new Wall(17, 4));

        for (int i = 2;i <= 4;i++){
            Wall wall1 = new Wall(i, 6);
            wallsCreated.add(wall1);
        }

        for (int i = 13; i<=15;i++){
            Wall wall1 = new Wall(i, 6);
            wallsCreated.add(wall1);
        }

        wallsCreated.add(new Wall(8, 6));
        wallsCreated.add(new Wall(6, 6));
        wallsCreated.add(new Wall(7, 6));
        wallsCreated.add(new Wall(10, 6));
        wallsCreated.add(new Wall(11, 6));

        wallsCreated.add(new Wall(4, 4));
        wallsCreated.add(new Wall(4, 5));
        wallsCreated.add(new Wall(14, 4));
        wallsCreated.add(new Wall(14, 5));

        wallsCreated.add(new Wall(9,7));

        for (int i = 1; i<=4;i++){
            wallsCreated.add(new Wall(i,8));
        }

        for (int i = 14; i<=17;i++){
            wallsCreated.add(new Wall(i,8));
        }

        for (int i = 8; i<=10;i++){
            wallsCreated.add(new Wall(i,8));
        }

        for (int i = 0; i <=4;i++){
            wallsCreated.add(new Wall(i, 10));
            wallsCreated.add(new Wall(i, 12));
            wallsCreated.add(new Wall(width-1-i,10));
            wallsCreated.add(new Wall(width-1-i,12));
        }

        wallsCreated.add(new Wall(4, 9));
        wallsCreated.add(new Wall(14, 9));

        for (int i = 8; i<=10;i++){
            wallsCreated.add(new Wall(6, i));
            wallsCreated.add(new Wall(12, i));
        }

        for (int i = 1; i<=4;i++){
            wallsCreated.add(new Wall(i, 14));
            wallsCreated.add(new Wall(width-1-i, 14));
        }

        wallsCreated.add(new Wall(4, 13));
        wallsCreated.add(new Wall(14,13));

        for (int i =12;i<=16;i++){
            wallsCreated.add(new Wall(6, i));
            wallsCreated.add(new Wall(12, i));

        }
        wallsCreated.add(new Wall(7, 14));
        wallsCreated.add(new Wall(11,14));

        for (int i = 18;i<=19;i++){
            for (int j = 2; j<=4;j++){
                wallsCreated.add(new Wall(j, i));
                wallsCreated.add(new Wall(width-1-j,i ));
            }

            for (int j = 6; j<=7;j++){
                wallsCreated.add(new Wall(j, i));
                wallsCreated.add(new Wall(width-1-j, i));
            }

        }
        for (int i = 2; i<=4;i++){
            wallsCreated.add(new Wall(i, 16));
            wallsCreated.add(new Wall(width-1-i, 16));
        }

        for (int i = 18; i<=20;i++){
            wallsCreated.add(new Wall(9, i));
        }

        for (int i = 8; i<=10; i++){
            wallsCreated.add(new Wall(i, 16));
        }

        wallsCreated.add(new Wall(9, 15));
        wallsCreated.add(new Wall(9, 14));


        return wallsCreated;
    }
}
