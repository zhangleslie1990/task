package springboot.springboot;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class demo {

    @RequestMapping("/index")
    public ModelAndView string() {
        JSONObject json = new JSONObject();
        json.put("name", "zhang");
        json.put("scor", 88);
        ModelAndView model = new ModelAndView();
        model.setViewName("index.jsp");
        model.addObject(json);
        return model;
    }

    @RequestMapping("/")
    public String demo1() {
        return "dgfhdfghdfg";
    }
}
