package com.stc.task.specification;

import com.stc.task.common.entity.Employee;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeSpecification implements Specification<Employee> {

    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private Double salary;

    @Override
    public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        final List<Predicate> predicates = new ArrayList<>();

        if (this.getId() != null) {
            predicates.add(criteriaBuilder.equal(root.get("id"), this.getId()));
        }
        if (this.getFirstName() != null) {
            predicates.add(criteriaBuilder.equal(root.get("firstName"), this.getFirstName()));
        }
        if (this.getLastName() != null) {
            predicates.add(criteriaBuilder.equal(root.get("lastName"), this.getLastName()));
        }
        if (this.getEmail() != null) {
            predicates.add(criteriaBuilder.equal(root.get("email"), this.getEmail()));
        }
        if (this.getPhone() != null) {
            predicates.add(criteriaBuilder.equal(root.get("phone"), this.getPhone()));
        }
        if (this.getSalary() != null) {
            predicates.add(criteriaBuilder.equal(root.get("salary"), this.getSalary()));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
    }
}
