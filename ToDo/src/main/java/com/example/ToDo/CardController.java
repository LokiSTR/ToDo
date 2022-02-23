package com.example.ToDo;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CardController {
    
    ArrayList<Card> cards;

    public CardController(){
        setCards(new ArrayList<Card>());
        addCard("Bananen...", "... sind zum Essen da!!");
    }

    @GetMapping("/cards")
    public String cards(@RequestParam(name="activePage", required = false, defaultValue = "cards") String activePage, Model model){
        model.addAttribute("activePage", "cards");
        model.addAttribute("cards", getCards());
        return "index.html";
    }

    public void addCard(String ueberschrift, String text){
        Card card = new Card(ueberschrift, text);
        getCards().add(card);
    }



// agenda building, agenda setting pgw

    @RequestMapping("/delcard")
    public String delcard(@RequestParam(name="id", required = true, defaultValue = "null") int id, @RequestParam(name="activePage", required = false, defaultValue = "cards") String activePage, Model model){
        
        getCards().remove(id);

        model.addAttribute("cards", getCards());
        model.addAttribute("activePage", "cards");
        return "index.html";
    }

/**   @RequestMapping("/addcard")
    public String addcard(@RequestParam(name="cardDesc", required = true, defaultValue = "null") String cardDesc, @RequestParam(name="activePage", required = false, defaultValue = "cards") String activePage, Model model){
        
        getCards().add(cardDesc);
        
        model.addAttribute("cards", getCards());
        model.addAttribute("activePage", "cards");

        return "index.html";
    }
**/

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
}