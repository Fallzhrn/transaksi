package ui.ft.ccit.faculty.transaksi.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "detail_transaksi")
@IdClass(DetailTransaksiId.class) // Menggunakan file pembantu tadi
public class DetailTransaksi {

    @Id
    @Column(name = "kode_transaksi", length = 4)
    private String kodeTransaksi;

    @Id
    @Column(name = "id_barang", length = 4)
    private String idBarang;

    @Column(name = "jumlah")
    private Integer jumlah;

    // Relasi balik ke Transaksi
    @ManyToOne
    @JoinColumn(name = "kode_transaksi", insertable = false, updatable = false)
    @JsonIgnore // Supaya tidak looping saat dikirim ke Postman
    private Transaksi transaksi;

    // --- Getters & Setters ---
    public String getKodeTransaksi() { return kodeTransaksi; }
    public void setKodeTransaksi(String kodeTransaksi) { this.kodeTransaksi = kodeTransaksi; }

    public String getIdBarang() { return idBarang; }
    public void setIdBarang(String idBarang) { this.idBarang = idBarang; }

    public Integer getJumlah() { return jumlah; }
    public void setJumlah(Integer jumlah) { this.jumlah = jumlah; }

    public Transaksi getTransaksi() { return transaksi; }
    public void setTransaksi(Transaksi transaksi) { this.transaksi = transaksi; }
}