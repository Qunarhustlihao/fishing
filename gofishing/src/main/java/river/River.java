package river;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

import com.google.common.collect.Lists;
import fish.bean.Fish;
import fish.bean.FishType;
import fisher.bean.Fisher;
import org.apache.commons.lang3.Range;

/**
 * Created by lihao on 15/10/7.
 */
public class River {
    private String name;
    private List<FishType> fishTypes = Lists.newArrayList();
    private float maxWeight;
    private int density;
    private int capacity;
    private String desc;
    private Range<Float> depth;
    private ArrayBlockingQueue<Fish> fishes;
    private List<Fisher> fishers = Lists.newArrayList();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FishType> getFishTypes() {
        return fishTypes;
    }

    public void setFishTypes(List<FishType> fishTypes) {
        this.fishTypes = fishTypes;
    }

    public float getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(float maxWeight) {
        this.maxWeight = maxWeight;
    }

    public int getDensity() {
        return density;
    }

    public void setDensity(int density) {
        this.density = density;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Range<Float> getDepth() {
        return depth;
    }

    public void setDepth(Range<Float> depth) {
        this.depth = depth;
    }

    public ArrayBlockingQueue<Fish> getFishes() {
        return fishes;
    }

    public void setFishes(ArrayBlockingQueue<Fish> fishes) {
        this.fishes = fishes;
    }

    public List<Fisher> getFishers() {
        return fishers;
    }

    public void setFishers(List<Fisher> fishers) {
        this.fishers = fishers;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
        fishes = new ArrayBlockingQueue<Fish>(capacity);
    }
}
