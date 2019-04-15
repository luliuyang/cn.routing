package cn.routing.runUtil;

import cn.routing.core.Main;
import cn.routing.entity.Car;
import cn.routing.entity.Lane;
import cn.routing.entity.Road;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class RunUtil2Test {

    @Test
    public void insertFreshCarToRoad() {
        /**
         * Car:String carID, String fromCrossID, String toCrossID, int maxVelocity, int planTime
         * String carID, String fromCrossID, String toCrossID, String curFromCrossID, String curToCrossID, int maxVelocity, int planTime, int realStartTime, int realEndTime, String roadID, int laneID, int priority, int curPos, int sheng, boolean hasArrangedOrNot, int state, String nextRoadID, boolean canThrough
         * Road:String roadID, int length, int speed, int channel, String from, String to, boolean isDuplex
         */
        /**
         * 需要测试是不是有可能新加入的车变成头车，
         */

        Car car = new Car("1", "2", "-1", 2, 2);
        /**原来在这个路上的车，它本来是一个状态为2的头车*/
        Car carInRoad = new Car("2", "2","4","2", "3", 1, 2,1,-1,
                "1",0,3,1,0,true,2,"",false);

        Road road = new Road("1",2,2,2,"2","3",false);
        Lane lane0 = new Lane(0);
        lane0.carsInLane.add(carInRoad);
        Lane lane1 = new Lane(1);
        LinkedList<Lane> lanes=new LinkedList<>();
        lanes.add(lane0);
        lanes.add(lane1);
        road.setForwardLane(lanes);
        HashMap<String, Car> mapCar=new HashMap<>();
        mapCar.put("2",carInRoad);


        RunUtil2.InsertFreshCarToRoad(car,road,2);
    }
}