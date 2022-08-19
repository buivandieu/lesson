package com.vti.specification.department;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.vti.entity.Department;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

public class DepartmentSpecification {

	@SuppressWarnings("deprecation")
	public static Specification<Department> buildWhere(String search) {
		
		Specification<Department> where = null;
		
		if (!StringUtils.isEmpty(search)) {
			search = search.trim();
			CustomSpecification username = new CustomSpecification("username", search);
			where = Specification.where(username);
		}
		
		return where;
	}
}

@SuppressWarnings("serial")
@RequiredArgsConstructor
class CustomSpecification implements Specification<Department> {

	@NonNull
	private String field;
	@NonNull
	private Object value;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Predicate toPredicate(
			Root<Department> root, 
			CriteriaQuery<?> query, 
			CriteriaBuilder criteriaBuilder) {

		if (field.equalsIgnoreCase("username")) {
			Join join = root.join("accounts", JoinType.LEFT);
			return criteriaBuilder.like(join.get("username"), "%" + value.toString() + "%");
		}
	
		return null;
	}
}

