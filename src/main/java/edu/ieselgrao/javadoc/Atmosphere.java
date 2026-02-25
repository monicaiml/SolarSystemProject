package edu.ieselgrao.javadoc;
import java.time.LocalDate;

/**
 * @author <a href="https://github.com/monicaiml">monicaiml</a>
 */

public class Atmosphere {
    // Constants for error messages
    public static final String INVALID_COMPOSITION = "[ERROR] Composition cannot be null or empty";
    public static final String INVALID_LAST_OBSERVATION = "[ERROR] Last observation cannot be null or in the future";
    public static final String INVALID_PRESSURE = "[ERROR] Pressure cannot be negative";
    public static final String INVALID_DENSITY = "[ERROR] Density cannot be negative";

    // Attributes
    private String composition;
    private LocalDate lastObservation;
    private int airQuality;
    private double pressure;
    private double density;
    private boolean hasClouds;



     /**
     * The constructor in OOP is a special method that creates objects, in this case atmosphere.
     * It receives the following parameters:
     * @param composition      chemical elements present in the atmosphere
     * @param lastObservation  date of the last observation of the atmosphere
     * @param airQuality       numerically indicates the quality of the atmospheric air
     * @param pressure         numerically expresses the pressure of the atmosphere
     * @param density          numerically shows the density of the atmosphere
     * @param hasClouds        specifies the existence or absence of clouds in the atmosphere
     * From the atmosphere constructor, all attribute setters are called
     */

    // Constructor
    public Atmosphere(String composition, LocalDate lastObservation, int airQuality, double pressure, double density, boolean hasClouds) {
        setComposition(composition);
        setLastObservation(lastObservation);
        setAirQuality(airQuality);
        setPressure(pressure);
        setDensity(density);
        setHasClouds(hasClouds);
    }

    // Getters and setters
    public String getComposition() {
        return composition;
    }

    /**
     * This set method performs a validation.
     * This method receives the composition parameter.
     * @param composition  chemical elements present in the atmosphere
     *@throws IllegalArgumentException if the parameter received is null, contains spaces, is empty, or does not comply with the established pattern.
     */
    public void setComposition(String composition) {
        if (composition == null || composition.trim().isEmpty() || !composition.matches("[a-zA-Z0-9, ]+")) {
            throw new IllegalArgumentException(INVALID_COMPOSITION);
        }
        this.composition = composition;
    }

    public LocalDate getLastObservation() {
        return lastObservation;
    }
   /**
    *This set method performs a validation.
    *This method receives the lastObservation parameter.
    *@param  lastObservation date of the last observation of the atmosphere
    *@throws IllegalArgumentException if the parameter received is null or the observation date is after the current date
    */

    public void setLastObservation(LocalDate lastObservation) {
        // LocalDate.now() can be setted
        if (lastObservation == null || lastObservation.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException(INVALID_LAST_OBSERVATION);
        }
        this.lastObservation = lastObservation;
    }

    public int getAirQuality() {
        return airQuality;
    }

    /**
     *This set method assigns a value between [0,100] to air quality.
     *This method receives the airQuality parameter.
     *@param airQuality numerically indicates the quality of the atmospheric air
     */
    public void setAirQuality(int airQuality) {
        // Adjust to range [0, 100]
        if (airQuality < 0) {
            this.airQuality = 0;
        } else if (airQuality > 100) {
            this.airQuality = 100;
        } else {
            this.airQuality = airQuality;
        }
    }


    public double getPressure() {
        return pressure;
    }

    /**
     *This set method performs a validation.
     *This method receives the pressure parameter.
     *@param pressure   numerically expresses the pressure of the atmosphere
     *@throws IllegalArgumentException if the parameter received is negative
     */

    public void setPressure(double pressure) {
        if (pressure < 0) {
            throw new IllegalArgumentException(INVALID_PRESSURE);
        }
        this.pressure = pressure;
    }

    public double getDensity() {
        return density;
    }
    /**
     *This set method performs a validation.
     *This method receives the density parameter.
     *@param density  numerically shows the density of the atmosphere
     *@throws IllegalArgumentException if the parameter received is negative
     */

    public void setDensity(double density) {
        if (density < 0) {
            throw new IllegalArgumentException(INVALID_DENSITY);
        }
        this.density = density;
    }
    public boolean hasClouds() {
        return hasClouds;
    }

    /**
     *This set method assigns a value to the attribute.
     *This method receives the hasClouds parameter.
     *@param hasClouds specifies the existence or absence of clouds in the atmosphere
     */
    public void setHasClouds(boolean hasClouds) {
        this.hasClouds = hasClouds;
    }

}
