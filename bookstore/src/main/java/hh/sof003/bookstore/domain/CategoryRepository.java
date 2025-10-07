package hh.sof003.bookstore.domain;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    static Category findByName(String name) {
        throw new UnsupportedOperationException("Unimplemented method 'findByName'");
    }
}
