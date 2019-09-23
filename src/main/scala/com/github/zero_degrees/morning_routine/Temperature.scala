package com.github.zero_degrees.morning_routine

trait Temperature

/**
 * As the name suggests, this represents the temperature.
 */
object Temperature {
    case object Hot extends Temperature
    case object Cold extends Temperature
    
    /**
     * Detect the current temperature from a string.
     * 
     * @param temperatureString The current temperature
     * 
     * @return The matching Temperature object
     */
    def fromString(temperatureString: String): Temperature =
        temperatureString.toUpperCase match {
            case "HOT" =>
                Hot
            case "COLD" =>
                Cold
            case _ =>
                throw new IllegalArgumentException("Invalid temperature: " + temperatureString)
        }
}