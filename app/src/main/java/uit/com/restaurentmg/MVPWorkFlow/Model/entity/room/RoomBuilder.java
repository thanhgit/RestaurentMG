package uit.com.restaurentmg.MVPWorkFlow.Model.entity.room;

import java.util.ArrayList;
import java.util.List;

import uit.com.restaurentmg.MVPWorkFlow.Model.entity.table.Table;
import uit.com.restaurentmg.MVPWorkFlow.Model.entity.table.TableBuilder;

public class RoomBuilder implements IRoom {

    private static IRoom iRoom;
    private static Room room;

    public static IRoom build(){
        iRoom = new RoomBuilder();
        room = new Room();
        return iRoom;
    }
    @Override
    public IRoom id(long id) {
        room.setId(id);
        return iRoom;
    }

    @Override
    public IRoom name(String name) {
        room.setName(name);
        return iRoom;
    }

    @Override
    public IRoom row(int row) {
        room.setRow(row);
        return iRoom;
    }

    @Override
    public IRoom col(int col) {
        room.setCol(col);
        return iRoom;
    }

    @Override
    public IRoom tables(List<Table> tables) {
        room.setTables(tables);
        return iRoom;
    }

    @Override
    public IRoom tables(int[] tables) {
        List<Table> tablesTmp = new ArrayList<>();
        for(int index=0 ; index<tables.length;index++){
            tablesTmp.add(TableBuilder.build()
                    .state((tables[index]>0?true:false))
                    .create());
        }
        room.setTables(tablesTmp);
        return iRoom;
    }

    @Override
    public Room create() {
        List<Table> tables = room.getTables();
        if(tables.size() > 0){
            int row=1;
            for (int index=1 ; index <= tables.size(); index ++){
                if(index % room.getCol() == 0){
                    tables.get(index-1).setnCol(room.getCol());
                    tables.get(index-1).setnRow(row);
                    row++;
                }else{
                    tables.get(index-1).setnCol(index % room.getCol());
                    tables.get(index-1).setnRow(row);
                }

                System.out.println(tables.get(index-1).toString());
            }

        }

        return room;
    }

}
