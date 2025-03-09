package SODEFEND.SODEFEND.RegisterLayer;


import SODEFEND.SODEFEND.RepositoryLayer.TicketRepo;
import jakarta.persistence.*;

//import java.util.Date;

@Entity
@Table(name = "ticket")
public class TicketModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticketId", unique = true, updatable = false, nullable = false)
    private Long ticketId;
    @Column(name = "olay_turu")
    private String olayTuru;
    @Column(name = "olay_tanimi")
    private String olayTanimi;
    @Column(name = "tespit_tarihi")
    private String tespitTarihi;
    @Column(name = "tespit_yontemi")
    private String tespitYontemi;
    @Column(name = "olay_sis_kes")
    // Olay sistem kesintisine sebep oldu mu = sisKesMi;
    private boolean olaySisKesMi;
    @Column(name = "etkilenen_sistem")
    private String etkilenenSistem;
    // Siber Olaylara Ait İz Kayıtları Tespit Edildi Mi = SibOlIz;
    @Column(name = "sib_ol_iz")
    private boolean sibOlIz;
    // Alınan Karşı Önlemlerin Açıklaması = onlemDetay
    @Column(name = "onlem_detay")
    private String onlemDetay;
    @Column(name = "ek_bilgiler")
    private String ekBilgiler;
    @Column(name = "statu")
    private String statu;
    @Column(name = "admin_yorum")
    private String adminYorum;
    @Column(name = "olusturma_tarihi")
    private String olusturmaTarihi;
    @Column(name = "gunceleme_tarihi")
    private String guncelemeTarihi;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kullanici_ismi", referencedColumnName = "user_name", nullable = false)
    private RegisterModel user;

    public TicketModel(Long ticketId, String olayTuru, String olayTanimi, String tespitTarihi, String tespitYontemi, boolean olaySisKesMi, String etkilenenSistem, boolean sibOlIz, String onlemDetay, String ekBilgiler, String statu, String adminYorum, String olusturmaTarihi, String guncelemeTarihi, RegisterModel user) {
        this.ticketId = ticketId;
        this.olayTuru = olayTuru;
        this.olayTanimi = olayTanimi;
        this.tespitTarihi = tespitTarihi;
        this.tespitYontemi = tespitYontemi;
        this.olaySisKesMi = olaySisKesMi;
        this.etkilenenSistem = etkilenenSistem;
        this.sibOlIz = sibOlIz;
        this.onlemDetay = onlemDetay;
        this.ekBilgiler = ekBilgiler;
        this.statu = statu;
        this.adminYorum = adminYorum;
        this.olusturmaTarihi = olusturmaTarihi;
        this.guncelemeTarihi = guncelemeTarihi;
        this.user = user;
    }

    public TicketModel() {}

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public String getOlayTuru() {
        return olayTuru;
    }

    public void setOlayTuru(String olayTuru) {
        this.olayTuru = olayTuru;
    }

    public String getOlayTanimi() {
        return olayTanimi;
    }

    public void setOlayTanimi(String olayTanimi) {
        this.olayTanimi = olayTanimi;
    }

    public String getTespitTarihi() {
        return tespitTarihi;
    }

    public void setTespitTarihi(String tespitTarihi) {
        this.tespitTarihi = tespitTarihi;
    }

    public String getTespitYontemi() {
        return tespitYontemi;
    }

    public void setTespitYontemi(String tespitYontemi) {
        this.tespitYontemi = tespitYontemi;
    }

    public boolean isOlaySisKesMi() {
        return olaySisKesMi;
    }

    public void setOlaySisKesMi(boolean olaySisKesMi) {
        this.olaySisKesMi = olaySisKesMi;
    }

    public String getEtkilenenSistem() {
        return etkilenenSistem;
    }

    public void setEtkilenenSistem(String etkilenenSistem) {
        this.etkilenenSistem = etkilenenSistem;
    }

    public boolean isSibOlIz() {
        return sibOlIz;
    }

    public void setSibOlIz(boolean sibOlIz) {
        this.sibOlIz = sibOlIz;
    }

    public String getOnlemDetay() {
        return onlemDetay;
    }

    public void setOnlemDetay(String onlemDetay) {
        this.onlemDetay = onlemDetay;
    }

    public String getEkBilgiler() {
        return ekBilgiler;
    }

    public void setEkBilgiler(String ekBilgiler) {
        this.ekBilgiler = ekBilgiler;
    }

    public String getStatu() {
        return statu;
    }

    public void setStatu(String statu) {
        this.statu = statu;
    }

    public String getAdminYorum() {
        return adminYorum;
    }

    public void setAdminYorum(String adminYorum) {
        this.adminYorum = adminYorum;
    }

    public String getOlusturmaTarihi() {
        return olusturmaTarihi;
    }

    public void setOlusturmaTarihi(String olusturmaTarihi) {
        this.olusturmaTarihi = olusturmaTarihi;
    }

    public String getGuncelemeTarihi() {
        return guncelemeTarihi;
    }

    public void setGuncelemeTarihi(String guncelemeTarihi) {
        this.guncelemeTarihi = guncelemeTarihi;
    }

    public RegisterModel getUser() {
        return user;
    }

    public void setUser(RegisterModel user) {
        this.user = user;
    }
}
