package com.epam.task2;

import com.epam.task2.parser.ParserXML;
import com.epam.task2.shop.Shop;
import com.epam.task2.shop.SportEquipment;

import java.util.Map;

/**
 * Entry point in the program
 */
public class Main {
    public static final String FILE_PATH = "SportEquipment.xml";

    public static void main(String[] args) {
        try {
            Shop shop = new Shop();
            Map<SportEquipment, Integer> fullInformation = shop.formationGoods(new ParserXML(FILE_PATH).getLine());
            Conversation conversation = new Conversation();
            conversation.startConversation(fullInformation);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
