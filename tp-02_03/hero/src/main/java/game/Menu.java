package game;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import element.Coin;
import element.Wall;
import element.monster.Monster;

public class Menu {

    private boolean toQuit;

    private boolean restart;

    private Arena arena;

    private boolean inGame;

    Menu(Arena arena){
        this.toQuit = false;
        this.restart = false;
        this.arena = arena;
        this.inGame = false;
    }

    public void processKey(KeyStroke key){
        if(key.getKeyType() != KeyType.Character) return;
        switch (key.getCharacter()){
            case 's':
                arena.resetArena();
                arena.startArena();
                inGame = true;
                break;
            case 'q':
                toQuit = true;
                break;
            default:
                break;
        }
    }

    public boolean toQuit(){
        return toQuit;
    }

    public boolean toRestart(){
        restart = false;
        return !restart;
    }

    public boolean isInGame(){
        return inGame;
    }

    public void endGame(){
        inGame = false;
    }

    public void draw(TextGraphics graphics){
        graphics.setBackgroundColor(TextColor.Factory.fromString("#8c2d19"));
        graphics.fillRectangle(new TerminalPosition(5, 2), new TerminalSize(arena.getWidth(), arena.getHeight()), ' ');
        if(arena.isGameOver()) graphics.putString(new TerminalPosition(arena.getWidth()/2  , arena.getHeight()/2 - 3), "Game Over!");
        else graphics.putString(new TerminalPosition(arena.getWidth()/2 - 5 , arena.getHeight()/2 - 3), "Welcome to BiroHero!");

        graphics.putString(new TerminalPosition(arena.getWidth()/2 - 3 , arena.getHeight()/2 ), "s - Start the game");
        graphics.putString(new TerminalPosition(arena.getWidth()/2 - 2 , arena.getHeight()/2 + 1), "q - Quit the game");

    }
}
