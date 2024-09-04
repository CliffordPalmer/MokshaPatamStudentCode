import java.util.ArrayList;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
public class Space {
    private int num;
    private Space parent;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Space getParent() {
        return parent;
    }

    public void setParent(Space parent) {
        this.parent = parent;
    }
}
