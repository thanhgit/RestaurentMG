package uit.com.restaurentmg.server.TableAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TableByIdOutput {

        @SerializedName("success")
        @Expose
        private Boolean success;
        @SerializedName("status")
        @Expose
        private Integer status;
        @SerializedName("data")
        @Expose
        private TableByIdOutput data;

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

    public TableByIdOutput getData() {
        return data;
    }

    public void setData(TableByIdOutput data) {
        this.data = data;
    }
}
