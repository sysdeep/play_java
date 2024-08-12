package nui.units.standart_dsensor;

import core.logic.models.IAttr;
import core.logic.models.IAttrObserver;
import core.logic.models.IModel;

import nui.interfaces.IDSensor;

public class StandartDSensorProto implements IAttrObserver {
    IDSensor _view;
    IModel _model;
    // Map<Integer, Consumer<Integer>> _handlers;

    public StandartDSensorProto(IDSensor view) {
        _view = view;

        // TODO: for example
        // HashMap<Integer, String> passportsAndNames = new HashMap<>();
        // _handlers = new HashMap<>();

        // _handlers.put(1, (Integer attr_id) -> _on_state(attr_id));
        // _handlers.put(2, (Integer attr_id) -> _on_state(attr_id));
        // _handlers.put(3, (Integer attr_id) -> _on_state(attr_id));
    }

    // private void _on_state(int attr_id) {
    // _view.set_state(false);
    // }

    public void set_model(IModel model) {
        _model = model;
        _model.register_attr_observer(this);

        // for(model.get_attrs(): attr){

        // }
    }

    @Override
    public void on_attr_changed(int attr_id) {
        IAttr attr = _model.get_attr(attr_id);

        switch (attr_id) {
            case 1:
                Integer value = attr.get_value();
                _view.set_state(value > 0);
                break;

            default:
                break;
        }
        // IAttr attr = _model.get_attr(attr_id);

        // System.out.println(attr.get_value());

        // _handlers.get(attr_id)(attr_id);

    }

}
