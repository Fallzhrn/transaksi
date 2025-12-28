package ui.ft.ccit.faculty.transaksi.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "transaksi")
public class Transaksi {

    @Id
    @Column(name = "kode_transaksi", length = 4)
    private String kodeTransaksi;

    @Column(name = "tgl_transaksi")
    private LocalDateTime tglTransaksi;

    @Column(name = "id_pelanggan", length = 4)
    private String idPelanggan;

    @Column(name = "id_karyawan", length = 4)
    private String idKaryawan;

    // Relasi: Satu Transaksi punya Banyak Detail
    // "mappedBy" mengacu pada variable 'transaksi' di file DetailTransaksi nanti
    @OneToMany(mappedBy = "transaksi", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DetailTransaksi> listDetail;

    // --- Constructor ---
    public Transaksi() {}

    // --- Getters & Setters ---
    public String getKodeTransaksi() { return kodeTransaksi; }
    public void setKodeTransaksi(String kodeTransaksi) { this.kodeTransaksi = kodeTransaksi; }

    public LocalDateTime getTglTransaksi() { return tglTransaksi; }
    public void setTglTransaksi(LocalDateTime tglTransaksi) { this.tglTransaksi = tglTransaksi; }

    public String getIdPelanggan() { return idPelanggan; }
    public void setIdPelanggan(String idPelanggan) { this.idPelanggan = idPelanggan; }

    public String getIdKaryawan() { return idKaryawan; }
    public void setIdKaryawan(String idKaryawan) { this.idKaryawan = idKaryawan; }

    public List<DetailTransaksi> getListDetail() { return listDetail; }
    public void setListDetail(List<DetailTransaksi> listDetail) { this.listDetail = listDetail; }
}