package com.ker.rsm.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ker.rsm.dto.PartDTO;
import com.ker.rsm.entitymapper.PartMapper;
import com.ker.rsm.model.Part;
import com.ker.rsm.repo.PartRepo;
import com.ker.rsm.service.PartService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Slf4j
public class PartServiceImpl implements PartService {

	private final PartRepo partRepo;

	private final PartMapper partMapper;

	@Override
	public PartDTO getPart(Long id) {
		Part part = new Part();
		Optional<Part> optionalPart = partRepo.findById(id);
		if (optionalPart.isPresent()) {
			part = optionalPart.get();
			return partMapper.toDto(part);
		}
		else {
			return null;
		}
	}

	@Override
	public PartDTO savePart(PartDTO dto) throws Exception {
		Part part = new Part();
		if (dto.getId() == null) {
			part = partMapper.toEntity(dto);
			part = partRepo.save(part);
		} else {
			log.error("id cannot be present for new entry");
			throw new Exception("id cannot be present for new entry");
		}
		return partMapper.toDto(part);
	}

	@Override
	public void deletePart(Long id) throws Exception {
		Optional<Part> part = partRepo.findById(id);
		if (part.isPresent()) {
			partRepo.deleteById(id);
		} else {
			log.error("Part with id {} not present", id);
			throw new Exception("Part with id " + id + " not present");
		}
	}

}
