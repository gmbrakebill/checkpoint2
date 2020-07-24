package com.galvanize.flight_log;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/flights")
public class FlightController {

    private final FlightRepository repository;

    public FlightController(FlightRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all")
    public Iterable<Flight> getAll()
    {
        return this.repository.findAll();
    }
    @GetMapping("/pilot/{id}")
    public Flight[] getFlightsByPilot(@PathVariable Long id) {
        return this.repository.findPilotsById(id);
    }
    @DeleteMapping("/delete-pilot/{id}/{pilotId}")
   public String deletePilotById(@PathVariable Long id, @PathVariable Long pilotId)
    {
                this.repository.deleteById(pilotId);
                return "Deleted";

   }
    @PostMapping("/save")
    public Flight addFlight(@RequestBody Flight flight)
    {
        return this.repository.save(flight);
    }
    @DeleteMapping("/delete-flight/{id}")
    public String deleteFlightsById(@PathVariable long id)
    {
        this.repository.deleteById(id);
        return "Flight has been deleted";
    }
    @PatchMapping("flights/{id}")
    public Flight updateFlight (@RequestBody Flight flight, @PathVariable Long id)
    {
        Flight flightToUpdate = this.repository.findById(id).get();
        flightToUpdate.setDate(flight.getDate());
        return this.repository.save(flightToUpdate);
    }
//    @DeleteMapping("/deletepilot")
//    public void deletePilot(@RequestParam("id") long id)
//    {
//        this.pilotRepository.deleteById(id);
//    }
//    @GetMapping("/pilot/{id}")
//    public Flight[] flightsByPilot(@PathVariable Long id)
//    {
//       return this.repository.findFlightsbyId(id);
//    }
//    @PostMapping("/addpilot")
//    public Pilot addFlight(@RequestBody Pilot pilot)
//    {
//        return this.pilotRepository.save(pilot);
//    }
//    @PatchMapping("/id/{id}")
//    public Flight patch (@PathVariable Long id, @RequestBody Long pilot)
//    {
//
//        Pilot newpilot = this.pilotRepository.findById(pilot).get();
//        Flight oldFlight = this.repository.findById(id).get();
//        oldFlight.setPilot(newpilot);
//
//
//        return this.repository.save(oldFlight);
//    }
//    @PatchMapping("/updatePilot/{id}")
//    public Pilot patch (@PathVariable Long id, @RequestBody Pilot pilot)
//    {
//
//        Pilot newpilot = this.pilotRepository.findById(id).get();
//        newpilot.setName(pilot.getName());
//        this.pilotRepository.save(newpilot);
//        return newpilot;
//    }
}
