package kodlama.io.hrms.dataAccess.abstracts;

import kodlama.io.hrms.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {
    User getByEmail(String email);
    User getById(int id);
}
