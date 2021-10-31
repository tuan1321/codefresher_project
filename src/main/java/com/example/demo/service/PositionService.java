package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Position;

public interface PositionService {
		// lấy thông tin phòng ban
		List<Position> getAllPosition();
		//	 Ø	Thêm
		Position addPosition(Position position);
		
		//	 Ø Sửa
		Position updatePosition(Position position);
		
		//	 Ø Xóa
		boolean deletePosition(long id);
		
		//get theo id
		Position getById(long id);
}
