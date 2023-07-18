import javax.swing.*;
import java.awt.*;
public class ColorPick{



    public ColorPick(String type){

        Color c1 = JColorChooser.showDialog(null, "Pick a Primary Gradient Color", Color.black);
        Color c2 = JColorChooser.showDialog(null, "Pick an Secondary Gradient Color", Color.black);


        new Fractal(type, c1, c2);


    }

}
