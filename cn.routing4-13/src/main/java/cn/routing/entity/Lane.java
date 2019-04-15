package cn.routing.entity;

import java.util.LinkedList;

/**
 * @author lulu
 * @date 2019-04-08 18:08
 */
public class Lane {
    /**
     * lane的编号
     */
    private int laneIndex;
    /**
     *该lane上的车
     */
    public LinkedList<Car> carsInLane;

    public Lane(int laneIndex) {
        this.laneIndex=laneIndex;
        this.carsInLane=new LinkedList<>();
    }

    public Lane() {
        // TODO Auto-generated constructor stub
    }


    public int getLaneIndex() {
        return laneIndex;
    }

    public void setLaneIndex(int laneIndex) {
        this.laneIndex = laneIndex;
    }
}
