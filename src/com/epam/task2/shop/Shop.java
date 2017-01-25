package com.epam.task2.shop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * All information about goods in the shop
 */
public class Shop {
    public static ArrayList<String> allCategory;
    public static ArrayList<String> allTitles;
    private Map<SportEquipment, Integer> goods;

    /**
     * Generates two lists for availability of goods and gives the number of each product
     *
     * @param equipments list
     * @return collection with all shop equipment
     */
    public Map<SportEquipment, Integer> formationGoods(ArrayList<SportEquipment> equipments) {
        goods = new HashMap<>();
        allCategory = new ArrayList<>();
        allTitles = new ArrayList<>();
        for (int i = 0; i < equipments.size(); i++) {
            goods.put(equipments.get(i), getTotalTitle(equipments.get(i), equipments) - 1);
            allCategory.add(equipments.get(i).getCategory());
            allTitles.add(equipments.get(i).getTitle());
        }
        return goods;
    }

    /**
     * Calculate quantity of the goods
     *
     * @param sportEquipment one goods of the goods
     * @param equipments     list of all goods in the shop
     * @return quantity of the goods in the shop
     */
    private int getTotalTitle(SportEquipment sportEquipment, ArrayList<SportEquipment> equipments) {
        int count = 1;
        for (SportEquipment equipment : equipments) {
            if (sportEquipment.equals(equipment)) {
                count++;
            }
        }
        return count;
    }
}
