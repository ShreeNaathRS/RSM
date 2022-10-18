package com.ker.rsm.service;

import com.ker.rsm.dto.PartDTO;

public interface PartService {
	PartDTO getPart(Long id);
	PartDTO savePart(PartDTO dto) throws Exception;
	void deletePart(Long id) throws Exception;
}
