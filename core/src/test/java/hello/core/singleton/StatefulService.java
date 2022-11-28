package hello.core.singleton;

public class StatefulService {

    private int price; // 가격을 유지하는 필드(공유필드:조심해야함)

    public void order(String name, int price) {
        System.out.println("name = " + name + "price = " + price);
        this.price = price; // 여기가 문제!
    }

    public int getPrice() {
        return price;
    }
}
