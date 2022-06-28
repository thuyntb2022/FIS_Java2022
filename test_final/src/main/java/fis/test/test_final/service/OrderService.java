package fis.test.test_final.service;

import fis.test.test_final.models.Order;
import fis.test.test_final.models.OrderItem;
import fis.test.test_final.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {
    Page<OrderDTO> findAll(Pageable pageable);
    OrderDTO findById(Long order_id);
    OrderDTO createOrder(Order order);
    void delete(Long order_id);
    OrderDTO addOrderItem(OrderItem orderItem);
    OrderDTO removeOrderItem(OrderItem orderItem);
    OrderDTO toPaid(Long order_id);//Chuyen doi trang thai create -> paid
    OrderDTO toCanced(Long order_id); //chuyen trang thai created ->canceld


}
