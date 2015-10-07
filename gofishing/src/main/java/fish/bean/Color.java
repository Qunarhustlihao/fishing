package fish.bean;

/**
 * Created by lihao on 15/10/7.
 */
public enum Color {
    red("红色"),
    blue("蓝色"),
    golden("金色"),
    black("黑色"),
    yellow("黄色"),
    grace("灰色");

    String desc;

    Color(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static Color codeOf(int code) {
        for (Color color : Color.values()) {
            if(color.ordinal() == code) {
                return color;
            }
        }
        return null;
    }
}
