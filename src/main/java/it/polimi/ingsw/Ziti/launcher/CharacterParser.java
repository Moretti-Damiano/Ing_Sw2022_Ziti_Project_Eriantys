package it.polimi.ingsw.Ziti.launcher;

import it.polimi.ingsw.Ziti.launcher.model.Character;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import static it.polimi.ingsw.Ziti.launcher.enumeration.XMLName.*;

public class CharacterParser {

    private CharacterParser() {
    }

    public static List<Character> parseCharacters(String fileName) throws ParserConfigurationException, IOException, SAXException {
        String filePath = "/xml/" + fileName;
        List<Character> characters = new ArrayList<>();
        DocumentBuilder db;
        Document doc = null;

        InputStream CharactersIs = CharacterParser.class.getResourceAsStream(filePath);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        db = dbf.newDocumentBuilder();
        dbf.setValidating(false);
        doc = db.parse(CharactersIs);

        Element root = doc.getDocumentElement();

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
        String description = characterElement.getElementsByTagName(DESCRIPTION.getText()).item(0).getTextContent();

        return new Character.Builder(id)
                .withCost(cost)
                .withDescription(description)
                .build();
    }

    }
