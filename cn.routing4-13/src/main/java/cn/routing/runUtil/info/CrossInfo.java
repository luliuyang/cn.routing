package cn.routing.runUtil.info;


import cn.routing.core.Main;
import cn.routing.entity.Lane;
import cn.routing.entity.Road;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class CrossInfo {
	
	
	
//**************************************cost****************************************************
	/**
	 * cost1
	 * @param road
	 * @return NormalizedRoadLength
	 * @author Tricia
	 * @version 2019-3-21
	 */
//	移到了util包里的RunUtil
	//public static float getNormalizedRoadLength(Road road) {
//		float NormalizedRoadLength =0;

 //       NormalizedRoadLength = road.getRoadLength()/Main.maxRoadLength;  //Main.maxRoadLength最大路长度
//		return NormalizedRoadLength;
//	}
	
	
	
	

	/**
	 *
	 * @param road
	 * @param crossID
	 * @return NormalizedRoadLeftLength
	 */
	public  static float getNormalizedRoadLeftLength(Road road, String crossID) {
		float NormalizedRoadLeftLength = 0;
		ArrayList<Integer> leftLength = RoadInfo.getLeftLanesLength(road,crossID);
		int ans=0;
		Iterator<Integer> i=leftLength.iterator();
		while(i.hasNext()) {
			ans+=i.next();
		}
		/**
		 * 修改与4.9
		 */
		NormalizedRoadLeftLength=1-ans/(road.getRoadLength()*road.getLanesNum());
		return NormalizedRoadLeftLength;
	}
	
	
	
	
	

	/**
	 * cost3,sigmoid(carInCrossNum)
	 * @param carFromCossID
	 * @param carToCrossID
	 * @return
	 */
	public static int getCrossCarNum(String carFromCossID,String carToCrossID) {
		//Cross相连的道路上的所有车
		int carInCrossNum =0;
		int carInCrossSumNum =0;  
		int carInReverseLaneNum =0;
		String[] roadIDList = Main.MapCross.get(carToCrossID).getRoadIDList();
		ArrayList<Road> roadList = new ArrayList<Road>();
		for(String s:roadIDList) {
			if (!s.equals("-1")) {

				roadList.add(Main.MapRoad.get(s));
			}
		}
		for(Road road:roadList) {
			//road的toCross=car.curFromCross
			//****************寻找不能算的道路
			if(road.getFromCrossID().equals(carToCrossID)) {
				//计算这辆车的同一road的逆向lane上的路 （如果存在的话）
				for(Lane lane:road.getBackwardLane()) {
					//如果lane上没有车
					if(lane.carsInLane==null) {
						carInReverseLaneNum = 0;
					}else {
						carInReverseLaneNum += lane.carsInLane.size();
					}	
				}
			}
			//forward道路
			LinkedList<Lane> forwardLanes = road.getForwardLane();
			for(Lane lane:forwardLanes) {
				if(lane.carsInLane==null) {
					carInCrossSumNum +=0;
				}else {
					carInCrossSumNum += lane.carsInLane.size();
				}
			}

			//如果存在反向道路,也就是有反向的lane
			if(road.getBackwardLane()!=null) {
				LinkedList<Lane> backwardLanes = road.getBackwardLane();
				for(Lane lane:backwardLanes) {
					if(lane.carsInLane==null) {
						carInCrossSumNum += 0;
					}else {
						carInCrossSumNum += lane.carsInLane.size();}
				}
			}
		}

		//减去这辆车的同一road的逆向lane上的路 （如果存在的话）
		carInCrossNum =carInCrossSumNum-carInReverseLaneNum;
		return carInCrossNum;

	}

}
