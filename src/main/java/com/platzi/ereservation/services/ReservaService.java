package com.platzi.ereservation.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.platzi.ereservation.model.Reserva;
import com.platzi.ereservation.repository.ReservaRepository;

@Service
@Transactional(readOnly=true)
public class ReservaService {
	private final ReservaRepository reservaRepository;
	
	public ReservaService(ReservaRepository reservaRepository) {
		this.reservaRepository = reservaRepository;
	}
	
	@Transactional
	public Reserva create(Reserva reserva) {
		return this.reservaRepository.save(reserva);
	}
	
	@Transactional
	public Reserva update(Reserva reserva) {
		return this.reservaRepository.save(reserva);
	}
	
	@Transactional
	public void delete(Reserva reserva) {
		this.reservaRepository.delete(reserva);
	}
	
	public Reserva findById(String id) {
		return this.reservaRepository.findById(id).get();
	}
	
	public List<Reserva> find(Date fechaInicio, Date fechaSalida) {
		return this.reservaRepository.find(fechaInicio, fechaSalida);
	}
	
	public List<Reserva> findAll() {
		return this.reservaRepository.findAll();
	}
	

}
