package edu.ieselgrao.javadoc;
import java.time.LocalDate;

/**
 * @author <a href="https://github.com/monicaiml">monicaiml</a>
 */
public class SolarSystem {
    // Constants for error messages
    public static final String INVALID_NAME = "[ERROR] Name cannot be null, contain only spaces or have less than 3 characters";
    public static final String INVALID_NUMBER_OF_STARS = "[ERROR] Number of stars cannot be less than 1";
    public static final String INVALID_RADIUS = "[ERROR] Radius cannot be less or equal to 0";
    public static final String INVALID_REGISTRATION_DATE = "[ERROR] Registration date cannot be null or in the future";
    public static final String INVALID_LAST_PLANET_ADDED = "[ERROR] Last planet date added cannot be in the future";
    public static final String INVALID_MAX_PLANETS = "[ERROR] Maximum number of planets reached";
    public static final String PLANET_NULL = "[ERROR] Planet cannot be null";
    public static final String PLANET_ALREADY_EXISTS = "[ERROR] This planet already exists";
    public static final String PLANET_NOT_FOUND = "[ERROR] This planet does not exist";

    private static final int MIN_NAME_LENGTH = 3;

    // Private atributtes
    private final int MAX_PLANETS;
    private int id;
    private static int nextId = 1;
    private String name;
    private int numberOfStars;
    private double radius;
    private LocalDate registrationDate;
    private LocalDate lastPlanetAdded;
    private int numPlanets;
    private int sumMoons;
    private Planet[] planets;


     /**
     * The constructor creates objects, in this case solar system.
     * It receives the following parameters:
     * @param name                     specifies the name of the solar system
     * @param numberOfStars            number of stars has the solar system
     * @param radius                   expresses the radius of the solar system
     * @param registrationDate         shows the date the registration was taken
     * @param maxPlanets               shows how many planets has the system solar
     * The setters for the attributes name, numberOfStars, radius, and registrationDate are called from the constructor.
     * The parameter maxPlanets is assigned a constant.
     * An array of planets with a fixed (constant) size is created.
     * The methods setId and incNextId are called from the constructor.
     * numPlanets and sumMoons are counters and are initialised to zero.
     */

    public SolarSystem(String name, int numberOfStars, double radius, LocalDate registrationDate, int maxPlanets) {
        setName(name);
        setNumberOfStars(numberOfStars);
        setRadius(radius);
        setRegistrationDate(registrationDate);
        MAX_PLANETS = maxPlanets;
        planets = new Planet[MAX_PLANETS];
        setId();
        incNextId();
        numPlanets = 0;
        sumMoons = 0;

    }

    public int getId() {
        return id;
    }
    /**
     * This method stores a numeric attribute in a local variable.
     * This method is called from the constructor.
     */
    public void setId() {
        id = nextId;
    }
    public static int getNextId() {
        return nextId;
    }

