package ui.ft.ccit.faculty.transaksi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ui.ft.ccit.faculty.transaksi.model.Transaksi;
import ui.ft.ccit.faculty.transaksi.service.TransaksiService;

import java.util.List;

@RestController
@RequestMapping("/api/transaksi") // <-- Ini alamat URL-nya nanti
public class TransaksiController {

    @Autowired
    private TransaksiService service;

    @GetMapping
    public List<Transaksi> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Transaksi getById(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping
    public Transaksi create(@RequestBody Transaksi transaksi) {
        return service.save(transaksi);
    }

    @PutMapping("/{id}")
    public Transaksi update(@PathVariable String id, @RequestBody Transaksi transaksi) {
        transaksi.setKodeTransaksi(id); // Jaga-jaga biar ID konsisten
        return service.save(transaksi);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}