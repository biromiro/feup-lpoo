package element.monster;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import datatype.Position;
import element.monster.Monster;

import java.util.Random;

public class Horse extends Monster {

    public Horse(int x, int y){
        super(x, y);
    }

    public Position move(){
        Random random = new Random();
        switch (random.nextInt(2)){
            case 0:
                int toMoveUpDown = random.nextInt(3) - 1 , toMoveLeftRight = 0;
                if (toMoveUpDown != 0) toMoveLeftRight = (random.nextInt(2) == 0) ? 1 : -1;
                return new Position(position.getX() + toMoveLeftRight, position.getY() + toMoveUpDown*2);
            case 1:
                int toMoveLeftRight2 = random.nextInt(3) - 1 , toMoveUpDown2 = 0;
                if (toMoveLeftRight2 != 0) toMoveUpDown2 = (random.nextInt(2) == 0) ? 1 : -1;
                return new Position(position.getX() + toMoveLeftRight2*2, position.getY() + toMoveUpDown2);
            default:
                return new Position(position.getX(), position.getY());
        }
    }


    @Override
    public void draw(TextGraphics graphics){
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "H");
    }
}
