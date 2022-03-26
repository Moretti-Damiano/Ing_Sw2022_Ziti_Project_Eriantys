package it.polimi.ingsw.Ziti.launcher;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class CharacterParser {

    private CharacterParser() {
    }
    public static List<Character> parseCharacters(String fileName) {
        String filePath = "/xml/" + fileName;
        List<Character> characters = new ArrayList<>();
        DocumentBuilder db;
        Document doc = null;

        InputStream CharactersIs = CharacterParser.class.getResourceAsStream(filePath);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            dbf.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
            dbf.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");

            db = dbf.newDocumentBuilder();
            dbf.setValidating(false);
            doc = db.parse(CharactersIs);
        } catch (ParserConfigurationException | IllegalArgumentException | SAXException | IOException e) {
            Server.LOGGER.severe("failed to read characters.xml file.");
            System.exit(1);
        }

        Element root = doc.getDocumentElement();

        // Retrieve all <god> nodes
        NodeList characterNodeList = root.getChildNodes();

        for (int i = 0; i < characterNodeList.getLength(); i++) {
            Node characterNode = characterNodeList.item(i);
            if (characterNode.getNodeType() == Node.ELEMENT_NODE) {
                characters.add(buildCharacterObject((Element) characterNode));
            }
        }
        return characters;
    }


    private static Character buildCharacterObject(Element characterElement) {
        int id = Integer.parseInt(characterElement.getElementsByTagName(ID.getText()).item(0).getTextContent());
        int cost = Integer.parseInt(characterElement.getElementsByTagName(COST.getText()).item(0).getTextContent());
        String description = characterElement.getElementsByTagName(DESCRIPTION.getText())
                .item(0).getTextContent();

        return new Character.Builder(id)
                .withCost(cost)
                .withDescription(description)
                .build();
    }

    private static Map<String, String> toMap(NodeList nodeList) {
        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                map.put(node.getNodeName(), node.getTextContent());

                if (node.hasAttributes()) {
                    NamedNodeMap attributes = node.getAttributes();

                    for (int j = 0; j < attributes.getLength(); j++) {
                        Node attr = attributes.item(j);
                        map.put(node.getNodeName() + attr.getNodeName(), attr.getNodeValue());
                    }
                }
            }
        }
        return Collections.unmodifiableMap(map);
    }
}
