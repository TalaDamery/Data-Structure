
public class ArrayList {

    int size;
    int arr[];

    public ArrayList(int size, int arr[]) {
        size = 0;
        arr = new int[10];
    }

    public void add(int val) {
        arr[size] = val;
        size++;
    }

    public int addBysize(int val, int i) {
        checksize(i);
        ensureCapacity(i);
        for (int j = size; j > i; j--) {
            arr[j] = arr[j - 1];
        }
        arr[i] = val;
        size++;
        return i;
    }

    public int get(int i) {
        checksize(i);
        return arr[i];
    }

    public void checksize(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException("Invalid size: " + i);
        }
    }

    public void ensureCapacity(int i) {
        if (i >= arr.length) {
            int newSize = arr.length * 2;
            int newArr[] = new int[newSize];
            System.arraycopy(arr, 0, newArr, 0, arr.length);
            arr = newArr;
        }
    }

    public int remove(int i) {
        checksize(i);
        int removedValue = arr[i];
        for (int j = i; j < size - 1; j++) {
            arr[j] = arr[j + 1];
        }
        size--;
        return removedValue;
    }

}
