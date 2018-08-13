package uit.com.restaurentmg.server.TableAPI;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface TableClient {

    @GET("/resa/api/v1/tables")
    Call<TableOutput> getAllTable();

    @GET("/resa/api/v1/tables/{id}")
    Call<TableByIdOutput> getPayment(@Path("id") long id);

    @POST("/resa/api/v1/tables/{id}/drinks")
    Call<TableAddOutput> addDrinkToTable(@Path("id")long id,@Body JsonObject jsonObject);

    @POST("/resa/api/v1/tables/{id}/drinks")
    Call<TableAddOutput> addToTable(@Path("id")long id,@Body JsonObject jsonObject);

    @POST("/resa/api/v1/tables")
    Call<TableAddOutput> addTable(@Body JsonObject jsonObject);



}
