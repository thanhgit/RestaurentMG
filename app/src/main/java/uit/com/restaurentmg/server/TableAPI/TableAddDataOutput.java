package uit.com.restaurentmg.server.TableAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TableAddDataOutput {


        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("state")
        @Expose
        private Boolean state;
        @SerializedName("nRow")
        @Expose
        private Integer nRow;
        @SerializedName("nCol")
        @Expose
        private Integer nCol;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Boolean getState() {
            return state;
        }

        public void setState(Boolean state) {
            this.state = state;
        }

        public Integer getNRow() {
            return nRow;
        }

        public void setNRow(Integer nRow) {
            this.nRow = nRow;
        }

        public Integer getNCol() {
            return nCol;
        }

        public void setNCol(Integer nCol) {
            this.nCol = nCol;
        }

    }