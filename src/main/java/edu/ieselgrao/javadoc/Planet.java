package edu.ieselgrao.javadoc;
import java.time.LocalDate;

/**
 * @author <a href="https://github.com/monicaiml">monicaiml</a>
 */
public class Planet {
    // Constants for error messages
    public static final String INVALID_NAME = "[ERROR] Name cannot be null or empty";
    public static final String INVALID_NUMBER_OF_MOONS = "[ERROR] Number of moons cannot be negative";
    public static final String INVALID_MASS = "[ERROR] Mass cannot be less than 10e23 kg";
    public static final String INVALID_RADIUS = "[ERROR] Radius cannot be less than 500 km";
    public static final String INVALID_GRAVITY = "[ERROR] Gravity cannot be negative or zero";
    public static final String INVALID_LAST_ALBEDO_MEASUREMENT = "[ERROR] Last albedo measurement cannot be null or in the future";
    public static final String INVALID_PLANET_TYPE = "[ERROR] Invalid planet type";

    // Constants for minimum values
    private static final double MIN_MASS = 5.97e22;
    private static final double MIN_RADIUS = 500;

    // Attributes
    private String name;
    private int numberOfMoons;
    private double mass;
    private double radius;
    private double gravity;
    private LocalDate lastAlbedoMeasurement;
    private boolean hasRings;
    private Atmosphere atmosphere;
    private PlanetType type;



     /**
     * The basic constructor creates objects, in this case planet.
     * It receives the following parameters:
     * @param name                     specifies the name of the planet
     * @param numberOfMoons            number of moons has the planet
     * @param mass                     numerically indicates the mass of the planet
     * @param radius                   expresses the radius of the planet
     * @param gravity                  indicates the gravity of the planet
     * @param lastAlbedoMeasurement    shows the date the last measurement was taken
     * @param hasRings                 shows how many rings has the planet
     * @param type                     indicates what type of planet it is
     * From the planet constructor, all attribute setters are called
     */
    // Basic constructor
    public Planet(String name, int numberOfMoons, double mass, double radius, double gravity, LocalDate lastAlbedoMeasurement, boolean hasRings, PlanetType type) {
        setName(name);
        setNumberOfMoons(numberOfMoons);
        setMass(mass);
        setRadius(radius);
        setGravity(gravity);
        setLastAlbedoMeasurement(lastAlbedoMeasurement);
        setHasRings(hasRings);
        setType(type);

        atmosphere = null;
    }


     /**
     * This is another constructor that creates planets too.
     * It receives the following parameters:
     * @param name                     specifies the name of the planet
     * @param numberOfMoons            number of moons has the planet
     * @param mass                     numerically indicates the mass of the planet
     * @param radius                   expresses the radius of the planet
     * @param gravity                  indicates the gravity of the planet
     * @param lastAlbedoMeasurement    shows the date the last measurement was taken
     * @param hasRings                 shows how many rings has the planet
     * @param type                     indicates what type of planet it is
     * From the planet constructor, all attribute setters are called
     * There is inheritance between the Atmosphere class and the Planet class.
     * Planet class receives the attributes composition, lastObservation, airQuality, pressure, density, hasClouds from Atmosphere class.
     * @throws Exception if it has not received the attributes from the Atmosphere class correctly
     */
    // Detailed constructor with atmosphere
    public Planet(String name, int numberOfMoons, double mass, double radius, double gravity, LocalDate lastAlbedoMeasurement, boolean hasRings, PlanetType type, String composition, LocalDate lastObservation, int airQuality, double pressure, double density, boolean hasClouds) {
        setName(name);
        setNumberOfMoons(numberOfMoons);
        setMass(mass);
        setRadius(radius);
        setGravity(gravity);
        setLastAlbedoMeasurement(lastAlbedoMeasurement);
        setHasRings(hasRings);
        setType(type);

        try {
            setAtmosphere(composition, lastObservation, airQuality, pressure, density, hasClouds);
        } catch (IllegalArgumentException e) {
            this.atmosphere = null;
        }
    }

