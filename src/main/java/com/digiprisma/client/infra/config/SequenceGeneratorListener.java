package com.digiprisma.client.infra.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import com.digiprisma.client.persistence.model.ClientDpo;

@Component
public class SequenceGeneratorListener extends AbstractMongoEventListener<ClientDpo> {

	private SequenceGeneratorService sequenceGenerator;

	@Autowired
	public SequenceGeneratorListener(SequenceGeneratorService sequenceGenerator) {
		this.sequenceGenerator = sequenceGenerator;
	}

	@Override
	public void onBeforeConvert(BeforeConvertEvent<ClientDpo> event) {
		if (event.getSource().getId() < 1) {
			event.getSource().setId(sequenceGenerator.generateSequence(ClientDpo.SEQUENCE_NAME));
		}
	}
}
