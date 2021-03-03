package element;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.terminal.Terminal;
import datatype.Position;

public class Hero extends Element{

    private int health = 5;

    private int score = 0;

    private boolean targetable = true;

    public Hero(int x, int y){
        super(x, y);
    }

    public Position moveUp(){
        return new Position(position.getX(), position.getY() - 1);
    }

    public Position moveDown(){
        return new Position(position.getX(), position.getY() + 1);
    }

    public Position moveLeft(){
        return new Position(position.getX() - 1, position.getY());
    }

    public Position moveRight(){
        return new Position(position.getX() + 1, position.getY());
    }

    public void decrementHealth(){
        health--;
        switchTargetable();
    }

    public boolean isDead(){
        return health == 0;
    }

    public void switchTargetable(){
        targetable = !targetable;
    }

    public boolean isTargetable() {
        switchTargetable();
        return !targetable;
    }

    public void incrementScore(){
        score++;
    }

    @Override
    public void draw(TextGraphics graphics){
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "X");
        graphics.putString(new TerminalPosition(5, 19), "Health: ");
        for(int i = 0; i < health; i++){
            graphics.putString(new TerminalPosition(13 + i, 19), "♥");
        }

        graphics.putString(new TerminalPosition(25, 19), "Score: ");
        graphics.putString(new TerminalPosition(32, 19), String.valueOf(score));
    }


}
