package leetcode;

public class MountainArray {
    private static int[] array;

    public MountainArray(int[] array){
        this.array = array;
    }

    public int get(int index) {
        return array[index];
    }
    public int length() {
        return array.length;
    }
}
