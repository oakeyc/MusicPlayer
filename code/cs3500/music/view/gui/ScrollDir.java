package cs3500.music.view.gui;

/**
 * Created by Courtney on 6/24/2016.
 */
public enum ScrollDir {
    LEFT(-1), RIGHT(1), END(10), HOME(0), DOWN(2);

    private int val;

    ScrollDir(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    /**
     * Returns the name of this enum constant, as contained in the declaration.  This method may be
     * overridden, though it typically isn't necessary or desirable.  An enum type should override
     * this method when a more "programmer-friendly" string form exists.
     *
     * @return the name of this enum constant
     */
    @Override
    public String toString() {
        return "";
    }
}
