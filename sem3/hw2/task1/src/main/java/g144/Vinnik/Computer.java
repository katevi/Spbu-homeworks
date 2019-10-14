package g144.Vinnik;

public class Computer {
    private String nameOS;
    private boolean infected;

    public Computer(String name) {
        nameOS = name;
        infected = false;
    }

    protected String getOS() {
        return nameOS;
    }


    protected void setInfected(boolean result) {
        infected = result;
    }

    protected boolean isInfected() {
        return infected;
    }
}
