package testview.bawei.com.list;

/**
 * Created by Administrator on 2017/12/24.
 */

public class Bean {
    private String name;
    private boolean select;

    public Bean(String name, boolean select) {
        this.name = name;
        this.select = select;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }
}
