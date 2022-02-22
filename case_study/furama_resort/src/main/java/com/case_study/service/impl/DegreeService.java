package com.case_study.service.impl;

import com.case_study.model.employee.Degree;
import com.case_study.repository.employee.IDegreeRepository;
import com.case_study.service.IDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "degreeService")
public class DegreeService implements IDegreeService {
    @Autowired
    @Qualifier(value = "iDegreeRepository")
    private IDegreeRepository degreeRepository;

    @Override
    public List<Degree> getAll() {
        return degreeRepository.findAll();
    }
}
