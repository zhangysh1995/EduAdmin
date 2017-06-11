package controllers;

import database.ScoreManager;
import objects.Score;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by KellyZhang on 2017/6/1.
 */

@Controller
public class ScoreController {
    // auto-generated stub
@RequestMapping(value="/myscores", method= RequestMethod.GET)
    public String showScores(@RequestParam(value = "studentNo", defaultValue = "00000000") String studentNo, Model model) {

    Score results [] =  ScoreManager.fetchScore(studentNo);
    model.addAttribute("studentNo", studentNo);
    model.addAttribute("scores",results);
    return "/utilities/scores";
    }

    @RequestMapping(value="/teacher/scores", method=RequestMethod.GET)
    public ModelAndView scores(Model model) {
        model.addAttribute("rows", ScoreManager.fetchAll());
        return new ModelAndView("/utilities/editScores", "score", new Score());
    }

    @RequestMapping(value="/teacher/addScore", method=RequestMethod.POST)
    public String addScore(@Validated @ModelAttribute("score") Score score, BindingResult result, Model model) {
      ScoreManager.add(score);
        return "/utilities/editScores";
    }
}
