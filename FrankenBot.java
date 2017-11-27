package Lashley_Rossi;
import robocode.*;
import static robocode.util.Utils.normalRelativeAngleDegrees;
import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

public class FrankenBot extends Robot
{
	public final double PERCENT_BUFFER = .20;

	public void run() {

	double width = this.getBattleFieldWidth();
	double height = this.getBattleFieldHeight();
	double buffer = PERCENT_BUFFER*Math.max(width, height);

	//Robot Main Loop
	while(true) {

	turnGunRight(50);
	double xPos = this.getX();
	double yPos = this.getY();
	
	if (yPos<buffer) //too close to bottom
	{
		System.out.println("Too close to bot");
		if((this.getHeading()<180)&&(this.getHeading()>90))
		{
			turnLeft(90);
			turnGunRight(90);
		}
	
		else if((this.getHeading()<270)&&(this.getHeading()>180))
		{
			turnRight(90);
			turnGunLeft(90);
		} 
	}
	
	else if (yPos>height-buffer) //too close to top
	{
		System.out.println("Too close to top");
		if ((this.getHeading()<90)&&(this.getHeading()>0))
		{
			turnRight(90);
			turnGunLeft(90);
		}
		else if((this.getHeading()<360)&&(this.getHeading()>270))
		{
			turnLeft(90);
			turnGunRight(90);
		}
	}
	
	else if (xPos<buffer) //too close to left
	{
		System.out.println("Too close to left");
		if ((this.getHeading()<360)&&(this.getHeading()>270))
		{
			turnRight(90);
			turnGunLeft(90);
		}
		else if((this.getHeading()<270)&&(this.getHeading()>180))
		{
			turnLeft(90);
			turnGunRight(90);
		}
	}
	
	else if (xPos>width-buffer) //too close to right
	{
		System.out.println("Too close to right");
		if ((this.getHeading()<90)&&(this.getHeading()>0))
		{
			turnLeft(90);
			turnGunRight(90);
		}
		
		else if((this.getHeading()<180)&&(this.getHeading()>90))
		{
			turnRight(90);
			turnGunLeft(90);
		}
	}

	else
	{
		turnRight(0);
		turnLeft(0);
	} 
	ahead(10);
	}
}


public void onScannedRobot(ScannedRobotEvent e) {

	//colors
	if(getEnergy()>50)
		setColors(Color.blue,Color.blue,Color.blue); // body,gun,radar
	else if(getEnergy()>20)
		setColors(Color.yellow, Color.yellow, Color.yellow);
	else
		setColors(Color.red, Color.red, Color.red);
		
		
	double absoluteBearing = getHeading() + e.getBearing();
	double bearingFromGun = normalRelativeAngleDegrees(absoluteBearing - getGunHeading());

	if (Math.abs(bearingFromGun) <= 3)
	{
		turnGunLeft(bearingFromGun);
	
		if(e.getDistance()<=100) 
			fire(3);
		else if(e.getDistance()<=300)
			fire(2);
		else if(e.getDistance()>300)
			fire(1);
	}

	else 
	{
		turnGunRight(bearingFromGun);
	}

	if (bearingFromGun == 0) 
	{
		scan();
	}


}


public void onHitByBullet(HitByBulletEvent e) {

	double ang = e.getHeading() + 90;
	ang = getHeading() - ang;
	turnLeft(ang);
	ahead(100);
}


public void onHitWall(HitWallEvent e) {
	turnLeft(e.getBearing() + 180);
	ahead(100);
} 

}