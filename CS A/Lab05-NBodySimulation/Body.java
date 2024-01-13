public class Body
{
   public static final double G = 6.67E-11;  //Newtons' gravitational constant

   private double x, y; //planet's x and y coordinate position
   private double xVelocity, yVelocity;
   private double mass;
   private double xNetForce, yNetForce; //net forces action on this planet
   private double xAccel, yAccel;
   private String image; //image of this planet (for drawing)

   public Body()
   {
       x = y = xVelocity = yVelocity = mass = 0;
    }
   public Body(double iX, double iY, double xV, double yV, double m, String i)
   {
       x = iX;
       y = iY;
       xVelocity = xV;
       yVelocity = yV;
       mass = m;
       image = i;
    }
    
   public double getMass()
   {
       return mass;
   }
   public double getX()
   {
       return x;
   }
   public double getY()
   {
       return y;
   }
   
   public double getDistance(Body other)
   {
      double xD = other.x - x;
      double yD = other.y - y;
      double distance = Math.sqrt(Math.pow(xD, 2) + Math.pow(yD, 2));
      return distance;
   }
   double getPairwiseForceX(Body other)
   {
       double force = ((mass * other.mass) * G) / Math.pow(this.getDistance(other), 2);
       double pairwiseX = force * ((other.x - x) / this.getDistance(other));
       return pairwiseX;
   }
   double getPairwiseForceY(Body other)
   {
       double force = ((mass * other.mass) * G) / Math.pow(this.getDistance(other), 2);
       double pairwiseY = force * ((other.y - y) / this.getDistance(other));
       return pairwiseY;
   }

    // calculates / sets the net force exerted on this body by all the (input) bodies */
   public void setNetForce(Body[] bodies)
   {
       double netForceX = 0, netForceY = 0;
       for (int i = 0; i < bodies.length; i++)
       {
           if (this == bodies[i])
                continue;
           netForceX += getPairwiseForceX(bodies[i]);
           netForceY += getPairwiseForceY(bodies[i]);
       }
       xNetForce = netForceX;
       yNetForce = netForceY;
   }

    /** updates this body's accel, vel, and position, given the time step */
   public void update(double dt)
   {
       xAccel = xNetForce / mass;
       yAccel = yNetForce / mass;
       xVelocity = xVelocity + xAccel * dt;
       yVelocity = yVelocity + yAccel * dt;
       x += xVelocity * dt;
       y += yVelocity * dt;
   }

    /** Draws the body using the StdDraw library file's drawing method */
   public void draw()
   {
      StdDraw.picture(x, y, image);
   }
}
