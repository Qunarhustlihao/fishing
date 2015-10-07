package fishingGear;

import common.Catchable;
import fish.bean.Fish;

/**
 * Created by lihao on 15/10/7.
 */
public class FishingGear implements Catchable {
    private FishingRod fishingRod;
    private Line line;
    private FishHook fishHook;
    private Buoy buoy;
    private FishingNet fishingNet;

    public FishingGear(FishingRod fishingRod, Line line, FishHook fishHook, Buoy buoy, FishingNet fishingNet) {
        this.fishingRod = fishingRod;
        this.line = line;
        this.fishHook = fishHook;
        this.buoy = buoy;
        this.fishingNet = fishingNet;
    }

    public FishingGear() {
    }

    public FishingRod getFishingRod() {
        return fishingRod;
    }

    public void setFishingRod(FishingRod fishingRod) {
        this.fishingRod = fishingRod;
    }

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    public FishHook getFishHook() {
        return fishHook;
    }

    public void setFishHook(FishHook fishHook) {
        this.fishHook = fishHook;
    }

    public Buoy getBuoy() {
        return buoy;
    }

    public void setBuoy(Buoy buoy) {
        this.buoy = buoy;
    }

    public FishingNet getFishingNet() {
        return fishingNet;
    }

    public void setFishingNet(FishingNet fishingNet) {
        this.fishingNet = fishingNet;
    }

    public boolean canCatch(Fish fish) {
        return (this.fishingRod != null) && (this.line != null && this.line.canCatch(fish))
                && (this.fishHook != null && this.fishHook.canCatch(fish)) && (this.buoy != null)
                && (this.fishingNet != null && this.fishingNet.canCatch(fish));
    }
}
