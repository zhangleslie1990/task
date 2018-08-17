package serviceimpl;

import daobase.DaoSupportImpl;
import mapper.demomapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.demo;

import java.util.List;
import java.util.Map;

@Service
public class demoImpl implements demo {
    @Autowired
    DaoSupportImpl daoSupport;
    @Autowired
    demomapper demomapper;

    public void getAll() {
        List<Map> list = demomapper.getAll();
        for (Map map : list) {
            System.out.println(map);
        }
    }

    public static void main(String[] args) {
        new demoImpl().getAll();
    }
}
