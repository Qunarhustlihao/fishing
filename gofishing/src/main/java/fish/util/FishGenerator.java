package fish.util;

import com.google.common.collect.Lists;
import fish.bean.Color;
import fish.bean.Fish;
import fish.bean.FishActivityDegree;
import fish.bean.FishType;
import river.River;

import java.util.Random;

/**
 * Created by lihao on 15/10/7.
 */
public class FishGenerator {
    private static final Random random =new Random();

    public static Fish generateFish(River river) {
        Fish fish = new Fish();
        fish.setFishType(generateType(river));
        fish.setColor(generateColor());
        fish.setActivityDegree(generateDegree());
        fish.setWeight(generateWeight(river));
        return fish;
    }

    private static Color generateColor() {
        int code = random.nextInt(Color.values().length);
        return Color.codeOf(code);
    }

    private static FishType generateType(River river) {
        int code = random.nextInt(river.getFishTypes().size());
        return river.getFishTypes().get(code);
    }

    private static FishActivityDegree generateDegree() {
        int code = random.nextInt(FishActivityDegree.values().length);
        return FishActivityDegree.codeOf(code);
    }

    private static float generateWeight(River river) {
        return random.nextFloat() + random.nextInt((int)(river.getMaxWeight() - 1));
    }

    public static void main(String[] args) {
        River river1 = new River();
        river1.setFishTypes(Lists.newArrayList(FishType.carp,FishType.crucian));
        river1.setMaxWeight(10);
        for (int i = 0; i < 10; i++) {
            System.out.println(generateFish(river1));
        }
    }
}
