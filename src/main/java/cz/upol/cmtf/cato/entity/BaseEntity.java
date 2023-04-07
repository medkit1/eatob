package cz.upol.cmtf.cato.entity;

import java.sql.Timestamp;

import javax.persistence.Column;

public abstract class BaseEntity {
	
	@Column(name = "CREATION_DATE", columnDefinition = "TIMESTAMP")
    private Timestamp creationTimestamp;

	public Timestamp getCreationTimestamp() {
		return creationTimestamp;
	}

	public void setCreationTimestamp(Timestamp creationTimestamp) {
		this.creationTimestamp = creationTimestamp;
	}
}
