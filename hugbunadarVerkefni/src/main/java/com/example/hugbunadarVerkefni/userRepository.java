import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hugbunadarVerkefni.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    public User createUser(String name, String email){}
}
