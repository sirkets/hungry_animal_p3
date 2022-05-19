import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Apple extends Actor
{
    private int speed = 1;
    
    public void act()
    {
        // Add your action code here.
        int x = getX();
        int y = getY();
        setLocation(x, y + speed);
        
        MyWorld world = (MyWorld) getWorld();
        
        if(getY() >= world.getHeight())
        {
            world.gameOver();
            world.removeObject(this);
        }
    }
}
