/**
 * 
 */
package com.platzi.ereservation.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.platzi.ereservation.model.Cliente;
import com.platzi.ereservation.repository.ClienteRepository;

/**
 * Clase para definir los servicios del cliente
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
	/**
	 * Metodo para mandar la lista de clientes
	 * @param identificacionCli
	 * @return
	 */
	public List<Cliente> findAll() {
		return this.clienteRepository.findAll();
	}
	
	public Cliente findById(String id) {
		return this.clienteRepository.findById(id).get();
	}
	
	
}
