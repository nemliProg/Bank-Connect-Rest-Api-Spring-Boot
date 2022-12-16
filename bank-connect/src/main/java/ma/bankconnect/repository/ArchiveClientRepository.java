package ma.bankconnect.repository;

import ma.bankconnect.entities.ArchiveClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArchiveClientRepository extends JpaRepository<ArchiveClient, Long> {

}
