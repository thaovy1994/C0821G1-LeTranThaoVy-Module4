package com.case_study.service.impl;

import com.case_study.model.Position;
import com.case_study.repository.IPositionRepository;
import com.case_study.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "positionService")
public class PositionService implements IPositionService {
    @Autowired
    @Qualifier(value = "iPositionRepository")
    private IPositionRepository positionRepository;

    @Override
    public List<Position> getAll() {
        return positionRepository.findAll();
    }
}
