package nasa.daidalus;

import larcfm.DAIDALUS.BandsRegion;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BandIntervals {
    private double current;
    private List<Band> bands = new ArrayList<>();

    public BandIntervals(double current, List<Band> bands) {
        this.current = current;
        this.bands = bands;
    }

    public double getCurrent() {
        return current;
    }

    public List<Band> getBands() {
        return bands;
    }

    public void setCurrent(double current) {
        this.current = current;
    }

    public void setBands(List<Band> bands) {
        this.bands = bands;
    }

    public static class Band {
        public double lower;
        public double upper;
        public BandsRegion region;
        private boolean isRecovery;

        public Band(double lower, double upper, BandsRegion region) {
            this.lower = lower;
            this.upper = upper;
            this.region = region;
            this.isRecovery = false;
        }

        public Band(double lower, double upper) {
            this.lower = lower;
            this.upper = upper;
            this.isRecovery = true;
        }

        public Color getColor() {
            // Colors are as prescribed by SC-228 RTCA DO-365 MOPS for DAA Systems
            // TODO: dashed lines as allowed to help distinguish preventive (Painter instead of just Color)
            if (isRecovery) {
                return Color.GREEN;
            }

            switch (region) {
                case NEAR: // warning
                    return Color.RED;
                case MID: // corrective
                    return Color.YELLOW;
                case FAR: // preventive
                    // return Color.YELLOW;
                    return Color.CYAN;
                default:
                    return Color.WHITE;
            }
        }
    }
}