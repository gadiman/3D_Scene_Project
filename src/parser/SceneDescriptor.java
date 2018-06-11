package parser;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Contains a scene description. Ensures syntactic correctness but not semantic.
 */
public class SceneDescriptor {

    protected Map<String, String> _sceneAttributes;
    protected Map<String, String> _cameraAttributes;
    protected Map<String, String> _ambientLightAttributes;
    protected List<Map<String, String>> _spheres   = new ArrayList<Map<String, String>>();
    protected List<Map<String, String>> _triangles = new ArrayList<Map<String, String>>();

    /**
     * Constructs scene description from given XML formatted text. Verifies
     * syntactic requirements that at least one scene element and one camera
     * element should exist.
     *
     * @param text
     *            XML string
     * @throws ParseException
     */
    public void fromXML(String text) throws ParseException {


        SceneXMLParser parser = new SceneXMLParser();
        parser.parse(text, this);

        // Verify that scene structure is syntactically correct
        if (_sceneAttributes == null) {
            throw new ParseException("No scene element found!", 0);
        }
        if (_cameraAttributes == null) {
            throw new ParseException("No camera element found!", 0);
        }
        if (_ambientLightAttributes == null) {
            throw new ParseException("No camera element found!", 0);
        }
    }

    public Map<String, String> getSceneAttributes()        { return _sceneAttributes;        }
    public Map<String, String> getCameraAttributes()       { return _cameraAttributes;       }
    public Map<String, String> getAmbientLightAttributes() { return _ambientLightAttributes; }

    public List<Map<String, String>> getSpheres()   { return _spheres;   }
    public List<Map<String, String>> getTriangles() { return _triangles; }


}
