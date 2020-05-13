package com.example.anytime.controller;

import com.example.anytime.model.Event;
import com.example.anytime.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class EventController {

    @Autowired
    EventService eventService;

    @PostMapping("/event")
    public Event save(@RequestBody Event event) {
        return eventService.save(event);
    }

    @PutMapping("/event")
    public Event update(@RequestBody Event event){ return eventService.save(event); }

    @ResponseStatus(value = HttpStatus.OK)
    @DeleteMapping("/event/{id}")
    public void delete(@PathVariable  int id){eventService.deleteById(id); }

    @GetMapping("/event")
    public Iterable<Event> findAll() { return eventService.findAll(); }

    @GetMapping("/event/{id}")
    public Optional<Event> findById(@PathVariable  int id) {
        return eventService.findById(id);
    }


    @PostMapping("/eventsbyevent")
    public List<Event> findByEvent(@RequestBody Event event) {
        return (List<Event>) eventService.findByEvent(event.getAllevent().getIdevent());
    }

    @PostMapping("/eventsbyuser")
    public List<Event> findByUser(@RequestBody Event event) {
        return (List<Event>) eventService.findByUser(event.getUser().getIduser());
    }


    // AFMELDEN VOOR EVENT
    @GetMapping("/testafmelden")
    public List<Integer> LogoutEvent(@RequestBody Event event) {
        return eventService.findIdByUserAndEvent(event.getUser().getIduser(), event.getAllevent().getIdevent());
    }

    @PostMapping("/logoutevent")
    public void delete(@RequestBody Event event){
        List<Integer> currentIDList = LogoutEvent(event);
        for (int i = 0; i < currentIDList.size(); i++) {
            eventService.deleteById(currentIDList.get(i));
        }
    }

    @GetMapping("/testaccountdelete")
    public List<Integer> removeaccount(@RequestBody Event event) {
        return eventService.findIdByUser(event.getUser().getIduser());
    }

    @PostMapping("/deleteaccount")
    public void deleteaccount(@RequestBody Event event){
        List<Integer> currentIDList = removeaccount(event);
        for (int i = 0; i < currentIDList.size(); i++) {
            eventService.deleteById(currentIDList.get(i));
        }
    }

    @GetMapping("/testeventdelete")
    public List<Integer> removeevent(@RequestBody Event event) {
        return eventService.findIdByEvent(event.getAllevent().getIdevent());
    }

    @PostMapping("/deleteevent")
    public void deleteevent(@RequestBody Event event){
        List<Integer> currentIDList = removeevent(event);
        for (int i = 0; i < currentIDList.size(); i++) {
            eventService.deleteById(currentIDList.get(i));
        }
    }


}

