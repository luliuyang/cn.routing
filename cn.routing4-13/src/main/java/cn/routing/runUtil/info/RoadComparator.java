package cn.routing.runUtil.info;


import cn.routing.entity.Road;

import java.util.Comparator;

/**
 * ��дRoad�ıȽϷ���
 * ����roadlength��road��������
 *
 * @author Tricia
 * @version 2019-03-20
 */
public class RoadComparator implements Comparator<Road> {
    @Override
    public int compare(Road r1, Road r2) {
        //����·�ĳ��ȶ�·����
        if (r1.getRoadLength() > r2.getRoadLength()) {

            return 1;
        } else if (r1.getRoadLength() < r2.getRoadLength()) {
            return -1;

        } else {

        }
        return 0;
    }
}
