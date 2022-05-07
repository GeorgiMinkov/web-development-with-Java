package com.fmi.web.theaterticketsystem.service;

import com.fmi.web.theaterticketsystem.model.Performer;
import com.fmi.web.theaterticketsystem.repository.PerformerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerformerServiceImpl implements PerformerService {

    private PerformerRepository performerRepository;

    @Autowired
    public PerformerServiceImpl(PerformerRepository performerRepository) {
        this.performerRepository = performerRepository;
    }

    @Override
    public List<Performer> findAll() {
        return performerRepository.findAll();
    }
}
