package hello.core.order;

public interface OrderService  {
    // @return : 주문 생성하면 주문결과인 Order를 반환
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
