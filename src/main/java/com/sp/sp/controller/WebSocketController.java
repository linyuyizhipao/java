package com.sp.sp.controller;


import com.sp.sp.exception.SpException;
import com.sp.sp.service.WebSocketServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author fengtao.xue
 */
@RestController
public class WebSocketController {
    static Logger logger = LoggerFactory.getLogger(WebSocketController.class);

    @Autowired
    WebSocketServer webSocketServer;

    /**
     * 群发消息内容
     *
     * @param message
     * @return
     */
    @RequestMapping(value = "/ws/sendAll", method = RequestMethod.GET)
    public String sendAllMessage(@RequestParam(required = true) String message) {
        try {
            webSocketServer.broadCastInfo(message);
        } catch (SpException e) {
            e.printStackTrace();
        }
        return "success";
    }

    /**
     * 指定会话ID发消息
     *
     * @param message 消息内容
     * @param userId  连接会话ID
     * @return
     */
    @RequestMapping(value = "/ws/sendOne", method = RequestMethod.GET)
    public String sendOneMessage(@RequestParam(required = true) String message,
                                 @RequestParam(value="user_id" ,required = true) String userId) {
        try {
            webSocketServer.sendToUser(userId, message);
        } catch (SpException e) {
            e.printStackTrace();
        }
        return "success";
    }

    /**
     * 指定会话ID发消息
     * @param userId  连接会话ID
     * @return
     */
    @GetMapping(value = "/index")
    public ModelAndView index(@RequestParam(value="user_id") String userId) {
        logger.info("胡爽");
        ModelAndView mav=new ModelAndView("/index");
        mav.addObject("userId", userId);
        return mav;
    }
}