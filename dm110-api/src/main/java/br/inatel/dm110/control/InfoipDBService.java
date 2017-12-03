package br.inatel.dm110.control;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/poller")
public interface InfoipDBService {
	@GET
	@Path("/start/{ip}/{mask}")
	@Produces(MediaType.TEXT_PLAIN)
	void sendIPMask(@PathParam("ip") String ip, @PathParam("mask") String mask);

	@GET
	@Path("/status/{ip}")
	@Produces(MediaType.TEXT_PLAIN)
	boolean showStatusIp(@PathParam("ip") String ip);
}
