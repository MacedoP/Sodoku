package nye.hu.progTech;

import nye.hu.progTech.Map.Board;
import nye.hu.progTech.Start.Menu_Interation;


public class Main {

    public static void main(String[] args) {
        Board world = new Board(100);
        Menu_Interation menu = new Menu_Interation(world);
        menu.showMainMenu();
    }
}