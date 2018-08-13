package uit.com.restaurentmg.server.PaymentAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PaymenDataOutput {


    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("table")
    @Expose
    private PaymenTableOutput table;
     @SerializedName("money")
    @Expose
    private Integer money;
    @SerializedName("state")
    @Expose
    private Boolean state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PaymenTableOutput getTable() {
        return table;
    }

    public void setTable(PaymenTableOutput table) {
        this.table = table;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

}
