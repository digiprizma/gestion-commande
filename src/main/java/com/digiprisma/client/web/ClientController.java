package com.digiprisma.client.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digiprisma.client.api.dto.ClientRequest;
import com.digiprisma.client.core.application.ClientService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@Api(value = "Clients", tags = "Clients")
@RequestMapping(value = "/api/v0/", produces = { MediaType.APPLICATION_JSON_VALUE })
@Slf4j
public class ClientController {

	@Autowired
	private ClientService clientService;

	/**
	 * Get all client
	 *
	 * @return a list of clients
	 */
	@GetMapping(value = "clients", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Get all clients")
	public ResponseEntity<?> getClients() {
		return ResponseEntity.ok(clientService.getAllClients());
	}

	@PostMapping(value = "client", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Create client")
	public ResponseEntity<?> createClient(@RequestBody @Valid ClientRequest request) throws Exception {
		return ResponseEntity.ok(clientService.createClient(request));
	}

	@DeleteMapping(value = "/client")
	@ApiOperation(value = "Delete client")
	public String deleteClient(@RequestParam String id) throws Exception {
		clientService.deleteClient(id);
		return HttpStatus.OK.toString();

	}

	@PutMapping(value = "/client", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Update client")
	public ResponseEntity<?> updateClient(@RequestBody @Valid ClientRequest request) throws Exception {
		return ResponseEntity.ok(clientService.updateClient(request));
	}
}
