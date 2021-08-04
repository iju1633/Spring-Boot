package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository // 자동으로 Component 스캔의 대상이 됨. 안에 @Component 있음
public class ItemRepository {

    private static final Map<Long, Item> store = new HashMap<>(); // static, 동시에 여러개가 접근하면 HashMap 사용하면 안됨
    private static long sequence = 0L; // static

    public Item save(Item item){
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id) {
        return store.get(id);
    }

    public List<Item> findAll() {
        return new ArrayList<>(store.values()); // 타입을 바꿔야하는 문제도 있고, ArrayList에 뭔갈 넣어도 store에는 변함이 없기에
        // 안전성 측면에서 ArrayList로 한번 감쌈
    }

    public void update(Long itemId, Item updateParam) { // 여기에선 id가 활용되지 않기에 사실 id를 제외한 3개의 매개변수를 가지는
        // class를 하나더 만드는 것이 맞음, 중복성보다는 명확성을 따라가는 것이 더 중요
        // 프로젝트가 작고 인식 범위에 있으므로 그냥 함
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    public void clearStore() {
        store.clear();
    }

}
