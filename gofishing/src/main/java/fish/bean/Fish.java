package fish.bean;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Created by lihao on 15/10/7.
 */
public class Fish {
    private FishType fishType;
    private float weight;
    private FishActivityDegree activityDegree;
    private Color color;

    public FishType getFishType() {
        return fishType;
    }

    public void setFishType(FishType fishType) {
        this.fishType = fishType;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public FishActivityDegree getActivityDegree() {
        return activityDegree;
    }

    public void setActivityDegree(FishActivityDegree activityDegree) {
        this.activityDegree = activityDegree;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "一条" + color.getDesc() + "的" + fishType.getDesc() + ", 重" + weight + "公斤";
    }
}
