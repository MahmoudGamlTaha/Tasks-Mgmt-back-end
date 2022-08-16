package com.hc.managers;

import com.hc.model.EmsExpertCertificate;
import com.hc.model.EmsExpertCertificatePK;
import com.hc.model.EmsExpertCertificate_;
import com.hc.model.EmsExpertEducation;
import com.hc.model.EmsExpertEducationPK;
import com.hc.model.EmsExpertExperience;
import com.hc.model.EmsExpertExperience_;
import com.hc.repositories.EmsExpertCertificateRepository;
import com.hc.security.administration.UserRepo;
import com.hc.security.administration.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
* Generated by Spring Data Generator on 01/01/2022
*/
@Service
@RequiredArgsConstructor
@Slf4j
public class EmsExpertCertificateService {

	private EmsExpertCertificateRepository emsExpertCertificateRepository;
	
	public static Specification<EmsExpertCertificate> getTasksSpecs(Long ExpertId) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get(EmsExpertCertificate_.emsExpert), ExpertId);
        };
    }

	@Autowired
	public EmsExpertCertificateService(EmsExpertCertificateRepository emsExpertCertificateRepository) {
		this.emsExpertCertificateRepository = emsExpertCertificateRepository;
	}
	public EmsExpertCertificate addNewCertificate(EmsExpertCertificate e) {
		e=emsExpertCertificateRepository.save(e);
		return e;
		
	}
	public EmsExpertCertificate getCertificate(EmsExpertCertificatePK Id) {
		return emsExpertCertificateRepository.getById(Id);
	}
	public EmsExpertCertificatePK deleteCertificate(EmsExpertCertificatePK Id) {
		emsExpertCertificateRepository.deleteById(Id);
		 return Id;
	}
	
	public List<EmsExpertCertificate> getExperiencebyExpert(Long ExpertId) {
		return emsExpertCertificateRepository.findAll(getTasksSpecs(ExpertId));
	}

}
