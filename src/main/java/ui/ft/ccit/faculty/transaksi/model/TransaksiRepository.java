package ui.ft.ccit.faculty.transaksi.model; // Sesuaikan package jika temanmu memisahkannya

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaksiRepository extends JpaRepository<Transaksi, String> {
    // String karena Primary Key (kode_transaksi) tipenya String
}