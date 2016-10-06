package com.wellsfargo.cbtrest.controller;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import com.wellsfargo.cbtrest.model.CBTRequest;
import com.wellsfargo.cbtrest.model.CBTResponse;
import com.wellsfargo.cbtrest.service.CBTService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@Path("/cbt")
@Api(value = "/cbt", description = "Process the CBT WS Call")
public class CBTRestController {
	@Inject
	private CBTService cbtService;
/*
	@Produces({ MediaType.APPLICATION_JSON })
	@POST
	@ApiOperation(value = "Process the CBT WS Call", notes = "Process the CBT WS Call", response = CBTResponse.class)
	@ApiResponses({
			@ApiResponse(code = 200, message = "Request Processed Successfully without wsfault"),
			@ApiResponse(code = 409, message = "Request failed with wsfault") })
	public CBTResponse processCBTRequest(
			@Context final UriInfo uriInfo,
			@ApiParam(value = "originator", required = false) @FormParam("originator") final String originator,
			@ApiParam(value = "messageId", required = false) @FormParam("messageId") final String messageId,
			@ApiParam(value = "component", required = true) @FormParam("component") final String component,
			@ApiParam(value = "function", required = true) @FormParam("function") final String function,
			@ApiParam(value = "argument", required = true) @FormParam("argument") final String[] argument) {
		CBTRequest request = new CBTRequest();
		if (null != messageId && null != originator) {
			CBTContext context = new CBTContext(originator, messageId);
			request.setContext(context);
		}
		if (null != argument && argument.length > 0) {
			Arguments arguments = new Arguments();
			arguments.setArgument(argument);
			request.setArguments(arguments);
		}
		request.setComponent(component);
		request.setFunction(function);

		return cbtService.processCBTRequest(request);
	}*/
	
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	@POST
	@ApiOperation(value = "Process the CBT WS Call with JSON Request", notes = "Process the CBT WS Call with JSON Request", response = CBTResponse.class)
	@ApiResponses({
			@ApiResponse(code = 200, message = "Request Processed Successfully without wsfault"),
			@ApiResponse(code = 409, message = "Request failed with wsfault"),
			@ApiResponse(code = 500, message = "Request failed with fault")})
	public CBTResponse processCBTJSONRequest(
			@Context final UriInfo uriInfo,
			@ApiParam(value = "request", required = false ) final CBTRequest request)  {
		//ObjectMapper mapper = new ObjectMapper();
		//JSON from String to Object
		//CBTRequest cbtRequest = mapper.readValue(request, CBTRequest.class);
		return cbtService.processCBTRequest(request);
	}

}
