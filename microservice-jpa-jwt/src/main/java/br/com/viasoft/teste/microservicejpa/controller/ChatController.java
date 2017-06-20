package br.com.viasoft.teste.microservicejpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ChatController {

    private SimpMessagingTemplate template;

    @Autowired
    public ChatController(SimpMessagingTemplate template) {
        this.template = template;
    }

    @GetMapping
    @RequestMapping("/chat")
    public @ResponseBody String chat(@RequestParam("usuario") String usuario, @RequestParam("mensagem") String mensagem) {
        template.convertAndSendToUser(usuario, "/queue/topic/notificacao", mensagem);
        template.convertAndSend("/topic/notificacao", mensagem);
        return usuario + " = " + mensagem;
    }

}
