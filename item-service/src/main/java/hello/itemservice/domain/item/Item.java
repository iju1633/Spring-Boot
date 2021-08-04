package hello.itemservice.domain.item;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

 @Data // Getter Setter 만들 필요 없지만, 예기치 않게 오작동할 수 있으므로 사용하는 거 비추, 지원하는 걸 다 알고 써야함
//@Getter @Setter
public class Item {

    private Long id;
    private String itemName;
    private Integer price; // int말고 Integer라는 건 null값이 들어갈 수 도 있음을 의미한다(이해)
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
