import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Papyrus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Papyrus extends Actor
{
    private GreenfootImage myImage1 = getImage();
    private String[] imageNamesSide = {"PapyrusWalkS (1).png","PapyrusWalkS (2).png","PapyrusWalkS (3).png",};
    private String[] imageNamesUp = {"PapyrusWalkU (1).png","PapyrusWalkU (2).png","PapyrusWalkU (3).png",};
    private String[] imageNamesDown = {"PapyrusWalkD (1).png","PapyrusWalkD (2).png","PapyrusWalkD (3).png"};
    private int currentImage = 0;
    int xPos;
    int yPos;
    
    int speed = 4;
    int frame = 0;
    int animationSpeed = 10;
    int CharachterSize = 3;
    
    public void addedToWorld(World w)
    {
        xPos = getX();
        yPos = getY();
    }
    /**
     * Act - do whatever the Papyrus wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        frame++;
        if(Greenfoot.isKeyDown("up"))
        {
           setLocation(getX(),getY()-speed);
           if (frame % animationSpeed == 0) {
               animateOnMoveUp();
            }
        }    
        if(Greenfoot.isKeyDown("down"))
        {
           setLocation(getX(),getY()+speed);
           if (frame % animationSpeed == 0) {
               animateOnMoveDown();
            }
        }  
        if(Greenfoot.isKeyDown("left"))
        {
           setLocation(getX()-speed,getY());
           if (frame % animationSpeed == 0) {
               animateOnMoveSide();
            }
        }  
        if(Greenfoot.isKeyDown("right"))
        {
           setLocation(getX()+speed,getY());
           if (frame % animationSpeed == 0) {
               animateOnMoveSide();
            }
        }  
        if(Greenfoot.isKeyDown("q"))
        {
           turn(30);
        }  
        //animateOnMove();
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
    public Papyrus ()
    {
        GreenfootImage myImage = getImage ();
        int myNewHeight = (int)myImage.getHeight() *CharachterSize;
        int myNewWidth = (int)myImage.getWidth() *CharachterSize;
        myImage.scale(myNewWidth, myNewHeight);
    }
}
