package common;

import river.River;

import com.google.common.collect.Lists;
import common.util.FishFactory;

import fish.bean.FishType;
import fisher.bean.Fisher;
import fishingGear.*;

/**
 * Created by lihao on 15/10/7.
 */
public class MainTest {

    public static void main(String[] args) throws Exception{
        River river1 = new River();
        river1.setName("沙河水库");
        river1.setMaxWeight(3);
        river1.setCapacity(1000);
        river1.setDensity(45);
        river1.setFishTypes(Lists.newArrayList(FishType.crucian, FishType.carp));
        River river2 = new River();
        river2.setName("十三陵水库");
        river2.setMaxWeight(3);
        river2.setCapacity(2000);
        river2.setDensity(60);
        river2.setFishTypes(Lists.newArrayList(FishType.pomfret, FishType.salmon));
        Fisher fisher = new Fisher();
        fisher.setName("黎昊");
        fisher.setAge(26);
        fisher.setSkillLevel(10);
        fisher.setCapacity(10);
        FishingGear fishingGear = new FishingGear();
        fishingGear.setFishingRod(FishingRod.middle);
        fishingGear.setBuoy(Buoy.middle);
        fishingGear.setFishHook(FishHook.level2);
        fishingGear.setFishingNet(FishingNet.middle);
        fishingGear.setLine(Line.level3);
        fisher.setFishingGear(fishingGear);
        fisher.chooseRiver(river1);

        Fisher fisher1 = new Fisher();
        fisher1.setName("汪伟");
        fisher1.setAge(26);
        fisher1.setSkillLevel(10);
        fisher1.setCapacity(5);
        FishingGear fishingGear1 = new FishingGear();
        fishingGear1.setFishingRod(FishingRod.middle);
        fishingGear1.setBuoy(Buoy.middle);
        fishingGear1.setFishHook(FishHook.level2);
        fishingGear1.setFishingNet(FishingNet.middle);
        fishingGear1.setLine(Line.level3);
        fisher1.setFishingGear(fishingGear1);
        fisher1.chooseRiver(river2);

        FishFactory.start(Lists.newArrayList(river1, river2));

       // Thread.sleep(15000);

       // System.exit(0);
    }
}
