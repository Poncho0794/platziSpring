/**
 * 
 */
package com.platzi.ereservation.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.platzi.ereservation.model.Cliente;
import com.platzi.ereservation.repository.ClienteRepository;

/**
 * Calse para definir los servicios del cliente
 * @author blue
 *
 */
@Service
@Transactional(readOnly=true)
public class ClienteService {
	private final ClienteRepository clienteRepository;
	
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	/**
	 * Metodo para realizar la operacion de guardar un cliente
	 * @param cliente
	 * @return cliente
	 */
	@Transactional
	public Cliente create(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}
	
	/**
	 * Metodo para realizar la actualizacion de un cliente
	 * @param cliente
	 * @return
	 */
	@Transactional
	public Cliente update(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}
	
	/**
	 * Metodo para eliinar un cliente
	 * @param cliente
	 */
	@Transactional
	public void delete(Cliente cliente) {
		this.clienteRepository.delete(cliente);
	}
	/**
	 * Metodo para encontrar un cliente por su identificación
	 * @param identificacionCli
	 * @return
	 */
	public Cliente findByIdentificacion(String identificacionCli) {
		return this.clienteRepository.findByIdentificacion(identificacionCli);
	}
}
