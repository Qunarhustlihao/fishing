package common.util;

import fish.bean.Fish;
import fish.util.FishGenerator;
import fisher.bean.Fisher;
import org.apache.commons.collections4.CollectionUtils;
import river.River;

import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by lihao on 15/10/7.
 */
public class FishFactory {
    private static final ConcurrentHashMap<River, ScheduledExecutorService> river2executorServiceOfGenerateFish = new ConcurrentHashMap<River, ScheduledExecutorService>();

    private static final ConcurrentHashMap<River, ScheduledExecutorService> river2executorServiceOfPutFish = new ConcurrentHashMap<River, ScheduledExecutorService>();


    public static void start(List<River> riverList) {
        if (CollectionUtils.isEmpty(riverList)) {
            return;
        }
        for (River river : riverList) {
            if (river2executorServiceOfGenerateFish.get(river) == null) {
                river2executorServiceOfGenerateFish.put(river, Executors.newScheduledThreadPool(1));
            }
            river2executorServiceOfGenerateFish.get(river).scheduleAtFixedRate(new GenerateFishTask(river), 5, river.getDensity(),
                    TimeUnit.SECONDS);

            if (river2executorServiceOfPutFish.get(river) == null) {
                river2executorServiceOfPutFish.put(river, Executors.newScheduledThreadPool(1));
            }
            river2executorServiceOfPutFish.get(river).scheduleAtFixedRate(new PushFishTask(river), 20, river.getDensity(),
                    TimeUnit.SECONDS);
        }
    }

    static class GenerateFishTask implements Runnable {
        private River river;

        public GenerateFishTask(River river) {
            this.river = river;
        }

        public void run() {
            Fish fish = FishGenerator.generateFish(river);
            try {
                river.getFishes().put(fish);
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static class PushFishTask implements Runnable {
        private static final Random random = new Random();
        private River river;

        public PushFishTask(River river) {
            this.river = river;
        }

        public void run() {
            Fisher fisher = river.getFishers().get(random.nextInt(river.getFishers().size()));
            try {
                fisher.catchFish(river.getFishes().take());
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
