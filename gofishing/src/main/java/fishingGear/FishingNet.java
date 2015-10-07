package fishingGear;

import common.Catchable;
import fish.bean.Fish;

/**
 * Created by lihao on 15/10/7.
 */
public enum FishingNet implements Catchable {
    small(1, 5), middle(6, 10), big(11, 20);

    private float min;
    private float max;

    FishingNet(float min, float max) {
        this.min = min;
        this.max = max;
    }

    public boolean canCatch(Fish fish) {
        return fish.getWeight() <= this.max;
    }
}
