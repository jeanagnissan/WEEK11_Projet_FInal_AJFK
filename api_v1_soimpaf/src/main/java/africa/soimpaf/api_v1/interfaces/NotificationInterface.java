
package africa.soimpaf.api_v1.interfaces;

import africa.soimpaf.api_v1.models.Notification;

import java.util.List;
import java.util.Optional;

public interface NotificationInterface {

    List<Notification> getAll();

    Notification create(Notification notification);

    Optional<Notification> getSingle(long id);

    void delete (long id);

    Notification update(long id, Notification notification);

    Optional<Notification> getById(long id);

}
