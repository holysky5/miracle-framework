package com.miracle.framework.repository.jpa.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.domain.Persistable;

import com.miracle.framework.repository.entity.PersistableEntity;

@MappedSuperclass
public abstract class BasePersistable implements PersistableEntity, Persistable<String> {
	
	private static final long serialVersionUID = -4968591878907824618L;
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(length = 36, updatable = false, nullable = false)
	private String id;
	
	public final String getId() {
		return id;
	}
	
	public final void setId(final String id) {
		this.id = id;
	}
	
	@Override
	@Transient
	public final boolean isNew() {
		return null == getId();
	}
}