    // Getters and setters
    public String getName() {
        return name;
    }

/**
 * This set method performs a validation.
 * This method receives the name parameter.
 * @param name specifies the name of the planet
 *@throws IllegalArgumentException if the parameter received is null or contains spaces and is empty.
 */
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_NAME);
        }
        this.name = name;
    }

    public int getNumberOfMoons() {
        return numberOfMoons;
    }

    /**
     *This set method performs a validation.
     *This method receives the number of moons  parameter.
     *@param numberOfMoons  number of moons has the planet
     *@throws IllegalArgumentException if the parameter received is negative
     */
    public void setNumberOfMoons(int numberOfMoons) {
        if (numberOfMoons < 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_MOONS);
        }
        this.numberOfMoons = numberOfMoons;
    }

    public double getMass() {
        return mass;
    }
    /**
     *This set method performs a validation.
     *This method receives mass parameter.
     *@param mass numerically indicates the mass of the planet
     *@throws IllegalArgumentException if the received mass value is less than the minimum allowed mass
     */

    public void setMass(double mass) {
        if (mass < MIN_MASS) {
            throw new IllegalArgumentException(INVALID_MASS);
        }
        this.mass = mass;
    }
    public double getRadius() {
        return radius;
    }
    /**
     *This set method performs a validation.
     *This method receives radius parameter.
     *@param radius  expresses the radius of the planet
     *@throws IllegalArgumentException if the received radius value is less than the minimum allowed radius
     */

    public void setRadius(double radius) {
        if (radius < MIN_RADIUS) {
            throw new IllegalArgumentException(INVALID_RADIUS);
        }
        this.radius = radius;
    }
    public double getGravity() {
        return gravity;
    }
    /**
     *This set method performs a validation.
     *This method receives gravity parameter.
     *@param gravity indicates the gravity of the planet
     *@throws IllegalArgumentException if the parameter received less than or equal to zero
     */
    public void setGravity(double gravity) {
        if (gravity <= 0) {
            throw new IllegalArgumentException(INVALID_GRAVITY);
        }
        this.gravity = gravity;
    }
    public LocalDate getLastAlbedoMeasurement() {
        return lastAlbedoMeasurement;
    }

    /**
     *This set method performs a validation.
     *This method receives the lastAlbedoMeasurement parameter.
     *@param  lastAlbedoMeasurement shows the date the last measurement was taken
     *@throws IllegalArgumentException if the parameter received is null or the measurement date is after the current date
     */
    public void setLastAlbedoMeasurement(LocalDate lastAlbedoMeasurement) {
        // last albedo measurement is allowed to be today (LocalDate.now())
        if (lastAlbedoMeasurement == null || lastAlbedoMeasurement.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException(INVALID_LAST_ALBEDO_MEASUREMENT);
        }
        this.lastAlbedoMeasurement = lastAlbedoMeasurement;
    }

    public boolean hasRings() {
        return hasRings;
    }
    /**
     *This set method assigns a value to the attribute.
     *This method receives the hasRings parameter.
     *@param hasRings specifies the existence or absence of rings in the planet
     */
    public void setHasRings(boolean hasRings) {
        this.hasRings = hasRings;
    }
    public Atmosphere getAtmosphere() {
        return atmosphere;
    }

    /**
     *In this method, atmosphere objects are created
     * The Atmosphere and Planet classes have a composition relationship
     * The method receives the following parameters:
     * @param composition      chemical elements present in the atmosphere
     * @param lastObservation  date of the last observation of the atmosphere
     * @param airQuality       numerically indicates the quality of the atmospheric air
     * @param pressure         numerically expresses the pressure of the atmosphere
     * @param density          numerically shows the density of the atmosphere
     * @param hasClouds        specifies the existence or absence of clouds in the atmosphere
     */
    public void setAtmosphere(String composition, LocalDate lastObservation, int airQuality, double pressure, double density, boolean hasClouds) {
        // Can propagate IllegalArgumentException
        atmosphere = new Atmosphere(composition, lastObservation, airQuality, pressure, density, hasClouds);
    }

    public PlanetType getType() {
        return type;
    }
    /**
     *This set method performs a validation.
     *This method receives the type parameter.
     *@param  type indicates what type of planet it is
     *@throws IllegalArgumentException if the parameter received is null
     */
    public void setType(PlanetType type) {
        if (type == null) {
            throw new IllegalArgumentException(INVALID_PLANET_TYPE);
        }
        this.type = type;
    }





}
