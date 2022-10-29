package no.dagpenger.geometry;

import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;
import no.dagpenger.App;

public class Hubworld extends Node {


    public static final String S_LOL = "Stringlolz";
    App.Container container;


    public Hubworld(App.Container container) {
        this.container = container;
    }

    private void makeAnyGeometry(Vector3f pos, float x, float y, float z) {

        Box box = new Box(pos, x, y, z);
        Geometry boxGeom = new Geometry("box", box);
        Material mat2 = new Material(container.assetManager,
                "Common/MatDefs/Misc/Unshaded.j3md");
        mat2.setColor("Color", ColorRGBA.Red);
        boxGeom.setMaterial(mat2);
        this.attachChild(boxGeom);
        container.worldNode.attachChild(this);
    }


    public void attach(Node node) {
        container.worldNode.attachChild(node);
    }


}
