package uz.test.javatest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.test.javatest.entity.SocialService;

public interface SocialServiceRepository extends JpaRepository<SocialService, Integer> {
}
