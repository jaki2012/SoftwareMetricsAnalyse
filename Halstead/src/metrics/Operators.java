package metrics;

import java.util.ArrayList;

/**
 * Project: Halstead
 * Package: metrics
 * Author:  Novemser
 * 2016/10/7
 */
public class Operators {
    public static Operators instance;
    public ArrayList<String> name = new ArrayList();
    public ArrayList<String> count = new ArrayList();

    private Operators() {
    }

    public static Operators getInstance() {
        if(instance == null) {
            instance = new Operators();
        }

        return instance;
    }

    public void insert(String name) {
        if(this.name.contains(name)) {
            int count = Integer.parseInt(((String)this.count.get(this.name.indexOf(name))).toString());
            this.count.set(this.name.indexOf(name), "" + (count + 1));
        } else {
            this.name.add(name);
            this.count.add("1");
        }

    }

    public void insert(String name, int counter) {
        if(this.name.contains(name)) {
            counter += Integer.parseInt(((String)this.count.get(this.name.indexOf(name))).toString());
            this.count.set(this.name.indexOf(name), "" + counter);
        } else {
            this.name.add(name);
            this.count.add("" + counter);
        }

    }

}
