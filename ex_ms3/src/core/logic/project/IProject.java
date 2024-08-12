package core.logic.project;

import java.util.ArrayList;

import core.logic.models.BaseModel;

public interface IProject {

    public ArrayList<BaseModel> get_objects();

    public BaseModel get_node(String node_path);
}
