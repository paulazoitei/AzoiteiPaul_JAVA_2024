//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

/**
 * This class is used to store a pair of objects.
 * @param <F>
 * @param <S>
 */
public class Pair<F, S> {
    private F first;
    private S second;

    /**
     * Constructor for the Pair class.
     * @param first
     * @param second
     */
    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    /**
     * This method is used to get the first object of the pair.
     * @return F
     */
    public F getFirst() {
        return this.first;
    }
    /**
     * This method is used to get the second object of the pair.
     * @return S
     */

    public S getSecond() {
        return this.second;
    }
}
