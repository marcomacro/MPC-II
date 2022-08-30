import java.io.BufferedReader;
import java.util.TreeMap;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.RandomAccessFile;

class FileAccess implements DataAccess {

    private String fileName = "prices.txt";

    public String readValue(String key){
        String result = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = "";
            String[] content;
            while ((line = br.readLine()) != null) {
                content = line.split(" = ");
                if (content[0].equals(key)) {
                    result = content[1];
                    break;
                }
            }
            br.close();
        } catch (IOException ioe) {
            System.out.println();
        }
        return result;
    }

    public TreeMap<String, Float> readMaterials(){
        TreeMap<String, Float> result = new TreeMap<String, Float>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = "";
            String[] content;
            String defaults = "current-materialheight-valuewidth-value";
            while ((line = br.readLine()) != null) {
                content = line.split(" = ");
                if (defaults.contains(content[0])) {
                    continue;
                }
                result.put(content[0], Float.parseFloat(content[1]));
            }
            br.close();
        } catch (IOException ioe) {
            System.out.println();
        }
        return result;
    }
    
    public void addValue(String key, String value){
        try {
            FileWriter file = new FileWriter(fileName, true);
            file.write(key + " = " + value);
            file.close();
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }
    
    public void updateValue(String key, String value){
        try {
            File file = new File(fileName);
            File tmpFile = new File("tmp.txt");

            // open the file with a specific file-reader
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            RandomAccessFile tmpRaf = new RandomAccessFile(tmpFile, "rw");

            // set file-pointer to start
            raf.seek(0);
            tmpRaf.seek(0);

            // search the line to overwrite
            String insertStr = key + " = " + value;
            String currentLine = "";

            while (raf.getFilePointer() < raf.length()) {
                currentLine = raf.readLine();
                if (currentLine.startsWith(key)) {
                    currentLine = insertStr;
                }
                tmpRaf.writeBytes(currentLine);
                tmpRaf.writeBytes(System.lineSeparator());
            }
            
            // close the file
            raf.close();
            tmpRaf.close();

            file.delete();
            java.nio.file.Files.move(tmpFile.toPath(), tmpFile.toPath().resolveSibling(fileName));

        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }
}