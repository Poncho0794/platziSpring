/**
 * 
 */
package com.platzi.ereservation.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Cliente que representa la tabla de reservas
 * @author Poncho
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="reserva")
public class Reserva {
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy="uuid2")
	private String idRes;
	@Temporal(TemporalType.DATE)
	private Date fechaIngresoRes;
	@Temporal(TemporalType.DATE)
	private Date fechaSalidaRes;
	private int cantidadPersonaRes;
	private String descripcionRes;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="idCli")
	private Cliente cliente;
}
