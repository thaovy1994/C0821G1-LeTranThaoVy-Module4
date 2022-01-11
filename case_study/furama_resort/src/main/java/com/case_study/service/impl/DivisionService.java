package com.case_study.service.impl;

import com.case_study.model.Division;
import com.case_study.repository.IDivisionRepository;
import com.case_study.service.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "divisionService")
public class DivisionService implements IDivisionService {
    @Autowired
    @Qualifier(value = "iDivisionRepository")
    private IDivisionRepository divisionRepository;

    @Override
    public List<Division> getAll() {
        return divisionRepository.findAll();
    }
}
