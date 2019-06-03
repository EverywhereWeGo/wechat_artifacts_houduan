package a_controller;

import b_util.SpliderWechat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

@RestController
public class HelloController {

    @RequestMapping("/getList")
    public String index() throws SQLException, URISyntaxException, IOException {
        SpliderWechat asdf = new SpliderWechat();
        return asdf.asasdf();

    }
}