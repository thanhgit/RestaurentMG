package uit.com.restaurentmg.server.UserAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginDataOutput {

    @SerializedName("state")
    @Expose
    private Boolean state;
    @SerializedName("message")
    @Expose
    private String message;

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

