package fishingGear;

import common.Catchable;
import fish.bean.Fish;

/**
 * Created by lihao on 15/10/7.
 */
public enum Line implements Catchable {
    level1(1), // just for 1kg below
    level2(2), // just for 1kg~2kg
    level3(3), // just for 2kg~3kg
    level4(4), // just for 3kg~4kg
    level5(5), // just for 4kg~5kg
    level6(6); // just for 5kg~6kg

    int code;

    Line(int code) {
        this.code = code;
    }

    public boolean canCatch(Fish fish) {
        return fish.getWeight() <= this.code;
    }
}
