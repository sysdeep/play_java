package pro.comcon.core.logic.project;

import java.util.ArrayList;

import pro.comcon.core.logic.models.BaseModel;

public class Project implements IProject {
    ArrayList<BaseModel> _objects;

    @Override
    public ArrayList<BaseModel> get_objects() {
        return _objects;
    }

    public BaseModel get_node(String node_path) {
        // TODO
        return null;
    }

}
