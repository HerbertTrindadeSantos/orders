package com.buildingdev.tools.service;

import com.buildingdev.tools.entities.Order;
import com.buildingdev.tools.service.exception.OrderNotFoundException;
import com.buildingdev.tools.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Order findById(long id){
        Order order = orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException("Pedido nao encontrado id: "+id));
        return order;
    }
}
