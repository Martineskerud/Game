package no.dagpenger;

import com.jme3.app.SimpleApplication;
import com.jme3.asset.AssetManager;
import com.jme3.input.InputManager;
import com.jme3.material.Material;
import com.jme3.renderer.Camera;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;
import com.jme3.math.ColorRGBA;
import com.jme3.system.AppSettings;
import no.dagpenger.geometry.Hubworld;

import java.time.LocalDate;

/**
 * Sample 1 - how to get started with the most simple JME 3 application.
 * Display a blue 3D cube and view from all sides by
 * moving the mouse and pressing the WASD keys.
 */
public class App extends SimpleApplication {
        Geometry geom;
        Geometry geom2;
        public Container c = new Container();
    public static void main(String[] args) {


        App app = new App();
        AppSettings settings = new AppSettings(true);
        settings.setResolution(1600, 1080);
        app.setShowSettings(false);
        settings.setVSync(true);
        float f = settings.getFloat("asd");
        System.out.println(f);
        app.start();
    }

    /**
     * Advanced instruction set CPU
     * RISC
     * Reduced instruction set Computer <--
     *
     *
     */
    @Override
    public void simpleInitApp() {
        Box b = new Box(1, 1, 1); // create cube shape
        Box b2 = new Box(2, 2, 2); // create cube shape
        geom = new Geometry("Box", b);  // create cube geometry from the shape
        geom2 = new Geometry("Box", b);  // create cube geometry from the shape
        Material mat = new Material(assetManager,
                "Common/MatDefs/Misc/Unshaded.j3md");  // create a simple material
        Material mat2 = new Material(assetManager,
                "Common/MatDefs/Misc/Unshaded.j3md");  // create a simple material
        mat.setColor("Color", ColorRGBA.Green);   // set color of material to blue
        geom.setMaterial(mat);                   // set the cube's material
        mat2.setColor("Color",ColorRGBA.Cyan);
        geom2.setMaterial(mat);

        rootNode.attachChild(geom);
        geom2.setMesh(b2);
        rootNode.attachChild(geom2);
    }
    
    @Override
    public void simpleUpdate(float tpf) {
        geom.rotate(0, 1 * tpf, 1 * tpf);
    }

    public class Container {

        public Node guiNode;
        public Node worldNode;
        public AssetManager assetManager;
        public ViewPort vp;
        public InputManager im;
        public AppSettings settings;
        public Camera cam;
        /*Bullet App State for physics*/

        public Container() {

            this.guiNode = App.this.guiNode;
            this.worldNode = App.this.rootNode;
            this.assetManager = App.this.assetManager;
            this.vp = viewPort;
            this.settings = App.this.settings;
            this.im = inputManager;
            this.cam = App.this.cam;
        }
    }

}