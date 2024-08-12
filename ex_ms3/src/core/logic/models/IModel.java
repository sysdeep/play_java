package core.logic.models;

import java.util.ArrayList;

public interface IModel {
    // public static final String E_ATTR_UPDATED = "attr_updated";

    public ArrayList<Attr> get_attrs();

    public IAttr get_attr(int attr_id);

    public void register_attr_observer(IAttrObserver observer);

    public void set_attr_value(Integer attr_id, Integer value);

    public Integer get_attr_value(Integer attr_id);
}
