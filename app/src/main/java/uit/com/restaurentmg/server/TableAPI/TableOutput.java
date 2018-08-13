package uit.com.restaurentmg.server.TableAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TableOutput {

        @SerializedName("success")
        @Expose
        private Boolean success;
        @SerializedName("status")
        @Expose
        private Integer status;
        @SerializedName("data")
        @Expose
        private List<TableDataOutput> data = null;

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

    public List<TableDataOutput> getData() {
        return data;
    }

    public void setData(List<TableDataOutput> data) {
        this.data = data;
    }
}
