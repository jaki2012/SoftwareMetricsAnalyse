package metrics;

import java.util.ArrayList;

/**
 * Project: Halstead
 * Package: metrics
 * Author:  Novemser
 * 2016/10/7
 */
public class Operands {
    public static Operands instance;
    public ArrayList<String> name = new ArrayList();
    public ArrayList<String> count = new ArrayList();

    private Operands() {
    }

    public static Operands getInstance() {
        if(instance == null) {
            instance = new Operands();
        }

        return instance;
    }

    public void insert(String name) {
        if(this.name.contains(name)) {
            int count = Integer.parseInt(this.count.get(this.name.indexOf(name)));
            this.count.set(this.name.indexOf(name), "" + (count + 1));
        } else {
            this.name.add(name);
            this.count.add("1");
        }

    }

    public void insert(String name, int counter) {
        if(this.name.contains(name)) {
            counter += Integer.parseInt(this.count.get(this.name.indexOf(name)));
            this.count.set(this.name.indexOf(name), "" + counter);
        } else {
            this.name.add(name);
            this.count.add("" + counter);
        }

    }

}
