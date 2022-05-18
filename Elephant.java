import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Elephant extends Actor
{
    private GreenfootImage[] rightImages;
    private GreenfootImage[] leftImages;
    private SimpleTimer animTimer;
    private int delay = 0;
    private boolean isFacingRight = true;
    
    public Elephant(){
        //GreenfootImage image = new GreenfootImage("images/elephant_idle/idle0.png");
        rightImages = new GreenfootImage[8];
        leftImages = new GreenfootImage[8];
        for(int i = 0; i < rightImages.length; i++){
            rightImages[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            rightImages[i].scale(100,100);
            leftImages[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            leftImages[i].mirrorHorizontally();
            leftImages[i].scale(100,100);
        }
        setImage(rightImages[3]);
        animTimer = new SimpleTimer();
        animTimer.mark();
    }
    
    int curIndex = 0;
    public void animate()
    {
        if(animTimer.millisElapsed() > 100){
            if(isFacingRight){
                setImage(rightImages[curIndex]);
            } else {
                setImage(leftImages[curIndex]);
            }
            curIndex++;
            curIndex %= 8;
            animTimer.mark();
        }
        
    }
    
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("a")){
            isFacingRight = false;
            move(-2);
        }
        if(Greenfoot.isKeyDown("d")){
            isFacingRight = true;
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
