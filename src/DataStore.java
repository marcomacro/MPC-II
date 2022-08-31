import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.util.Map;
import java.util.TreeMap;

class DataStore {

    final private String fileName = "prices.txt";

    private int currentMaterial;
    private int height;
    private int width;
    private TreeMap<String, Float> materialLst;

    public DataStore() {
        try {
            materialLst = new TreeMap<String, Float>();

            BufferedReader br = new BufferedReader(new java.io.FileReader(fileName));
            String line = "";
            String[] content;

            while ((line = br.readLine()) != null) {
                content = line.split(" = ");
                if (content[0].equals("current-material")) {
                    try {
                        currentMaterial = Integer.parseInt(content[1]);
                    } catch (NumberFormatException nfe) {
                        currentMaterial = 0;
                    }
                }
                else if (content[0].equals("height-value")) {
                    try {
                        height = Integer.parseInt(content[1]);
                    } catch (NumberFormatException nef) {
                        height = 70;
                    }
                }
                else if (content[0].equals("width-value")) {
                    try {
                        width = Integer.parseInt(content[1]);
                    } catch (NumberFormatException nef) {
                        width = 70;
                    }
                }
                else {
                    try {
                        materialLst.put(content[0], Float.parseFloat(content[1]));
                    } catch (NumberFormatException nef) {
                        materialLst.put(content[0], 10.00f);
                    }
                }
            }
            br.close();
        } catch (java.io.IOException ioe) {
            System.out.println();
        }
    }

    public void save() {
        try {
            FileWriter tmp = new FileWriter("tmp.txt", true);
            tmp.write("current-material = " + currentMaterial);
            tmp.write(System.lineSeparator());
            tmp.write("height-value = " + height);
            tmp.write(System.lineSeparator());
            tmp.write("width-value = " + width);
            tmp.write(System.lineSeparator());

            java.util.Iterator<Map.Entry<String, Float>> materials = materialLst.entrySet().iterator();
            while (materials.hasNext()) {
                Map.Entry<String, Float> m = (Map.Entry<String, Float>)materials.next();
                tmp.write(m.getKey().toString() + " = " + m.getValue().toString());
                tmp.write(System.lineSeparator());
            }

            tmp.close();

            // delete old file
            File f = new File(fileName);
            f.delete();

            // rename temp-file
            File tmpFile = new File("tmp.txt");
            java.nio.file.Files.move(tmpFile.toPath(), tmpFile.toPath().resolveSibling(fileName));

        } catch (java.io.IOException ioe) {
            System.out.println(ioe);
        }
    }

    public int getCurrentMaterial() {
        return currentMaterial;
    }

    public void setCurrentMaterial(int currentMaterial) {
        this.currentMaterial = currentMaterial;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public TreeMap<String, Float> getMaterialLst() {
        return materialLst;
    }

    public void setMaterialLst(TreeMap<String, Float> materialLst) {
        this.materialLst = materialLst;
    }

}