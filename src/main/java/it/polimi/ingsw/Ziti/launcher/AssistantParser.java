package it.polimi.ingsw.Ziti.launcher;
import it.polimi.ingsw.Ziti.launcher.model.Assistant;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import static it.polimi.ingsw.Ziti.launcher.enumeration.XMLName.*;

public class AssistantParser {

    /**
     * Default costructor
     */
    private AssistantParser() {
    }

    /**
     *
     * @param fileName is the filePath where is located "Assistant.xml"
     * @return  List<Assistant>
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */

    public static List<Assistant> parseAssistants(String fileName) throws ParserConfigurationException, IOException, SAXException {
        String filePath = "/xml/" + fileName;
        List<Assistant> assistants = new ArrayList<>();
        DocumentBuilder db;
        Document doc = null;

        InputStream assIs = AssistantParser.class.getResourceAsStream(filePath);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        db = dbf.newDocumentBuilder();
        dbf.setValidating(false);
        doc = db.parse(assIs);

        Element root =doc.getDocumentElement();

        NodeList assNodeList = root.getChildNodes();

        for (int i = 0; i < assNodeList.getLength(); i++) {
            Node assNode = assNodeList.item(i);
            if (assNode.getNodeType() == Node.ELEMENT_NODE) {
                assistants.add(buildAssistantObject((Element) assNode));
            }
        }
        return assistants;
    }

    /**
     *
     * @param assElement is an Element of XML file, it's an "assNode". It contains all the info that have to be inserted in the assistant object
     * @return an initialized Assistant object
     */

    private static Assistant buildAssistantObject(Element assElement) {
        int id = Integer.parseInt(assElement.getElementsByTagName(ID.getText()).item(0).getTextContent());
        int moves = Integer.parseInt(assElement.getElementsByTagName(MOVES.getText()).item(0).getTextContent());
        int value = Integer.parseInt(assElement.getElementsByTagName(VALUE.getText()).item(0).getTextContent());
        return new Assistant.Builder(id)
                .withmovesMother(moves)
                .withvalue(value)
                .build();
    }
}
