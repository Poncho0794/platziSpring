/**
 * 
 */
package com.platzi.ereservation.resources.vo;

import java.util.Date;

import lombok.Data;

/**
 * Objeto Virtual de Reserva para ser retornado en respuesta
 * @author blue
 *
 */
@Data
public class ReservaVO {
	private String codigoRes;
	private Date fechaIngresoRes;
	private Date fechaSalidaRes;
	private int cantidadPersonasRes;
	private String descripcionRes;
	private ClienteVO cliente;
}