    /**
     * This method is static (belongs to the class) and increases the value of the nextId attribute by 1 each time it is called by the constructor.
     */
    public static void incNextId() {
        nextId++;
    }
    public String getName() {
        return name;
    }
    /**
     * This set method performs a validation.
     * This method receives the name parameter.
     * @param name specifies the name of the solar system
     *@throws IllegalArgumentException if the name received is null or shorter than the established length.
     */
    public void setName(String name) {
        if (name == null || name.trim().length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_NAME);
        }
        this.name = name.trim();
    }
    public int getNumberOfStars() {
        return numberOfStars;
    }

 /**
 *This set method performs a validation.
 *This method receives the number of stars parameter.
 *@param numberOfStars  number of stars has the solar system
 *@throws IllegalArgumentException if the parameter received is less than one
 */
    public void setNumberOfStars(int numberOfStars) {
        if (numberOfStars < 1) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_STARS);
        }
        this.numberOfStars = numberOfStars;
    }
    public double getRadius() {
        return radius;
    }

    /**
     *This set method performs a validation.
     *This method receives radius parameter.
     *@param radius indicates the radius of the solar system
     *@throws IllegalArgumentException if the parameter received less than or equal to zero
     */
    public void setRadius(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException(INVALID_RADIUS);
        }
        this.radius = radius;
    }
    public LocalDate getRegistrationDate() {
        return registrationDate;
    }
    /**
     *This set method performs a validation.
     *This method receives the registrationDate parameter.
     *@param  registrationDate shows the date the last registration was taken
     *@throws IllegalArgumentException if the parameter received is null or the registration date is after the current date
     */
    public void setRegistrationDate(LocalDate registrationDate) {
         if (registrationDate == null || registrationDate.isAfter(LocalDate.now())) {
             throw new IllegalArgumentException(INVALID_REGISTRATION_DATE);
         }
         this.registrationDate = registrationDate;
    }
    public LocalDate getLastPlanetAdded() {
        return lastPlanetAdded;
    }

    /**
     * The Planet class has an aggregation relationship with the Solar System class.
     * This method receives the lastPlanetAdded parameter.
     * @param lastPlanetAdded shows a date  when the last planet was added.
     *This method checks that the lastPlanetAdded attribute is not null.
     * @throws IllegalArgumentException if lastPlanetAdded is not null and attempts to add the planet after the current date.
     */
    public void setLastPlanetAdded(LocalDate lastPlanetAdded) {
        // If last planet is null no planet is updated but no exception is thrown
        if (lastPlanetAdded != null) {
            if (lastPlanetAdded.isAfter(LocalDate.now())) {
                throw new IllegalArgumentException(INVALID_LAST_PLANET_ADDED);
            }
            this.lastPlanetAdded = lastPlanetAdded;
        }
    }

    public int getDaysFromLastPlanetAdded() {
        if (lastPlanetAdded == null) {
            return -1;
        }
        return lastPlanetAdded.until(LocalDate.now()).getDays();
    }

    public int getMaxPlanets(){
        return MAX_PLANETS;
    }
    public Planet[] getPlanets(){
        return planets;
    }
    public int getNumPlanets() {
        return numPlanets;
    }
    /**

     * @param planet is the planet object.
     *This method checks that the planet received is not null. If the planet is not null, it checks that the added planet is not a duplicate.
     * @throws NullPointerException if planet is null
     * @return the position of the planet (within the array) if another with the same name has been found, or -1 if the planet is not a duplicate.
     */
    public int findPlanet(Planet planet){

        if (planet == null) {
            throw new NullPointerException(PLANET_NULL);
        }
        for (int i = 0; i < MAX_PLANETS; i++) {
             if (planet.equals(planets[i])) { // equals method is inherited from object
                 return i;
             }
        }
        // If planet is not found, return -1
        return -1;
    }
    /**
     *This method traverses the planets array to find the first null position.
     * @return the null position within the array or -1 if no null position is found in the array.
     */
    public int findFirstEmptySlot(){
        for (int i = 0; i < MAX_PLANETS; i++) {
            if (planets[i] == null) {
                return i;
            }
        }
        return -1;
    }
    /**
     * This method checks if planet exists in the array.
     *@param planet is the planet object.
     * @return true if the planet is present in the array, false otherwise.
     * @throws NullPointerException if the planet parameter is null.
     */
    public boolean containsPlanet(Planet planet){
        // Exception can be thrown from findPlanet method
        return findPlanet(planet) != -1;
    }
    /**
     * Thid method adds a planet to the array.
     * @param planet planet to be added.
     * @param addedDate date when the planet is added.
     * @throws NullPointerException if the planet parameter is null
     * @throws IllegalArgumentException  if the planet already exists in the array
       or if the array is no empty slot is available.
     */
    public void addPlanet(Planet planet, LocalDate addedDate){
        if (containsPlanet(planet)){ // comparison can throw exception if planet is null
            throw new IllegalArgumentException(PLANET_ALREADY_EXISTS);
        }

        int slot = findFirstEmptySlot();
        if (slot == -1) {
            throw new IllegalStateException(INVALID_MAX_PLANETS);
        }

        setLastPlanetAdded(addedDate);

        planets[slot] = planet;
        numPlanets++;
        sumMoons += planet.getNumberOfMoons();
    }

    /**
     * This method removes a planet from the planets array.
     * @param planet Planet to be removed from the array.
     * @throws NullPointerException if the planet parameter is null
     * @throws IllegalArgumentException if the planet is not found in the array.
     */
    public void removePlanet(Planet planet){
        int index = findPlanet(planet); // Can throw PLANET_NULL exception
        if (index == -1) {
            throw new IllegalArgumentException(PLANET_NOT_FOUND);
        }
        planets[index] = null;
        numPlanets--;
    }
    public double getAverageMoonsByPlanet(){
        // Avoid dividing by 0
        if (numPlanets == 0) {
            return 0;
        }
        return (double) sumMoons / numPlanets;
    }





}
