package fish.bean;

/**
 * Created by lihao on 15/10/7.
 */
public enum  FishType {
    crucian(0, "鲫鱼"),
    carp(1, "鲤鱼"),
    salmon(2, "鲑鱼"),
    pomfret(3, "武昌鱼");
    int code;
    String desc;

    FishType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static FishType codeOf(int code) {
        for (FishType fishType : FishType.values()) {
            if (fishType.ordinal() == code) {
                return fishType;
            }
        }
        return null;
    }
}
