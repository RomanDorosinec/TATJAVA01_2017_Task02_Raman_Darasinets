package com.epam.task2.checkData;

import com.epam.task2.Instruction;
import com.epam.task2.shop.SportEquipment;

import java.util.Map;

import static com.epam.task2.shop.Shop.allCategory;
import static com.epam.task2.shop.Shop.allTitles;

/**
 * Check all input commands from console
 */
public class DataChecking {
    /**
     * Check the command that a user enters. Throw exception, if command incorrect
     *
     * @param command command from the console
     * @throws Exception wrong input commands
     */
    public void checkCommandUser(String command) throws Exception {
        Instruction instruction = new Instruction();
        if (!instruction.createCommands().contains(command.toLowerCase())) {
            throw new Exception("Uncorrected command! Enter correct command.");
        }
    }

    /**
     * Check the rent collection. Throw exception if collection is empty
     *
     * @param rentGoods collection rent of the goods
     * @throws Exception wrong no rented goods
     */
    public void checkRentList(Map<SportEquipment, Integer> rentGoods) throws Exception {
        if (rentGoods == null) {
            throw new Exception("Nope rented goods!");
        }
    }

    /**
     * Check category of shop equipment. Throw exception if category doesn't exist
     *
     * @param category category of the goods
     * @throws Exception wrong input category
     */
    public void checkCategory(String category) throws Exception {
        if (!allCategory.contains(category)) {
            throw new Exception("This goods is not in shop.");
        }
    }

    /**
     * Check title of shop equipment. Throw exception if title doesn't exist
     *
     * @param title name of the goods
     * @throws Exception wrong input name of goods
     */
    public void checkTitle(String title) throws Exception {
        if (!allTitles.contains(title)) {
            throw new Exception("This goods is not in shop.");
        }
    }
}
