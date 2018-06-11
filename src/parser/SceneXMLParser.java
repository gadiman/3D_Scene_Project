package parser;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Parses the scene XML description and initializes the scene description object
 * You will need to add things here if you will insert new data in the XML
 */
public class SceneXMLParser extends DefaultHandler {

    SceneDescriptor _sceneDesc;

    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {

        Map<String, String> myAttributes = new HashMap<String, String>();

        for (int i = 0; i < attributes.getLength(); ++i) {
            String k = attributes.getQName(i);
            String v = attributes.getValue(i).trim();

            myAttributes.put(k, v);
        }

        if (qName == "scene") {
            _sceneDesc._sceneAttributes = myAttributes;
        } else if (qName == "camera") {
            _sceneDesc._cameraAttributes = myAttributes;
        } else if (qName == "ambient-light"){
            _sceneDesc._ambientLightAttributes = myAttributes;
        } else{
            if (qName == "sphere")
                _sceneDesc._spheres.add(myAttributes);
            if (qName == "triangle")
                _sceneDesc._triangles.add(myAttributes);
        }

        super.startElement(uri, localName, qName, attributes);
    }

    /**
     * Start parsing scene description XML
     *
     * @param text
     *            XML Scene description
     * @param sceneDesc
     *            Scene Description object to contain scene description
     */
    public void parse(String text, SceneDescriptor sceneDesc) {

        this._sceneDesc = sceneDesc;

        try {
            XMLReader xr = XMLReaderFactory.createXMLReader();
            xr.setContentHandler(this);
            xr.setErrorHandler(this);
            xr.parse(new InputSource(new StringReader(text)));

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
