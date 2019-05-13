package ServerHallPackage;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/ServerHallDBService")
public class ServerHallDBService {

    private static ServerHallDBDao serverDao = new ServerHallDBDao();

    @GET
    @Path("/hi")
    @Produces(MediaType.TEXT_PLAIN)
    public String test() {

        return "Hej, det funkar";
    }

    @GET
    @Path("/temperature/latest")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TempTable> getLatestTemperature() {
        return serverDao.getLatestTemperature();
    }

    @GET
    @Path("/econsumption/latest")
    @Produces(MediaType.APPLICATION_JSON)
    public List<EconsumptionTable> getLatestConsumption() {
        return serverDao.getLatestConsumption();
    }

    @GET
    @Path("/eprice/latest")
    @Produces(MediaType.APPLICATION_JSON)
    public List<EpriceTable> getEprice() {
        return serverDao.getEprice();
    }

    @POST
    @Path("/temperature/add")
    public Response insertTemp(TempTable t) {

        Response res = new Response("New Temperature added", Boolean.FALSE);

        serverDao.insertTemp(t);
        res.setStatus(Boolean.TRUE);
        return res;

    }

    @POST
    @Path("/eprice/add")
    public Response insertEprice(EpriceTable t) {

        Response res = new Response("New Eprice added", Boolean.FALSE);

        serverDao.insertEprice(t);
        res.setStatus(Boolean.TRUE);
        return res;

    }
    
    @GET
    @Path("/temperature/avg")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AvgTemperature> RapportAvgMinMax(){
        return serverDao.RapportAvgMinMax();
    }
    
    @GET
    @Path("/econsumption/avg")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AvgEconsumption> RapportAvgEcons(){
        return serverDao.RapportAvgEcons();
    }
    
    

}
