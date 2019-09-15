package com.valley.app.repository;

        import com.valley.app.model.Company;
        import com.valley.app.model.Prog;
        import org.springframework.data.jpa.repository.JpaRepository;

        import java.util.List;

public interface ProgRepository extends JpaRepository<Prog, Long> {

    List<Prog> findByNameContaining(String letters);

}
