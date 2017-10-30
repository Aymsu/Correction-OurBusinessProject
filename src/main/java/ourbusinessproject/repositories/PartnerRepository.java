package ourbusinessproject.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import ourbusinessproject.Partnership;

public interface PartnerRepository extends PagingAndSortingRepository<Partnership,Long>, QueryByExampleExecutor<Partnership> {
}
