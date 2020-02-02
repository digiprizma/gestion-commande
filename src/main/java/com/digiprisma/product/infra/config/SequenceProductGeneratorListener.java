package com.digiprisma.product.infra.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import com.digiprisma.product.persistence.model.ProductDpo;

@Component
public class SequenceProductGeneratorListener extends AbstractMongoEventListener<ProductDpo> {

	private SequenceProductGeneratorService sequenceProductGeneratorService;

	@Autowired
	public SequenceProductGeneratorListener(SequenceProductGeneratorService sequenceGenerator) {
		this.sequenceProductGeneratorService = sequenceGenerator;
	}

	@Override
	public void onBeforeConvert(BeforeConvertEvent<ProductDpo> event) {
		if (event.getSource().getId() < 1) {
			event.getSource().setId(sequenceProductGeneratorService.generateSequence(ProductDpo.SEQUENCE_NAME));
		}
	}
}
