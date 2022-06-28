package fis.test.test_final.service.impl;

import fis.test.test_final.models.Order;
import fis.test.test_final.models.OrderItem;
import fis.test.test_final.dto.OrderDTO;
import fis.test.test_final.models.enums.OrderStatus;
import fis.test.test_final.repository.OrderRepository;
import fis.test.test_final.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Page<OrderDTO> findAll(Pageable pageable) {
        Page<OrderDTO> orderDTOs = null;
        orderRepository.findAll(pageable).forEach(order -> {
            orderDTOs.forEach(orderDTO -> OrderDTO.Mapper.fromOrder(order));
        });
        log.info("Request all of Order. PageNumber: {}, PageSize: {}", pageable.getPageNumber(), pageable.getPageSize());
        return orderDTOs;
    }

    @Override
    public OrderDTO findById(Long order_id) {
        return OrderDTO.Mapper.fromOrder(orderRepository.findById(order_id)
                .orElseThrow(() -> {
                    throw new IllegalArgumentException(String.format("Not found order with id %s",order_id));
                }));
    }

    @Override
    public OrderDTO createOrder(Order order) {
        return null;
    }

    @Override
    public void delete(Long order_id) {
        Order order = orderRepository.findById(order_id).orElseThrow(() -> {
            throw new IllegalArgumentException(String.format("Not found order with id %s",order_id));
        });
        if(order.getStatus().equals("PAID"))
            //Dung tam exception nay
            throw new IllegalArgumentException(String.format("Not found order with id %s",order_id));
        orderRepository.deleteById(order_id);
    }

    @Override
    public OrderDTO addOrderItem(OrderItem orderItem) {
        Order order = orderRepository.findById(orderItem.getOrder().getId()).get();
        order.getOrderItems().add(orderItem);
        if (order != null) {
            Double totalAmount = order.getTotalAmount();
            totalAmount += orderItem.getQuantity()*orderItem.getAmount();
            order.setTotalAmount(totalAmount);
            orderRepository.save(order);
            return OrderDTO.Mapper.fromOrder(order);
        }
        throw new IllegalArgumentException(String.format("Not found order with id %s",order.getId()));
    }

    @Override
    public OrderDTO removeOrderItem(OrderItem orderItem) {
        Order order = orderRepository.findById(orderItem.getOrder().getId()).get();
        order.getOrderItems().remove(orderItem);
        if (order != null) {
            Double totalAmount = order.getTotalAmount();
            totalAmount -= orderItem.getQuantity()*orderItem.getAmount();
            order.setTotalAmount(totalAmount);
            orderRepository.save(order);
            return OrderDTO.Mapper.fromOrder(order);
        }
        throw new IllegalArgumentException(String.format("Not found order with id %s",order.getId()));
    }

    @Override
    public OrderDTO toPaid(Long order_id) {
        Order order = orderRepository.findById(order_id).orElseThrow(() -> {
            throw new IllegalArgumentException(String.format("Not found order with id %s",order_id));
        });

        if(!order.getStatus().equals("CREATED")) {
            throw new IllegalArgumentException(String.format("Not found order with id %s",order_id));
        }
        order.setStatus(OrderStatus.PAID);
        orderRepository.save(order);
        return OrderDTO.Mapper.fromOrder(order);
    }

    @Override
    public OrderDTO toCanced(Long order_id) {
        Order order = orderRepository.findById(order_id).orElseThrow(() -> {
            throw new IllegalArgumentException(String.format("Not found order with id %s",order_id));
        });

        if(!order.getStatus().equals("PAID")) {
            throw new IllegalArgumentException(String.format("Not found order with id %s",order_id));
        }
        order.setStatus(OrderStatus.CREATED);
        orderRepository.save(order);
        return OrderDTO.Mapper.fromOrder(order);
    }
}