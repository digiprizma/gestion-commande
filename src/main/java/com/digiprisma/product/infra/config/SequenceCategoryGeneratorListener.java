package com.digiprisma.product.infra.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import com.digiprisma.client.infra.config.SequenceGeneratorService;
import com.digiprisma.client.persistence.model.ClientDpo;
import com.digiprisma.product.persistence.model.CategoryDpo;
import com.digiprisma.product.persistence.model.ProductDpo;

@Component
public class SequenceCategoryGeneratorListener extends AbstractMongoEventListener<CategoryDpo> {

	private SequenceCategoryGeneratorService sequenceCategoryGeneratorService;

	@Autowired
	public SequenceCategoryGeneratorListener(SequenceCategoryGeneratorService sequenceGenerator) {
		this.sequenceCategoryGeneratorService = sequenceGenerator;
	}

	@Override
	public void onBeforeConvert(BeforeConvertEvent<CategoryDpo> event) {
		if (event.getSource().getId() < 1) {
			event.getSource().setId(sequenceCategoryGeneratorService.generateSequence(CategoryDpo.SEQUENCE_NAME));
		}
	}
}
