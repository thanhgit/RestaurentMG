package uit.com.restaurentmg.server.FoodAPI;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface FoodClient {

    @GET("/resa/api/v1/foods")
    Call<FoodOutput> getFoods();

    @GET("/resa/api/v1/foods/{id}")
    Call<FoodFindOuput> getFoodById(@Path("id") long id);

    @GET("/resa/api/v1/foods")
    Call<FoodyQueryNameOutput> getFoodByName(@Query("name") String name);
}
