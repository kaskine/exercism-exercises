class SpaceAge {

    private final int earthRatio = 31557600;
    private final double mercuryRatio = 0.2408467;
    private final double venusRatio = 0.61519726;
    private final double marsRatio = 1.8808158;
    private final double jupiterRatio = 11.862615;
    private final double saturnRatio = 29.447498;
    private final double uranusRatio = 84.016846;
    private final double neptuneRatio = 164.79132;

    private double seconds;

    SpaceAge(double seconds) {
        this.seconds = seconds;
    }

    double getSeconds() {
        return seconds;
    }

    double onEarth() {
        return seconds / earthRatio;
    }

    double onMercury() {
        return seconds / earthRatio / mercuryRatio;
    }

    double onVenus() {
        return seconds / earthRatio / venusRatio;
    }

    double onMars() {
        return seconds / earthRatio / marsRatio;
    }

    double onJupiter() {
        return seconds / earthRatio / jupiterRatio;
    }

    double onSaturn() {
        return seconds / earthRatio / saturnRatio;
    }

    double onUranus() {
        return seconds / earthRatio / uranusRatio;
    }

    double onNeptune() {
        return seconds / earthRatio / neptuneRatio;
    }

}
