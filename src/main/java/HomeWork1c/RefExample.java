package HomeWork1c;

/**
 * Created by User on 18.10.2016.
 */
public class RefExample {
    @Save
    private int a;
    @Save
    private String text;
    private double b;
    @Save
    private boolean flag;

    public RefExample(int a, String text, double b, boolean flag) {
        this.a = a;
        this.text = text;
        this.b = b;
        this.flag = flag;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "RefExample{" +
                "a=" + a +
                ", text='" + text + '\'' +
                ", b=" + b +
                ", flag=" + flag +
                '}';
    }
}
