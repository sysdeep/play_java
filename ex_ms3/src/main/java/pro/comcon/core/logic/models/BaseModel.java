package pro.comcon.core.logic.models;

import java.util.ArrayList;

public class BaseModel implements IModel {
    ArrayList<Attr> _attrs;
    ArrayList<IAttrObserver> _attr_observers;
    String _sys_id;
    String _plc_id;
    String _obj_id;
    String _name;
    ArrayList<BaseModel> _childrens;
    BaseModel _parent;

    public BaseModel() {

    }

    @Override
    public ArrayList<Attr> get_attrs() {
        return _attrs;
    }

    @Override
    public Attr get_attr(int attr_id) {
        // TODO: to map
        return _attrs.stream().filter((IAttr item) -> item.get_attr_id() == attr_id).findFirst().orElse(null);
    }

    @Override
    public void register_attr_observer(IAttrObserver observer) {
        _attr_observers.add(observer);
    }

    @Override
    public void set_attr_value(Integer attr_id, Integer value) {
        Attr attr = get_attr(attr_id);
        if (attr != null) {
            attr.set_value(value);
        }

        for (IAttrObserver observer : _attr_observers) {
            observer.on_attr_changed(attr_id);
        }
    }

    @Override
    public Integer get_attr_value(Integer attr_id) {
        Attr attr = get_attr(attr_id);
        if (attr != null) {
            return attr.get_value();
        }

        return null;
    }

    public ArrayList<BaseModel> get_childrens() {
        return _childrens;
    }

    public BaseModel get_node(String node_path) {
        // TODO
        return null;
    }

}
