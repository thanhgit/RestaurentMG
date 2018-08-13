package uit.com.restaurentmg.server.DrinkAPI;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DrinkClient {
    @GET("/resa/api/v1/drinks")
    Call<DrinkOutput> getDrinks();

    @GET("/resa/api/v1/drinks/{id}")
    Call<DrinkFindOutput> getDrinkById(@Path("id") long id);

    @GET("/resa/api/v1/foods")
    Call<DrinkQueryNameOutput> getDrinksByName(@Query("name") String name);
}
