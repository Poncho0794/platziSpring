package com.platzi.ereservation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.platzi.ereservation.model.Cliente;

/**
 *  Interfaz para definir las operaciones de base de datos relacionadas con el cliente
 * @author Poncho
 *
 */
public interface ClienteRepository extends JpaRepository<Cliente, String> {
	/**
	 * Definicion de metodo para biscar los clientes por su apellido
	 * @param apellidoCli
	 * @return
	 */
	public List<Cliente> findByApellidoCli(String apellidoCli);
	
	public Cliente findByIdentificacion(String identificacionCli);
	
	
	
}
