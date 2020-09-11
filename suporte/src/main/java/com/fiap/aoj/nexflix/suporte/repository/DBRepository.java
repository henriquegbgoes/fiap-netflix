package com.fiap.aoj.nexflix.suporte.repository;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

@Repository
public class DBRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Object> callProcedure(Object object, String procedureName) {
		
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery(procedureName);
		
		if(object != null) {			
			Class<?> clazz = object.getClass();
			
			if(object instanceof String){
				query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
				query.setParameter(1, (String) object);
			}else if(object instanceof Integer) {
				query.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);
				query.setParameter(1, (Integer) object);
			}else {
				List<Field> fields = Arrays.asList(clazz.getDeclaredFields());
				for(int i = 0; i < fields.size(); i++) {
					Field field = fields.get(i);
					query.registerStoredProcedureParameter((i+1), field.getType(), ParameterMode.IN);
					
					field.setAccessible(true);
					Object value;
					try {
						value = field.get(object);
						query.setParameter((i+1), value);
					} catch (IllegalArgumentException | IllegalAccessException e) {
						e.printStackTrace();
					}
				}
			}
		}
		query.execute();
		try {
			return query.getResultList();
		} catch (IllegalStateException e) {
			return Arrays.asList(Boolean.TRUE);
		}
	}
}
