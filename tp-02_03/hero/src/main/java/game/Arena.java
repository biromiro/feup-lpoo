package game;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import datatype.Position;
import element.*;
import element.monster.Horse;
import element.monster.Monster;
import element.monster.Pawn;
import element.monster.Tower;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {

    private int width;
    private int height;
    private int arenaWidthPadding = 5;
    private int arenaHeightPadding = 2;
    private List<Wall> walls;
    private List<Coin> coins;
    private List<Monster> monsters;
    private boolean finished;
    private Position door;

    Hero hero;

    Arena(int width, int height){

        hero = new Hero(10,10);

        this.width = width;
        this.height = height;

        this.walls = createWalls();

        startArena();

    }

    public void startArena(){
        this.coins = createCoins();
        this.monsters = createMonsters();
        this.finished = false;

        Random random = new Random();

        switch (random.nextInt(4)){
            case 0:
                this.door = new Position(arenaWidthPadding + random.nextInt(width - 2) + 1, arenaHeightPadding);
                break;
            case 1:
                this.door = new Position(arenaWidthPadding + random.nextInt(width - 2) + 1 , arenaHeightPadding + height - 1);
                break;
            case 2:
                this.door = new Position(arenaWidthPadding , arenaHeightPadding +  random.nextInt(height - 2) + 1);
                break;
            case 3:
                this.door = new Position(arenaWidthPadding + width - 1, arenaHeightPadding + random.nextInt(height - 2) + 1);
                break;
            default:
                this.door = new Position(arenaWidthPadding, arenaHeightPadding);
                break;
        }
    }

    public void resetArena(){
        hero = new Hero(10,10);

        this.walls = createWalls();

        startArena();
    }

    private boolean isDoorVisible(){
        return coins.isEmpty();
    }

    private List<Wall> createWalls(){
        List<Wall> walls = new ArrayList<>();

        for (int c = arenaWidthPadding; c < width + arenaWidthPadding; c++) {
            walls.add(new Wall(c, arenaHeightPadding));
            walls.add(new Wall(c, height - 1 + arenaHeightPadding));
        }

        for (int r = 1 + arenaHeightPadding; r < height - 1 + arenaHeightPadding; r++) {
            walls.add(new Wall(arenaWidthPadding, r));
            walls.add(new Wall(width - 1 + arenaWidthPadding, r));
        }

        return walls;
    }

    private List<Coin> createCoins(){
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        int numberOfCoins = random.nextInt(8);
        for (int i = 0; i < numberOfCoins; i++) {
            while(true) {
                boolean invalid = false;
                Position coinPosition = new Position(random.nextInt(width - 2) + 1 + arenaWidthPadding, random.nextInt(height - 2) + 1 + arenaHeightPadding);
                for (Coin coin: coins) {
                    if (coin.getPosition().equals(coinPosition)){
                        invalid = true;
                        break;
                    }
                }
                if (hero.getPosition().equals(coinPosition)) invalid = true;
                if (!invalid) {
                    coins.add(new Coin(coinPosition.getX(), coinPosition.getY()));
                    break;
                }
            }
        }
        return coins;
    }

    private List<Monster> createMonsters(){
        Random random = new Random();
        ArrayList<Monster> monsters = new ArrayList<>();
        int numberOfMonsters = random.nextInt(8);
        for (int i = 0; i < numberOfMonsters; i++) {
            while(true) {
                boolean invalid = false;
                Position monsterPosition = new Position(random.nextInt(width - 2) + 1 + arenaWidthPadding, random.nextInt(height - 2) + 1 + arenaHeightPadding);
                for (Monster monster: monsters) {
                    if (monster.getPosition().equals(monsterPosition)){
                        invalid = true;
                        break;
                    }
                }
                if (hero.getPosition().equals(monsterPosition)) invalid = true;
                if (!invalid) {
                    Random random2 = new Random();
                    switch (random2.nextInt(3)) {
                        case 1 -> monsters.add(new Horse(monsterPosition.getX(), monsterPosition.getY()));
                        case 2 -> monsters.add(new Tower(monsterPosition.getX(), monsterPosition.getY()));
                        default -> monsters.add(new Pawn(monsterPosition.getX(), monsterPosition.getY()));
                    }

                    break;
                }
            }
        }
        return monsters;
    }

    private boolean canMove(Position position){
        if(door.equals(position) && isDoorVisible()) return true;
        if(position.getX() < width + arenaWidthPadding && position.getY() < height + arenaHeightPadding &&
                position.getX() >= arenaWidthPadding && position.getY() >= arenaHeightPadding) {
            for (Wall wall : walls) {
                if (wall.getPosition().equals(position))
                    return false;
            }
            return true;
        } else return false;
    }

    private boolean verifyMonsterCollision(){
        for(Monster monster: monsters){
            if (monster.getPosition().equals(hero.getPosition()) && hero.isTargetable()) return true;
        }
        return false;
    }

    private void retrieveCoins(Position position){

        Coin coinToRemove = null;

        for (Coin coin: coins){
            if (coin.getPosition().equals(position)) {
                coinToRemove = coin;
                hero.incrementScore();
                break;
            }
        }

        coins.remove(coinToRemove);

    }

    public boolean isGameOver(){
        return finished;
    }

    private void gameOver(){
        System.out.println("game.Game Over!");
        finished = true;
    }

    private void moveHero(Position position){
        moveMonsters();
        if(verifyMonsterCollision()) hero.decrementHealth();
        if(hero.isDead()) gameOver();
        if (canMove(position)) {
            if(door.equals(position) && isDoorVisible()){
                startArena();
                return;
            }
            retrieveCoins(position);
            hero.setPosition(position);
            if(verifyMonsterCollision()) hero.decrementHealth();
            if(hero.isDead()) gameOver();
        }
    }

    private void moveMonsters(){
        for(Monster monster: monsters){
            Position newPosition = monster.move();
            if(canMove(newPosition)){
                retrieveCoins(newPosition);
                monster.setPosition(newPosition);
            }
        }
    }

    public void processKey(KeyStroke key){
        switch (key.getKeyType()){
            case ArrowUp:
                moveHero(hero.moveUp());
                break;
            case ArrowDown:
                moveHero(hero.moveDown());
                break;
            case ArrowLeft:
                moveHero(hero.moveLeft());
                break;
            case ArrowRight:
                moveHero(hero.moveRight());
                break;
            default:
                break;
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void draw(TextGraphics graphics){
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(5, 2), new TerminalSize(width, height), ' ');
        hero.draw(graphics);
        for (Wall wall: walls){
            wall.draw(graphics);
        }

        for (Coin coin: coins){
            coin.draw(graphics);
        }

        for (Monster monster: monsters){
            monster.draw(graphics);
        }

        if(isDoorVisible()) graphics.putString(new TerminalPosition(door.getX(), door.getY()), " ");
    }

}
