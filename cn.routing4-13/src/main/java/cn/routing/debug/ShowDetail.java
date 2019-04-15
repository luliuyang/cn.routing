package cn.routing.debug;

import cn.routing.core.Main;
import cn.routing.entity.Car;
import cn.routing.entity.Road;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author lulu
 * @date 2019-04-09 11:10
 */
public class ShowDetail {


    /*
     * 用来输出车的状态，来debug
     *
     * @author lulu
     *
     * @version 2019-3-28
     */
    public static void testShowCarInfo(LinkedList<Car> cs) {
        Iterator<Car> it = cs.iterator();
        while (it.hasNext()) {
            Car c = it.next();
            System.out.println(c.toString());

        }

    }
    /*
     * 用来输出车的状态，来debug
     *
     * @author lulu
     *
     * @version 2019-3-28
     */
    public static void testShowCarInfo(HashSet<Car> cs) {
        Iterator<Car> it = cs.iterator();
        while (it.hasNext()) {
            Car c = it.next();
            System.out.println(c.toString());

        }

    }

    /*
     * 用来输出路的状态，来debug
     *
     * @author lulu
     *
     * @version 2019-3-28
     */
    public static void testShowRoadInfo() {
        Iterator<Road> it = Main.listRoad.iterator();
        while (it.hasNext()) {

            String s = it.next().getRoadID();
            testShowRoadInfo(s);
        }

    }

    /*
     * 用来输出路的状态，来debug
     *
     * @author lulu
     *
     * @version 2019-3-28
     */
    public static void testShowRoadInfo(String s) {
        Road r = Main.MapRoad.get(s);
        System.out.println("-----正向：");
        for (int i = 0; i < r.getLanesNum(); i++) {

            testShowCarInfo(r.getForwardLane().get(i).carsInLane);

        }
        System.out.println("-----反向：");
        for (int i = 0; i < r.getLanesNum(); i++) {

            testShowCarInfo(r.getBackwardLane().get(i).carsInLane);

        }

    }

}
