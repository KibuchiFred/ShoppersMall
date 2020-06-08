package com.apple.controllers.session_trial;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SessionHandler {
    @PostMapping("/addNote")
    public String addNote(@RequestParam("note") String note, HttpServletRequest httpRequest){

        //to get the notes from the request session
        //getSession method returns a http session object, if not yet, creates  a new session
        //and binds it to he request
        List<String> notes = (List<String>) httpRequest.getSession().getAttribute("NOTES_SESSION");

        //check if the notes exists in the session or not
        if(notes == null){
            notes = new ArrayList<>();

            //if not, set the notes in the request session
            httpRequest.getSession().setAttribute("NOTES_SESSION", notes);
        }
            notes.add(note);
            httpRequest.getSession().setAttribute("NOTES_SESSION",notes);

            return "sessionHome";
    }

    @GetMapping("/sessionHome")

    public String sessionHome(Model model, HttpSession httpSession){
        List<String> notes = (List<String>) httpSession.getAttribute("NOTES_SESSION");
        model.addAttribute("notesSession", notes != null ? notes :new ArrayList<>());
        return "sessionHome";

    }

    //to invalidate the session after use
    @PostMapping("/invalidateSession")
    public String invalidateSession(HttpServletRequest request){
        //this will clear session data from the configured database(redis)
        request.getSession().invalidate();

        return "redirect:/sessionHome";

    }

}
