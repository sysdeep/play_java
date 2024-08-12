package core.logic.models;

public class Attr implements IAttr {
    String _name;
    Integer _value;
    Integer _attr_id;

    public Attr(Integer attr_id, String name) {
        _attr_id = attr_id;
        _name = name;
    }

    @Override
    public Integer get_value() {
        return _value;
    }

    @Override
    public Integer get_attr_id() {
        return _attr_id;
    }

    @Override
    public String get_name() {
        return _name;
    }

    @Override
    public void set_value(Integer value) {
        _value = value;
    }
}