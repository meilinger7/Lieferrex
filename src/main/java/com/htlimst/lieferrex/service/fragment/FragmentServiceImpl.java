package com.htlimst.lieferrex.service.fragment;

import com.htlimst.lieferrex.model.Fragment;
import com.htlimst.lieferrex.repository.FragmentRepository;
import com.htlimst.lieferrex.repository.MandantRepository;
import com.htlimst.lieferrex.service.mandant.MandantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FragmentServiceImpl implements FragmentService {

    @Autowired
    private FragmentRepository fragmentRepository;

    
    @Override
    public List<Fragment> findFragmentByMandant_id(Long id){
        return fragmentRepository.findFragmentByMandant_id(id);
    }

}
