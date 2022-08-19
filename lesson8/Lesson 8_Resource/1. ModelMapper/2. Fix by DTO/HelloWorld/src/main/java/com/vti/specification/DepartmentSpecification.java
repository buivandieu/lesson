package com.vti.specification;

import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.vti.entity.Department;
import com.vti.form.DepartmentFilterForm;


import lombok.NonNull;
import lombok.RequiredArgsConstructor;

public class DepartmentSpecification {

	@SuppressWarnings("deprecation")
	public static Specification<Department> buildWhere(String search, DepartmentFilterForm filterForm) {
		
		Specification<Department> where = null;
		
		if (!StringUtils.isEmpty(search)) {
			search = search.trim();
			CustomSpecification1 name = new CustomSpecification1("name", search);
			where = Specification.where(name);
		}
		
		// if there is filter by min id
		if (filterForm != null && filterForm.getMinId() != null) {
			CustomSpecification1 minId = new CustomSpecification1("minId", filterForm.getMinId());
			if (where == null) {
				where = minId;
			} else {
				where = where.and(minId);
			}
		}
		
		// if there is filter by max id
		if (filterForm != null && filterForm.getMaxId() != null) {
			CustomSpecification1 maxId = new CustomSpecification1("maxId", filterForm.getMaxId());
			if (where == null) {
				where = maxId;
			} else {
				where = where.and(maxId);
			}
		}
		
//		if (totalForm != null && totalForm.getMinTotal() != null) {
//			CustomSpecification1 minTotal = new CustomSpecification1("minTotal", filterForm.getMinId());
//			if (where == null) {
//				where = minTotal;
//			} else {
//				where = where.and(minTotal);
//			}
//		}
		
		// if there is filter by max id
//		if (totalForm != null && totalForm.getMaxTotal() != null) {
//			CustomSpecification1 maxId = new CustomSpecification1("maxTotal", filterForm.getMaxId());
//			if (where == null) {
//				where = maxId;
//			} else {
//				where = where.and(maxId);
//			}
//		}
		System.out.println(filterForm.getMinCreateDate());
		if (filterForm != null && filterForm.getMinCreateDate() != null) {
			System.out.println("minDate");
			CustomSpecification1 minDate = new CustomSpecification1("minDate", filterForm.getMinCreateDate());
			if (where == null) {
				where = minDate;
			} else {
				where = where.and(minDate);
			}
		}
		
		if (filterForm != null && filterForm.getMaxCreateDate() != null) {
			CustomSpecification1 maxDate = new CustomSpecification1("maxDate", filterForm.getMaxCreateDate());
			if (where == null) {
				where = maxDate;
			} else {
				where = where.and(maxDate);
			}
		}
		
		if (filterForm != null && filterForm.getType() != null) {
			CustomSpecification1 type = new CustomSpecification1("Type", filterForm.getType());
			if (where == null) {
				where = type;
			} else {
				where = where.and(type);
			}
		}
			
		return where;
	}
}

@SuppressWarnings("serial")
@RequiredArgsConstructor
class CustomSpecification1 implements Specification<Department> {

	@NonNull
	private String field;
	@NonNull
	private Object value;

	@Override
	public 	Predicate toPredicate(
			Root<Department> root, 
			CriteriaQuery<?> query, 
			CriteriaBuilder criteriaBuilder) {

		if (field.equalsIgnoreCase("name")) {
			return criteriaBuilder.like(root.get("name"), "%" + value.toString() + "%");
		}
		
		if (field.equalsIgnoreCase("minId")) {
			return criteriaBuilder.greaterThanOrEqualTo(root.get("id"), value.toString());
		}
		
		if (field.equalsIgnoreCase("maxId")) {
			return criteriaBuilder.lessThanOrEqualTo(root.get("id"), value.toString());
		}
		
		if (field.equalsIgnoreCase("minTotal")) {
			return criteriaBuilder.greaterThanOrEqualTo(root.get("totalMember"), value.toString());
		}
		
		if (field.equalsIgnoreCase("maxTotal")) {
			return criteriaBuilder.lessThanOrEqualTo(root.get("totalMember"), value.toString());
		}
		
		if (field.equalsIgnoreCase("minDate")) {
			return criteriaBuilder.greaterThanOrEqualTo(root.get("createdDate").as(java.sql.Date.class), (Date) value);
		}
		
		if (field.equalsIgnoreCase("maxDate")) {
			return criteriaBuilder.lessThanOrEqualTo(root.get("createdDate").as(java.sql.Date.class), (Date) value);
		}
		
		if (field.equalsIgnoreCase("Type")) {
			return criteriaBuilder.equal(root.get("type"), value);
		}
		
		

		return null;
	}
}

