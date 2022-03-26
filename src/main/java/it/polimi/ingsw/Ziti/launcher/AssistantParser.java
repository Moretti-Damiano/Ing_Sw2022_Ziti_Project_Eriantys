package it.polimi.ingsw.Ziti.launcher;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class AssistantParser {

    private AssistantParser(){
    }

    public static List<Assistant> parseAssistants(String fileName){
        String filePath = "/xml" + fileName;
        List<Assistant> assistants = new ArrayList<>();
        DocumentBuilder db;
        Document doc=null;

        InputStream assistantsIs = AssistantParser.class.getResourceAsStream(filePath);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        //Dobbiamo prima creare il server
        try {
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            dbf.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
            dbf.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");

            db = dbf.newDocumentBuilder();
            dbf.setValidating(false);
            doc = db.parse(assistantsIs);
        } catch (ParserConfigurationException | IllegalArgumentException | SAXException | IOException e) {
            Server.LOGGER.severe("failed to read gods.xml file.");
            System.exit(1);
        }

        Element root = doc.getDocumentElement();

        NodeList assistantNodeList= root.getChildNodes();

        for(int i=0;i<assistantNodeList.getLength();i++){
            Node assistantNode = assistantNodeList.item(i);
            if (assistantNode.getNodeType() == Node.ELEMENT_NODE) {
                assistants.add(buildAssistantObject((Element) assistantNode));
            }
        }
        return assistants;
    }

    private static Assistant buildAssistantObject(Element assistantElement) {
        int id = Integer.parseInt(assistantElement.getElementsByTagName(ID.getText()).item(0).getTextContent());
        int movesMother = Integer.parseInt(assistantElement.getElementsByTagName(MOVES.getText()).item(0).getTextContent());
        int value = Integer.parseInt(assistantElement.getElementsByTagName(VALUE.getText()).item(0).getTextContent());

        return new Assistant.Builder(id)
                .withmovesMother(movesMother)
                .withvalue(value)
                .build();
    }

}
