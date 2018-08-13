package uit.com.restaurentmg.MVPWorkFlow.Model.entity.table;

public class Table {

public static String ID = "id";
	public static String NAME = "name";
	public static String STATE = "state";
	public static String NROW = "nRow";
	public static String NCOL = "nCol";

    private long id;
    private String name;
    private boolean state;
    private int nRow;
    private int nCol;

    public Table(){

    }

    public int getnRow() {
        return nRow;
    }

    public void setnRow(int nRow) {
        this.nRow = nRow;
    }

    public int getnCol() {
        return nCol;
    }

    public void setnCol(int nCol) {
        this.nCol = nCol;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Bạn đang ở bàn " + this.name +" ở vị trí: " + "hàng thứ " + this.nRow +" cột " + this.nCol;
    }
}
