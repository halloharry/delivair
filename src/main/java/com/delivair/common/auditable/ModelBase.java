package com.delivair.common.auditable;

import lombok.Data;

import javax.persistence.*;

@MappedSuperclass
@Data
public class ModelBase extends AuditableBase{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column
    private Long id;

    @Column
    private String description;

    @Column(name="is_deleted", length = 1)
    private Integer isDeleted;
}
