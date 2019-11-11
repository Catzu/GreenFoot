import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CopyOfSans here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sans extends Actor
{
    private GreenfootImage myImage1 = getImage();
    private String[] imageNamesSide = {"SansWalkR (1).png","SansWalkR (2).png","SansWalkR (3).png"};
    private String[] imageNamesUp = {"SansWalkU (1).png","SansWalkU (2).png","SansWalkU (3).png"};
    private String[] imageNamesDown = {"SansWalkD (1).png","SansWalkD (2).png","SansWalkD (3).png"};
    private int currentImage = 0;
    int xPos;
    int yPos;
    String facingDirection = "down";
    
    //charachter properties
    int speed = 4;
    int frame = 0;
    int animationSpeed = 10;
    int CharachterSize = 3;
    int playerHp = 10;
    
    //?
    int FireBallSize = 2;
    
    boolean touchingEnemyTest = false;
    
    public static int sansX, sansY;
    
    public void addedToWorld(World w)
    {
        xPos = getX();
        yPos = getY();
    }
    /**
     * Act - do whatever the CopyOfSans wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        sansY = getY();
        sansX = getX();
        hitEnemyTest();
        lost();
        
        frame++;
        if(Greenfoot.isKeyDown("w"))
        {
            facingDirection = "up";
           setLocation(getX(),getY()-speed);
           if (frame % animationSpeed == 0) {
               animateOnMoveUp();
            }
        }    
        if(Greenfoot.isKeyDown("s"))
        {
            facingDirection = "down";
           setLocation(getX(),getY()+speed);
           if (frame % animationSpeed == 0) {
               animateOnMoveDown();
            }
        }  
        if(Greenfoot.isKeyDown("a"))
        {
            facingDirection = "left";
           setLocation(getX()-speed,getY());
           if (frame % animationSpeed == 0) {
               animateOnMoveSide();
            }
        }  
        if(Greenfoot.isKeyDown("d"))
        {
            facingDirection = "right";
           setLocation(getX()+speed,getY());
           if (frame % animationSpeed == 0) {
               animateOnMoveSide();
            }
        }  
        if(Greenfoot.isKeyDown("q"))
        {
           //turn(30);
        }  
        if ("space".equals(Greenfoot.getKey()))
        {
            fire();
        }
        //animateOnMove();
    }
    private void fire()
    {
        FireBall fireball = new FireBall();
        getWorld().addObject(fireball, getX(), getY());
        switch (facingDirection) {
            case "up": fireball.setRotation(270); break;
            case "down": fireball.setRotation(90); break;
            case "right": fireball.setRotation(0); break;
            case "left": fireball.setRotation(180); break;
        }
        
        fireball.move(40.0);
    }
    private void animateOnMoveSide()
    {
        if(getX()!=xPos|| getY()!=yPos)
        {
            currentImage++;
            if(currentImage >= imageNamesSide.length)
                currentImage=0;
                
            GreenfootImage newImage = new GreenfootImage(imageNamesSide[currentImage]);
            
            if(getX()<xPos)
                newImage.mirrorHorizontally();
                
            setImage(newImage);
            myImage1=getImage();
            
            GreenfootImage myImage = getImage ();
            int myNewHeight = (int)myImage.getHeight() *CharachterSize;
            int myNewWidth = (int)myImage.getWidth() *CharachterSize;
            myImage.scale(myNewWidth, myNewHeight);
        }
        xPos=getX();
        yPos=getY();
    }
    private void animateOnMoveUp()
    {
        if(getX()!=xPos|| getY()!=yPos)
        {
            currentImage++;
            if(currentImage >= imageNamesUp.length)
                currentImage=0;
                
            GreenfootImage newImage = new GreenfootImage(imageNamesUp[currentImage]);
            
            if(getX()<xPos)
                newImage.mirrorHorizontally();
                
            setImage(newImage);
            myImage1=getImage();
            
            GreenfootImage myImage = getImage ();
            int myNewHeight = (int)myImage.getHeight() *CharachterSize;
            int myNewWidth = (int)myImage.getWidth() *CharachterSize;
            myImage.scale(myNewWidth, myNewHeight);
        }
        xPos=getX();
        yPos=getY();
    }
    private void animateOnMoveDown()
    {
        if(getX()!=xPos|| getY()!=yPos)
        {
            currentImage++;
            if(currentImage >= imageNamesDown.length)
                currentImage=0;
                
            GreenfootImage newImage = new GreenfootImage(imageNamesDown[currentImage]);
            
            if(getX()<xPos)
                newImage.mirrorHorizontally();
                
            setImage(newImage);
            myImage1=getImage();
            
            GreenfootImage myImage = getImage ();
            int myNewHeight = (int)myImage.getHeight() *CharachterSize;
            int myNewWidth = (int)myImage.getWidth() *CharachterSize;
            myImage.scale(myNewWidth, myNewHeight);
        }
        xPos=getX();
        yPos=getY();
    }
    public void hitEnemyTest()
    {
        Actor EnemyTest = getOneIntersectingObject(EnemyTest.class);
        if (EnemyTest !=null){
        getWorld().removeObject(EnemyTest);
        ((BG)getWorld()).HealthBar.loseHealth();
        playerHp--;
        }
    }
    public void lost()
    {
        if (playerHp == 0)
        {
            Greenfoot.stop();
            getWorld().addObject(new GameOver(), 600, 350);
        }
    }
    public Sans ()
    {
        GreenfootImage myImage = getImage ();
        int myNewHeight = (int)myImage.getHeight() *CharachterSize;
        int myNewWidth = (int)myImage.getWidth() *CharachterSize;
        myImage.scale(myNewWidth, myNewHeight);
    }
}
