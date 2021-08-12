package ro.fasttrackit.finalproject.petclinicreservation.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ro.fasttrackit.finalproject.petclinicreservation.service.ReservationService;

@Controller
@RequestMapping("reservations")
public class ReservationUiController {
    private final ReservationService service;

    public ReservationUiController( ReservationService service ){
        this.service = service;
    }

    @GetMapping
    String reservationPage( Model model ){
        model.addAttribute("reservations", service.getAll());
        return "reservations";
    }

    @GetMapping("{reservationId}")
    String singleReservationPage( @PathVariable int reservationId, Model pageModel ){
        pageModel.addAttribute("reservation", service.getReservationId(reservationId)
                .orElse(null));

        return "single-reservation";
    }
}
