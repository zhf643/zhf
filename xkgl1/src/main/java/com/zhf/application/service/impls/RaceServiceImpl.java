package com.zhf.application.service.impls;

import com.zhf.application.RaceInputDTO;
import com.zhf.signup.Race;
import com.zhf.signup.repository.RaceRepo;
import com.zhf.application.service.IRaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RaceServiceImpl implements IRaceService{
    @Autowired
    private RaceRepo repo;

    @Override
    public Object create(RaceInputDTO model){
        Race entity = new Race();
        entity.setYear(model.getYear());
        entity.setName(model.getName());
        entity.setProfession(model.getProfession());
        entity.setOrganizer(model.getOrganizer());
        entity.setLevel(model.getLevel());
        entity.setCategory(model.getCategory());
        return repo.save(entity);
    }
}
