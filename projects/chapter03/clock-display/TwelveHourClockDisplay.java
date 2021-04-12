/**
 * A 12-hour kind of ClockDisplay.
 *
 * @author Julian Canepa
 * @updated Feb 5, 2021
 */
public class TwelveHourClockDisplay extends ClockDisplay
{
    private boolean isAm;

    public TwelveHourClockDisplay()
    {
        super();
	isAm = true;
        this.updateDisplay();
    }
    
    public TwelveHourClockDisplay(int hour, int minute)
    {
        super(hour, minute);
        isAm = (hour < 12);
    }
    
    /**
     * Update the display of the 12-hour clock.
     * Overwrites super class method of the same name.
     */
    private void updateDisplay()
    {
        int hour;
        
        if (hours.getValue() == 0 || hours.getValue() == 12) {
            hour = 12;
        } else {
            hour = hours.getValue() % 12;
        }

        String timeOfDay = isAm ? " AM" : " PM";

        displayString = hour + ":" + minutes.getDisplayValue() + ":" + 
                        seconds.getDisplayValue() + timeOfDay;
    }

    /**
     * Increment the clock by one minute.
     * Overwrites super class method of the same name.
     */
    public void timeTick()
    {
        seconds.increment();

        if (seconds.getValue() == 0) {
            minutes.increment();

            if (minutes.getValue() == 0) {
                hours.increment();
                if (hours.getValue() == 0 || hours.getValue() == 12) {
                    isAm = !isAm;
                }
            }
        }

        updateDisplay();
    }

    /**
     * Set the time by the specified hour and minute, updating the time of day field.
     * Overwrites super class method of the same name.
     */
    public void setTime(int hour, int minute)
    {
        hours.setValue(hour);
        minutes.setValue(minute);

        this.isAm = (hour < 12);

        updateDisplay();
    }
}
