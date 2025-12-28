package ui.ft.ccit.faculty.transaksi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ui.ft.ccit.faculty.transaksi.model.*;
import java.util.List;

@Service
public class TransaksiService {

    @Autowired
    private TransaksiRepository repo;

    // --- 1. GET ALL (Ambil Semua Data) ---
    public List<Transaksi> findAll() {
        return repo.findAll();
    }

    // --- 2. GET BY ID (Cari Satu Data) ---
    public Transaksi findById(String id) {
        return repo.findById(id).orElse(null);
    }

    // --- 3. SAVE (Simpan Baru / Update) ---
    public Transaksi save(Transaksi transaksi) {
        
        if (transaksi.getListDetail() != null) {
            for (DetailTransaksi detail : transaksi.getListDetail()) {
                detail.setKodeTransaksi(transaksi.getKodeTransaksi());
            }
        }
        return repo.save(transaksi);
    }

    // --- 4. DELETE (Hapus) ---
    public void delete(String id) {
        repo.deleteById(id);
    }
}