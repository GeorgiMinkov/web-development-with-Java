package com.fmi.web.theaterticketsystem.service;

import com.fmi.web.theaterticketsystem.model.Performer;

import java.util.List;

public interface PerformerService {
    List<Performer> findAll();
}
