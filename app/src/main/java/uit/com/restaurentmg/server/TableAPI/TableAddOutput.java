package uit.com.restaurentmg.server.TableAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TableAddOutput {

        @SerializedName("success")
        @Expose
        private Boolean success;
        @SerializedName("status")
        @Expose
        private Integer status;
        @SerializedName("data")
        @Expose
        private TableAddDataOutput data;

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

    public TableAddDataOutput getData() {
        return data;
    }

    public void setData(TableAddDataOutput data) {
        this.data = data;
    }
}
