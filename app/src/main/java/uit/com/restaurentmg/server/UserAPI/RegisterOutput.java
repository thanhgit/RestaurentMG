package uit.com.restaurentmg.server.UserAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegisterOutput {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("data")
    @Expose
    private RegisterDataOutput data;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public RegisterDataOutput getData() {
        return data;
    }

    public void setData(RegisterDataOutput data) {
        this.data = data;
    }
}
