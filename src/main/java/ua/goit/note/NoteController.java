package ua.goit.note;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/note")
public class NoteController {

    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping(value = "/list")
    public ModelAndView getNoteList() {
        ModelAndView result = new ModelAndView("note");
        result.addObject("note" , noteService.getListAll());
        return result;
    }

    @PostMapping(value = "/delete")
    public String deleteNote(@RequestParam(name = "id", required = false) Long id) {
        if (id == null) {
            id = noteService.getLastId();
        }
        noteService.deleteById(id);
        return "redirect:/note/list";
    }

    @GetMapping(value = "/edit")
    public ModelAndView editNotePage(@RequestParam(name = "id", required = false) Long id) {
        if (id == null) {
            id = noteService.getLastId();
        }
        ModelAndView result = new ModelAndView("note");
        result.addObject("note", noteService.getById(id));
        return result;
    }

    @PostMapping(value = "/edit")
    public String editNote(@RequestParam(name = "id", required = false) Long id,
                                 @RequestParam("title") String title,
                                 @RequestParam("content") String content)
    {
        Note editNote = noteService.getById(id);
        editNote.setId(id);
        editNote.setTitle(title);
        editNote.setContent(content);
        noteService.update(editNote);
        return "redirect:/note/list";
    }
}
