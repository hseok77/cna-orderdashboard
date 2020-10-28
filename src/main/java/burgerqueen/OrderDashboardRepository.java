package burgerqueen;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderDashboardRepository extends CrudRepository<OrderDashboard, Long> {


}