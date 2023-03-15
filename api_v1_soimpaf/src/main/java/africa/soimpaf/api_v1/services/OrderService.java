package africa.soimpaf.api_v1.services;

import africa.soimpaf.api_v1.interfaces.OrderInterface;
import africa.soimpaf.api_v1.models.Order;
import africa.soimpaf.api_v1.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements OrderInterface {
    @Autowired OrderRepository orderRepository;

    @Override
    public List<Order> getAll() {
        return (List<Order>) orderRepository.findAll();
    }

    @Override
    public Order create(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Optional<Order> getSingle(long id) {
        return  orderRepository.findById(id);
    }

    @Override
    public Order update(long id, Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void delete(long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Optional<Order> getById(long id) {
        return  orderRepository.findById(id);
    }



}
