import java.util.TreeMap;

interface DataAccess {
    
    /**
     * Reads the value of the specified key.
     * @param key 
     * Should be one of: "height-value", "width-value", "current-material".
     * Otherwise this method will be undefined.
     * Even so it's possible to ask the material-prices with this method,
     * it's recommended to use readMaterials() for this purpose.
     * @return
     * The resulting string will contain parsable integer value.
     */
    public String readValue(String key);

    /**
     * Reads the managed list of materials and prices.
     * @return
     * A treemap which contains the material-names as string-keys and the
     * corresponding prices as float-values.
     */
    public TreeMap<String, Float> readMaterials();
    
    /**
     * Adds a new material to the managed list.
     * @param key
     * The materials name.
     * @param value
     * The materials price as String. This should be parsable to float.
     */
    public void addValue(String key, String value);
    
    /**
     * Changes the value of the specified entry (either an material-name or 
     * a default-value for a certain input-field).
     * @param key
     * Specifies the entry to be updated.
     * @param value
     * The new value.
     */
    public void updateValue(String key, String value);

}