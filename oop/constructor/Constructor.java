package oop.constructor;

public class Constructor {
    private int attr1;
    private int attr2;

    public Constructor(int attr1, int attr2) {
        this.attr1 = attr1;
        this.attr2 = attr2;
    }

    public Constructor(Constructor cc) {
        this.attr1 = cc.attr1;
        this.attr2 = cc.attr2;
    }

    public void setAttr1(int attr1) {
        this.attr1 = attr1;
    }

    public void setAttr2(int attr2) {
        this.attr2 = attr2;
    }

    public int getAttr1() {
        return attr1;
    }

    public int getAttr2() {
        return attr2;
    }

}
