import arraylist.MyList;

public class Main {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<>(5);
        for (int i = 0; i < 7; i ++) {
            myList.add(i, i*i);
        }
        System.out.println(myList);
        System.out.println(myList.getSize());
        myList.remove(1);
        System.out.println(myList);
    }

}
