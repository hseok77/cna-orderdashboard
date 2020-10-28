package burgerqueen;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OrderDashboardRepository extends CrudRepository<OrderDashboard, Long> {
    List<OrderDashboard> findByOrderId(Long orderId);

}