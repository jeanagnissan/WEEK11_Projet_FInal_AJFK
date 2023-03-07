package africa.soimpaf.api_v1.services;

import africa.soimpaf.api_v1.interfaces.NotificationInterface;
import africa.soimpaf.api_v1.models.Notification;
import africa.soimpaf.api_v1.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationService implements NotificationInterface {
    @Autowired NotificationRepository notificationRepository;

    @Override
    public List<Notification> getAll() {
        return (List<Notification>) notificationRepository.findAll();
    }

    @Override
    public Notification create(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public Optional<Notification> getSingle(long id) {
        return  notificationRepository.findById(id);
    }

    @Override
    public Notification update(long id, Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public void delete(long id) {
        notificationRepository.deleteById(id);
    }

    @Override
    public Optional<Notification> getById(long id) {
        return  notificationRepository.findById(id);
    }

}
