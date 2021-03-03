package element.monster;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import datatype.Position;
import element.monster.Monster;

import java.util.Random;

public class Tower extends Monster {

    public Tower(int x, int y){
        super(x, y);
    }

    public Position move(){
        Random random = new Random();
        switch (random.nextInt(2)){
            case 0:
                return new Position(position.getX() + random.nextInt(10) * (random.nextInt(2)*2 - 1), position.getY());
            case 1:
                return new Position(position.getX(), position.getY() + random.nextInt(10) * (random.nextInt(2)*2 - 1));
            default:
                return new Position(position.getX(), position.getY());
        }
    }


    @Override
    public void draw(TextGraphics graphics){
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "T");
    }
}
