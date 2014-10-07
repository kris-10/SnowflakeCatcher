import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class SnowflakeCatcher extends PApplet {

SnowFlake[]frosty = new SnowFlake[1000];
public void setup()
{
  size (400,400);
  background(0);
  for (int i=0; i<1000; i++)
  {
    frosty[i] = new SnowFlake((int)(Math.random()*401),0);
  }
  //your code here
}
public void draw()
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
public void mouseDragged()
{
  fill(254);
  noStroke();
  ellipse(mouseX,mouseY,40,40);
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
  public void show()
  {
    noStroke();
    fill(255);
    ellipse(myX,myY,ranSiz,ranSiz);
    //your code here
  }
  public void lookDown()
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
  public void erase()
  {
    fill(0);
    ellipse(myX,myY-1,ranSiz+4,ranSiz+4); 
    //your code here
  }
  public void move()
  {
    if (isMoving)
    //your code here
  {
    myY++;
  }
  }
  public void wrap()
  {
    if (myY>390)
    {
        myY=0;
        myX=(int)(Math.random()*395);
    }
    //your code here
  }
}


  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "SnowflakeCatcher" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
