package com.incloud.tgestiona.b2b.model;

import java.util.logging.Logger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.incloud.tgestiona.domain.BaseDomain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bitacora",schema = "oferta")
public class Bitacora extends BaseDomain {

	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(Bitacora.class.getName());
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bitacora_id" , nullable = false)
	
	private Integer bitacora_id;
	private Integer usuario_id;
	
	@Column(name = "usuario", length = 255 )
	private String usuario;
	
	private Integer estado_id;
	private String fecha;
	private Integer oferta_id;
	
	@Override
	public boolean isIdSet() {
		return bitacora_id != null;
	}
	
}