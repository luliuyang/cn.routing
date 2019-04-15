package cn.routing.runUtil.info;


import cn.routing.entity.Road;

import java.util.Comparator;

/**
 * 重写Road的比较方法
 * 根据roadlength对road排序，升序
 *
 * @author Tricia
 * @version 2019-03-20
 */
public class RoadComparator implements Comparator<Road> {
    @Override
    public int compare(Road r1, Road r2) {
        //根据路的长度对路排序
        if (r1.getRoadLength() > r2.getRoadLength()) {

            return 1;
        } else if (r1.getRoadLength() < r2.getRoadLength()) {
            return -1;

        } else {

        }
        return 0;
    }
}
