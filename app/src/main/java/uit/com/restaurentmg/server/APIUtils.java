package uit.com.restaurentmg.server;

import uit.com.restaurentmg.server.DrinkAPI.DrinkClient;
import uit.com.restaurentmg.server.FoodAPI.FoodClient;
import uit.com.restaurentmg.server.UserAPI.UserClient;
import uit.com.restaurentmg.server.PaymentAPI.PaymentClient;

public class APIUtils {
    public static final String BASE_URL ="http://202.182.112.206/";

    public static UserClient getUserClient(){
        return ServerClient.getServer(BASE_URL).create(UserClient.class);
    }

    public static FoodClient getFoodClient(){
        return ServerClient.getServer(BASE_URL).create(FoodClient.class);
    }

    public static DrinkClient getDrinkClient(){
        return ServerClient.getServer(BASE_URL).create(DrinkClient.class);
    }

    public static PaymentClient getPaymentClient(){
        return ServerClient.getServer(BASE_URL).create(PaymentClient.class);
    }
}
