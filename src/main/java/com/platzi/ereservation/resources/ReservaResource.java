/**
 * 
 */
package com.platzi.ereservation.resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.platzi.ereservation.model.Cliente;
import com.platzi.ereservation.model.Reserva;
import com.platzi.ereservation.resources.vo.ReservaVO;
import com.platzi.ereservation.services.ClienteService;
import com.platzi.ereservation.services.ReservaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Clase que representa el servicio web de cliente
 * @author blue
 *
 */
@RestController
@RequestMapping("/api/reserva")
@Api(tags="reserva")
public class ReservaResource {
	
	private final ReservaService reservaService;
	private final ClienteService clienteService;

	public ReservaResource (ReservaService reservaService, ClienteService clienteServcie) {
		this.reservaService = reservaService;
		this.clienteService = clienteServcie;
	}
	@PostMapping
	@ApiOperation(value = "Crear Reserva", notes = "Servicio para crear una nueva reserva")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "reserva creada correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Invalida")})
	public ResponseEntity<Reserva> createReserva(@RequestBody ReservaVO reservaVo){
		Cliente cliente = this.clienteService.findById(reservaVo.getCliente().getIdCli());
		Reserva reserva = new Reserva(); 
		reserva.setCantidadPersonaRes(reservaVo.getCantidadPersonasRes());
		reserva.setCliente(cliente);
		reserva.setDescripcionRes(reservaVo.getDescripcionRes());
		reserva.setFechaIngresoRes(reservaVo.getFechaIngresoRes());
		reserva.setFechaSalidaRes(reservaVo.getFechaSalidaRes());
		Reserva result = this.reservaService.create(reserva);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value = "Actualizar Reserva", notes = "Servicio para actualizar una reserva")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "reserva actualizada correctamente"),
			@ApiResponse(code = 404, message = "reserva no encontrado")})
	public ResponseEntity<Reserva> updateReserva(@PathVariable("id") String id, ReservaVO reservaVo){
		Reserva reserva = this.reservaService.findById(id);
		if(reserva == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Cliente cliente = this.clienteService.findById(reservaVo.getCliente().getIdCli());
		if(cliente == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		reserva.setCantidadPersonaRes(reservaVo.getCantidadPersonasRes());
		reserva.setCliente(cliente);
		reserva.setDescripcionRes(reservaVo.getDescripcionRes());
		reserva.setFechaIngresoRes(reservaVo.getFechaIngresoRes());
		reserva.setFechaSalidaRes(reservaVo.getFechaSalidaRes());
		return new ResponseEntity<>(this.reservaService.update(reserva), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Eliminar Reserva", notes = "Servicio para eliminar una reserva")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "reserva eliminada correctamente"),
			@ApiResponse(code = 404, message = "Cliente no encontrado")})
	public void removeReserva(@PathVariable("id") String id) {
		Reserva reserva = this.reservaService.findById(id);
		if(reserva != null) {
			this.reservaService.delete(reserva);
		}
	}
	
	@GetMapping
	@ApiOperation(value = "Listar Reservas", notes = "Servicio para listar todas las reservas")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Reservas encontrados"),
			@ApiResponse(code = 404, message = "Reservas no encontrados")})
	public ResponseEntity<List<Reserva>> findAll(){
		return ResponseEntity.ok(this.reservaService.findAll());
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Listar Reservas", notes = "Servicio para listar todas las reservas")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Reservas encontrados"),
			@ApiResponse(code = 404, message = "Reservas no encontrados")})
	public ResponseEntity<Reserva> findOne(@PathVariable("id") String id){
		Reserva reserva = this.reservaService.findById(id);
		return new ResponseEntity<>(reserva, HttpStatus.OK);
	}
}
