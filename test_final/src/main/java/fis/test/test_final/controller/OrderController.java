package fis.test.test_final.controller;

import fis.test.test_final.dto.OrderDTO;
import fis.test.test_final.models.Order;
import fis.test.test_final.models.OrderItem;
import fis.test.test_final.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@Slf4j
public class OrderController {
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{pageNumber}/{pageSize}")
    public Page<OrderDTO> findAll(@PathVariable(name="pageNumber") Integer pageNumber, @PathVariable(name="pageSize") Integer pageSize) {
        log.info("Request All Order. PageNumber: {}, PageSize: {}", pageNumber, pageSize);
        return orderService.findAll(PageRequest.of(pageNumber, pageSize));
    }

    @GetMapping("/findById/{orderId}")
    public OrderDTO findById(@PathVariable(name="orderId")Long orderId) {
        return orderService.findById(orderId);
    }
    @PostMapping("/create")
    public OrderDTO createOrder(@RequestBody Order newOrder) {
        return orderService.createOrder(newOrder);

    };
    @DeleteMapping("/deleteById/{orderId}")
    public void delete(@PathVariable(name="orderId")Long orderId){
        log.info("Delete Order by Id ", orderId);
        orderService.delete(orderId);
    };
    @PutMapping("/addOrderItem")
    public OrderDTO addOrderItem(@RequestBody OrderItem orderItem) {
        return orderService.addOrderItem(orderItem);
    };
    @PostMapping("/removeOrderItem")
    public OrderDTO removeOrderItem(@RequestBody OrderItem orderItem){
        return orderService.removeOrderItem(orderItem);
    };
    @PostMapping("/toPaid")
    public OrderDTO toPaid(@RequestBody Long order_id){
        return orderService.toPaid(order_id);
    };
    @PostMapping("/toPaid")
    public OrderDTO toCanced(@RequestBody Long order_id) {
        return orderService.toCanced(order_id);
    };
}
