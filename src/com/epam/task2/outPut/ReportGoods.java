package com.epam.task2.outPut;

import com.epam.task2.shop.SportEquipment;

import java.util.Map;

/**
 * Report of shop equipments
 */
public class ReportGoods {
    /**
     * Output all information of collection in the console
     *
     * @param goods collection whit shop equipments
     */
    public void outPutGoods(Map<SportEquipment, Integer> goods) {
        for (Map.Entry<SportEquipment, Integer> equipmentIntegerEntry : goods.entrySet()) {
            System.out.println(equipmentIntegerEntry.getKey().getCategory() + " "
                    + equipmentIntegerEntry.getKey().getTitle() + " "
                    + equipmentIntegerEntry.getValue());
        }
    }
}
