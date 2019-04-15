package cn.routing.core;


import cn.routing.entity.Car;
import cn.routing.entity.Cross;


import java.util.LinkedList;
import java.util.Map;

import static cn.routing.postprocUtil.PostprocUtil.updateAns;
import static cn.routing.runUtil.RunUtil2.*;


public class Run2 {
    public static void run(Map<String, String> ansMap, String[] ans) {
        int t = 1;
        /**�ڵ�ǰʱ�̴ӳ��ⷢ��*/
        carsFromGarageInsertToRoad(t);
        /**���Ŵӳ������ĳ��ˣ������Ժ�ͳһ�����ı�־λ���ó�true,ͬʱҪ�Ѵӳ������ĳ��ӵ���·�ϵĳ���ȥ*/
        setNowInRoadCarFromGarageWait();

        /**���泵��·��*/
        updateAns(ansMap, ans);

        while (true) {
            /**�ѱ�־λ�����false*/
            setNowInRoadCarState(false);

            t++;

            /**�ж��ǲ������г������Ź��ˣ�sheng����0��ѽ��Ҳ����˵λ�ö��������*/
            while (!isAllReal()) {
                System.out.println("At time slot " + t);
                /**�ȸ���·��id���򣬸��� ·�ϳ���״̬*/
                for (int i = 0; i < Main.listCross.size(); i++) {

                    /**����ĸ�������������������� ����4���� �����������*/
                    Cross s = Main.listCross.get(i);
                    LinkedList<Car> carsFour = extractFourCar(s);
                    if (carsFour.isEmpty()) {
                        continue;
                    }
                    /**��ȡ�����ġ�4����������һЩ�в���*/
                    FourCarStateUnionProcess(carsFour, t);

                }
                /**�ѱ�־λ�����false,��������ȡ��ͷ����*/
                setNowInRoadCarState(false);

                /**���泵��·��*/
                updateAns(ansMap, ans);

                /**�ڵ�ǰʱ�̴ӳ��ⷢ��*/
                carsFromGarageInsertToRoad(t);

                /**���Ŵӳ������ĳ��ˣ������Ժ�ͳһ�����ı�־λ���ó�true,ͬʱҪ�Ѵӳ������ĳ��ӵ���·�ϵĳ���ȥ*/
                setNowInRoadCarFromGarageWait();

                /**֮ǰ��ԭ����·�ϵĳ������false,��������Ҫȫ��Ϊtrueһ��*/
                setNowInRoadCarState(true);

                /**���泵��·��*/
                updateAns(ansMap, ans);

                if (isAllArrived()) {
                    break;
                }

            }

        }

    }
}
