package org.academiadecodigo.bootcamp;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.gui.Window;


/**
 * Created by codecadet on 29/06/16.
 */
public class HelloWorld {

    public static void main(String[] args) {

        GUIScreen gui = TerminalFacade.createGUIScreen();
        gui.getScreen().startScreen();

        Window window = new Window("Yo!");
        gui.showWindow(window);

        gui.getScreen().stopScreen();

    }
}
