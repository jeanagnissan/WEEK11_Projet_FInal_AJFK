package africa.soimpaf.api_v1.services;

import africa.soimpaf.api_v1.interfaces.OrderHistoryInterface;
import africa.soimpaf.api_v1.models.OrderHistory;
import africa.soimpaf.api_v1.repository.OrderHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderHistoryService implements OrderHistoryInterface {
    @Autowired OrderHistoryRepository orderHistoryRepository;

    @Override
    public List<OrderHistory> getAll() {
        return (List<OrderHistory>) orderHistoryRepository.findAll();
    }

    @Override
    public OrderHistory create(OrderHistory orderHistory) {
        return orderHistoryRepository.save(orderHistory);
    }

    @Override
    public Optional<OrderHistory> getSingle(long id) {
        return  orderHistoryRepository.findById(id);
    }

    @Override
    public OrderHistory update(long id, OrderHistory orderHistory) {
        return orderHistoryRepository.save(orderHistory);
    }

    @Override
    public void delete(long id) {
        orderHistoryRepository.deleteById(id);
    }

    @Override
    public Optional<OrderHistory> getById(long id) {
        return  orderHistoryRepository.findById(id);
    }

}
