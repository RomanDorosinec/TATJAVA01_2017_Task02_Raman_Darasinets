package com.epam.task2.parser;

import com.epam.task2.shop.SportEquipment;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

/**
 *
 */
public class ParserXML {
    private final static String SPORT_EQUIPMENT = "sportEquipment";
    Document document;

    /**
     * Constructor of class. Create objects, which need to parse xml file
     *
     * @param filePath path to .xml file
     */
    public ParserXML(String filePath) throws Exception {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        document = documentBuilder.parse(new File(filePath));
    }

    /**
     * Method for get all sport equipment
     *
     * @return list of equipment
     * @throws Exception if .xml file not exist
     */
    public ArrayList<SportEquipment> getLine() throws Exception {
        ArrayList<SportEquipment> linesOfFile = new ArrayList<>();
        NodeList nodes = document.getElementsByTagName(SPORT_EQUIPMENT);
        for (int i = 0; i < nodes.getLength(); i++) {
            NamedNodeMap namedNodeMap = nodes.item(i).getAttributes();
            linesOfFile.add(new SportEquipment(getInstructionOfLine(namedNodeMap).get(0),
                    getInstructionOfLine(namedNodeMap).get(1)));
        }
        return linesOfFile;
    }

    /**
     * Method get all parameters of sport equipment
     *
     * @param namedNodeMap object
     * @return arrayList with all parameters of instruction
     */
    private ArrayList<String> getInstructionOfLine(NamedNodeMap namedNodeMap) throws Exception {
        ArrayList<String> paramInstruction = new ArrayList<>();
        paramInstruction.add(namedNodeMap.getNamedItem(SportEquipment.CATEGORY) == null
                ? null : namedNodeMap.getNamedItem(SportEquipment.CATEGORY).getNodeValue());
        paramInstruction.add(namedNodeMap.getNamedItem(SportEquipment.TITLE) == null
                ? null : namedNodeMap.getNamedItem(SportEquipment.TITLE).getNodeValue());
        return paramInstruction;
    }
}
