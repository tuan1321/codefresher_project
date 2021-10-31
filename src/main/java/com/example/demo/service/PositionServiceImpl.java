package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Position;
import com.example.demo.repository.PositionRepository;

@Service
public class PositionServiceImpl implements PositionService {

	@Autowired
	private PositionRepository positionRepository;
	
	@Override
	public List<Position> getAllPosition() {
		// TODO Auto-generated method stub
		return positionRepository.findAll();
	}

	@Override
	public Position addPosition(Position position) {
		// TODO Auto-generated method stub
		return positionRepository.save(position);
	}

	@Override
	public Position updatePosition(Position position) {
		// TODO Auto-generated method stub
		return positionRepository.save(position);
	}

	@Override
	public boolean deletePosition(long id) {
		// TODO Auto-generated method stub
		if(getById(id) != null) {
			positionRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Position getById(long id) {
		// TODO Auto-generated method stub
		return positionRepository.getOne(id);
	}

}
