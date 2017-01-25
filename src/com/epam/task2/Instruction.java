package com.epam.task2;

import java.util.ArrayList;

/**
 * This class contains all the supporting information for the user
 */
public class Instruction {
    public static final String WELCOME = "Welcome to the store of sporting goods rental!\n";
    public static final String INSTRUCTION_GOODS_WITHOUT_RENT = "list without rent - to take without rental goods\n";
    public static final String INSTRUCTION_ONLY_RENT_GOODS = "rent - to take the goods rental\n";
    public static final String INSTRUCTION_LIST = "list - to take the all goods in the shop\n";
    public static final String INSTRUCTION_EXIT = "exit - close the program\n";
    public static final String COMMAND = "command";
    public static final String CATEGORY = "category";
    public static final String TITLE = "title";
    public static final String WITHOUT_RENT_COMMAND = "list without rent";
    public static final String RENT_COMMAND = "rent";
    public static final String ALL_GOODS_COMMAND = "list";
    public static final String EXIT_COMMAND = "exit";

    ArrayList<String> allCommands;

    /**
     * Add all commands that can be used
     *
     * @return all commands that the user can use
     */
    public ArrayList<String> createCommands() {
        allCommands = new ArrayList<>();
        allCommands.add(WITHOUT_RENT_COMMAND);
        allCommands.add(ALL_GOODS_COMMAND);
        allCommands.add(EXIT_COMMAND);
        allCommands.add(RENT_COMMAND);
        return allCommands;
    }
}
