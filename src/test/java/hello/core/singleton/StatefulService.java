package hello.core.singleton;

public class StatefulService {
//    private int price;
//    이와 같이 상태 플래그 변수 두지 말 것!!

    public int order(String name,int price){
        System.out.println("name = "+name+" , price : "+price);
//        this.price =price;
//        이와 같이 상태 플래그 변수 두지 말 것!!
        return price;
    }

//    public int getPrice() {
//        return price;
//    }
}
