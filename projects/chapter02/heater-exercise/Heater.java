
/**
 * The heater class models a thermostat device.
 *
 * @author Julian Canepa
 * @version 2.1.2021
 */
public class Heater
{
    private double temperature;
    private double increment;
    private double minTemp;
    private double maxTemp;

    public Heater(double increment, double minTemp, double maxTemp)
    {
        this.temperature = 15.0;
        this.increment = increment;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }

    /**
     * Increase the temperature by a number of degrees.
     */
    public void warmer()
    {
        double requested = temperature + increment;
        
        if (!(requested > maxTemp)) {
            temperature += increment;
        }
    }
    
    /**
     * Decrease the temperature by a number of degrees.
     */
    public void cooler()
    {
        double requested = temperature - increment;
        
        if (!(requested < minTemp)) {
            temperature -= increment;
        }
    }
    
    /**
     * Get the current temperature.
     */
    public double getTemperature()
    {
        return temperature;
    }
    
    public void setIncrement(double increment)
    {
        if (increment > 0) {
            this.increment = increment;
        }
    }
}
