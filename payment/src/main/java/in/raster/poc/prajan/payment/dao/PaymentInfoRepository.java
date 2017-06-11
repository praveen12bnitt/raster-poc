package in.raster.poc.prajan.payment.dao;

import org.springframework.data.repository.CrudRepository;

import in.raster.poc.prajan.payment.model.PaymentInfo;

public interface PaymentInfoRepository extends CrudRepository<PaymentInfo, Integer>
{
}
