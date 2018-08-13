package uit.com.restaurentmg.server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

public class ServerClient {
    private static Retrofit server = null;
    public static Retrofit getServer(String base_url){
        OkHttpClient builder = new OkHttpClient.Builder()
                                    .readTimeout(5000,TimeUnit.MILLISECONDS)
                                    .writeTimeout(5000, TimeUnit.MILLISECONDS)
                                    .connectTimeout(10000, TimeUnit.MILLISECONDS)
                                    .retryOnConnectionFailure(true)
                                    .build();
        Gson gson = new GsonBuilder().setLenient().setDateFormat("dd-MM-yyy").create();

        server = new Retrofit.Builder().baseUrl(base_url).client(builder)
                            .addConverterFactory(GsonConverterFactory.create(gson))
                            .build();

        return server;
    }
}
