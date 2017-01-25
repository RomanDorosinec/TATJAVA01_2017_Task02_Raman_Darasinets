package com.epam.task2;

import com.epam.task2.checkData.DataChecking;
import com.epam.task2.outPut.ReportGoods;
import com.epam.task2.shop.RentUnit;
import com.epam.task2.shop.SportEquipment;

import java.util.Map;
import java.util.Scanner;

import static com.epam.task2.Instruction.*;

/**
 * This class working with argument of the console, which entered user and output all information about goods of shop
 */
public class Conversation {
    Map<SportEquipment, Integer> goodsWithoutRent = null;

    /**
     * Welcome use, provide list of commands and wait to write the command.
     *
     * @param fullInformation collection this all goods in the shop
     * @throws Exception wrong input commands / category / name / no rented goods
     */
    public void startConversation(Map<SportEquipment, Integer> fullInformation) throws Exception {

        boolean flag = true;
        System.out.println(WELCOME + INSTRUCTION_GOODS_WITHOUT_RENT + INSTRUCTION_LIST
                + INSTRUCTION_EXIT + INSTRUCTION_ONLY_RENT_GOODS);
        int countGoods = 0;
        while (flag) {
            try {
                flag = performCommand(userCommandInput(COMMAND), fullInformation, countGoods, flag);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Receives a command from the console. Handle this command
     *
     * @param inputCommand    command from the console
     * @param fullInformation collection this all goods in the shop
     * @param countGoods      amount of goods
     * @param flag            is true if user don't have less the three goods
     * @return is true if if the user has leased three goods
     * @throws Exception wrong input commands / category / name / no rented goods
     */
    private boolean performCommand(String inputCommand, Map<SportEquipment, Integer> fullInformation,
                                   int countGoods, boolean flag) throws Exception {
        DataChecking dataChecking = new DataChecking();
        ReportGoods reportGoods = new ReportGoods();
        dataChecking.checkCommandUser(inputCommand);
        switch (inputCommand) {
            case RENT_COMMAND:
                String category = userCommandInput(CATEGORY);
                String title = userCommandInput(TITLE);
                dataChecking.checkCategory(category);
                dataChecking.checkTitle(title);
                if (goodsWithoutRent == null) {
                    goodsWithoutRent = fullInformation;
                }
                goodsWithoutRent = rentWithoutEquipment(goodsWithoutRent, category, title);
                countGoods++;
                if (countGoods == 3) {
                    throw new Exception("You have reached the maximum number of goods the rented.");
                }
                break;
            case ALL_GOODS_COMMAND:
                reportGoods.outPutGoods(fullInformation);
                break;
            case WITHOUT_RENT_COMMAND:
                dataChecking.checkRentList(goodsWithoutRent);
                reportGoods.outPutGoods(goodsWithoutRent);
                break;
            case EXIT_COMMAND:
                flag = false;
                System.out.println("Good bye!");
                break;
            default:
                flag = false;
                System.out.println("Good bye!");
                break;
        }
        return flag;
    }

    /**
     * Input from the command console
     *
     * @param instruction instructions to execute
     * @return instruction to be executed
     */
    private String userCommandInput(String instruction) {
        System.out.print("Enter " + instruction + ": ");
        String in = new Scanner(System.in).nextLine();
        return in;
    }

    /**
     * Generates collection of goods leased
     *
     * @param fullInformation collection this all goods in the shop
     * @param category        category of the goods
     * @param title           name of the goods
     * @return collection with rent sport equipment
     * @throws Exception wrong input category / name
     */
    private Map<SportEquipment, Integer> rentWithoutEquipment(Map<SportEquipment,
            Integer> fullInformation, String category, String title) throws Exception {
        RentUnit rentUnit = new RentUnit();
        return rentUnit.withoutRentGoods(fullInformation, category, title);
    }
}