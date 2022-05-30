import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * My World
 */
public class MyWorld extends World
{
    public static int score = 0;
    
    public Label scoreLabel = new Label(0, 80);
    
    /**
     * Constructor for objects of class MyWorld.
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
        Elephant e = new Elephant();
        addObject(e, 300, 350);
        
        // Add a label
        addObject(scoreLabel, 50,50);
        
        // add an apple
        spawnApple();
        
        Rock rock = new Rock();
        addObject(rock, 0,0);
    }
    
    public void spawnApple()
    {
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        Apple apple = new Apple();
        addObject(apple, x, y);
    }
    
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
    }
    
    public void gameOver()
    {
        GameOverWorld world = new GameOverWorld();
        Greenfoot.setWorld(world);
        
    }
}
