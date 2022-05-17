import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Elephant extends Actor
{
    private GreenfootImage[] images;
    
    public Elephant(){
        //GreenfootImage image = new GreenfootImage("images/elephant_idle/idle0.png");
        images = new GreenfootImage[8];
        images[0] = new GreenfootImage("images/elephant_idle/idle0.png");
        for(int i = 0; i < images.length; i++){
            images[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
        }
        setImage(images[3]);
    }
    
    int curIndex = 0;
    public void animate()
    {
        setImage(images[curIndex]);
        curIndex++;
        curIndex %= 8;
    }
    
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("a")){
            move(-2);
        }
        if(Greenfoot.isKeyDown("d")){
            move(2);
        }
        
        eat();
        animate();
    }
    
    public void eat()
    {
        if(isTouching(Apple.class)){
            Greenfoot.playSound("sounds/elephantcub.mp3");
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.increaseScore();
            world.spawnApple();
        }
    }
}
