SnowFlake[]frosty = new SnowFlake[1000];
void setup()
{
  size (400,400);
  background(0);
  for (int i=0; i<1000; i++)
  {
    frosty[i] = new SnowFlake((int)(Math.random()*401),0);
  }
  //your code here
}
void draw()
{
  for (int i=0; i<frosty.length; i++)
  {
    frosty[i].erase();
    frosty[i].lookDown();
    frosty[i].move();
    frosty[i].wrap();
    frosty[i].show();
   

  }

  //your code here
}
void mouseDragged()
{
  fill(254);
  noStroke();
  ellipse(mouseX,mouseY,60,60);
  //your code here
}

class SnowFlake
{
  int myX, myY;
  boolean isMoving; 
  int ranSiz=(int)((Math.random()*8)+1);
  //class member variable declarations
  SnowFlake(int x, int y)
  {
    myX=(int)(Math.random()*401);
    myY=(int)(Math.random()*395);
    isMoving=false;
    //class member variable initializations
  }
  void show()
  {
    noStroke();
    fill(255);
    ellipse(myX,myY,ranSiz,ranSiz);
    //your code here
  }
  void lookDown()
  {
    if (myY<400 && myY>0 && (get(myX, myY+7) != color(255)) && (get (myX, myY+8) != color (0)))
    {
      isMoving=false;
    }
    else 
    {
      isMoving=true;
    }
    //your code here
  }
  void erase()
  {
    fill(0);
    ellipse(myX,myY-1,ranSiz+6,ranSiz+6); 
    //your code here
  }
  void move()
  {
    if (isMoving)
    //your code here
  {
    myY++;
  }
  }
  void wrap()
  {
    if (myY>390)
    {
        myY=0;
        myX=(int)(Math.random()*395);
    }
    //your code here
  }
}


