package com.liao.controller;

import com.liao.dao.TulingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TulingController {
    @Autowired
    TulingDao tulingDao;

}
