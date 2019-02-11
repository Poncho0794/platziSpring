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
import com.platzi.ereservation.resources.vo.ClienteVO;
import com.platzi.ereservation.services.ClienteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 
 * Clase que representa el servicio web de cliente
 * 
 * @author blue
 *
 */

@RestController
@RequestMapping("/api/cliente")
@Api(tags = "cliente")
public class ClienteResource {
	private final ClienteService clienteService;

	public ClienteResource(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@PostMapping
	@ApiOperation(value = "Crear Cliente", notes = "Servicio para crear un nuevo cliente")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "cliente creado correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Invalida")})
	public ResponseEntity<Cliente> createCliente(@RequestBody ClienteVO clienteVo) {
		Cliente cliente = new Cliente();
		cliente.setNombreCli(clienteVo.getNombreCli());
		cliente.setApellidoCli(clienteVo.getApellidoCli());
		cliente.setDireccionCli(clienteVo.getDireccionCli());
		cliente.setEmailCli(clienteVo.getEmailCli());
		cliente.setTelefonoCli(clienteVo.getTelefonoCli());
		cliente.setIdentificacionCli(clienteVo.getIdentificacionCli());
		return new ResponseEntity<>(this.clienteService.create(cliente), HttpStatus.CREATED);
	}

	@PutMapping("/{identificacion}")
	@ApiOperation(value = "Actualizar Cliente", notes = "Servicio para actualizar un nuevo cliente")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "cliente actualizado correctamente"),
			@ApiResponse(code = 404, message = "Cliente no encontrado")})
	public ResponseEntity<Cliente> updateCliente(@PathVariable("identificacion") String identificacion,
			ClienteVO clienteVo) {
		Cliente cliente = this.clienteService.findByIdentificacion(identificacion);
		if (cliente == null) {
			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
		} else {
			cliente.setNombreCli(clienteVo.getNombreCli());
			cliente.setApellidoCli(clienteVo.getApellidoCli());
			cliente.setDireccionCli(clienteVo.getDireccionCli());
			cliente.setEmailCli(clienteVo.getEmailCli());
			cliente.setTelefonoCli(clienteVo.getTelefonoCli());
		}

		return new ResponseEntity<>(this.clienteService.update(cliente), HttpStatus.OK);
	}

	@DeleteMapping("/{identificacion}")
	@ApiOperation(value = "Eliminar Cliente", notes = "Servicio para eliminar un nuevo cliente")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "cliente eliminado correctamente"),
			@ApiResponse(code = 404, message = "Cliente no encontrado")})
	public void removeCliente(@PathVariable("identificacion") String identificacion) {
		Cliente cliente = this.clienteService.findByIdentificacion(identificacion);
		if (cliente != null) {
			this.clienteService.delete(cliente);
		}
	}

	@GetMapping
	@ApiOperation(value = "Listar Clientes", notes = "Servicio para listar todos los clientes")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Clientes encontrados"),
			@ApiResponse(code = 404, message = "Clientes no encontrados")})
	public ResponseEntity<List<Cliente>> findAll() {
		return ResponseEntity.ok(this.clienteService.findAll());
	}

}
