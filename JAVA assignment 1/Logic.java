package mooc.vandy.java4android.shapes.logic;

import mooc.vandy.java4android.shapes.ui.OutputInterface;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early
 * Android interactions.  Designing the assignments this way allows
 * you to first learn key 'Java' features without having to beforehand
 * learn the complexities of Android.
 *
 */
public class Logic 
       implements LogicInterface {
    /**
     * This is a String to be used in Logging (if/when you decide you
     * need it for debugging).
     */
    public static final String TAG = 
        Logic.class.getName();

    /*
     * This is the variable that stores our OutputInterface instance.
     * <p>
     * This is how we will interact with the User Interface [MainActivity.java].
     * <p>
     * It is called 'out' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'out' is good enough)
     */
    private OutputInterface mOut;

    /**
     * These are the numeric values that you will receive from the
     * User Interface and use in your calculations.
     */
    private static double mRadius = 0;
    private static double mLength = 0;
    private static double mWidth = 0;
    private static double mHeight = 0;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance
     * (which implements [OutputInterface]) to 'out'
     */
    public Logic(OutputInterface out){
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labeled 'Process...' is pressed.
     */
    @Override
    public void process() {
        // Get which calculation should be computed.  Do not worry
        // about the specifics of this right now.
        Shapes shapeForCalculations = mOut.getShape();

        // Store the values returned by the User Interface.
        mLength = mOut.getLength();
        mWidth = mOut.getWidth();
        mHeight = mOut.getHeight();
        mRadius = mOut.getRadius();

        // Determine which calculation to process right now.  Again,
        // do not worry about the specifics of how this works for now.
        switch (shapeForCalculations) {
            case Box:
                mOut.print("A " 
                           + mLength 
                           + " by " 
                           + mWidth 
                           + " by " 
                           + mHeight 
                           + " box has a volume of: ");
                mOut.println("" 
                             + String.format("%.2f",
                                             boxVolume(mLength, mWidth, mHeight)));
                mOut.println("");

                mOut.print("A " 
                           + mLength 
                           + " by " 
                           + mWidth 
                           + " by " 
                           + mHeight 
                           + " box has a surface area of: ");
                mOut.println("" 
                             + String.format("%.2f",
                                             boxSurfaceArea(mLength, mWidth, mHeight)));
                mOut.println("");
                // If you are paying attention, you will notice that
                // there is no 'break;' here like there is in other
                // places, meaning that if 'Box' was selected, it will
                // run the two sets of print statements above and the
                // two statements below until the 'break;' statement.
            case Rectangle:
                mOut.print("A " 
                           + mLength 
                           + " by " 
                           + mWidth 
                           + " rectangle has a perimeter of: ");
                mOut.println("" + String.format("%.2f", 
                                                rectanglePerimeter(mLength, mWidth)));
                mOut.println("");

                mOut.print("A " 
                           + mLength 
                           + " by " 
                           + mWidth 
                           + " rectangle has area of: ");
                mOut.println("" + String.format("%.2f", rectangleArea(mLength, mWidth)));
                mOut.println("");
                break;
            case Sphere:
                mOut.print("A sphere with radius " + mRadius + " has a volume of: ");
                mOut.println("" + String.format("%.2f", sphereVolume(mRadius)));
                mOut.println("");

                mOut.print("A sphere with radius " + mRadius + " has surface area of: ");
                mOut.println("" + String.format("%.2f", sphereSurfaceArea(mRadius)));
                mOut.println("");
                // Same here as with 'Box' above. If 'Sphere' is picked, it will run the
                // two sets of print statements above and the two below until the 'break;'
            case Circle:
                mOut.print("A circle with radius " + mRadius + " has a perimeter of: ");
                mOut.println("" + String.format("%.2f", circleCircumference(mRadius)));
                mOut.println("");

                mOut.print("A circle with radius " + mRadius + " has area of: ");
                mOut.println("" + String.format("%.2f", circleArea(mRadius)) );
                mOut.println("");
                break;
            case Triangle:
                mOut.print("A right triangle with base " 
                           + mLength 
                           + " and height " 
                           + mWidth + " has a perimeter of: ");
                mOut.println("" 
                             + String.format("%.2f", rightTrianglePerimeter(mLength,
                                                                       mWidth)));
                mOut.println("");

                mOut.print("A right triangle with base " 
                           + mLength 
                           + " and height " 
                           + mWidth 
                           + " has area of: ");
                mOut.println("" 
                             + String.format("%.2f", rightTriangleArea(mLength,
                        mWidth)));
                mOut.println("");
                break;
            default:
                break;
        }
    }

    // TODO -- add your code here

    public static double rectangleArea(double length, double width)
    {
        double rectangleLength=length;
        double rectangleWidth=width;
        double areaRectangle;
        areaRectangle= rectangleLength*rectangleWidth;
        return areaRectangle;

    }

    public static double rectanglePerimeter(double length, double width)
    {
        double rectangleLength=length;
        double rectangleWidth=width;
        double perimeterRectangle;
        perimeterRectangle= 2*(rectangleLength+rectangleWidth);
        return perimeterRectangle;

    }

    public static double circleArea(double radius)
    {
        double circleRadius =radius;
        double areaCircle ;
        areaCircle = Math.PI * Math.pow(circleRadius,2);
        return areaCircle;

    }

    public static double circleCircumference(double radius)
    {
        double circleRadius =radius;
        double circumferenceCircle ;
        circumferenceCircle = 2* Math.PI * circleRadius;
        return circumferenceCircle;
    }
    public static double rightTriangleArea(double base, double height)
    {
        double triangleBase=base;
        double triangleHeight=height;
        double rightTriangleArea = (triangleBase*triangleHeight)/2;
        return rightTriangleArea;
    }

    public static double rightTrianglePerimeter(double base, double height)
    {
        double triangleBase=base;
        double triangleHeight=height;
        double squareAdd = Math.pow(triangleBase,2)+ Math.pow(triangleHeight,2);
        double rightTrianglePerimeter = triangleBase+triangleHeight+ Math.sqrt(squareAdd);
        return rightTrianglePerimeter;
    }
    public static double boxVolume(double length, double width, double depth)
    {
        double boxLength=length;
        double boxWidth = width;
        double boxDepth = depth;
        double boxVolume = boxDepth*boxLength*boxWidth;
        return boxVolume;
    }

    public static double boxSurfaceArea(double length, double width,double depth)
    {
        double boxLength=length;
        double boxWidth = width;
        double boxDepth = depth;
        double boxSurfacearea = 2*(boxLength*boxWidth)+2*(boxWidth*boxDepth)+2*(boxDepth*boxLength);
        return boxSurfacearea;

    }

    public static double sphereVolume(double radius)
    {
        double sphereRadius=radius;
        double sphereVolume = (4.0/3.0)*Math.PI*Math.pow(sphereRadius,3);
        return sphereVolume;
    }

    public static double sphereSurfaceArea(double radius)
    {
        double sphereRadius=radius;
        double sphereSurfaceArea = 4*Math.PI*Math.pow(sphereRadius,2);
        return sphereSurfaceArea;
    }



}
