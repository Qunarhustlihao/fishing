package fisher.bean;

import fish.bean.Fish;
import fisher.FisherAction;
import fishingGear.FishingGear;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import river.River;

/**
 * Created by lihao on 15/10/7.
 */
public class Fisher implements FisherAction {
    private String name;
    private int age;
    private int skillLevel;
    private float totalFishWeight = 0;
    private float totalFishNum = 0;
    private FishingGear fishingGear;
    private float capacity = 0;
    private River river;

    public boolean catchFish(Fish fish) {
        System.out.println(name + ":哈哈，来鱼了");
        if (fishingGear.canCatch(fish)) {
            System.out.println(name + ":我钓上来了: " + fish);
            totalFishNum++;
            totalFishWeight += fish.getWeight();
            if(this.capacity <= this.totalFishWeight) {
                goHome();
            }
            return true;
        } else {
            System.out.println(name + ":尼玛, 跑了");
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(int skillLevel) {
        this.skillLevel = skillLevel;
    }

    public float getTotalFishWeight() {
        return totalFishWeight;
    }

    public void setTotalFishWeight(float totalFishWeight) {
        this.totalFishWeight = totalFishWeight;
    }

    public FishingGear getFishingGear() {
        return fishingGear;
    }

    public void setFishingGear(FishingGear fishingGear) {
        this.fishingGear = fishingGear;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getTotalFishNum() {
        return totalFishNum;
    }

    public void setTotalFishNum(float totalFishNum) {
        this.totalFishNum = totalFishNum;
    }

    public void chooseRiver(River river) {
        river.getFishers().add(this);
        this.river = river;
    }
    
    public void goHome() {
        if(this.river == null) {
            System.out.println(this.name + ":你都没钓鱼，回个毛线家");
        }
        System.out.println("回家咯！钓了" + this.totalFishNum + "条鱼，总共" + this.totalFishWeight + "公斤!");
        this.river.getFishers().remove(this);
    }

    public float getCapacity() {
        return capacity;
    }

    public void setCapacity(float capacity) {
        this.capacity = capacity;
    }

    public River getRiver() {
        return river;
    }

    public void setRiver(River river) {
        this.river = river;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
