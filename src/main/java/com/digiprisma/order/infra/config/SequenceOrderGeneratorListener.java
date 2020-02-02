package com.digiprisma.order.infra.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import com.digiprisma.client.persistence.model.ClientDpo;
import com.digiprisma.order.persistence.model.OrderDpo;

@Component
public class SequenceOrderGeneratorListener extends AbstractMongoEventListener<OrderDpo> {

	private SequenceOrderGeneratorService sequenceOrderGeneratorService;

	@Autowired
	public SequenceOrderGeneratorListener(SequenceOrderGeneratorService sequenceGenerator) {
		this.sequenceOrderGeneratorService = sequenceGenerator;
	}

	@Override
	public void onBeforeConvert(BeforeConvertEvent<OrderDpo> event) {
		if (event.getSource().getId() < 1) {
			event.getSource().setId(sequenceOrderGeneratorService.generateSequence(OrderDpo.SEQUENCE_NAME));
		}
	}
}
