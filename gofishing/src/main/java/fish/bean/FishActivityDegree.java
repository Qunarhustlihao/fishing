package fish.bean;

/**
 * Created by lihao on 15/10/7.
 */
public enum FishActivityDegree {
    level1(1), level2(2), level3(3), level4(4), level5(5);

    int code;

    FishActivityDegree(int code) {
        this.code = code;
    }

    public static FishActivityDegree codeOf(int code) {
        for (FishActivityDegree activityDegree : FishActivityDegree.values()) {
            if (activityDegree.ordinal() == code) {
                return activityDegree;
            }
        }
        return null;
    }
}
