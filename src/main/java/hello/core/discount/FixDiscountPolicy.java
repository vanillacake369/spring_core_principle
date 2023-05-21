package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FixDiscountPolicy implements DiscountPolicy {
    private int discountFixAmount = 1000; //1000원 할인

    @Override
    public int discount(Member member, int price) {
        /* VIP이면 1000원 반환, 아니면 0원 반환 */
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        }else{
            return 0;
        }
    }
}
