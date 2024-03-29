package NEAT;

/**
 * Models an organism that will be building and modifying its own network to get the highest
 * fitness score it can.
 * @author Chance Simmons and Brandon Townsend
 * @version 25 February 2019
 */
public class Organism implements Cloneable {

    /** Used to assign an organism a specified id number. */
    private static int id = 0;

    /** Keeps track of this organisms fitness. */
    private double fitness;

    /** The string representation of this organisms name. */
    private String name;

    /** Keeps track of this organisms generation. */
    private int generation;

    /** The neural network related to this organism. Used to represent phenotype. */
    private Network network;

    /** The species that this organism is a part of. */
    private Species species;

    /** ID for this organism. */
    private int orgId;

    /** Input size of the network for this organism. */
    private int inputSize;

    /** Output size of the network for this organism. */
    private int outputSize;

    /**
     * Constructor for an organism based on the passed in name.
     * @param name The name to be granted to the organism.
     */
    public Organism(String name,int inputSize,int outputSize){
        this.fitness    = 0;
        this.inputSize = inputSize;
        this.outputSize = outputSize;
        this.generation = 0;
        this.name       = name;
        this.species    = null;
        this.orgId = id;
        this.network    = new Network(id, this.inputSize,this.outputSize);
        id++;
    }

    /**
     * Sets the fitness of this organism.
     * @param fitness the new value of the fitness
     */
    public void setFitness(double fitness){
        this.fitness = fitness;
    }

    /**
     * Gets the fitness of this organism
     * @return the fitness of the organism
     */
    public double getFitness(){
        return this.fitness;
    }

    /**
     * Gets the ID of this organism
     * @return the ID of this organism
     */
    public int getId(){
        return this.orgId;
    }

    /**
     * Returns this organism's neural network aka. phenotype.
     * @return the network of this organism
     */
    public Network getNetwork() {
        return network;
    }

    /**
     * Gets the generation of this organism
     * @return the generation of this organism
     */
    public int getGeneration(){
        return this.generation;
    }

    /**
     * Sets the generation of this organism
     * @param generation the new generation for this organism
     */
    public void setGeneration(int generation){
        this.generation = generation;
    }

    /**
     * Gets the species that this organism is a part of
     * @return the species that this organism is a part of
     */
    public Species getSpecies() {
        return species;
    }

    /**
     * Sets the species of this organism
     * @param species the new species for this organism
     */
    public void setSpecies(Species species) {
        this.species = species;
    }

    /**
     * Generates a string representation of this organism.
     * @return A string representation of this organism.
     */
    @Override
    public String toString() {
        return "\tName: " + this.name + "\tID: " + this.network.getId()+ "\tGen: "
                + this.generation + "\tFitness: " + this.fitness;
    }

    /**
     * Checks to see if the object passed in is equal to this organism
     * @param o the object to compare the equality to
     * @return true if the object passed in is equal to this organism
     */
    @Override
    public boolean equals(Object o){
        boolean result = false;
        if(o instanceof Organism){
            Organism organism = (Organism) o;
            if(organism.getId() == this.getId()){
                result = true;
            }
        }
        return  result;
    }

    /**
     * Clones this organism.
     * @return A clone of this organism.
     */
    @Override
    public Object clone() {
        Organism organism;
        try {
            organism = (Organism) super.clone();
        } catch (CloneNotSupportedException cne) {
            organism = new Organism(this.name,this.inputSize,this.outputSize);
        }

        organism.orgId = ++id;
        organism.network = new Network(this.network);
        organism.species = this.species;
        organism.setGeneration(this.getGeneration());
        return organism;
    }
}
