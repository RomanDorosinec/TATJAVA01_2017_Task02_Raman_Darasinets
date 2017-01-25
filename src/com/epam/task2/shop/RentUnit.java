package com.epam.task2.shop;

import java.util.HashMap;
import java.util.Map;

/**
 * All information about rental goods
 */
public class RentUnit {
    private Map<SportEquipment, Integer> goodsWithoutRent;

    /**
     * Get all information about goods without rental things
     *
     * @param goods    collection with all information about shop equipments
     * @param category category of the goods
     * @param title    name of the goods
     * @return collection without rental goods
     * @throws Exception throw exception if goods is not available
     */
    public Map<SportEquipment, Integer> withoutRentGoods(Map<SportEquipment, Integer> goods, String category, String title) throws Exception {
        goodsWithoutRent = new HashMap<>();
        for (Map.Entry<SportEquipment, Integer> equipment : goods.entrySet()) {
            goodsWithoutRent.put(equipment.getKey(), getTotalTitle(equipment.getKey(), equipment.getValue(), category, title));
        }
        return goodsWithoutRent;
    }

    /**
     * Calculate quantity of the goods without rent goods
     *
     * @param equipment one goods of the goods
     * @param value     quantity of the goods
     * @param category  category of the goods
     * @param title     name of the goods
     * @return quantity of the goods without rent goods
     * @throws Exception throw exception if goods is not available
     */
    private int getTotalTitle(SportEquipment equipment, Integer value, String category, String title) throws Exception {
        if (equipment.getCategory().equals(category) && equipment.getTitle().equals(title)) {
            if (value == 0) {
                throw new Exception("No goods available for rent. Choose other goods: ");
            } else {
                value--;
            }
        }
        return value;
    }
}
