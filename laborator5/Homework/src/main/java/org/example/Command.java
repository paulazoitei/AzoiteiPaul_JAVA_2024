package org.example;

/**
 * Clasa Command este o clasă abstractă care definește metoda execute, care va fi implementată în clasele care extind această clasă.

 */
public abstract class Command {
/**
 * Metoda abstractă execute care va fi implementată în clasele care extind această clasă.
 */
    abstract void execute(String[] args);

}
