package ma.bankconnect.repository;

import ma.bankconnect.entities.ArchiveAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArchiveAccountRepository extends JpaRepository<ArchiveAccount, Long> {

}
