package in.raster.poc.prajan.order.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.raster.poc.prajan.order.model.CustomerOrder;

@Repository
public interface OrderRepository extends CrudRepository<CustomerOrder, Integer>
{
}
